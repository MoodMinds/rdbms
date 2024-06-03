package org.moodminds.rdbms.lang;

import org.moodminds.rdbms.data.Relation;

/**
 * An RDBMS {@link Relation} result retrieving SQL string statement.
 *
 * @param <R> the type of the result {@link Relation}
 */
public interface QueryString<R extends Relation<?>> extends Query<R>, StatementString {}
