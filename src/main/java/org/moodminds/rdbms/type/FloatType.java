package org.moodminds.rdbms.type;

/**
 * Parent interface for all float {@link Number} types.
 *
 * @param <V> the type of the corresponding java type
 */
public interface FloatType<V extends Number> extends FloatClass<V>, Type<V> {

    /**
     * Return size of this float number type.
     *
     * @return size of this float number type
     */
    int getSize();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    FloatDomain<V> getDomain();
}
