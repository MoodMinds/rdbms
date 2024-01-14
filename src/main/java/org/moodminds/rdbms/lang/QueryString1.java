package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple1;

/**
 * An RDBMS {@link Relation} 1-attribute result retrieving SQL string statement.
 *
 * @param <V> the type of the value
 */
public interface QueryString1<V>
        extends Query1<V>, QueryString<Relation<Tuple1<V>>> {}
