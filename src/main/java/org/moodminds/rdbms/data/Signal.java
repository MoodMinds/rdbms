package org.moodminds.rdbms.data;

import org.moodminds.rdbms.DatabaseException;

/**
 * A root for all rdbms signals - exceptions, warnings, messages and so on.
 * Provides detail about an "SQLState" string, which follows either the XOPEN SQLState conventions
 * or the SQL:2003 conventions and a vendor-specific error code representing this signal.
 */
public interface Signal {

    /**
     * Return the error code.
     *
     * @return the error code
     */
    int getError();

    /**
     * Return the "SQLState" string.
     *
     * @return the "SQLState" string
     */
    String getState();

    /**
     * Returns the detail message string.
     *
     * @return  the detail message string
     */
    String getMessage();

    /**
     * Return this event as {@link DatabaseException}.
     *
     * @return this event as {@link DatabaseException}
     */
    DatabaseException getException();
}
