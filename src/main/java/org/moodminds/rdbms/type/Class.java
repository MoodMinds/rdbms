package org.moodminds.rdbms.type;

/**
 * Root interface of the RDBMS data types.
 *
 * @param <V> the type of the corresponding java type
 *
 * @author Ivan Tishchenko
 */
public interface Class<V> {

    /**
     * Return the java type that represents current RDBMS data type.
     *
     * @return the java type that represents current RDBMS data type
     */
    java.lang.Class<V> getType();
}
