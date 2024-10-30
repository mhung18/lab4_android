package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;
    private TextView tvTotal;
    private int userCount = 0; // Đếm số lượng user hiện có

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTotal = findViewById(R.id.tvTotal);

        recyclerView = findViewById(R.id.recyclerView);
        Button btnAddUsers = findViewById(R.id.btnAddUsers);
        Button btnRemoveUsers = findViewById(R.id.btnRemoveUsers);

        userList = new ArrayList<>();
        userAdapter = new UserAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

        btnAddUsers.setOnClickListener(v -> addUsers());
        btnRemoveUsers.setOnClickListener(v -> removeUsers());

        updateTotalUserCount();
    }

    private void addUsers() {
        for (int i = 0; i < 5; i++) {
            userCount++;
            userList.add(new User("User " + userCount, "user" + userCount + "@tdtu.edu.vn"));
        }
        updateTotalUserCount();
        userAdapter.notifyDataSetChanged(); // Cập nhật RecyclerView
    }

    private void removeUsers() {
        if (userList.size() < 5) {
            Toast.makeText(this, "List of users is empty", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < 5; i++) {
                userList.remove(userList.size() - 1); // Xóa 5 user cuối cùng
            }
            updateTotalUserCount();
            userAdapter.notifyDataSetChanged(); // Cập nhật RecyclerView
        }
    }
    private void updateTotalUserCount() {
        tvTotal.setText(String.valueOf(userList.size()));
    }
}
