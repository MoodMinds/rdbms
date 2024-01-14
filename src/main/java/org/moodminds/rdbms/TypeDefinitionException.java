package org.moodminds.rdbms;

/**
 * An exception indicating some error in type definition, e.g. mistyping in the type name
 * or incorrect precision/scale or other cases.
 */
public class TypeDefinitionException extends RdbmsException {

    private static final long serialVersionUID = 3179985578289999493L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public TypeDefinitionException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public TypeDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public TypeDefinitionException(Throwable cause) {
        super(cause);
    }
}