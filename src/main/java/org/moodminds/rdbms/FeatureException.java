package org.moodminds.rdbms;

/**
 * An exception indicating that feature is not supported by the implementation on the client level.
 */
public class FeatureException extends RdbmsException {

    private static final long serialVersionUID = 3569735215699673615L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public FeatureException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public FeatureException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public FeatureException(Throwable cause) {
        super(cause);
    }
}
