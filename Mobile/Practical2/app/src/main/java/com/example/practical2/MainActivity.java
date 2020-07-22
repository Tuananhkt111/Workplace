package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText editModel, editPrice, editIdRemove, editIdUpdate, editModelUpdate, editPriceUpdate;
    public TextView txtListCar;
    public Uri CONTENT_URI_1 = Uri.parse("content://com.example.practical/CAR_LIST");

    public final String COLUMN_ID = "id";
    public final String COLUMN_MODEL = "model";
    public final String COLUMN_PRICE = "price";

    private ContentResolver contentResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editModel = findViewById(R.id.editModel);
        editPrice = findViewById(R.id.editPrice);
        editIdRemove = findViewById(R.id.editIdRemove);
        editIdUpdate = findViewById(R.id.editIdUpdate);
        editModelUpdate = findViewById(R.id.editModelUpdate);
        editPriceUpdate = findViewById(R.id.editPriceUpdate);

        txtListCar = findViewById(R.id.txtListCar);
        contentResolver = getContentResolver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtListCar.setText(getAllCar());
    }

    private String getAllCar(){
        Cursor cursor = contentResolver.query(CONTENT_URI_1, null,null,null,null,null);
        String list = "";
        if(cursor != null &cursor.getCount() > 0){
            while(cursor.moveToNext()){
                list = list + cursor.getLong(0) + ", " + cursor.getString(1) + ", " + cursor.getString(2) + "\n";
            }
        }
        cursor.close();
        txtListCar.setText(list);
        return list;
    }

    public void clickToAdd(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MODEL, editModel.getText().toString());
        contentValues.put(COLUMN_PRICE,editPrice.getText().toString());

        contentResolver.insert(CONTENT_URI_1,contentValues);
        txtListCar.setText(getAllCar());
        editModel.setText("");
        editPrice.setText("");
    }

    public void clickToRemove(View view) {
        contentResolver.delete(CONTENT_URI_1,COLUMN_ID + " = ?", new String[]{editIdRemove.getText().toString()});
        txtListCar.setText(getAllCar());
        editIdRemove.setText("");
    }

    public void clickToUpdate(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MODEL, editModelUpdate.getText().toString());
        contentValues.put(COLUMN_PRICE, editPriceUpdate.getText().toString());

        contentResolver.update(CONTENT_URI_1,contentValues,COLUMN_ID + " = ?", new String[]{editIdUpdate.getText().toString()});
        txtListCar.setText(getAllCar());
        editIdUpdate.setText("");
        editModelUpdate.setText("");
        editPriceUpdate.setText("");
    }
}