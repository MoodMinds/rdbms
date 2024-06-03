package org.moodminds.rdbms.type;

/**
 * Represents the root of the precise {@link Number} type hierarchy.
 *
 * @param <V> the type of the corresponding java type
 */
public interface PreciseClass<V extends Number> extends NumberClass<V> {}
