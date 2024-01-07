package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;

/**
 * An RDBMS relation 7-attributes tuple.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 * @param <V6> the type of value 6
 * @param <V7> the type of value 7
 */
public interface Tuple7<V1, V2, V3, V4, V5, V6, V7> extends Tuple,
        org.moodminds.elemental.Tuple7<V1, V2, V3, V4, V5, V6, V7> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws {@inheritDoc}
     */
    @Override
    Header7<V1, V2, V3, V4, V5, V6, V7> getHeader();

    /**
     * Return attribute 1 value.
     *
     * @return attribute 1 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V1 get1st() {
        return org.moodminds.elemental.Tuple7.super.get1st();
    }

    /**
     * Return attribute 2 value.
     *
     * @return attribute 2 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V2 get2nd() {
        return org.moodminds.elemental.Tuple7.super.get2nd();
    }

    /**
     * Return attribute 3 value.
     *
     * @return attribute 3 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V3 get3rd() {
        return org.moodminds.elemental.Tuple7.super.get3rd();
    }

    /**
     * Return attribute 4 value.
     *
     * @return attribute 4 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V4 get4th() {
        return org.moodminds.elemental.Tuple7.super.get4th();
    }

    /**
     * Return attribute 5 value.
     *
     * @return attribute 5 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V5 get5th() {
        return org.moodminds.elemental.Tuple7.super.get5th();
    }

    /**
     * Return attribute 6 value.
     *
     * @return attribute 6 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V6 get6th() {
        return org.moodminds.elemental.Tuple7.super.get6th();
    }

    /**
     * Return attribute 7 value.
     *
     * @return attribute 7 value
     * @throws RdbmsException an exception in case of value retrieving error
     */
    @Override
    default V7 get7th() {
        return org.moodminds.elemental.Tuple7.super.get7th();
    }
}
