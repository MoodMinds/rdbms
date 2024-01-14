package org.moodminds.rdbms.type;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple;

import static org.moodminds.sneaky.Cast.cast;

/**
 * Parent interface for all {@link Relation} resource types.
 */
public interface RelationType extends ResourceType<Tuple, Relation<?>> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<Relation<?>> getType() {
        return cast(Relation.class);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<Tuple> getValueType() {
        return Tuple.class;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default RelationType getDomain() {
        return (RelationType) ResourceType.super.getDomain();
    }
}
