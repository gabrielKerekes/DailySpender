package nestel.dailyspender;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Date;

import nestel.dailyspender.db.MoneySpentContract.MoneySpentEntry;
import nestel.dailyspender.model.MoneySpentManager;

public class HomeActivity extends AppCompatActivity
{
    public ListView moneySpentListView;
    public MoneySpentCursorAdapter moneySpentCursorAdapter;

    public Button addButton;
    public EditText amountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // todo: divide into methods
        MoneySpentManager manager = new MoneySpentManager(this);

        Cursor c = manager.GetAllEntries();
        String[] fromColumns = { MoneySpentEntry._ID, MoneySpentEntry.COLUMN_NAME_DATE, MoneySpentEntry.COLUMN_NAME_AMOUNT };
        int[] toViews = { R.id.money_spent_row_id, R.id.money_spent_row_date, R.id.money_spent_row_amount };
        moneySpentCursorAdapter = new MoneySpentCursorAdapter(this, R.layout.money_spent_row, c, fromColumns, toViews, 0);

        moneySpentListView = (ListView) findViewById(R.id.moneySpentListView);
        moneySpentListView.setAdapter(moneySpentCursorAdapter);

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MoneySpentManager manager = new MoneySpentManager(v.getContext());
                manager.AddEntry(new Date(), Long.parseLong(amountEditText.getText().toString()));

                moneySpentCursorAdapter.changeCursor(manager.GetAllEntries());
                moneySpentCursorAdapter.notifyDataSetChanged();
            }
        });

        amountEditText = (EditText) findViewById(R.id.amountEditText);
    }
}
