package org.moodminds.rdbms.lang;

import org.moodminds.elemental.Container;
import org.moodminds.rdbms.type.Class;

import java.util.Optional;

/**
 * Root interface for SQL instructions (expressions, statements) that can be parameterized.
 */
public interface Directive {

    /**
     * Return the parameters of this instruction object.
     *
     * @return the parameters of this instruction object
     */
    Container<? extends Parameter<?>> getParameters();

    /**
     * Return the parameter of this instruction object by the given name.
     *
     * @param name the given parameter name
     * @return the parameter of this instruction object by the given name
     */
    Optional<? extends Parameter<?>> getParameter(java.lang.String name);


    /**
     * Represents an RDBMS SQL instruction parameter.
     *
     * @param <V> the corresponding type of the parameter
     */
    interface Parameter<V> {

        /**
         * Return the name of the parameter.
         *
         * @return the name of the parameter
         */
        java.lang.String getName();

        /**
         * Return the {@link Typing} of the parameter.
         *
         * @return the {@link Typing} of the parameter
         */
        Typing<V> getTyping();

        /**
         * Represents the parameter typing.
         *
         * @param <V> the corresponding type of the parameter
         */
        interface Typing<V> {

            /**
             * Return the corresponding {@link java.lang.Class type} of the parameter.
             *
             * @return the corresponding {@link java.lang.Class type} of the parameter
             */
            java.lang.Class<V> getType();
        }

        /**
         * Represents the parameter RDBMS data typing.
         *
         * @param <V> the corresponding type of the parameter
         */
        interface DataTyping<V> extends Typing<V> {

            /**
             * {@inheritDoc}
             *
             * @return {@inheritDoc}
             */
            @Override
            default java.lang.Class<V> getType() {
                return getDataType().getType();
            }

            /**
             * Return the RDBMS {@link Class type} of the parameter.
             *
             * @return the RDBMS {@link Class type} of the parameter
             */
            Class<V> getDataType();
        }
    }

    /**
     * Represents an input value RDBMS SQL instruction parameter.
     *
     * @param <V> the corresponding type of the parameter
     */
    interface In<V> extends Parameter<V> {}

    /**
     * Represents an output value RDBMS SQL instruction parameter.
     *
     * @param <V> the corresponding type of the parameter
     */
    interface Out<V> extends Parameter<V> {}

    /**
     * Represents an input-output value RDBMS SQL instruction parameter.
     *
     * @param <V> the corresponding type of the parameter
     */
    interface InOut<V> extends In<V>, Out<V> {}

    /**
     * Represents a multiple input values RDBMS SQL instruction parameter.
     *
     * @param <V> the corresponding type of the parameter
     */
    interface Multi<V> extends In<V> {

        /**
         * Return the length of this multiple inputs parameters.
         *
         * @return the length of this multiple inputs parameter
         */
        Optional<Integer> getLength();
    }
}
