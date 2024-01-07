package org.moodminds.rdbms;

/**
 * Exception indicating that a resource fails temporarily and the operation can be retried.
 */
public class TransientResourceException extends TransientException {

    private static final long serialVersionUID = -8912808090048274688L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public TransientResourceException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and "SQLState" string.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     */
    public TransientResourceException(String message, String sqlState) {
        super(message, sqlState);
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string and vendor-specific error code.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param errorCode the vendor-specific error code
     */
    public TransientResourceException(String message, String sqlState, int errorCode) {
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
    public TransientResourceException(String message, String sqlState, int errorCode, Throwable cause) {
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
    public TransientResourceException(String message, String sqlState, Throwable cause) {
        super(message, sqlState, cause);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public TransientResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public TransientResourceException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public TransientResourceException getException() {
        return (TransientResourceException) super.getException();
    }
}
