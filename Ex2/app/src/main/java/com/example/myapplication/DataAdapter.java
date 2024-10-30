package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends BaseAdapter {

    private Activity activity;
    private List<String> items;

    public DataAdapter(Activity activity,List<String> items ){
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gọi layoutInflater ra để bắt đầu ánh xạ view và data.
        LayoutInflater inflater = activity.getLayoutInflater();

        // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong item_name.xml
        convertView = inflater.inflate(R.layout.item, null);

        // Đặt chữ cho từng view trong danh sách.
        TextView tvItem = (TextView) convertView.findViewById(R.id.tvItem);
        tvItem.setText(items.get(position));

        // Xóa item bị click "Remove"
        Button btnRemove = (Button) convertView.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(position);
                notifyDataSetChanged(); //thông báo cho adapter cập nhật lại khi xóa
            }
        });
        // Trả về view kết quả.
        return convertView;

    }
}
