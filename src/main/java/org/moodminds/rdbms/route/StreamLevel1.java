package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Emitting;

/**
 * Streaming route definition function by the {@link Flow} level 1.
 *
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 */
@FunctionalInterface
public interface StreamLevel1<V, E extends Exception, $S, $T extends Types>
        extends RouteLevel1<E, $S, $T, Emitting<? extends V>> {}
