package org.moodminds.rdbms;

/**
 * An exception indicating that retry of the same operation would fail unless the cause is corrected.
 */
public class NonTransientException extends DatabaseException {

    private static final long serialVersionUID = 7438015766072498062L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public NonTransientException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and "SQLState" string.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     */
    public NonTransientException(String message, String sqlState) {
        super(message, sqlState);
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string and vendor-specific error code.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param errorCode the vendor-specific error code
     */
    public NonTransientException(String message, String sqlState, int errorCode) {
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
    public NonTransientException(String message, String sqlState, int errorCode, Throwable cause) {
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
    public NonTransientException(String message, String sqlState, Throwable cause) {
        super(message, sqlState, cause);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public NonTransientException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public NonTransientException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public NonTransientException getException() {
        return (NonTransientException) super.getException();
    }
}
