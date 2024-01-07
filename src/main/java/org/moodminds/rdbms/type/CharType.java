package org.moodminds.rdbms.type;

/**
 * Parent interface for all {@link String} types.
 */
public interface CharType extends CharClass, Type<String> {

    /**
     * Return length of this character type.
     *
     * @return length of this character type
     */
    int getLength();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    CharDomain getDomain();
}
