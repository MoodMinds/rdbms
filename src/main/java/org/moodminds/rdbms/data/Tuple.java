package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;
import org.moodminds.rdbms.type.Class;

/**
 * An RDBMS relation tuple.
 */
public interface Tuple extends org.moodminds.elemental.Tuple {

    /**
     * Return a relation attributes header.
     *
     * @return a relation attributes header
     * @throws RdbmsException an exception in case of header obtaining error
     */
    Header getHeader();

    /**
     * Return a value by the specified tuple attribute index.
     *
     * @param index the index position of the value
     * @return a value by the specified tuple attribute index
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index &lt; 0 || index &gt;= width()})
     * @throws RdbmsException an exception in case of value retrieving error
     * @param <R> the type of return value
     */
    @Override
    <R> R get(int index);

    /**
     * Return a value by the specified tuple attribute index and {@link java.lang.Class} type.
     *
     * @param index the index position of the value
     * @param type the specified expected value {@link java.lang.Class} type
     * @return a value by the specified tuple attribute index
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index &lt; 0 || index &gt;= width()})
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(int index, java.lang.Class<V> type);

    /**
     * Return a value by the specified tuple attribute index and {@link Class} type.
     *
     * @param index the index position of the value
     * @param type the specified expected value {@link Class} type
     * @return a value by the specified tuple attribute index
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index &lt; 0 || index &gt;= width()})
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(int index, Class<V> type);

    /**
     * Return a value by the specified tuple attribute name.
     *
     * @param name the specified tuple attribute name
     * @param <V> the type of value of the attribute
     * @return a value by the specified tuple attribute name
     * @throws IllegalArgumentException an exception in case of absence of the given attribute name
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(String name);

    /**
     * Return a value by the specified tuple attribute name and type.
     *
     * @param name the specified tuple attribute name
     * @param type the specified expected value {@link java.lang.Class} type
     * @param <V> the type of value of the attribute
     * @return a value by the specified tuple attribute name
     * @throws IllegalArgumentException an exception in case of absence of the given attribute name
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(String name, java.lang.Class<V> type);

    /**
     * Return a value by the specified tuple attribute name and type.
     *
     * @param name the specified tuple attribute name
     * @param type the specified expected value {@link Class} type
     * @param <V> the type of value of the attribute
     * @return a value by the specified tuple attribute name
     * @throws IllegalArgumentException an exception in case of absence of the given attribute name
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(String name, Class<V> type);
}
