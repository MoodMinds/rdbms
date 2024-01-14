package org.moodminds.rdbms.type;

/**
 * An RDBMS data domain (root type without precisions, length and so on) definition object.
 *
 * @param <V> the type of the corresponding java type
 */
public interface Domain<V> extends Class<V> {

    /**
     * Return the type name of this RDBMS data domain.
     *
     * @return the type name of this RDBMS data domain
     */
    String getName();
}
