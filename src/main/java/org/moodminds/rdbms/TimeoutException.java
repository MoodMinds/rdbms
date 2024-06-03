package org.moodminds.rdbms;

/**
 * Exception indicating that the timeout specified by a database operation (query, login) is exceeded.
 */
public class TimeoutException extends TransientException {

    private static final long serialVersionUID = -4990743203160926073L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public TimeoutException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and "SQLState" string.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     */
    public TimeoutException(String message, String sqlState) {
        super(message, sqlState);
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string and vendor-specific error code.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param errorCode the vendor-specific error code
     */
    public TimeoutException(String message, String sqlState, int errorCode) {
        super(message, sqlState, errorCode);
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
    public TimeoutException(String message, String sqlState, int errorCode, Throwable cause) {
        super(message, sqlState, errorCode, cause);
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string
     * and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param cause the reason cause
     */
    public TimeoutException(String message, String sqlState, Throwable cause) {
        super(message, sqlState, cause);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public TimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public TimeoutException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public TimeoutException getException() {
        return (TimeoutException) super.getException();
    }
}
