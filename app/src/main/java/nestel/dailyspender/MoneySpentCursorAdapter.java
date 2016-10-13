package nestel.dailyspender;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;

import nestel.dailyspender.db.MoneySpentContract.MoneySpentEntry;
import nestel.dailyspender.model.MoneySpentManager;

/**
 * Created by nestel on 3.9.2016.
 */
public class MoneySpentCursorAdapter extends SimpleCursorAdapter
{
    public MoneySpentCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags)
    {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView dateTextView = (TextView) view.findViewById(R.id.moneySpentListItemDate);
        TextView amountTextView = (TextView) view.findViewById(R.id.moneySpentListItemValue);
        Button deleteEntryButton = (Button) view.findViewById(R.id.moneySpentListItemRemoveButton);

        Date date = new Date(cursor.getLong(cursor.getColumnIndex(MoneySpentEntry.COLUMN_NAME_DATE)));
        double amount = cursor.getDouble(cursor.getColumnIndex(MoneySpentEntry.COLUMN_NAME_AMOUNT));

        SimpleDateFormat ft = new SimpleDateFormat("dd. MM. yyyy hh:mm");

        dateTextView.setText(ft.format(date));
        amountTextView.setText(String.valueOf(amount) + "€");

        // todo: fix to delete the right entry
        deleteEntryButton.setOnClickListener(new View.OnClickListener()
        {
            // todo: onClick needs to remove the id which has been clicked somehow
            @Override
            public void onClick(View v)
            {
                MoneySpentManager manager = new MoneySpentManager(v.getContext());
                Cursor c = manager.GetAllEntries();
                c.moveToLast();
                manager.DeleteEntry(c.getLong(c.getColumnIndex(MoneySpentEntry._ID)));

                changeCursor(manager.GetAllEntries());
                notifyDataSetChanged();
            }
        });
    }
}
