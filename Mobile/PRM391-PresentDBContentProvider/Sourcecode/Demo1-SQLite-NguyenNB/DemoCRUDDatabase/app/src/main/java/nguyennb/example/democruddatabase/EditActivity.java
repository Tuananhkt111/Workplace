package nguyennb.example.democruddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private EditText edtName,edtAge;
    private DatabaseHandler handler;
    private String id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        handler = new DatabaseHandler(this);
        Intent intent = this.getIntent();
        String checked = intent.getStringExtra("USER");
        String[] row = checked.split("-");
        id = row[0].toString();
        edtName.setText(row[1].toString().trim());
        edtAge.setText(row[2].toString().trim());

    }

    public void clicktoSave(View view) {
        if(edtName.getText().toString().trim() == null || edtAge.getText().toString().trim() == null){
            Toast.makeText(this,"Cant input blank",Toast.LENGTH_LONG).show();
        }else{
            try {
                handler.updateStudent(id, edtName.getText().toString(), edtAge.getText().toString());
                Toast.makeText(this, "Edit Complete", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,ViewActivity.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
