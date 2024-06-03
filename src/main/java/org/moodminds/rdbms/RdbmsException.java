package org.moodminds.rdbms;

/**
 * Root of the RDBMS exceptions hierarchy.
 */
public class RdbmsException extends RuntimeException {

    private static final long serialVersionUID = -1785761374142446607L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public RdbmsException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public RdbmsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public RdbmsException(Throwable cause) {
        super(cause);
    }
}
