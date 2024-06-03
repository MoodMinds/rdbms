package org.moodminds.rdbms.route;

import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Statings;

/**
 * Action route definition function by the {@link Flow}.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Action<E extends Exception>
        extends ActionLevel3<E, Statings, Types> {}
