package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public EditText editTitle, editIsbn, editIdRemove, editIdUpdate, editTitleUpdate, editIsbnUpdate;
    public TextView txtListBook;
    public Uri CONTENT_URI_1 = Uri.parse("content://com.example.practical/BOOK_LIST");

    public final String COLUMN_ID = "id";
    public final String COLUMN_TITLE = "title";
    public final String COLUMN_ISBN = "isbn";

    private ContentResolver contentResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.editTitle);
        editIsbn = findViewById(R.id.editIsbn);
        editIdRemove = findViewById(R.id.editIdRemove);
        editIdUpdate = findViewById(R.id.editIdUpdate);
        editTitleUpdate = findViewById(R.id.editTitleUpdate);
        editIsbnUpdate = findViewById(R.id.editIsbnUpdate);

        txtListBook = findViewById(R.id.txtListBook);
        contentResolver = getContentResolver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtListBook.setText(getAllBook());
    }

    private String getAllBook(){
        Cursor cursor = contentResolver.query(CONTENT_URI_1, null,null,null,null,null);
        String list = "";
        if(cursor != null &cursor.getCount() > 0){
            while(cursor.moveToNext()){
                list = list + cursor.getLong(0) + ", " + cursor.getString(1) + ", " + cursor.getString(2) + "\n";
            }
        }
        cursor.close();
        txtListBook.setText(list);
        return list;
    }

    public void clickToAdd(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, editTitle.getText().toString());
        contentValues.put(COLUMN_ISBN,editIsbn.getText().toString());

        contentResolver.insert(CONTENT_URI_1,contentValues);
        txtListBook.setText(getAllBook());
        editTitle.setText("");
        editIsbn.setText("");
    }

    public void clickToRemove(View view) {
        contentResolver.delete(CONTENT_URI_1,COLUMN_ID + " = ?", new String[]{editIdRemove.getText().toString()});
        txtListBook.setText(getAllBook());
        editIdRemove.setText("");
    }

    public void clickToUpdate(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, editTitleUpdate.getText().toString());
        contentValues.put(COLUMN_ISBN, editIsbnUpdate.getText().toString());

        contentResolver.update(CONTENT_URI_1,contentValues,COLUMN_ID + " = ?", new String[]{editIdUpdate.getText().toString()});
        txtListBook.setText(getAllBook());
        editIdUpdate.setText("");
        editTitleUpdate.setText("");
        editIsbnUpdate.setText("");
    }
}