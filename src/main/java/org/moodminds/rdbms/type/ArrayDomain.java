package org.moodminds.rdbms.type;

/**
 * Parent interface for all array domains.
 *
 * @param <V> the type of the corresponding element java type
 * @param <A> the type of the element RDBMS data type
 */
public interface ArrayDomain<V, A extends Type<V>> extends ArrayClass<V, A>, Domain<V[]> {}
