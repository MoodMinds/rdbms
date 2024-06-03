package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Emitting;

/**
 * Streaming route definition function by the {@link Flow} and 2 argument values level 2.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 */
@FunctionalInterface
public interface Stream2Level2<I1, I2, V, E extends Exception, $S, $T extends Types>
        extends Route2Level2<I1, I2, E, $S, $T, Emitting<? extends V>>, Stream2Level1<I1, I2, V, E, $S, $T> {}
