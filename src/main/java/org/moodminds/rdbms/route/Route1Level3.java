package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Routing;

/**
 * Route definition function by the {@link Flow} and argument value level 3.
 *
 * @param <I> the type of the input argument
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route1Level3<I, E extends Exception, $S, $T extends Types, $R extends Routing<?>>
        extends Route1Level2<I, E, $S, $T, $R> {}
