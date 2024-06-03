package org.moodminds.rdbms.data;

import org.moodminds.emission.Resource;
import org.moodminds.rdbms.DatabaseException;
import org.moodminds.rdbms.RdbmsException;

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
     * @throws RdbmsException an exception in case of header obtaining error
     */
    Header getHeader();
}
