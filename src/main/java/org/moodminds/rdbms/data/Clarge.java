package org.moodminds.rdbms.data;

import org.moodminds.emission.Resource;
import org.moodminds.rdbms.DatabaseException;

/**
 * An RDBMS character large data object interface.
 */
public interface Clarge extends Resource<CharSequence, DatabaseException> {}
