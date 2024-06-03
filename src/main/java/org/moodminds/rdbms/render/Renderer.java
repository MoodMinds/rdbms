package org.moodminds.rdbms.render;

import org.moodminds.rdbms.RenderException;

/**
 * RDBMS SQL rendering function interface.
 *
 * @param <R> the type of the parent rendering object
 * @param <V> the type of the current rendering object
 */
@FunctionalInterface
public interface Renderer<R, V> {

    /**
     * Render the given value in context of the given {@link Render} render.
     *
     * @param render the given {@link Render} rendering context
     * @param value the given value to render
     * @throws RenderException in case of some rendering error
     */
    void render(Render<R> render, V value);
}
