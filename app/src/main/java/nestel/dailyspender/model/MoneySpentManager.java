package nestel.dailyspender.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import nestel.dailyspender.db.MoneySpentContract.MoneySpentEntry;
import java.util.*;

import nestel.dailyspender.db.Database;
import nestel.dailyspender.db.MoneySpentContract;
import nestel.dailyspender.db.MoneySpentDbHelper;

/**
 * Created by nestel on 2.9.2016.
 */

// tutorial: https://developer.android.com/training/basics/data-storage/databases.html#DefineContract

// todo: rename from manager
public class MoneySpentManager
{
    private MoneySpentDbHelper dbHelper;
    private Context context;

    public MoneySpentManager(Context context)
    {
        this.context = context;

        this.dbHelper = new MoneySpentDbHelper(context);
    }

    public long AddEntry(Date date, double amount)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MoneySpentEntry.COLUMN_NAME_DATE, date.getTime());
        values.put(MoneySpentEntry.COLUMN_NAME_AMOUNT, amount);
        values.put(MoneySpentEntry.COLUMN_NAME_ADDED_ON, new Date().getTime());
        values.put(MoneySpentEntry.COLUMN_NAME_ON_SERVER, false);

        return db.insert(MoneySpentEntry.TABLE_NAME, null, values);
    }

    public Cursor GetAllEntries()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection =
        {
            MoneySpentEntry._ID,
            MoneySpentEntry.COLUMN_NAME_DATE,
            MoneySpentEntry.COLUMN_NAME_AMOUNT,
            MoneySpentEntry.COLUMN_NAME_ADDED_ON,
            MoneySpentEntry.COLUMN_NAME_ON_SERVER,
        };

        return db.query(MoneySpentEntry.TABLE_NAME, projection, null, null, null, null, null);
    }

    public void DeleteEntry(long id)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = MoneySpentEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        db.delete(MoneySpentEntry.TABLE_NAME, selection, selectionArgs);
    }
}
