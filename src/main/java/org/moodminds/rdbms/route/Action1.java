package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;
import org.moodminds.route.Flowing;

/**
 * Action route definition function by the {@link Flow} and argument value.
 *
 * @param <I> the type of the input argument
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Action1<I, E extends Exception>
        extends Route1Level3<I, E, Statings, Types, Flowing<?>> {}
