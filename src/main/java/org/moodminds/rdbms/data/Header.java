package org.moodminds.rdbms.data;

import org.moodminds.rdbms.RdbmsException;
import org.moodminds.rdbms.type.Type;
import org.moodminds.elemental.KeyValue;
import org.moodminds.elemental.Tuple;

/**
 * An RDBMS relation tuple attributes header object.
 */
public interface Header extends Tuple {

    /**
     * Return attribute by the given index position.
     *
     * @param index the index position of the value
     * @return attribute by the given index position
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index &lt; 0 || index &gt;= size()})
     * @throws RdbmsException an exception in case of attribute obtaining error
     */
    @Override
    @SuppressWarnings("unchecked")
    KeyValue<String, ? extends Type<?>> get(int index);

    /**
     * Return the RDBMS data type of the relation attribute by the given name.
     *
     * @param name the given relation attribute name
     * @return the RDBMS data type of the relation attribute by the given name
     * @throws IllegalArgumentException an exception in case of absence of the given attribute name
     * @throws RdbmsException an exception in case of attribute type obtaining error
     */
    Type<?> get(String name);

    /**
     * Return the width of the RDBMS relation.
     *
     * @return the width of the RDBMS relation
     * @throws RdbmsException an exception in case of the width obtaining error
     */
    @Override
    int width();
}
