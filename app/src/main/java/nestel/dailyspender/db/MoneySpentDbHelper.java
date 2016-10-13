package nestel.dailyspender.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import nestel.dailyspender.db.Database;

/**
 * Created by nestel on 2.9.2016.
 */

// tutorial: https://developer.android.com/training/basics/data-storage/databases.html#DefineContract

public class MoneySpentDbHelper extends SQLiteOpenHelper
{
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MoneySpent.db";

    public MoneySpentDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Database.SQL_CREATE_MONEY_SPENT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // TODO: implement if needed
        //db.execSQL(Database.SQL_DELETE_MONEY_SPENT);
        //onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }

}
