package org.moodminds.rdbms.clause;

import org.moodminds.rdbms.ClauseException;
import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple;
import org.moodminds.rdbms.lang.*;
import org.moodminds.rdbms.type.Class;
import org.moodminds.type.*;

import java.lang.String;

/**
 * A {@link Clausing} definition interface that defines {@link Statement} objects.
 */
public interface Statings {

    /**
     * Define a stored procedure call {@link Calling} by the given SQL string.
     *
     * @param string the given stored procedure SQL string call
     * @return a stored procedure call {@link Calling} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    Calling call(String string);

    /**
     * Define an execution {@link Stating} by the given SQL string.
     *
     * @param string the given statement SQL string
     * @param <S>    the type of the execution statement object
     * @return an execution {@link Stating} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <S extends ExecuteString> Stating<S> state(String string);

    /**
     * Define a query {@link Querying} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <R>    the type of the relation tuple
     * @return a query {@link Querying} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <R extends Tuple> Querying<R> query(String string);

    /**
     * Define a 1-attribute tuple query {@link Querying1} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V>    the type of the attribute
     * @return a 1-attribute tuple query {@link Querying1} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V> Querying1<V> query1(String string);

    /**
     * Define a 1-attribute tuple query {@link Querying1} by the given SQL string
     * and attribute type definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V>    the type of the attribute
     * @return a 1-attribute tuple query {@link Querying1} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V> Querying1<V> query(Type1<V> type, String string);

    /**
     * Define a 2-attributes tuple query {@link Querying2} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @return a 2-attributes tuple query {@link Querying2} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2> Querying2<V1, V2> query2(String string);

    /**
     * Define a 2-attributes tuple query {@link Querying2} by the given SQL string
     * and attribute types definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @return a 2-attributes tuple query {@link Querying2} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2> Querying2<V1, V2> query(Type2<V1, V2> type, String string);

    /**
     * Define a 3-attributes tuple query {@link Querying3} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @return a 3-attributes tuple query {@link Querying3} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3> Querying3<V1, V2, V3> query3(String string);

    /**
     * Define a 3-attributes tuple query {@link Querying3} by the given SQL string
     * and attribute types definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @return a 3-attributes tuple query {@link Querying3} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3> Querying3<V1, V2, V3> query(Type3<V1, V2, V3> type, String string);

    /**
     * Define a 4-attributes tuple query {@link Querying4} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @return a 4-attributes tuple query {@link Querying4} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4> Querying4<V1, V2, V3, V4> query4(String string);

    /**
     * Define a 4-attributes tuple query {@link Querying4} by the given SQL string
     * and attribute types definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @return a 4-attributes tuple query {@link Querying4} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4> Querying4<V1, V2, V3, V4> query(Type4<V1, V2, V3, V4> type, String string);

    /**
     * Define a 5-attributes tuple query {@link Querying5} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @return a 5-attributes tuple query {@link Querying5} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5> Querying5<V1, V2, V3, V4, V5> query5(String string);

    /**
     * Define a 5-attributes tuple query {@link Querying5} by the given SQL string
     * and attribute types definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @return a 5-attributes tuple query {@link Querying5} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5> Querying5<V1, V2, V3, V4, V5> query(Type5<V1, V2, V3, V4, V5> type, String string);

    /**
     * Define a 6-attributes tuple query {@link Querying6} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @param <V6>   the type of the attribute 6
     * @return a 6-attributes tuple query {@link Querying6} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5, V6> Querying6<V1, V2, V3, V4, V5, V6> query6(String string);

    /**
     * Define a 6-attributes tuple query {@link Querying6} by the given SQL string
     * and attribute types definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @param <V6>   the type of the attribute 6
     * @return a 6-attributes tuple query {@link Querying6} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5, V6> Querying6<V1, V2, V3, V4, V5, V6> query(Type6<V1, V2, V3, V4, V5, V6> type, String string);

    /**
     * Define a 7-attributes tuple query {@link Querying7} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @param <V6>   the type of the attribute 6
     * @param <V7>   the type of the attribute 7
     * @return a 7-attributes tuple query {@link Querying7} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5, V6, V7> Querying7<V1, V2, V3, V4, V5, V6, V7> query7(String string);

    /**
     * Define a 7-attributes tuple query {@link Querying7} by the given SQL string
     * and attribute types definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @param <V6>   the type of the attribute 6
     * @param <V7>   the type of the attribute 7
     * @return a 7-attributes tuple query {@link Querying7} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5, V6, V7> Querying7<V1, V2, V3, V4, V5, V6, V7> query(Type7<V1, V2, V3, V4, V5, V6, V7> type, String string);

    /**
     * Define an 8-attributes tuple query {@link Querying8} by the given SQL string.
     *
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @param <V6>   the type of the attribute 6
     * @param <V7>   the type of the attribute 7
     * @param <V8>   the type of the attribute 8
     * @return an 8-attributes tuple query {@link Querying8} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5, V6, V7, V8> Querying8<V1, V2, V3, V4, V5, V6, V7, V8> query8(String string);

    /**
     * Define an 8-attributes tuple query {@link Querying8} by the given SQL string
     * and attribute types definition object.
     *
     * @param type   the given attribute type definition object
     * @param string the given query statement SQL string
     * @param <V1>   the type of the attribute 1
     * @param <V2>   the type of the attribute 2
     * @param <V3>   the type of the attribute 3
     * @param <V4>   the type of the attribute 4
     * @param <V5>   the type of the attribute 5
     * @param <V6>   the type of the attribute 6
     * @param <V7>   the type of the attribute 7
     * @param <V8>   the type of the attribute 8
     * @return an 8-attributes tuple query {@link Querying8} definition object by the given SQL string
     * @throws ClauseException an exception in case of any statement definition error
     */
    <V1, V2, V3, V4, V5, V6, V7, V8> Querying8<V1, V2, V3, V4, V5, V6, V7, V8> query(Type8<V1, V2, V3, V4, V5, V6, V7, V8> type, String string);


    /**
     * The {@link CallString} statement definition object.
     */
    interface Calling extends Clausing<CallString> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @return the statement definition object self-instance
         */
        Calling param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @return the statement definition object self-instance
         */
        Calling param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link StatementString} statement definition object.
     */
    interface Stating<S extends StatementString> extends Clausing<S> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X>   the type of the execution statement object
         * @return the statement definition object self-instance
         */
        <X extends S> Stating<X> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X>   the type of the execution statement object
         * @return the statement definition object self-instance
         */
        <X extends S> Stating<X> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString} statement definition object.
     *
     * @param <R> the type of the relation tuple
     */
    interface Querying<R extends Tuple> extends Clausing<QueryString<Relation<R>>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X>   the type of the relation tuple
         * @return the statement definition object self-instance
         */
        <X extends R> Querying<X> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X>   the type of the relation tuple
         * @return the statement definition object self-instance
         */
        <X extends R> Querying<X> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString1} statement definition object.
     *
     * @param <V> the type of the value
     */
    interface Querying1<V> extends Clausing<QueryString1<V>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X>   the type of the value
         * @return the statement definition object self-instance
         */
        <X extends V> Querying1<X> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X>   the type of the value
         * @return the statement definition object self-instance
         */
        <X extends V> Querying1<X> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString2} statement definition object.
     *
     * @param <V1> the type of value 1
     * @param <V2> the type of value 2
     */
    interface Querying2<V1, V2> extends Clausing<QueryString2<V1, V2>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2> Querying2<X1, X2> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2> Querying2<X1, X2> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString3} statement definition object.
     *
     * @param <V1> the type of value 1
     * @param <V2> the type of value 2
     * @param <V3> the type of value 3
     */
    interface Querying3<V1, V2, V3> extends Clausing<QueryString3<V1, V2, V3>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3> Querying3<X1, X2, X3> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3> Querying3<X1, X2, X3> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString4} statement definition object.
     *
     * @param <V1> the type of value 1
     * @param <V2> the type of value 2
     * @param <V3> the type of value 3
     * @param <V4> the type of value 4
     */
    interface Querying4<V1, V2, V3, V4> extends Clausing<QueryString4<V1, V2, V3, V4>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4> Querying4<X1, X2, X3, X4> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4> Querying4<X1, X2, X3, X4> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString5} statement definition object.
     *
     * @param <V1> the type of value 1
     * @param <V2> the type of value 2
     * @param <V3> the type of value 3
     * @param <V4> the type of value 4
     * @param <V5> the type of value 5
     */
    interface Querying5<V1, V2, V3, V4, V5> extends Clausing<QueryString5<V1, V2, V3, V4, V5>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5> Querying5<X1, X2, X3, X4, X5> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5> Querying5<X1, X2, X3, X4, X5> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString6} statement definition object.
     *
     * @param <V1> the type of value 1
     * @param <V2> the type of value 2
     * @param <V3> the type of value 3
     * @param <V4> the type of value 4
     * @param <V5> the type of value 5
     * @param <V6> the type of value 6
     */
    interface Querying6<V1, V2, V3, V4, V5, V6> extends Clausing<QueryString6<V1, V2, V3, V4, V5, V6>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @param <X6>  the type of value 6
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5, X6 extends V6> Querying6<X1, X2, X3, X4, X5, X6> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @param <X6>  the type of value 6
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5, X6 extends V6> Querying6<X1, X2, X3, X4, X5, X6> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString7} statement definition object.
     *
     * @param <V1> the type of value 1
     * @param <V2> the type of value 2
     * @param <V3> the type of value 3
     * @param <V4> the type of value 4
     * @param <V5> the type of value 5
     * @param <V6> the type of value 6
     * @param <V7> the type of value 7
     */
    interface Querying7<V1, V2, V3, V4, V5, V6, V7> extends Clausing<QueryString7<V1, V2, V3, V4, V5, V6, V7>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @param <X6>  the type of value 6
         * @param <X7>  the type of value 7
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5, X6 extends V6, X7 extends V7> Querying7<X1, X2, X3, X4, X5, X6, X7> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @param <X6>  the type of value 6
         * @param <X7>  the type of value 7
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5, X6 extends V6, X7 extends V7> Querying7<X1, X2, X3, X4, X5, X6, X7> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }

    /**
     * The {@link QueryString8} statement definition object.
     *
     * @param <V1> the type of value 1
     * @param <V2> the type of value 2
     * @param <V3> the type of value 3
     * @param <V4> the type of value 4
     * @param <V5> the type of value 5
     * @param <V6> the type of value 6
     * @param <V7> the type of value 7
     * @param <V8> the type of value 8
     */
    interface Querying8<V1, V2, V3, V4, V5, V6, V7, V8> extends Clausing<QueryString8<V1, V2, V3, V4, V5, V6, V7, V8>> {

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @param <X6>  the type of value 6
         * @param <X7>  the type of value 7
         * @param <X8>  the type of value 8
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5, X6 extends V6, X7 extends V7, X8 extends V8> Querying8<X1, X2, X3, X4, X5, X6, X7, X8> param(Class<?> type, Class<?>... types);

        /**
         * Define types for the sequence of parameters in the SQL statement string.
         *
         * @param type  the given parameter type
         * @param types the given parameters types
         * @param <X1>  the type of value 1
         * @param <X2>  the type of value 2
         * @param <X3>  the type of value 3
         * @param <X4>  the type of value 4
         * @param <X5>  the type of value 5
         * @param <X6>  the type of value 6
         * @param <X7>  the type of value 7
         * @param <X8>  the type of value 8
         * @return the statement definition object self-instance
         */
        <X1 extends V1, X2 extends V2, X3 extends V3, X4 extends V4, X5 extends V5, X6 extends V6, X7 extends V7, X8 extends V8> Querying8<X1, X2, X3, X4, X5, X6, X7, X8> param(java.lang.Class<?> type, java.lang.Class<?>... types);
    }
}
