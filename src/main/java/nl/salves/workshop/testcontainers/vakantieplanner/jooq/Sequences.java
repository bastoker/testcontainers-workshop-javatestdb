/*
 * This file is generated by jOOQ.
 */
package nl.salves.workshop.testcontainers.vakantieplanner.jooq;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.holiday_id_seq</code>
     */
    public static final Sequence<Integer> HOLIDAY_ID_SEQ = Internal.createSequence("holiday_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.member_id_seq</code>
     */
    public static final Sequence<Integer> MEMBER_ID_SEQ = Internal.createSequence("member_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
