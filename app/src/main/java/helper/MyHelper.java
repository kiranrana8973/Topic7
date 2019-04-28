package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import model.Dictionary;

public class MyHelper extends SQLiteOpenHelper {

    public static final String databaseName = "DictionayDB";
    public static final int dbVersion = 1;

    //Constructor
    public MyHelper(Context context) {
        super(context, databaseName, null, dbVersion);
        //context, databaseName , cursorFactory, databaseVersion
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE WORDS " +
                "(" +
                "WordID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "Word TEXT, " +
                "Meaning TEXT" +
                ")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS WORDS");
        onCreate(db);
    }

    public boolean InsertData(String word, String meaning, SQLiteDatabase db) {
        try {
            String query = "insert into Words(Word,Meaning) values('" + word + "','" + meaning + "')";
            db.execSQL(query);
            return true;

        } catch (Exception e) {
            Log.d("Error : ", e.toString());
            return false;
        }
    }

    public List<Dictionary> getAllWords()
    {
        return null;
    }
}

