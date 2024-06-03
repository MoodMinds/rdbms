package org.moodminds.rdbms.clause;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.lang.Statement;

/**
 * An RDBMS {@link Statement} definition function by the given {@link Statings} and {@link Types} objects.
 *
 * @param <S> the type of the {@link Statement} definition object
 */
@FunctionalInterface
public interface Script<S extends Statement> extends Clause<Statings, Types, Clausing<? extends S>> {}