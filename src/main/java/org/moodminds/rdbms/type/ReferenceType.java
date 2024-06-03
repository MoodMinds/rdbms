package org.moodminds.rdbms.type;

import org.moodminds.rdbms.data.Reference;

import java.util.Optional;

import static org.moodminds.sneaky.Cast.cast;

/**
 * Parent interface for all {@link Reference} types.
 */
public interface ReferenceType<V, R extends Type<V>> extends Domain<Reference<V>>, Type<Reference<V>> {

    /**
     * Return the name of this {@link Reference} type.
     *
     * @return the name of this {@link Reference} type
     */
    @Override
    String getName();

    /**
     * Return this reference type's referenced RDBMS data type.
     *
     * @return this reference type's referenced RDBMS data type
     */
    Optional<R> getReferencedType();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<Reference<V>> getType() {
        return cast(Reference.class);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default ReferenceType<V, R> getDomain() {
        return this;
    }
}
