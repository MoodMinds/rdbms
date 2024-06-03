package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Flowing;

/**
 * Action route definition function by the {@link Flow} and 7 argument values level 3.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <I7> the type of the input argument 7
 * @param <E>  the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 */
@FunctionalInterface
public interface Action7Level3<I1, I2, I3, I4, I5, I6, I7, E extends Exception, $S, $T extends Types>
        extends Route7Level3<I1, I2, I3, I4, I5, I6, I7, E, $S, $T, Flowing<?>>, Action7Level2<I1, I2, I3, I4, I5, I6, I7, E, $S, $T> {}
