package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple5;

/**
 * An RDBMS {@link Relation} 5-attributes result retrieving SQL string statement.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 */
public interface QueryString5<V1, V2, V3, V4, V5>
        extends Query5<V1, V2, V3, V4, V5>, QueryString<Relation<Tuple5<V1, V2, V3, V4, V5>>> {}
