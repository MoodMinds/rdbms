package org.moodminds.rdbms.clause;

import org.moodminds.rdbms.ClauseException;
import org.moodminds.rdbms.Types;

/**
 * RDBMS clauses definition function by the clausings and the RDBMS {@link Types}
 * which returns the {@link Clausing} result.
 *
 * @param <$C> the type of the clausings definition object
 * @param <$T> the type of the RDBMS types' accessor interface
 * @param <C> the type of the {@link Clausing} definition result object
 */
@FunctionalInterface
public interface Clause<$C, $T extends Types, C extends Clausing<?>> {

    /**
     * Define a {@link Clausing} by the given clausings definition object and the RDBMS {@link Types}.
     *
     * @param clausings the given clausings definition object
     * @param types the given RDBMS {@link Types} accessor object
     * @return a {@link Clausing} by the given clausings definition object and the RDBMS {@link Types}.
     * @throws ClauseException an exception in case of any definition error
     */
    C clause($C clausings, $T types);
}
