package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentProvider extends ContentProvider {

    public static final String AUTHORITY="com.example.contentprovider";

    public static final String PATH_STUDENT_LIST ="STUDENT_LIST";

    public static final int STUDENTS_LIST_ID =1;

    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        MATCHER.addURI(AUTHORITY, PATH_STUDENT_LIST, STUDENTS_LIST_ID);
    }

    private DBAdapter dbAdapter;

    public StudentProvider() {
    }

    @Override
    public boolean onCreate() {
        dbAdapter = DBAdapter.getDBAdapterInstance(getContext()) ;
        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor=null;
        switch (MATCHER.match(uri)){
            case STUDENTS_LIST_ID:
                cursor = dbAdapter.getCursorsForAllStudent();
                break;
            default:
                cursor=null;
                break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int result = -1;
        switch (MATCHER.match(uri)){
            case STUDENTS_LIST_ID:
                result = dbAdapter.update(values,selection,selectionArgs);
                break;
            default:
                new UnsupportedOperationException("insert operation not supported");
                break;
        }
        return result;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int result = -1;
        switch (MATCHER.match(uri)){
            case STUDENTS_LIST_ID:
                result = dbAdapter.delete(selection,selectionArgs);
            break;
            default:
                new UnsupportedOperationException("delete operation not supported");
                break;
        }
        return result;
    }


    @Override
    public Uri insert(@NonNull Uri uri,ContentValues contentValues) throws UnsupportedOperationException{
        Uri returnUri = null;
        switch (MATCHER.match(uri)){
            case STUDENTS_LIST_ID:
                long id = dbAdapter.insert(contentValues);

                returnUri = Uri.parse("content://"+AUTHORITY+"/"+ PATH_STUDENT_LIST +"/"+id);
                break;
            default:
                new UnsupportedOperationException("insert operation not supported");
                break;
        }

        return returnUri ;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return  null;
    }

}
