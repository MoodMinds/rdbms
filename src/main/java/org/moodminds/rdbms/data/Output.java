package org.moodminds.rdbms.data;

import org.moodminds.elemental.Ordered;
import org.moodminds.rdbms.RdbmsException;
import org.moodminds.rdbms.type.Class;

/**
 * An RDBMS stored procedure output parameters values access object.
 */
public interface Output extends Ordered<Object> {

    /**
     * Return a value by the specified output parameter index.
     *
     * @param index the index position of the value
     * @return a value by the specified output parameter index
     * @throws IndexOutOfBoundsException if the index is out of range
     * @throws RdbmsException an exception in case of value retrieving error
     * @param <R> the type of return value
     */
    @Override
    <R> R get(int index);

    /**
     * Return a value by the specified output parameter index and {@link java.lang.Class} type.
     *
     * @param index the index position of the value
     * @param type the specified expected value {@link java.lang.Class} type
     * @param <V> the type of value of the stored procedure output parameter
     * @return a value by the specified output parameter index
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index &lt; 0 || index &gt;= width()})
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(int index, java.lang.Class<V> type);

    /**
     * Return a value by the specified output parameter index and {@link Class} type.
     *
     * @param index the index position of the value
     * @param type the specified expected value {@link Class} type
     * @param <V> the type of value of the stored procedure output parameter
     * @return a value by the specified output parameter index
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index &lt; 0 || index &gt;= width()})
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(int index, Class<V> type);

    /**
     * Return a value by the specified output parameter name.
     *
     * @param name the specified output parameter name
     * @return a value by the specified output parameter name
     * @throws IllegalArgumentException an exception in case of absence of the given output parameter name
     * @throws RdbmsException an exception in case of value retrieving error
     */
    Object get(String name);

    /**
     * Return a value by the specified output parameter name and {@link java.lang.Class} type.
     *
     * @param name the specified output parameter name
     * @param type the specified expected value {@link java.lang.Class} type
     * @param <V> the type of value of the output parameter
     * @return a value by the specified output parameter name
     * @throws IllegalArgumentException an exception in case of absence of the given output parameter name
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(String name, java.lang.Class<V> type);

    /**
     * Return a value by the specified output parameter name and {@link Class} type.
     *
     * @param name the specified output parameter name
     * @param type the specified expected value {@link Class} type
     * @param <V> the type of value of the output parameter
     * @return a value by the specified output parameter name
     * @throws IllegalArgumentException an exception in case of absence of the given output parameter name
     * @throws RdbmsException an exception in case of value retrieving error
     */
    <V> V get(String name, Class<V> type);
}
