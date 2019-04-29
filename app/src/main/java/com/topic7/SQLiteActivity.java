package com.topic7;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import helper.MyHelper;
import model.Word;

public class SQLiteActivity extends AppCompatActivity {

    EditText etWord, etMeaning;
    Button btnAddWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Word> wordList = myHelper.GetAllWords(sqLiteDatabase);



        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myHelper.InsertData(etWord.getText().toString(), etMeaning.getText().toString(), sqLiteDatabase))
                {
                    Toast.makeText(SQLiteActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SQLiteActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


