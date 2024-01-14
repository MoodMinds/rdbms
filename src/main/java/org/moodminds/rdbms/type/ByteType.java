package org.moodminds.rdbms.type;

import java.nio.ByteBuffer;

/**
 * Parent interface for all {@link ByteBuffer} types.
 */
public interface ByteType extends ByteClass, Type<ByteBuffer> {

    /**
     * Return length of this byte type.
     *
     * @return length of this byte type
     */
    int getLength();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    ByteDomain getDomain();
}
