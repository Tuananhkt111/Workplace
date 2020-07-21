package com.example.practical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.practical.dataset.Book;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {

    public static final String DB_NAME = "BookSQLite.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_BOOK = "books";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_ISBN = "isbn";


    public static String CREATE_TABLE_BOOK =
            "CREATE TABLE " +
                    TABLE_BOOK +
                    "(" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT NOT NULL, " + COLUMN_ISBN + " TEXT NOT NULL)";

    private Context context;
    private SQLiteDatabase sqLliteDatabase;
    private static DBAdapter dBAdapterInstance;

    private DBAdapter(Context context) {
        this.context = context;
        sqLliteDatabase = new DBHelper(this.context, DB_NAME, null, DB_VERSION).getWritableDatabase();
    }

    public static DBAdapter getDBAdapterInstance(Context context) {
        if (dBAdapterInstance == null) {
            dBAdapterInstance = new DBAdapter(context);
        }
        return dBAdapterInstance;
    }


    //Will be used by the provider
    public Cursor getCursorsForAllBooks() {
        Cursor cursor = sqLliteDatabase.query(
                TABLE_BOOK,
                new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_ISBN},
                null, null, null, null, null, null);
        return cursor;
    }


    //Insert
    public boolean insert(String title, String isbn) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, title);
        contentValues.put(COLUMN_ISBN, isbn);

        return sqLliteDatabase.insert(TABLE_BOOK, null, contentValues) > 0;
    }

    //Will be used by the provider
    public long insert(ContentValues contentValues) {
        return sqLliteDatabase.insert(TABLE_BOOK, null, contentValues);
    }


    // Delete
    public boolean delete(int id) {
        return sqLliteDatabase.delete(TABLE_BOOK, COLUMN_ID + " = " + id, null) > 0;
    }

    //Will be used by the provider
    public int delete(String whereClause, String[] whereValues) {
        return sqLliteDatabase.delete(TABLE_BOOK, whereClause, whereValues);
    }


    // Update
    public boolean update(int id, String title, String isbn) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, title);
        contentValues.put(COLUMN_ISBN, isbn);

        return sqLliteDatabase.update(TABLE_BOOK, contentValues, COLUMN_ID + " = " + id, null) > 0;
    }

    //Will be used in the content provider
    public int update(ContentValues contentValues, String s, String[] strings) {
        return sqLliteDatabase.update(TABLE_BOOK, contentValues, s, strings);
    }


    public List<Book> getAllBooks() {
        List<Book> listBook = new ArrayList<>();

        Cursor cursor = sqLliteDatabase.query(
                TABLE_BOOK,
                new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_ISBN},
                null, null, null, null, null, null);

        if (cursor != null & cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                listBook.add(book);

            }
        }
        cursor.close();
        return listBook;
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int dbVersion) {
            super(context, databaseName, factory, dbVersion);
        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            super.onConfigure(db);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_BOOK);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                              int oldVersion, int newVersion) {
        }
    }
}