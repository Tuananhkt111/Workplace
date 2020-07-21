package com.example.contentproviderapp2;

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

    public EditText editName,editEmail,editIdRemove,editIdUpdate,editNameUpdate, editEmailUpdate;
    public TextView txtListStudent;
    public Uri CONTENT_URI_1 = Uri.parse("content://com.example.contentprovider/STUDENT_LIST");

    public final String COLUMN_ID="id";
    public final String COLUMN_NAME="name";
    public final String COLUMN_EMAIL="email";

    private ContentResolver contentResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editIdRemove = findViewById(R.id.editIdRemove);
        editIdUpdate = findViewById(R.id.editIdUpdate);
        editNameUpdate = findViewById(R.id.editNameUpdate);
        editEmailUpdate = findViewById(R.id.editEmailUpdate);

        txtListStudent = findViewById(R.id.txtListStudent);
        contentResolver = getContentResolver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtListStudent.setText(getAllStudent());
    }

    private String getAllStudent(){
        Cursor cursor = contentResolver.query(CONTENT_URI_1, null,null,null,null,null);
        String list = "";
        if(cursor != null &cursor.getCount() > 0){
            while(cursor.moveToNext()){
                list = list + cursor.getLong(0)+", "+cursor.getString(1)+", "+cursor.getString(2)+"\n";
            }
        }
        cursor.close();
        txtListStudent.setText(list);
        return list;
    }

    public void clickToAdd(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, editName.getText().toString());
        contentValues.put(COLUMN_EMAIL,editEmail.getText().toString());

        contentResolver.insert(CONTENT_URI_1,contentValues);
        txtListStudent.setText(getAllStudent());
        editName.setText("");
        editEmail.setText("");
    }

    public void clickToRemove(View view) {
        contentResolver.delete(CONTENT_URI_1,COLUMN_ID + " = ?",new String[]{editIdRemove.getText().toString()});
        txtListStudent.setText(getAllStudent());
        editIdRemove.setText("");
    }

    public void clickToUpdateName(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,editNameUpdate.getText().toString());
        contentValues.put(COLUMN_EMAIL,editEmailUpdate.getText().toString());

        contentResolver.update(CONTENT_URI_1,contentValues,COLUMN_ID + " = ?",new String[]{editIdUpdate.getText().toString()});
        txtListStudent.setText(getAllStudent());
        editIdUpdate.setText("");
        editNameUpdate.setText("");
        editEmailUpdate.setText("");
    }
}
