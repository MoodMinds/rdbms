package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Route4;
import org.moodminds.route.Routing;

/**
 * Route definition function by the {@link Flow} and 4 argument values level 0.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route4Level0<I1, I2, I3, I4, E extends Exception, $S, $T extends Types, $R extends Routing<?>>
        extends Route4<Flow<?, ? extends $S, ? extends $T, E>, I1, I2, I3, I4, $R> {}
