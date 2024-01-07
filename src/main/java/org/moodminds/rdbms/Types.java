package org.moodminds.rdbms;

import org.moodminds.rdbms.type.Class;
import org.moodminds.type.Type1;

/**
 * The RDBMS types accessor interface.
 */
public interface Types {

    /**
     * The constant string name for the BOOLEAN RDBMS data type
     */
    String BOOLEAN = "BOOLEAN";

    /**
     * The constant string name for the CHAR RDBMS data type
     */
    String CHAR = "CHAR";
    /**
     * The constant string name for the CHARACTER RDBMS data type
     */
    String CHARACTER = "CHARACTER";
    /**
     * The constant string name for the NCHAR RDBMS data type
     */
    String NCHAR = "NCHAR";

    /**
     * The constant string name for the VARCHAR RDBMS data type
     */
    String VARCHAR = "VARCHAR";

    /**
     * The constant string name for the NVARCHAR RDBMS data type
     */
    String NVARCHAR = "NVARCHAR";

    /**
     * The constant string name for the CLOB RDBMS data type
     */
    String CLOB = "CLOB";

    /**
     * The constant string name for the NCLOB RDBMS data type
     */
    String NCLOB = "NCLOB";


    /**
     * The constant string name for the BINARY RDBMS data type
     */
    String BINARY = "BINARY";

    /**
     * The constant string name for the VARBINARY RDBMS data type
     */
    String VARBINARY = "VARBINARY";

    /**
     * The constant string name for the BLOB RDBMS data type
     */
    String BLOB = "BLOB";


    /**
     * The constant string name for the INT RDBMS data type
     */
    String INT = "INT";

    /**
     * The constant string name for the INTEGER RDBMS data type
     */
    String INTEGER = "INTEGER";

    /**
     * The constant string name for the TINYINT RDBMS data type
     */
    String TINYINT = "TINYINT";

    /**
     * The constant string name for the SMALLINT RDBMS data type
     */
    String SMALLINT = "SMALLINT";

    /**
     * The constant string name for the BIGINT RDBMS data type
     */
    String BIGINT = "BIGINT";

    /**
     * The constant string name for the FLOAT RDBMS data type
     */
    String FLOAT = "FLOAT";

    /**
     * The constant string name for the REAL RDBMS data type
     */
    String REAL = "REAL";

    /**
     * The constant string name for the DOUBLE RDBMS data type
     */
    String DOUBLE = "DOUBLE";

    /**
     * The constant string name for the DECIMAL RDBMS data type
     */
    String DECIMAL = "DECIMAL";

    /**
     * The constant string name for the NUMERIC RDBMS data type
     */
    String NUMERIC = "NUMERIC";


    /**
     * The constant string name for the DATE RDBMS data type
     */
    String DATE = "DATE";

    /**
     * The constant string name for the TIME RDBMS data type
     */
    String TIME = "TIME";

    /**
     * The constant string name for the TIME WITH TIME ZONE RDBMS data type
     */
    String TIME_WITH_TIME_ZONE = "TIME WITH TIME ZONE";

    /**
     * The constant string name for the TIMESTAMP RDBMS data type
     */
    String TIMESTAMP = "TIMESTAMP";

    /**
     * The constant string name for the TIMESTAMP WITH TIME ZONE RDBMS data type
     */
    String TIMESTAMP_WITH_TIME_ZONE = "TIMESTAMP WITH TIME ZONE";


    /**
     * The constant string name for the COLLECTION RDBMS data type
     */
    String COLLECTION = "COLLECTION";

    /**
     * The constant string name for the ARRAY RDBMS data type
     */
    String ARRAY = "ARRAY";

    /**
     * The constant string name for the MULTISET RDBMS data type
     */
    String MULTISET = "MULTISET";


    /**
     * Return the RDBMS type by the given name.
     *
     * @param name the given RDBMS type name
     * @param <V> the type of the corresponding java type
     * @return the RDBMS type by the given name
     * @throws TypeDefinitionException an exception in case of mistyping in type name string
     * @throws TypeAbsenceException an exception if there is no type with the specified name
     */
    <V> Class<V> $(String name);

    /**
     * Return the RDBMS type by the given corresponding {@link Type1} type definition and name.
     *
     * @param type the given corresponding type definition
     * @param name the given RDBMS type name
     * @param <V> the type of the corresponding java type
     * @return the RDBMS type by the given corresponding {@link Type1} type definition and name
     * @throws TypeDefinitionException an exception in case of mistyping in type name string
     * @throws TypeAbsenceException an exception if there is no type with the specified name
     */
    <V> Class<V> $(Type1<V> type, String name);

    /**
     * Return the RDBMS type by the given corresponding type {@link java.lang.Class} and name.
     *
     * @param type the given corresponding type {@link java.lang.Class}
     * @param name the given RDBMS type name
     * @param <V> the type of the corresponding java type
     * @return the RDBMS type by the given corresponding type {@link java.lang.Class} and name
     * @throws TypeDefinitionException an exception in case of mistyping in type name string
     */
    <V> Class<V> $(java.lang.Class<V> type, String name);
}
