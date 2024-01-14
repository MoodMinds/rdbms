package org.moodminds.rdbms.type;

/**
 * Parent interface for all array types.
 *
 * @param <V> the type of the corresponding element java type
 * @param <A> the type of the element RDBMS data type
 */
public interface ArrayType<V, A extends Type<V>> extends ArrayClass<V, A>, Type<V[]> {

    /**
     * Return this array type's length.
     *
     * @return this array type's length
     */
    int getSize();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    ArrayDomain<V, A> getDomain();
}
