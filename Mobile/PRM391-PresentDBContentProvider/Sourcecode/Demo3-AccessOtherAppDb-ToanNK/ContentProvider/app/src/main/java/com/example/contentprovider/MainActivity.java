package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.contentprovider.Dataset.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public EditText editName,editEmail,editIdRemove,editIdUpdate,editNameUpdate;
    public TextView txtListStudent;
    private DBAdapter dbAdapter;

    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter = DBAdapter.getDBAdapterInstance(getApplicationContext());
        list = dbAdapter.getAllStudents();

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editIdRemove = findViewById(R.id.editIdRemove);
        editIdUpdate = findViewById(R.id.editIdUpdate);
        editNameUpdate = findViewById(R.id.editNameUpdate);

        txtListStudent = findViewById(R.id.txtListStudent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtListStudent.setText(getListStudent());
    }
    private String getListStudent(){
        list = dbAdapter.getAllStudents();
        if(list != null && list.size() > 0){
            StringBuilder stringBuilder=new StringBuilder("");
            for(Student toDo:list){
                stringBuilder.append(toDo.getName()+", "+toDo.getEmail()+"\n");
            }
            return stringBuilder.toString();
        }else {
            return "There's no student!!!";
        }
    }



    public void clickToAdd(View view) {
        dbAdapter.insert(editName.getText().toString(),editEmail.getText().toString());
        txtListStudent.setText(getListStudent());
        editName.setText("");
        editEmail.setText("");
    }

    public void clickToRemove(View view) {
        dbAdapter.delete(Integer.parseInt(editIdRemove.getText().toString()));
        txtListStudent.setText(getListStudent());
        editIdRemove.setText("");
    }

    public void clickToUpdate(View view) {
        dbAdapter.update(Integer.parseInt(editIdUpdate.getText().toString()), editNameUpdate.getText().toString());
        txtListStudent.setText(getListStudent());
        editIdRemove.setText("");
        editIdUpdate.setText("");
    }
}
