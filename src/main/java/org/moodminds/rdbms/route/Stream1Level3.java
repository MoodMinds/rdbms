package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Emitting;

/**
 * Streaming route definition function by the {@link Flow} and argument value level 3.
 *
 * @param <I> the type of the input argument
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 */
@FunctionalInterface
public interface Stream1Level3<I, V, E extends Exception, $S, $T extends Types>
        extends Route1Level3<I, E, $S, $T, Emitting<? extends V>>, Stream1Level2<I, V, E, $S, $T> {}
