package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple3;

/**
 * An RDBMS {@link Relation} 3-attributes result retrieving statement.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 */
public interface Query3<V1, V2, V3> extends Query<Relation<Tuple3<V1, V2, V3>>> {}
