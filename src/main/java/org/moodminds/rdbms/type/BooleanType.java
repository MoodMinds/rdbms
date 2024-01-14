package org.moodminds.rdbms.type;

/**
 * Parent interface for all {@link Boolean} types.
 */
public interface BooleanType extends Domain<Boolean>, Type<Boolean> {

    /**
     * Return the name of this {@link Boolean} type.
     *
     * @return the name of this {@link Boolean} type
     */
    @Override
    String getName();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<Boolean> getType() {
        return Boolean.class;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default BooleanType getDomain() {
        return this;
    }
}
