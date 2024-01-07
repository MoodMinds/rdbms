package org.moodminds.rdbms.type;

/**
 * An RDBMS data type definition object (detailed type with dimensions such as precision, length and so on).
 *
 * @param <V> the type of the corresponding java type
 */
public interface Type<V> extends Class<V> {

    /**
     * Return the type name of this RDBMS data type including lengths, precisions and so on.
     *
     * @return the type name of this RDBMS data type including lengths, precisions and so on
     */
    String getName();

    /**
     * Return the domain of this RDBMS data type.
     *
     * @return the domain of this RDBMS data type
     */
    Domain<V> getDomain();
}
