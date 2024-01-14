package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;
import org.moodminds.route.Emitting;

/**
 * Streaming route definition function by the {@link Flow} and argument value.
 *
 * @param <I> the type of the input argument
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Stream1<I, V, E extends Exception>
        extends Route1Level3<I, E, Statings, Types, Emitting<? extends V>> {}
