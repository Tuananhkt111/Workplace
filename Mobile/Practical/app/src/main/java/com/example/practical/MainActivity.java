package com.example.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practical.dataset.Book;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public EditText editTitle, editIsbn, editIdRemove, editIdUpdate, editTitleUpdate, editIsbnUpdate;
    public TextView txtListBook;
    private DBAdapter dbAdapter;

    private List<Book> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter = DBAdapter.getDBAdapterInstance(getApplicationContext());
        list = dbAdapter.getAllBooks();

        editTitle = findViewById(R.id.editTitle);
        editIsbn = findViewById(R.id.editIsbn);
        editIdRemove = findViewById(R.id.editIdRemove);
        editIdUpdate = findViewById(R.id.editIdUpdate);
        editTitleUpdate = findViewById(R.id.editTitleUpdate);
        editIsbnUpdate = findViewById(R.id.editIsbnUpdate);

        txtListBook = findViewById(R.id.txtListBook);
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtListBook.setText(getListBook());
    }
    private String getListBook(){
        list = dbAdapter.getAllBooks();
        if(list != null && list.size() > 0){
            StringBuilder stringBuilder = new StringBuilder("");
            for(Book book : list){
                stringBuilder.append(book.getId() + ", " + book.getTitle() + ", " + book.getIsbn() + "\n");
            }
            return stringBuilder.toString();
        }else {
            return "There's no book!!!";
        }
    }



    public void clickToAdd(View view) {
        dbAdapter.insert(editTitle.getText().toString(), editIsbn.getText().toString());
        txtListBook.setText(getListBook());
        editTitle.setText("");
        editIsbn.setText("");
    }

    public void clickToRemove(View view) {
        dbAdapter.delete(Integer.parseInt(editIdRemove.getText().toString()));
        txtListBook.setText(getListBook());
        editIdRemove.setText("");
    }

    public void clickToUpdate(View view) {
        dbAdapter.update(Integer.parseInt(editIdUpdate.getText().toString()), editTitleUpdate.getText().toString(), editIsbnUpdate.getText().toString());
        txtListBook.setText(getListBook());
        editIdRemove.setText("");
        editIdUpdate.setText("");
    }
}