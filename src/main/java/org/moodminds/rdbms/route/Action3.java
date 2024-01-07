package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;
import org.moodminds.route.Flowing;

/**
 * Action route definition function by the {@link Flow} and argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Action3<I1, I2, I3, E extends Exception>
        extends Route3Level3<I1, I2, I3, E, Statings, Types, Flowing<?>> {}
