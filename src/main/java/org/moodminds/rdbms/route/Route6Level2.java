package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Routing;

/**
 * Route definition function by the {@link Flow} and 6 argument values level 2.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route6Level2<I1, I2, I3, I4, I5, I6, E extends Exception, $S, $T extends Types, $R extends Routing<?>>
        extends Route6Level1<I1, I2, I3, I4, I5, I6, E, $S, $T, $R> {}
