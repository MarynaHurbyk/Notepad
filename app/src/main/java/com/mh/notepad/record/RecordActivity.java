package com.mh.notepad.record;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mh.notepad.R;

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        TextView name = findViewById(R.id.name);

        String userName = (String) getIntent().getExtras().get("userName");
        name.setText("Hello, " + userName);
    }
}
