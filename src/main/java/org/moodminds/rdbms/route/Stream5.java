package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;
import org.moodminds.route.Emitting;

/**
 * Streaming route definition function by the {@link Flow} and argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <V>  the type of the emitting values
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Stream5<I1, I2, I3, I4, I5, V, E extends Exception>
        extends Route5Level3<I1, I2, I3, I4, I5, E, Statings, Types, Emitting<? extends V>> {}
