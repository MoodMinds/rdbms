package org.moodminds.rdbms.type;

/**
 * Represents the root of the {@link Number} type hierarchy.
 *
 * @param <V> the type of the corresponding java type
 */
public interface NumberClass<V extends Number> extends Class<V> {}
