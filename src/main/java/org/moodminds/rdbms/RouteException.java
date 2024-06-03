package org.moodminds.rdbms;

/**
 * An exception indicating an error on RDBMS client route definition.
 */
public class RouteException extends RdbmsException {

    private static final long serialVersionUID = -3989821505476697371L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public RouteException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public RouteException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public RouteException(Throwable cause) {
        super(cause);
    }
}
