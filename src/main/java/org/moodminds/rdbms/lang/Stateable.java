package org.moodminds.rdbms.lang;

/**
 * Generic {@link Statement} type marker interface. Used to prevent generic type merging.
 *
 * @param <S> the type of the marker
 */
interface Stateable<S extends Statement> extends Statement {}
