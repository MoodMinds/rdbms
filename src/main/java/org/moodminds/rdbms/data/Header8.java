package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;
import org.moodminds.rdbms.type.Type;
import org.moodminds.elemental.KeyValue;
import org.moodminds.elemental.Tuple8;

/**
 * An RDBMS relation 8-attributes tuple header object.
 */
public interface Header8<V1, V2, V3, V4, V5, V6, V7, V8> extends Header,
        Tuple8<KeyValue<String, ? extends Type<? extends V1>>, KeyValue<String, ? extends Type<? extends V2>>,
               KeyValue<String, ? extends Type<? extends V3>>, KeyValue<String, ? extends Type<? extends V4>>,
               KeyValue<String, ? extends Type<? extends V5>>, KeyValue<String, ? extends Type<? extends V6>>,
               KeyValue<String, ? extends Type<? extends V7>>, KeyValue<String, ? extends Type<? extends V8>>> {

    /**
     * {@inheritDoc}
     *
     * @param index {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws RdbmsException {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    KeyValue<String, ? extends Type<?>> get(int index);

    /**
     * Return attribute 1.
     *
     * @return attribute 1
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V1>> get1st() {
        return Tuple8.super.get1st();
    }

    /**
     * Return attribute 2.
     *
     * @return attribute 2
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V2>> get2nd() {
        return Tuple8.super.get2nd();
    }

    /**
     * Return attribute 3.
     *
     * @return attribute 3
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V3>> get3rd() {
        return Tuple8.super.get3rd();
    }

    /**
     * Return attribute 4.
     *
     * @return attribute 4
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V4>> get4th() {
        return Tuple8.super.get4th();
    }

    /**
     * Return attribute 5.
     *
     * @return attribute 5
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V5>> get5th() {
        return Tuple8.super.get5th();
    }

    /**
     * Return attribute 6.
     *
     * @return attribute 6
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V6>> get6th() {
        return Tuple8.super.get6th();
    }

    /**
     * Return attribute 7.
     *
     * @return attribute 7
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V7>> get7th() {
        return Tuple8.super.get7th();
    }

    /**
     * Return attribute 8.
     *
     * @return attribute 8
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V8>> get8th() {
        return Tuple8.super.get8th();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws {@inheritDoc}
     */
    @Override
    default int width() {
        return Tuple8.super.width();
    }
}
