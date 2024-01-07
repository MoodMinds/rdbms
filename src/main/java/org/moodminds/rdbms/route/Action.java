package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;
import org.moodminds.route.Flowing;

/**
 * Action route definition function by the {@link Flow}.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Action<E extends Exception>
        extends RouteLevel3<E, Statings, Types, Flowing<?>> {}
