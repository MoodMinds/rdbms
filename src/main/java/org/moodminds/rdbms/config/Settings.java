package org.moodminds.rdbms.config;

import org.moodminds.rdbms.SettingException;
import org.moodminds.rdbms.render.Renderer;

import java.lang.reflect.Array;

import static org.moodminds.sneaky.Cast.cast;

/**
 * RDBMS settings configuration interface.
 */
public interface Settings {

    /**
     * Set the given default fetch size for relation results.
     *
     * @param fetch the given default fetch size
     * @return the self-instance
     * @throws SettingException an exception in case of any setting error
     */
    Settings fetch(int fetch);

    /**
     * Set the given default batch size for batch operations.
     *
     * @param fetch the given default batch size
     * @return the self-instance
     * @throws SettingException an exception in case of any setting error
     */
    Settings batch(int fetch);

    /**
     * Register the given {@link Renderer} renderers.
     *
     * @param renderer the given renderer
     * @param renderers the given renderers
     * @return the self-instance
     * @throws SettingException an exception in case of any setting error
     */
    @SuppressWarnings("unchecked")
    Settings render(Class<? extends Renderer<?, ?>> renderer, Class<? extends Renderer<?, ?>>... renderers);

    /**
     * Register the given {@link Renderer} renderer.
     *
     * @param renderer the given renderer
     * @return the self-instance
     * @throws SettingException an exception in case of any setting error
     */
    default Settings render(Class<? extends Renderer<?, ?>> renderer) {
        return render(renderer, cast(Array.newInstance(Class.class, 0)));
    }
}
