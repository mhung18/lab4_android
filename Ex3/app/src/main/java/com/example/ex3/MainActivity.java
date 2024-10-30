package com.example.ex3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex3.adapter.ItemAdapter;
import com.example.ex3.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvItem;
    private ArrayList<Item> itemList;
    private ItemAdapter itemAdapter;
    Button btnRemove, btnRemoveAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rcvItem = findViewById(R.id.rcvItem);
        btnRemove = findViewById(R.id.btnRemove);
        btnRemoveAll = findViewById(R.id.btnRemoveAll);
        itemList = new ArrayList<>();

        Item item1 = new Item("Iphone");
        Item item2 = new Item("Samsung");
        Item item3 = new Item("Oppa");
        Item item4 = new Item("Sony");
        Item item5 = new Item("Xiaomi");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);

        itemAdapter = new ItemAdapter(itemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvItem.setLayoutManager(linearLayoutManager);
        rcvItem.setAdapter(itemAdapter);

        btnRemove.setOnClickListener(view -> itemAdapter.removeCheckedItems());
        btnRemoveAll.setOnClickListener(view -> itemAdapter.removeAllItems());
    }
}