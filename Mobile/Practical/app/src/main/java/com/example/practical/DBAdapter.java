package com.example.practical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.practical.dataset.Car;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {

    public static final String DB_NAME = "CarSQLite.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_CAR = "cars";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_PRICE = "price";


    public static String CREATE_TABLE_CAR =
            "CREATE TABLE " +
                    TABLE_CAR +
                    "(" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COLUMN_MODEL + " TEXT NOT NULL, " + COLUMN_PRICE + " INTEGER NOT NULL)";

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
    public Cursor getCursorsForAllCars() {
        Cursor cursor = sqLliteDatabase.query(
                TABLE_CAR,
                new String[]{COLUMN_ID, COLUMN_MODEL, COLUMN_PRICE},
                null, null, null, null, null, null);
        return cursor;
    }


    //Insert
    public boolean insert(String model, int price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MODEL, model);
        contentValues.put(COLUMN_PRICE, price);

        return sqLliteDatabase.insert(TABLE_CAR, null, contentValues) > 0;
    }

    //Will be used by the provider
    public long insert(ContentValues contentValues) {
        return sqLliteDatabase.insert(TABLE_CAR, null, contentValues);
    }


    // Delete
    public boolean delete(int id) {
        return sqLliteDatabase.delete(TABLE_CAR, COLUMN_ID + " = " + id, null) > 0;
    }

    //Will be used by the provider
    public int delete(String whereClause, String[] whereValues) {
        return sqLliteDatabase.delete(TABLE_CAR, whereClause, whereValues);
    }


    // Update
    public boolean update(int id, String model, int price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MODEL, model);
        contentValues.put(COLUMN_PRICE, price);

        return sqLliteDatabase.update(TABLE_CAR, contentValues, COLUMN_ID + " = " + id, null) > 0;
    }

    //Will be used in the content provider
    public int update(ContentValues contentValues, String s, String[] strings) {
        return sqLliteDatabase.update(TABLE_CAR, contentValues, s, strings);
    }


    public List<Car> getAllCars() {
        List<Car> listCar = new ArrayList<>();

        Cursor cursor = sqLliteDatabase.query(
                TABLE_CAR,
                new String[]{COLUMN_ID, COLUMN_MODEL, COLUMN_PRICE},
                null, null, null, null, null, null);

        if (cursor != null & cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Car car = new Car(cursor.getInt(0), cursor.getString(1), Integer.parseInt(cursor.getString(2)));
                listCar.add(car);
            }
        }
        cursor.close();
        return listCar;
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
            sqLiteDatabase.execSQL(CREATE_TABLE_CAR);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                              int oldVersion, int newVersion) {
        }
    }
}