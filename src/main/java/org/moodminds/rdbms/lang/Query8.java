package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple8;

/**
 * An RDBMS {@link Relation} 8-attributes result retrieving statement.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 * @param <V6> the type of value 6
 * @param <V7> the type of value 7
 * @param <V8> the type of value 8
 */
public interface Query8<V1, V2, V3, V4, V5, V6, V7, V8> extends Query<Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>> {}
