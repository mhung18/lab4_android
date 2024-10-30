package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvItem;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> items = new ArrayList<String>();
        for(int i = 1;i <= 100;i++){
            String item = "Item " + String.valueOf(i);
            items.add(item);
        }
        lvItem = findViewById(R.id.lvItem);

        DataAdapter dataAdapter = new DataAdapter(this,items);
        lvItem.setAdapter(dataAdapter);
    }
}