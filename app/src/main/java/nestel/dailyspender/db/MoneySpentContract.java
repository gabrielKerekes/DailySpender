package nestel.dailyspender.db;

import android.provider.BaseColumns;

/**
 * Created by nestel on 2.9.2016.
 */

// tutorial: https://developer.android.com/training/basics/data-storage/databases.html#DefineContract

public final class MoneySpentContract
{
    private MoneySpentContract() {}

    public static class MoneySpentEntry implements BaseColumns
    {
        // todo: edit table name and all moneySpent stuff
        public static final String TABLE_NAME = "MoneySpent";
        public static final String COLUMN_NAME_DATE = "DateT";
        public static final String COLUMN_NAME_AMOUNT = "Amount";
        public static final String COLUMN_NAME_ADDED_ON = "AddedOnT";
        public static final String COLUMN_NAME_ON_SERVER = "IsOnServer";
    }
}
