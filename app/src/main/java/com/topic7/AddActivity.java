package com.topic7;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class AddActivity extends AppCompatActivity {
    EditText etWord,etDefinition;
    Button btnAddWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etWord = findViewById(R.id.etWord);
        etDefinition = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }

    private void Save() {
        try {

            File directory = new File(getExternalFilesDir(Environment.DIRECTORY_DCIM),"Dictionary");
            directory.mkdir();
            File imgFile = new File(directory, "words.txt");
            FileOutputStream fos = new FileOutputStream(imgFile);
            fos.write((etWord.getText().toString() + "->" + etDefinition.getText().toString()).getBytes());

//            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
//            printStream.println(etWord.getText().toString() + "->" + etDefinition.getText().toString());
//            printStream.close();
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.d("Dictionary app " , "Error: " + e.toString());
            e.printStackTrace();
        }
    }
}