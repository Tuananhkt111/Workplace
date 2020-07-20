package nguyennb.example.democruddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    private ListView listView;
    private DatabaseHandler handler;
    private String checked ;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        listView = findViewById(R.id.lstUser);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        handler = new DatabaseHandler(this);
        list = handler.getUsers();
        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checked = list.get(position).toString();
            }
        });
    }

    public void clickToDelete(View view) {
        if(checked == null){
            Toast.makeText(this,"Please choose a row to delete",Toast.LENGTH_LONG).show();
        }else{
            try {
                String[] row = checked.split("-");
                handler.deleteStudent(row[0].trim());
                list.clear();
                list.addAll(handler.getUsers());
                System.out.println(list.size());
                ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
            }catch (Exception e){
                Toast.makeText(this,"Error " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }


    public void clickToEdit(View view) {
        if(checked == null){
            Toast.makeText(this,"Please choose a row to edit",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, EditActivity.class);
            intent.putExtra("USER", checked);
            startActivity(intent);
        }
    }
}
