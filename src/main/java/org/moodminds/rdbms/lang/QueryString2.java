package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple2;

/**
 * An RDBMS {@link Relation} 2-attributes result retrieving SQL string statement.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 */
public interface QueryString2<V1, V2>
        extends Query2<V1, V2>, QueryString<Relation<Tuple2<V1, V2>>> {}
