package org.moodminds.rdbms.render;

import org.moodminds.rdbms.RenderException;

/**
 * The RDBMS SQL rendering definition interface.
 *
 * @param <R> the type of the rendering object
 */
public interface Render<R> {

    /**
     * Return the rendering object instance.
     *
     * @return the rendering object instance
     */
    R getRenderer();

    /**
     * Render the given object as a child of the current rendering object.
     *
     * @param object the given object to render
     * @return the self-instance
     * @throws RenderException in case of some rendering error
     */
    Render<R> render(Object object);

    /**
     * Render the given characters in context of the current rendering object.
     *
     * @param ch the given character value
     * @param chs the given character values
     * @return the self-instance
     * @throws RenderException in case of some rendering error
     */
    Render<R> render(char ch, char... chs);

    /**
     * Render the given characters in context of the current rendering object.
     *
     * @param ch the given character value
     * @param chs the given character values
     * @return the self-instance
     * @throws RenderException in case of some rendering error
     */
    Render<R> render(CharSequence ch, CharSequence... chs);
}
