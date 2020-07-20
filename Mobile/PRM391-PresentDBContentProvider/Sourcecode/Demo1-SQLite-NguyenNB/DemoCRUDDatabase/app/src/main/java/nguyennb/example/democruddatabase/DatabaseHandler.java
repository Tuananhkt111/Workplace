package nguyennb.example.democruddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    //Database Version
    private static final int DATABASE_VERSION =1;
    //Database Name
    private static final String DATABASE_NAME = "test.db";
    //Table
    private static final String TABLE_NAME = "userdata";
    //Field
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_AGE = "age";

    SQLiteDatabase database;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( "+
                COLUMN_ID +" INTEGER PRIMARY KEY, "+ COLUMN_NAME +" TEXT, " + COLUMN_AGE +" INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void insertStudent(int id , String name, int age){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_AGE,age);
        this.getWritableDatabase().insertOrThrow(TABLE_NAME,"",contentValues);
    }
    public int deleteStudent(String id){
        int check = this.getWritableDatabase().delete(TABLE_NAME,"id=?",new String[]{id});
        return check;
    }
    public void updateStudent(String id, String newName, String newAge){
        this.getWritableDatabase().execSQL("UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME +"= '" + newName + "', " +
                COLUMN_AGE + "='" + newAge +"' WHERE " + COLUMN_ID + "= '" + id +"'");
    }
    public ArrayList<String> getUsers(){
        ArrayList<String> list = new ArrayList<>();
        database = getReadableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor cursor = database.rawQuery(query,null);

        while (cursor.moveToNext()){
            list.add(cursor.getString(cursor.getColumnIndex(COLUMN_ID)) + " - " + cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) + " - "
            + cursor.getString(cursor.getColumnIndex(COLUMN_AGE)));
        }
        return list;
    }

}
