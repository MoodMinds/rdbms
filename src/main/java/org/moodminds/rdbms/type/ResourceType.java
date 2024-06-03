package org.moodminds.rdbms.type;

import org.moodminds.emission.Resource;
import org.moodminds.rdbms.DatabaseException;

/**
 * Parent interface for all {@link Resource} types.
 *
 * @param <V> the type of the corresponding value java type
 * @param <R> the type of the {@link Resource} java type
 */
public interface ResourceType<V, R extends Resource<? extends V, DatabaseException>>
        extends Domain<R>, Type<R> {

    /**
     * Return the name of this {@link Resource} type.
     *
     * @return the name of this {@link Resource} type
     */
    @Override
    String getName();

    /**
     * Return the java type of values of this RDBMS data type.
     *
     * @return the java type of values of this RDBMS data type
     */
    java.lang.Class<? extends V> getValueType();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default ResourceType<V, R> getDomain() {
        return this;
    }
}
