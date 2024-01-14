package org.moodminds.rdbms.config;

import org.moodminds.rdbms.SettingException;

/**
 * RDBMS settings definition function by the {@link Settings}.
 *
 * @param <S> the type of the {@link Settings} interface
 */
@FunctionalInterface
public interface Setting<S extends Settings> {

    /**
     * Set up the RDBMS configuration by the given {@link Settings} definition object.
     *
     * @param settings the given {@link Settings} definition object
     * @throws SettingException an exception in case of any settings error
     */
    void set(S settings);
}
