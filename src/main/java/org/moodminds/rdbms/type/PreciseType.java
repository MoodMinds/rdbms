package org.moodminds.rdbms.type;

/**
 * Parent interface for all precise {@link Number} types.
 *
 * @param <V> the type of the corresponding java type
 */
public interface PreciseType<V extends Number> extends PreciseClass<V>, Type<V> {

    /**
     * Return precision of this precise number type.
     *
     * @return precision of this precise number type
     */
    int getPrecision();

    /**
     * Return scale of this precise number type.
     *
     * @return scale of this precise number type
     */
    int getScale();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    PreciseDomain<V> getDomain();
}
