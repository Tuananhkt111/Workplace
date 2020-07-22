package com.example.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practical.dataset.Car;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public EditText editModel, editPrice, editIdRemove, editIdUpdate, editModelUpdate, editPriceUpdate;
    public TextView txtListCar;
    private DBAdapter dbAdapter;

    private List<Car> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter = DBAdapter.getDBAdapterInstance(getApplicationContext());
        list = dbAdapter.getAllCars();

        editModel = findViewById(R.id.editModel);
        editPrice = findViewById(R.id.editPrice);
        editIdRemove = findViewById(R.id.editIdRemove);
        editIdUpdate = findViewById(R.id.editIdUpdate);
        editModelUpdate = findViewById(R.id.editModelUpdate);
        editPriceUpdate = findViewById(R.id.editPriceUpdate);

        txtListCar = findViewById(R.id.txtListCar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtListCar.setText(getListCar());
    }
    private String getListCar(){
        list = dbAdapter.getAllCars();
        if(list != null && list.size() > 0){
            StringBuilder stringBuilder = new StringBuilder("");
            for(Car car : list){
                stringBuilder.append(car.getId() + ", " + car.getModel() + ", " + car.getPrice() + "\n");
            }
            return stringBuilder.toString();
        }else {
            return "There's no car!!!";
        }
    }



    public void clickToAdd(View view) {
        dbAdapter.insert(editModel.getText().toString(), Integer.parseInt(editPrice.getText().toString()));
        txtListCar.setText(getListCar());
        editModel.setText("");
        editPrice.setText("");
    }

    public void clickToRemove(View view) {
        dbAdapter.delete(Integer.parseInt(editIdRemove.getText().toString()));
        txtListCar.setText(getListCar());
        editIdRemove.setText("");
    }

    public void clickToUpdate(View view) {
        dbAdapter.update(Integer.parseInt(editIdUpdate.getText().toString()), editModelUpdate.getText().toString(), Integer.parseInt(editPriceUpdate.getText().toString()));
        txtListCar.setText(getListCar());
        editModelUpdate.setText("");
        editPriceUpdate.setText("");
        editIdUpdate.setText("");
    }
}