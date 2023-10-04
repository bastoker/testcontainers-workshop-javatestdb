/*
 * This file is generated by jOOQ.
 */
package nl.salves.workshop.testcontainers.vakantieplanner.jooq;


import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.FlywaySchemaHistory;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.Holiday;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.Member;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.records.FlywaySchemaHistoryRecord;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.records.HolidayRecord;
import nl.salves.workshop.testcontainers.vakantieplanner.jooq.tables.records.MemberRecord;
import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<HolidayRecord> HOLIDAY_PKEY = Internal.createUniqueKey(Holiday.HOLIDAY, DSL.name("holiday_pkey"), new TableField[] { Holiday.HOLIDAY.ID }, true);
    public static final UniqueKey<MemberRecord> MEMBER_NAME_KEY = Internal.createUniqueKey(Member.MEMBER, DSL.name("member_name_key"), new TableField[] { Member.MEMBER.NAME }, true);
    public static final UniqueKey<MemberRecord> MEMBER_PKEY = Internal.createUniqueKey(Member.MEMBER, DSL.name("member_pkey"), new TableField[] { Member.MEMBER.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<HolidayRecord, MemberRecord> HOLIDAY__HOLIDAY_MEMBER_ID_FKEY = Internal.createForeignKey(Holiday.HOLIDAY, DSL.name("holiday_member_id_fkey"), new TableField[] { Holiday.HOLIDAY.MEMBER_ID }, Keys.MEMBER_PKEY, new TableField[] { Member.MEMBER.ID }, true);
}
