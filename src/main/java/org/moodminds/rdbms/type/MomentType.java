package org.moodminds.rdbms.type;

import java.time.temporal.Temporal;

/**
 * Parent interface for all moment {@link Temporal} types.
 *
 * @param <V> the type of the corresponding java type
 */
public interface MomentType<V extends Temporal> extends TemporalClass<V>, Domain<V>, Type<V> {

    /**
     * Return the name of this moment temporal type.
     *
     * @return the name of this moment temporal type
     */
    @Override
    String getName();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default MomentType<V> getDomain() {
        return this;
    }
}
