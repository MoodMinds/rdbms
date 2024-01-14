package org.moodminds.rdbms.type;

import org.moodminds.rdbms.data.Blarge;

import java.nio.ByteBuffer;

/**
 * Parent interface for all {@link Blarge} resource types.
 */
public interface BlargeType extends ResourceType<ByteBuffer, Blarge> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<Blarge> getType() {
        return Blarge.class;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<ByteBuffer> getValueType() {
        return ByteBuffer.class;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default BlargeType getDomain() {
        return (BlargeType) ResourceType.super.getDomain();
    }
}
