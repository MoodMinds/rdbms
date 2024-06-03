package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Flowing;

/**
 * Action route definition function by the {@link Flow} and 8 argument values level 3.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <I7> the type of the input argument 7
 * @param <I8> the type of the input argument 8
 * @param <E>  the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 */
@FunctionalInterface
public interface Action8Level3<I1, I2, I3, I4, I5, I6, I7, I8, E extends Exception, $S, $T extends Types>
        extends Route8Level3<I1, I2, I3, I4, I5, I6, I7, I8, E, $S, $T, Flowing<?>>, Action8Level2<I1, I2, I3, I4, I5, I6, I7, I8, E, $S, $T> {}