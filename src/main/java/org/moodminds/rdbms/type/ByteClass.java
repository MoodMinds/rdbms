package org.moodminds.rdbms.type;

import java.nio.ByteBuffer;

/**
 * Represents the root of the {@link ByteBuffer} type hierarchy.
 */
public interface ByteClass extends Class<ByteBuffer> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default java.lang.Class<ByteBuffer> getType() {
        return ByteBuffer.class;
    }
}
