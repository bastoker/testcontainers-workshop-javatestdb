/*
 * This file is generated by jOOQ.
 */
package nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables;


import nl.salves.workshop.testcontainers.vakantieplanner.jooq.Keys;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.Public;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.records.MemberRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Member extends TableImpl<MemberRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.member</code>
     */
    public static final Member MEMBER = new Member();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MemberRecord> getRecordType() {
        return MemberRecord.class;
    }

    /**
     * The column <code>public.member.id</code>.
     */
    public final TableField<MemberRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.member.name</code>.
     */
    public final TableField<MemberRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    private Member(Name alias, Table<MemberRecord> aliased) {
        this(alias, aliased, null);
    }

    private Member(Name alias, Table<MemberRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.member</code> table reference
     */
    public Member(String alias) {
        this(DSL.name(alias), MEMBER);
    }

    /**
     * Create an aliased <code>public.member</code> table reference
     */
    public Member(Name alias) {
        this(alias, MEMBER);
    }

    /**
     * Create a <code>public.member</code> table reference
     */
    public Member() {
        this(DSL.name("member"), null);
    }

    public <O extends Record> Member(Table<O> child, ForeignKey<O, MemberRecord> key) {
        super(child, key, MEMBER);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<MemberRecord, Integer> getIdentity() {
        return (Identity<MemberRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<MemberRecord> getPrimaryKey() {
        return Keys.MEMBER_PKEY;
    }

    @Override
    public List<UniqueKey<MemberRecord>> getKeys() {
        return Arrays.<UniqueKey<MemberRecord>>asList(Keys.MEMBER_PKEY, Keys.MEMBER_NAME_KEY);
    }

    @Override
    public Member as(String alias) {
        return new Member(DSL.name(alias), this);
    }

    @Override
    public Member as(Name alias) {
        return new Member(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Member rename(String name) {
        return new Member(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Member rename(Name name) {
        return new Member(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
