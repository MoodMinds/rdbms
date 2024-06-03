package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple1;

/**
 * An RDBMS {@link Relation} 1-attribute result retrieving statement.
 *
 * @param <V> the type of the value
 */
public interface Query1<V> extends Query<Relation<Tuple1<V>>> {}
