package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;

/**
 * An RDBMS relation 1-attribute tuple.
 *
 * @param <V> the type of the value
 */
public interface Tuple1<V> extends Tuple,
        org.moodminds.elemental.Tuple1<V> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws {@inheritDoc}
     */
    @Override
    Header1<V> getHeader();

    /**
     * Return attribute value.
     *
     * @return attribute value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V get1st() {
        return org.moodminds.elemental.Tuple1.super.get1st();
    }
}
