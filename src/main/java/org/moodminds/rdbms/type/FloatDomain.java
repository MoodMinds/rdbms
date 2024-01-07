package org.moodminds.rdbms.type;

/**
 * Parent interface for all float {@link Number} domains.
 *
 * @param <V> the type of the corresponding java type
 */
public interface FloatDomain<V extends Number> extends FloatClass<V>, Domain<V> {}
