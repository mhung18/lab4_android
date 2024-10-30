package com.example.ex3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex3.R;
import com.example.ex3.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<Item> itemList;
    private ArrayList<Boolean> checkList;

    public ItemAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
        checkList = new ArrayList<>(Collections.nCopies(itemList.size(), false));
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        if (item == null){
            return;
        }
        holder.tvItem.setText(item.getItemName());
        holder.chkItem.setOnCheckedChangeListener((Checkbox, isChecked) -> {
            checkList.set(position, isChecked);
        });
    }

    public List<Boolean> getCheckedList() {
        return checkList;
    }

    public void removeCheckedItems() {
        for (int i = itemList.size() - 1; i >= 0; i--) {
            if (checkList.get(i) == true) {
                itemList.remove(i);
                checkList.remove(i);
            }
        }
        notifyDataSetChanged();// Cập nhật RecyclerView sau khi xóa
    }
    public void removeAllItems() {
        for (int i = itemList.size() - 1; i >= 0; i--) {
            itemList.remove(i);
        }
        notifyDataSetChanged();// Cập nhật RecyclerView sau khi xóa
    }
    @Override
    public int getItemCount() {
        if(itemList != null){
            return itemList.size();
        }
        return 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItem;
        CheckBox chkItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
            chkItem = itemView.findViewById(R.id.chkItem);
        }
    }
}
