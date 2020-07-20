package nguyennb.example.democruddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private EditText edtID, edtName, edtAge;
    private DatabaseHandler handler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edtID = findViewById(R.id.edtID);
        edtAge = findViewById(R.id.edtAge);
        edtName = findViewById(R.id.edtName);
        handler = new DatabaseHandler(this);
    }

    public void clickToAdd(View view) {
        try{
            handler.insertStudent(Integer.parseInt(edtID.getText().toString()),edtName.getText().toString(),Integer.parseInt(edtAge.getText().toString()));
            Toast.makeText(this,"Insert Success",Toast.LENGTH_LONG).show();
            edtID.setText("");
            edtName.setText("");
            edtAge.setText("");
            edtID.requestFocus();
        }catch (Exception e){
            Toast.makeText(this,"Already Existed",Toast.LENGTH_LONG).show();
        }
    }
}
