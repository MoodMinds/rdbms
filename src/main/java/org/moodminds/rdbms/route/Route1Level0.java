package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Route1;
import org.moodminds.route.Routing;

/**
 * Route definition function by the {@link Flow} and argument value level 0.
 *
 * @param <I> the type of the input argument
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route1Level0<I, E extends Exception, $S, $T extends Types, $R extends Routing<?>>
        extends Route1<Flow<?, ? extends $S, ? extends $T, E>, I, $R> {}
