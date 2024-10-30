package com.example.ex4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        // Sinh ngẫu nhiên số lượng phần tử từ 10 đến 100
        int itemCount = new Random().nextInt(91) + 10; // 10 - 100
        adapter = new MyAdapter(this, itemCount);

        // Sử dụng GridLayoutManager cho RecyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3)); // 3 cột
        recyclerView.setAdapter(adapter);
    }
}
