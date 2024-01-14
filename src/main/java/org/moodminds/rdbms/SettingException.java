package org.moodminds.rdbms;

/**
 * An exception indicating an error on RDBMS client configuration setting.
 */
public class SettingException extends RdbmsException {

    private static final long serialVersionUID = 1171820014170390379L;

    /**
     * Construct the object with the specified reason message.
     *
     * @param message the reason message
     */
    public SettingException(String message) {
        super(message);
    }

    /**
     * Construct the object with the specified reason message and the actual {@link Throwable} cause.
     *
     * @param message the reason message
     * @param cause the reason cause
     */
    public SettingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the specified actual {@link Throwable} cause.
     *
     * @param cause the reason cause
     */
    public SettingException(Throwable cause) {
        super(cause);
    }
}
