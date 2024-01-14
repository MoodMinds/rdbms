package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;
import org.moodminds.rdbms.data.Tuple3;

/**
 * An RDBMS {@link Relation} 3-attributes result retrieving SQL string statement.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 */
public interface QueryString3<V1, V2, V3>
        extends Query3<V1, V2, V3>, QueryString<Relation<Tuple3<V1, V2, V3>>> {}
