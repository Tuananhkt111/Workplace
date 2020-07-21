package com.example.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.contentprovider.Dataset.Student;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {

    public static final String DB_NAME="demo.db";
    public static final int DB_VERSION=1;

    public static final String TABLE_STUDENT="student";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_EMAIL="email";


    public static String CREATE_TABLE_STUDENT=
            "CREATE TABLE " +
            TABLE_STUDENT+
            "(" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_EMAIL+ " TEXT NOT NULL)";

    private Context context;
    private SQLiteDatabase sqLliteDatabase;
    private static DBAdapter dBAdapterInstance;

    private DBAdapter(Context context){
        this.context=context;
        sqLliteDatabase=new DBHelper(this.context,DB_NAME,null,DB_VERSION).getWritableDatabase();
    }

    public  static DBAdapter getDBAdapterInstance(Context context){
        if(dBAdapterInstance == null){
            dBAdapterInstance = new DBAdapter(context);
        }
        return dBAdapterInstance;
    }


    //Will be used by the provider
    public Cursor getCursorsForAllStudent(){
        Cursor cursor=sqLliteDatabase.query(
                TABLE_STUDENT,
                new String[]{COLUMN_ID,COLUMN_NAME, COLUMN_EMAIL},
                null,null,null,null,null,null);
        return cursor;
    }


    //Insert
    public boolean insert(String name, String email){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_EMAIL,email);

        return sqLliteDatabase.insert(TABLE_STUDENT,null,contentValues) > 0;
    }
    //Will be used by the provider
    public long insert(ContentValues contentValues){
        return sqLliteDatabase.insert(TABLE_STUDENT,null,contentValues);
    }


    // Delete
    public boolean delete(int id){
        return sqLliteDatabase.delete(TABLE_STUDENT, COLUMN_ID + " = "+ id,null) > 0;
    }
    //Will be used by the provider
    public int delete(String whereClause, String [] whereValues){
        return sqLliteDatabase.delete(TABLE_STUDENT, whereClause , whereValues);
    }


    // Update
    public boolean update(int id, String name, String email){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_EMAIL,email);

        return sqLliteDatabase.update(TABLE_STUDENT,contentValues, COLUMN_ID+" = "+id,null) > 0;
    }
    //Will be used in the content provider
    public int update(ContentValues contentValues, String s, String [] strings){
        return sqLliteDatabase.update(TABLE_STUDENT,contentValues, s,strings);
    }


    public List<Student> getAllStudents(){
        List<Student> listStudent =new ArrayList<>();

        Cursor cursor=sqLliteDatabase.query(
                TABLE_STUDENT,
                new String[]{COLUMN_ID,COLUMN_NAME, COLUMN_EMAIL},
                null,null,null,null,null,null);

        if(cursor!=null &cursor.getCount()>0){
            while(cursor.moveToNext()){
                Student student = new Student(cursor.getInt(0),cursor.getString(1), cursor.getString(2));
                listStudent.add(student);

            }
        }
        cursor.close();
        return listStudent;
    }


    private static class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int dbVersion){
            super(context,databaseName,factory,dbVersion);
        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            super.onConfigure(db);
//            db.setForeignKeyConstraintsEnabled(true);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_STUDENT);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                              int oldVersion, int newVersion) {
//            switch (oldVersion){
//                case 1: sqLiteDatabase.execSQL("ALTER TABLE "+TABLE_STUDENT+ " ADD COLUMN "+COLUMN_EMAIL+" TEXT");break;
//                default: break;
//            }
        }
    }

}
