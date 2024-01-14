package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple4;

/**
 * An RDBMS {@link Relation} 4-attributes result retrieving SQL string statement.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 */
public interface QueryString4<V1, V2, V3, V4>
        extends Query4<V1, V2, V3, V4>, QueryString<Relation<Tuple4<V1, V2, V3, V4>>> {}
