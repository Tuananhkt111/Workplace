package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToShowContacts(View view) {
        Intent intent = new Intent(this, ShowContactsActivity.class);
        startActivity(intent);
    }

    public void clickToAccessCallLog(View view) {
        Intent intent = new Intent(this, AccessCallLogActivity.class);
        startActivity(intent);
    }
}
