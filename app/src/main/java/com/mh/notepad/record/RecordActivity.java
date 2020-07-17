package com.mh.notepad.record;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mh.notepad.AplicationData;
import com.mh.notepad.R;
import com.mh.notepad.login.LoginActivity;

import java.util.List;

public class RecordActivity extends AppCompatActivity {
    private ListView listRecords;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        String userName = AplicationData.user.getName();
        String title = (String) getResources().getText(R.string.your_records);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);

        final List<Record> records = new RecordDAO().getRecordsByLogin(AplicationData.user.getLogin());

        recyclerView = (RecyclerView) findViewById(R.id.record_recycler);
        recyclerView.setHasFixedSize(true);

        CaptionedCardAdapter adapter = new CaptionedCardAdapter(this,records);
        recyclerView.setAdapter(adapter);


        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.invalidate();

    }


//        adapter.setListener(position->{}{
//                Intent intent = new Intent(this, CreatingRecordActivity.class);
//                intent.putExtra(CreatingRecordActivity., position);
//                getActivity().startActivity(intent);
//
//            }
//        });
//        return pizzaRecycler;

//        ArrayAdapter<Record> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, records);
//        listRecords = (ListView) findViewById(R.id.listRecords);
//        listRecords.setAdapter(listAdapter);
//
//        //Create the listener
//        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> listRecords,
//                                    View itemView,
//                                    int position,
//                                    long id) {
//                //Pass the food the user clicks on to FoodActivity
//                Intent intent = new Intent(RecordActivity.this,
//                        CreatingRecordActivity.class);
//                intent.putExtra("id", (int) id);
//                startActivity(intent);
//            }
//        };
//
//        //Assign the listener to the list view
//        listRecords.setOnItemClickListener(itemClickListener);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Заполнение меню; элементы действий добавляются на панель приложения
        getMenuInflater().inflate(R.menu.menu_record, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_record:
                System.out.println("rrr");
                Intent intent = new Intent(this, CreatingRecordActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_change_user:
                Intent intentChangeUser = new Intent(this, LoginActivity.class);
                startActivity(intentChangeUser);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

