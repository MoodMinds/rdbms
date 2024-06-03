package org.moodminds.rdbms.data;

import org.moodminds.emission.Resource;
import org.moodminds.rdbms.DatabaseException;

import java.nio.ByteBuffer;

/**
 * An RDBMS binary large data object interface.
 */
public interface Blarge extends Resource<ByteBuffer, DatabaseException> {}
