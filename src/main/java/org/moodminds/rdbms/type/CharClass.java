package org.moodminds.rdbms.type;

/**
 * Represents the root of the {@link String} type hierarchy.
 */
public interface CharClass extends Class<String> {

    /**
     * Return {@code true} if this type allows national characters.
     *
     * @return {@code true} if this type allows national characters or {@code false}, otherwise
     */
    boolean isNational();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<String> getType() {
        return String.class;
    }
}
