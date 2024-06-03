package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.route.Flowing;

/**
 * Action route definition function by the {@link Flow} and argument value level 1.
 *
 * @param <I> the type of the input argument
 * @param <E> the type of possible exception
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 */
@FunctionalInterface
public interface Action1Level1<I, E extends Exception, $S, $T extends Types>
        extends Route1Level1<I, E, $S, $T, Flowing<?>> {}
