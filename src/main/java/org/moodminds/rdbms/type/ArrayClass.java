package org.moodminds.rdbms.type;

import java.lang.reflect.Array;
import java.util.Optional;

import static org.moodminds.sneaky.Cast.cast;

/**
 * Represents the root of the array type hierarchy.
 *
 * @param <V> the type of the corresponding element java type
 * @param <A> the type of the element RDBMS data type
 */
public interface ArrayClass<V, A extends Type<V>> extends Class<V[]> {

    /**
     * Return this array type's element RDBMS data type.
     *
     * @return this array type's element RDBMS data type
     */
    Optional<A> getElementType();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<V[]> getType() {
        return cast(getElementType()
                .<java.lang.Class<?>>map(type -> Array.newInstance(type.getType(), 0).getClass())
                .orElse(Object[].class));
    }
}
