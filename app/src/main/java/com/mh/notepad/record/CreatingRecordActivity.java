package com.mh.notepad.record;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.mh.notepad.AplicationData;
import com.mh.notepad.R;

import java.util.List;

public class CreatingRecordActivity extends AppCompatActivity {
    public EditText text;
    public EditText theme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_record);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.record_title));

        init();

        try {
            Integer recordId = (Integer) getIntent().getExtras().get("id");
            final List<Record> records = new RecordDAO().getRecordsByLogin(AplicationData.user.getLogin());
            Record record = new RecordDAO().getRecordsById(recordId, records);
            theme.setText(record.getTheme());
            text.setText(record.getText());

        } catch (Exception e) {
        }
    }

    public void init() {
        text = findViewById(R.id.textRecord);
        theme = findViewById(R.id.themeRecord);
    }


    public void onSaveRecord(View view) {
        Integer recordId = null;
        try {
            recordId = (Integer) getIntent().getExtras().get("id");
        } catch (Exception e) {
        }

        if (recordId == null) {
            new RecordDAO().createRecord(AplicationData.user.getLogin(), theme.getText().toString(), text.getText().toString());
        } else {
            new RecordDAO().updateRecord(AplicationData.user.getLogin(), recordId, theme.getText().toString(), text.getText().toString());
        }
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }
}
