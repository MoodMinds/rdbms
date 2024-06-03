# Streaming Relational Database Access Client

**RDBMS** is a client-level Relational Database access API that seamlessly integrates with [Routes](https://github.com/MoodMinds/routes)
for data manipulation. It enriches its API with RDBMS-specific commands designed for SQL statement execution, expressions,
and traversals. Similar to [Routes](https://github.com/MoodMinds/routes), RDBMS is an execution model-agnostic API/SPI.
This means that depending on the chosen execution model, SPI implementations have the flexibility to select a Database Connectivity system,
such as JDBC, [R2DBC](https://r2dbc.io), or any other suitable option that may be available.

## The Concept

The core idea behind this project is to offer an API that allows writing client-level database manipulation code in a stream-like
manner. While [R2DBC](https://r2dbc.io) harnesses the power of [Reactive Streams](https://www.reactive-streams.org) in its API,
it operates at a very low level. This low-level approach necessitates higher-level abstractions due to the inherent complexity
of reactive code.

On the other hand, when dealing with traditional synchronous database access using JDBC, there are limited options for expressing
coherent data manipulation logic in a streaming fashion.

This project bridges this gap by providing a unified API that covers both RDBMS access models - synchronous (JDBC) and reactive [R2DBC](https://r2dbc.io).

### In a Nutshell

**Extends the [Routes](https://github.com/MoodMinds/routes) API (SPI)**: Incorporates RDBMS-specific commands and expressions
  for CRUD and stored procedure (SP) calls. Outputs from RDBMS naturally fit into the [Routes](https://github.com/MoodMinds/routes)
  streaming basis.

**Client-Level API**: This API focuses on the client-level functionality, relieving users of responsibilities such as transaction
  control and isolation level definitions.

**Enhanced Statement Parameter Flexibility**: Introducing qualifying markers for statement parameters:
- `:param` and `:>param`: Denote an input parameter.
- `:<param`: Indicates an output parameter (Stored Procedures).
- `:<>param` or `:><param`: Both designate an input-output parameter (Stored Procedures).
- `:param[5]` or `:param[]`: Represent multiple input parameters, with or without length (IN Clause). The length
  number is required to apply batching.

**Automatic Batching**: SQL INSERT, UPDATE, and DELETE statement executions are subjects for automatic batching. Batch sizes
  can be implementation-specific or customized using the `batch(size)` method in the statement execution definition. Implementations
  decide whether to employ batch processing based on the presence of subsequent executions that could be impacted by each INSERT,
  UPDATE, or DELETE operation.

**Automatic closing of resources.** Due to the semi-passive traversal nature of the [Routes](https://github.com/MoodMinds/routes)
  and `Emittable` representation of the Routes - there is no need to close/release resources explicitly. All potentially
  opened resources managed by the SPI implementation behind the scenes are automatically closed and released after consumption.

### RDBMS Routes Expressions

Let's explore how to use the RDBMS API.

The following execution can be expressed only once, serving both synchronous traversal and asynchronous reactive execution models.
It can be executed with a specific SPI implementation, whether it's JDBC or [R2DBC](https://r2dbc.io).

```java
import org.moodminds.emission.Emittable;
import org.moodminds.rdbms.clause.Script;
import org.moodminds.rdbms.data.Tuple1;
import org.moodminds.rdbms.lang.Create;
import org.moodminds.rdbms.lang.Query1;
import org.moodminds.rdbms.route.Action1;
import org.moodminds.rdbms.route.Action2;
import org.moodminds.rdbms.route.Routes;
import org.moodminds.rdbms.route.Stream1;
import org.moodminds.type.T;

import java.util.logging.Logger;

import static org.moodminds.rdbms.Types.VARCHAR;

class Sample {

    static final Logger LOG = Logger.getLogger(Sample.class.getName());

    static final Script<Create> CREATE_PHONE_STATEMENT = ($$, t) -> $$
            .state("INSERT INTO PHONE(person_id, number) VALUES(:personId, :number)")
                .param(Integer.class, String.class);

    static final Script<Query1<String>> RETURN_PHONES_QUERY = ($$, t) -> $$
            .query1("SELECT phone.number FROM PHONE phone JOIN PERSON person ON phone.personId = person.id WHERE person.name = :personName")
                .param(t.$("NVARCHAR"));

    static final Action2<Integer, String, RuntimeException> CREATE_PHONE = ($, person, phone) -> $
            .effect(CREATE_PHONE_STATEMENT)
                .input("personId", person)
                .input("number", phone);

    static final Action2<String, Emittable<String, RuntimeException>, RuntimeException> CREATE_PERSON = ($, name, phones) -> $
            .create(($$, t) -> $$.state("INSERT INTO PERSON(name) VALUES(:name)")
                    .param(t.$("NVARCHAR")))
                .input("name", name)
                .handle(T<Integer>::new, row -> $
                    .expand(row, id -> $
                        .stream(phones, phone -> $ // for each phone
                            .action(CREATE_PHONE, id, phone))));

    static final Action1<String, RuntimeException> DELETE_PERSON = ($, name) -> $
            .update(($$, t) -> $$.state("DELETE FROM PERSON WHERE name = :name")
                    .param(t.$("NVARCHAR")))
                .input("name", name)
                .batch(100)
                .number(affected -> $
                    .effect(affected, d -> LOG.info("Persons deleted: " + d)));

    static final Stream1<String, String, RuntimeException> RETURN_PHONES = ($, person) -> $
            .relate(RETURN_PHONES_QUERY)
                .fetch(10)
                .input("personName", person)
                .handle(phone -> $
                    .supply(phone, Tuple1::get1st));

    static final Action1<String, RuntimeException> CALL_PERSON = ($, name) -> $
            .invoke(($$, t) -> $$.call("PERSON(:>name, :<code)")
                    .param(String.class).param(t.$(VARCHAR)))
                .input("name", name)
                .output("code", code -> $
                    .effect(code, c -> LOG.info("Person's code: " + code)));

    static final Action2<String, Emittable<String, RuntimeException>, RuntimeException> ROUTE = ($, name, phones) -> $
            .action(CALL_PERSON, name)
            .action(CREATE_PERSON, name, phones)
            .action(DELETE_PERSON, name);

    // Materialize

    // assume it is initialized somehow as synchronous traversal or asynchronous reactive implementation
    private final Routes routes = null;

    public Emittable<Void, RuntimeException> route() {

        Emittable<String, RuntimeException> helenPhones = routes.stream(RETURN_PHONES, "Helen Wick");

        return routes.action(ROUTE, "John Wick", helenPhones);
    }
}
```

## Maven configuration

Artifacts can be found on [Maven Central](https://search.maven.org/) after publication.

```xml
<dependency>
    <groupId>org.moodminds.rdbms</groupId>
    <artifactId>rdbms</artifactId>
    <version>${version}</version>
</dependency>
```

## Building from Source

You may need to build from source to use **RDBMS** (until it is in Maven Central) with Maven and JDK 1.8 at least.

## License
This project is going to be released under version 2.0 of the [Apache License][l].

[l]: https://www.apache.org/licenses/LICENSE-2.0