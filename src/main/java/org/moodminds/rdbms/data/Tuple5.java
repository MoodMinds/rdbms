package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;

/**
 * An RDBMS relation 5-attributes tuple.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 */
public interface Tuple5<V1, V2, V3, V4, V5> extends Tuple,
        org.moodminds.elemental.Tuple5<V1, V2, V3, V4, V5> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws {@inheritDoc}
     */
    @Override
    Header5<V1, V2, V3, V4, V5> getHeader();

    /**
     * Return attribute 1 value.
     *
     * @return attribute 1 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V1 get1st() {
        return org.moodminds.elemental.Tuple5.super.get1st();
    }

    /**
     * Return attribute 2 value.
     *
     * @return attribute 2 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V2 get2nd() {
        return org.moodminds.elemental.Tuple5.super.get2nd();
    }

    /**
     * Return attribute 3 value.
     *
     * @return attribute 3 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V3 get3rd() {
        return org.moodminds.elemental.Tuple5.super.get3rd();
    }

    /**
     * Return attribute 4 value.
     *
     * @return attribute 4 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V4 get4th() {
        return org.moodminds.elemental.Tuple5.super.get4th();
    }

    /**
     * Return attribute 5 value.
     *
     * @return attribute 5 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V5 get5th() {
        return org.moodminds.elemental.Tuple5.super.get5th();
    }
}
