package org.moodminds.rdbms.statement;

import org.moodminds.elemental.Sequence;

/**
 * An RDBMS SQL string command representation.
 */
public interface String extends Command {

    /**
     * Return the SQL string representation with parameters
     * placeholders represented by the "?" symbol.
     *
     * @return the SQL string representation with parameters
     * placeholders represented by the "?" symbol
     */
    java.lang.String getString();

    /**
     * Return the parameters sequence of this SQL string object.
     *
     * @return the parameters sequence of this SQL string object
     */
    @Override
    Sequence<? extends Parameter<?>> getParameters();
}
