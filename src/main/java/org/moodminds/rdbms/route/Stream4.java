package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;

/**
 * Streaming route definition function by the {@link Flow} and 4 argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <V>  the type of the emitting values
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Stream4<I1, I2, I3, I4, V, E extends Exception>
        extends Stream4Level3<I1, I2, I3, I4, V, E, Statings, Types> {}
