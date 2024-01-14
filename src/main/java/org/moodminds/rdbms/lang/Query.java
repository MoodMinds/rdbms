package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;

/**
 * An RDBMS {@link Relation} result retrieving statement.
 *
 * @param <R> the type of the result {@link Relation}
 */
public interface Query<R extends Relation<?>> extends Stateable<Query<R>> {}
