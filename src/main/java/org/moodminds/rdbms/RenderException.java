package org.moodminds.rdbms;

/**
 * An exception indicating an error on SQL rendering.
 */
public class RenderException extends RdbmsException {

    private static final long serialVersionUID = 5966392797561430143L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public RenderException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public RenderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public RenderException(Throwable cause) {
        super(cause);
    }
}
