package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;
import org.moodminds.rdbms.type.Type;
import org.moodminds.elemental.KeyValue;
import org.moodminds.elemental.Tuple3;

/**
 * An RDBMS relation 3-attributes tuple header object.
 */
public interface Header3<V1, V2, V3> extends Header,
        Tuple3<KeyValue<String, ? extends Type<? extends V1>>, KeyValue<String, ? extends Type<? extends V2>>,
               KeyValue<String, ? extends Type<? extends V3>>> {

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
        return Tuple3.super.get1st();
    }

    /**
     * Return attribute 2.
     *
     * @return attribute 2
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V2>> get2nd() {
        return Tuple3.super.get2nd();
    }

    /**
     * Return attribute 3.
     *
     * @return attribute 3
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    default KeyValue<String, ? extends Type<? extends V3>> get3rd() {
        return Tuple3.super.get3rd();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws {@inheritDoc}
     */
    @Override
    default int width() {
        return Tuple3.super.width();
    }
}
