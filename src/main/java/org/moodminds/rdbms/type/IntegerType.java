package org.moodminds.rdbms.type;

/**
 * Parent interface for all integer {@link Number} types.
 *
 * @param <V> the type of the corresponding java type
 */
public interface IntegerType<V extends Number> extends NumberClass<V>, Domain<V>, Type<V> {

    /**
     * Return the name of this integer number type.
     *
     * @return the name of this integer number type
     */
    @Override
    String getName();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default IntegerType<V> getDomain() {
        return this;
    }
}
