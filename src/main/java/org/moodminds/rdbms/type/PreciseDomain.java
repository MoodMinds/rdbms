package org.moodminds.rdbms.type;

/**
 * Parent interface for all precise {@link Number} domains.
 *
 * @param <V> the type of the corresponding java type
 */
public interface PreciseDomain<V extends Number> extends PreciseClass<V>, Domain<V> {}
