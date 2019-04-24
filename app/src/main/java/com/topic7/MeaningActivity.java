package com.topic7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MeaningActivity extends AppCompatActivity {
    private TextView tvMeaning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            String meaning = bundle.getString("meaning");
            tvMeaning = findViewById(R.id.tvMeaning);
            //setting the meaning in textview
            tvMeaning.setText(meaning);
        }
    }
}
