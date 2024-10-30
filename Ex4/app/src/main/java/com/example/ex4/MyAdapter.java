package com.example.ex4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final List<Boolean> itemStates; // Danh sách trạng thái của từng item
    private final Context context;

    public MyAdapter(Context context, int itemCount) {
        this.context = context;
        this.itemStates = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            itemStates.add(false); // Mặc định trạng thái OFF
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        boolean isChecked = itemStates.get(position);
        holder.itemNumber.setText("PC " + String.valueOf(position + 1)); // +1 để bắt đầu từ 1

        holder.itemIcon.setImageResource(isChecked ? R.drawable.blue_monitor : R.drawable.red_monitor);

        holder.itemIcon.setOnClickListener(v -> {
            // Chuyển đổi trạng thái
            itemStates.set(position, !isChecked);
            notifyItemChanged(position); // Cập nhật chỉ mục item đã thay đổi
        });
    }

    @Override
    public int getItemCount() {
        return itemStates.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNumber;
        ImageView itemIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNumber = itemView.findViewById(R.id.item_number);
            itemIcon = itemView.findViewById(R.id.item_icon);
        }
    }
}

