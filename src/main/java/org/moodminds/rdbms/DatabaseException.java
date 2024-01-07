package org.moodminds.rdbms;

import org.moodminds.rdbms.data.Signal;

/**
 * A root of exceptions for a database access error.
 */
public class DatabaseException extends RdbmsException implements Signal {

    private static final long serialVersionUID = -1594825983808147732L;
    /**
     * The "SQLState" holder field.
     */
    private final String sqlState;

    /**
     * The vendor-specific error code holder field.
     */
    private final int errorCode;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public DatabaseException(String message) {
        this(message, null, 0);
    }

    /**
     * Construct the object with the specified reason message and "SQLState" string.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     */
    public DatabaseException(String message, String sqlState) {
        this(message, sqlState, 0);
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string and vendor-specific error code.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param errorCode the vendor-specific error code
     */
    public DatabaseException(String message, String sqlState, int errorCode) {
        super(message);
        this.sqlState = sqlState;
        this.errorCode = errorCode;
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string,
     * vendor-specific error code and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param errorCode the vendor-specific error code
     * @param cause the reason cause
     */
    public DatabaseException(String message, String sqlState, int errorCode, Throwable cause) {
        super(message, cause);
        this.sqlState = sqlState;
        this.errorCode = errorCode;
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string
     * and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param cause the reason cause
     */
    public DatabaseException(String message, String sqlState, Throwable cause) {
        this(message, sqlState, 0, cause);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public DatabaseException(String message, Throwable cause) {
        this(message, null, 0, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public DatabaseException(Throwable cause) {
        super(cause);
        sqlState = null;
        errorCode = 0;
    }

    /**
     * Return the error code of this exception.
     *
     * @return the error code of this exception
     */
    public int getError() {
        return errorCode;
    }

    /**
     * Return the "SQLState" string of this exception.
     *
     * @return the "SQLState" string of this exception
     */
    public String getState() {
        return sqlState;
    }

    /**
     * Returns the detail message string of this exception.
     *
     * @return  the detail message string of this exception
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * Return this event.
     *
     * @return this event
     */
    @Override
    public DatabaseException getException() {
        return this;
    }
}
