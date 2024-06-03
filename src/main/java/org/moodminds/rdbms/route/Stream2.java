package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;

/**
 * Streaming route definition function by the {@link Flow} and 2 argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Stream2<I1, I2, V, E extends Exception>
        extends Stream2Level3<I1, I2, V, E, Statings, Types> {}
