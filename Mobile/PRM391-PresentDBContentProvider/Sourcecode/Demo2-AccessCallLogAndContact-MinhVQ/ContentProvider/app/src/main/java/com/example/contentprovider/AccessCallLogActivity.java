package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AccessCallLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_call_log);
        accessTheCallLog();
    }

    public void accessTheCallLog() {
//        Uri uri = Uri.parse("content://call_log/calls");
        CursorLoader loader = new CursorLoader(this,CallLog.Calls.CONTENT_URI,null,null,null,null);
        Cursor cursor = loader.loadInBackground();
        ArrayList<String> list = new ArrayList<>();
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            String s="";
            String idColumn = CallLog.Calls._ID;
            int idIndex = cursor.getColumnIndex(idColumn);

            String nameColumn = CallLog.Calls.CACHED_FORMATTED_NUMBER;
            int nameIndex = cursor.getColumnIndex(nameColumn);

            s = cursor.getString(idIndex) + " . " + cursor.getString(nameIndex);
            cursor.moveToNext();
            list.add(s);
        }
        cursor.close();
        ListView lv = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
    }
}
