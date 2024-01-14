package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;

/**
 * An RDBMS relation 3-attributes tuple.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 */
public interface Tuple3<V1, V2, V3> extends Tuple,
        org.moodminds.elemental.Tuple3<V1, V2, V3> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws {@inheritDoc}
     */
    @Override
    Header3<V1, V2, V3> getHeader();

    /**
     * Return attribute 1 value.
     *
     * @return attribute 1 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V1 get1st() {
        return org.moodminds.elemental.Tuple3.super.get1st();
    }

    /**
     * Return attribute 2 value.
     *
     * @return attribute 2 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V2 get2nd() {
        return org.moodminds.elemental.Tuple3.super.get2nd();
    }

    /**
     * Return attribute 3 value.
     *
     * @return attribute 3 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V3 get3rd() {
        return org.moodminds.elemental.Tuple3.super.get3rd();
    }
}
