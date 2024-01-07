package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;
import org.moodminds.rdbms.type.Type;
import org.moodminds.elemental.KeyValue;
import org.moodminds.elemental.Tuple7;

/**
 * An RDBMS relation 7-attributes tuple header object.
 */
public interface Header7<V1, V2, V3, V4, V5, V6, V7> extends Header,
        Tuple7<KeyValue<String, ? extends Type<? extends V1>>, KeyValue<String, ? extends Type<? extends V2>>,
               KeyValue<String, ? extends Type<? extends V3>>, KeyValue<String, ? extends Type<? extends V4>>,
               KeyValue<String, ? extends Type<? extends V5>>, KeyValue<String, ? extends Type<? extends V6>>,
               KeyValue<String, ? extends Type<? extends V7>>> {

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
        return Tuple7.super.get1st();
    }

    /**
     * Return attribute 2.
     *
     * @return attribute 2
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V2>> get2nd() {
        return Tuple7.super.get2nd();
    }

    /**
     * Return attribute 3.
     *
     * @return attribute 3
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V3>> get3rd() {
        return Tuple7.super.get3rd();
    }

    /**
     * Return attribute 4.
     *
     * @return attribute 4
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V4>> get4th() {
        return Tuple7.super.get4th();
    }

    /**
     * Return attribute 5.
     *
     * @return attribute 5
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V5>> get5th() {
        return Tuple7.super.get5th();
    }

    /**
     * Return attribute 6.
     *
     * @return attribute 6
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V6>> get6th() {
        return Tuple7.super.get6th();
    }

    /**
     * Return attribute 7.
     *
     * @return attribute 7
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V7>> get7th() {
        return Tuple7.super.get7th();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws {@inheritDoc}
     */
    @Override
    default int width() {
        return Tuple7.super.width();
    }
}
