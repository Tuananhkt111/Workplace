package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);
        showAllContact();
    }

    public void showAllContact(){
        //Để lấy toàn bộ danh bạ trong điện thoại
        Uri uri = Uri.parse("content://contacts/people");
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            String s = "";
            String idColumn = ContactsContract.Contacts._ID;
            int idIndex = cursor.getColumnIndex(idColumn);

            String nameColumn = ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex = cursor.getColumnIndex(nameColumn);

            s = cursor.getString(idIndex) + "-" + cursor.getString(nameIndex);
            list.add(s);
            cursor.moveToNext();
        }
        cursor.close();
        ListView lv = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
    }
}
