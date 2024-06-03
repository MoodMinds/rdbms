package org.moodminds.rdbms.type;

import org.moodminds.rdbms.data.Clarge;

/**
 * Parent interface for all {@link Clarge} resource types.
 */
public interface ClargeType extends ResourceType<CharSequence, Clarge> {

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
    default java.lang.Class<Clarge> getType() {
        return Clarge.class;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<CharSequence> getValueType() {
        return CharSequence.class;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default ClargeType getDomain() {
        return (ClargeType) ResourceType.super.getDomain();
    }
}
