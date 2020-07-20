package nguyennb.example.democruddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);

    }


    public void clickToOpenAdd(View view) {
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }

    public void clickToView(View view) {
        Intent intent = new Intent(this,ViewActivity.class);
        startActivity(intent);
    }
}
