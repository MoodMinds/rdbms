package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Routing;

/**
 * Route definition function by the {@link Flow} level 1.
 *
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface RouteLevel1<E extends Exception, $S, $T extends Types, $R extends Routing<?>>
        extends RouteLevel0<E, $S, $T, $R> {}
