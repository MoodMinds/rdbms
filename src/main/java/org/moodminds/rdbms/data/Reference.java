package org.moodminds.rdbms.data;

import org.moodminds.rdbms.DatabaseException;

/**
 * An RDBMS reference to a structured type object.
 *
 * @param <V> the type of the referenced object
 */
public interface Reference<V> {

    /**
     * Return the referenced object mapped value or array of attributes values
     * if there is no corresponding Java object mapping registered for a structured type.
     *
     * @return the referenced object value or array of attributes values
     * @throws DatabaseException in case of any error while retrieving the referenced object value
     */
    V get();
}
