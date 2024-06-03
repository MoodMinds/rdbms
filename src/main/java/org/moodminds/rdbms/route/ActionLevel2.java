package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Flowing;

/**
 * Action route definition function by the {@link Flow} level 2.
 *
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 */
@FunctionalInterface
public interface ActionLevel2<E extends Exception, $S, $T extends Types>
        extends RouteLevel2<E, $S, $T, Flowing<?>>, ActionLevel1<E, $S, $T> {}
