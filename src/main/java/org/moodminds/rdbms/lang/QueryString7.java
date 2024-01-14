package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple7;

/**
 * An RDBMS {@link Relation} 7-attributes result retrieving SQL string statement.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 * @param <V6> the type of value 6
 * @param <V7> the type of value 7
 */
public interface QueryString7<V1, V2, V3, V4, V5, V6, V7>
        extends Query7<V1, V2, V3, V4, V5, V6, V7>, QueryString<Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>> {}
