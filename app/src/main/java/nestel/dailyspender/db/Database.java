package nestel.dailyspender.db;

import nestel.dailyspender.db.MoneySpentContract.MoneySpentEntry;

/**
 * Created by nestel on 2.9.2016.
 */

// tutorial: https://developer.android.com/training/basics/data-storage/databases.html#DefineContract

public class Database
{
    private static final String TEXT_TYPE = " TEXT";
    private static final String DATE_TYPE = " DATETIME";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String DOUBLE_TYPE = " DOUBLE";
    private static final String LONG_TYPE = " LONG";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_MONEY_SPENT_TABLE =
        "CREATE TABLE " + MoneySpentEntry.TABLE_NAME + " (" +
        MoneySpentEntry._ID + " INTEGER PRIMARY KEY," +
        MoneySpentEntry.COLUMN_NAME_DATE + LONG_TYPE + COMMA_SEP +
        MoneySpentEntry.COLUMN_NAME_AMOUNT + DOUBLE_TYPE + COMMA_SEP +
        MoneySpentEntry.COLUMN_NAME_ADDED_ON + LONG_TYPE + COMMA_SEP +
        MoneySpentEntry.COLUMN_NAME_ON_SERVER + INTEGER_TYPE + " )";

    public static final String SQL_DELETE_MONEY_SPENT =
        "DELETE TABLE IF EXISTS " + MoneySpentEntry.TABLE_NAME;
}
