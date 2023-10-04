/*
 * This file is generated by jOOQ.
 */
package nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables;


import nl.salves.workshop.testcontainers.vakantieplanner.jooq.Keys;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.Public;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.records.HolidayRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Holiday extends TableImpl<HolidayRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.holiday</code>
     */
    public static final Holiday HOLIDAY = new Holiday();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HolidayRecord> getRecordType() {
        return HolidayRecord.class;
    }

    /**
     * The column <code>public.holiday.id</code>.
     */
    public final TableField<HolidayRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.holiday.member_id</code>.
     */
    public final TableField<HolidayRecord, Integer> MEMBER_ID = createField(DSL.name("member_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.holiday.description</code>.
     */
    public final TableField<HolidayRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.holiday.start_date</code>.
     */
    public final TableField<HolidayRecord, LocalDate> START_DATE = createField(DSL.name("start_date"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>public.holiday.end_date</code>.
     */
    public final TableField<HolidayRecord, LocalDate> END_DATE = createField(DSL.name("end_date"), SQLDataType.LOCALDATE.nullable(false), this, "");

    private Holiday(Name alias, Table<HolidayRecord> aliased) {
        this(alias, aliased, null);
    }

    private Holiday(Name alias, Table<HolidayRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.holiday</code> table reference
     */
    public Holiday(String alias) {
        this(DSL.name(alias), HOLIDAY);
    }

    /**
     * Create an aliased <code>public.holiday</code> table reference
     */
    public Holiday(Name alias) {
        this(alias, HOLIDAY);
    }

    /**
     * Create a <code>public.holiday</code> table reference
     */
    public Holiday() {
        this(DSL.name("holiday"), null);
    }

    public <O extends Record> Holiday(Table<O> child, ForeignKey<O, HolidayRecord> key) {
        super(child, key, HOLIDAY);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<HolidayRecord, Integer> getIdentity() {
        return (Identity<HolidayRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<HolidayRecord> getPrimaryKey() {
        return Keys.HOLIDAY_PKEY;
    }

    @Override
    public List<UniqueKey<HolidayRecord>> getKeys() {
        return Arrays.<UniqueKey<HolidayRecord>>asList(Keys.HOLIDAY_PKEY);
    }

    @Override
    public List<ForeignKey<HolidayRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<HolidayRecord, ?>>asList(Keys.HOLIDAY__HOLIDAY_MEMBER_ID_FKEY);
    }

    private transient Member _member;

    public Member member() {
        if (_member == null)
            _member = new Member(this, Keys.HOLIDAY__HOLIDAY_MEMBER_ID_FKEY);

        return _member;
    }

    @Override
    public Holiday as(String alias) {
        return new Holiday(DSL.name(alias), this);
    }

    @Override
    public Holiday as(Name alias) {
        return new Holiday(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Holiday rename(String name) {
        return new Holiday(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Holiday rename(Name name) {
        return new Holiday(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, String, LocalDate, LocalDate> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
