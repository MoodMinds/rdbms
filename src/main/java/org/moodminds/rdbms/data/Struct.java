package org.moodminds.rdbms.data;

import org.moodminds.elemental.Ordered;
import org.moodminds.rdbms.NonTransientException;

import static org.moodminds.sneaky.Cast.cast;

/**
 * An RDBMS structured type data object.
 */
public class Struct implements Ordered<Object> {

    /**
     * A name of the RDBMS structured type holder field.
     */
    private final String name;

    /**
     * An RDBMS structured type attributes holder field.
     */
    private final Object[] attributes;

    /**
     * Construct the object with the given RDBMS structured type name and attributes.
     *
     * @param name the given RDBMS structured type name
     * @param attributes the given RDBMS structured type attributes
     */
    public Struct(String name, Object... attributes) {
        if (name == null || name.isEmpty() || attributes.length == 0)
            throw new NonTransientException("The structure should consist of not empty name and at least one attribute.");
        this.name = name; this.attributes = attributes;
    }

    /**
     * Return the RDBMS structured type name.
     *
     * @return the RDBMS structured type name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the RDBMS structured type attribute value by the given index.
     *
     * @param index the index position of the attribute value
     * @return the RDBMS structured type attribute value by the given index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public <R> R get(int index) {
        return cast(attributes[index]);
    }
}
