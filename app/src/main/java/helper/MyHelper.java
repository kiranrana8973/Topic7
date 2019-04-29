package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.Dictionary;
import model.Word;

public class MyHelper extends SQLiteOpenHelper {

    private static final String databaseName = "DictionayDB";
    private static final int dbVersion = 1;
    //Constructor
    public MyHelper(Context context) {
        super(context, databaseName, null, dbVersion);
        //context, databaseName , cursorFactory, databaseVersion
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE WORDS " +
                "(WordID INTEGER PRIMARY KEY AUTOINCREMENT ,Word TEXT,Meaning TEXT )";

        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean InsertData(String word, String meaning, SQLiteDatabase db) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Word",word);
            contentValues.put("Meanig",meaning);
            db.insert("WORDS",null,contentValues);
            return true;
        } catch (Exception e) {
            Log.d("Error : ", e.toString());
            return false;
        }
    }


    public List<Word> GetAllWords(SQLiteDatabase db)
    {
        List<Word> dictionaryList = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select WordId,Word,Meaning from WORDS",null);

        while(cursor.moveToNext())
        {
            int wordId = cursor.getInt(0);
            String word = cursor.getString(1);
            String meaning = cursor.getString(2);

            dictionaryList.add(new Word(wordId,word,meaning));
        }
        return dictionaryList;
    }
}



