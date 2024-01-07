package org.moodminds.rdbms;

/**
 * Exception indicating that the underlying resource denied a permission
 * to access a specific object, e.g. database table.
 */
public class PermissionException extends NonTransientException {

    private static final long serialVersionUID = 1271833728173477315L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public PermissionException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and "SQLState" string.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     */
    public PermissionException(String message, String sqlState) {
        super(message, sqlState);
    }

    /**
     * Construct the object with the specified reason message, "SQLState" string and vendor-specific error code.
     *
     * @param message the reason message
     * @param sqlState the "SQLState" string
     * @param errorCode the vendor-specific error code
     */
    public PermissionException(String message, String sqlState, int errorCode) {
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
    public PermissionException(String message, String sqlState, int errorCode, Throwable cause) {
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
    public PermissionException(String message, String sqlState, Throwable cause) {
        super(message, sqlState, cause);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public PermissionException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public PermissionException getException() {
        return (PermissionException) super.getException();
    }
}
