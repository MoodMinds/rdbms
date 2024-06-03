package org.moodminds.rdbms;

/**
 * An exception indicating that the required type is absent.
 */
public class TypeAbsenceException extends RdbmsException {

    private static final long serialVersionUID = 6768872166474870434L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public TypeAbsenceException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public TypeAbsenceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public TypeAbsenceException(Throwable cause) {
        super(cause);
    }
}