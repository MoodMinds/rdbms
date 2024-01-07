package org.moodminds.rdbms.data;

import org.moodminds.emission.Resource;
import org.moodminds.rdbms.DatabaseException;

/**
 * An RDBMS relation data object.
 *
 * @param <T> the type of the relation tuple
 */
public interface Relation<T extends Tuple> extends Resource<T, DatabaseException> {

    /**
     * Return a relation attributes header.
     *
     * @return a relation attributes header
     * @throws DatabaseException an exception in case of header obtaining error
     */
    Header getHeader();
}
