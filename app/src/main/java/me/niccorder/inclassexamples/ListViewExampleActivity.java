package me.niccorder.inclassexamples;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewExampleActivity extends AppCompatActivity {

    private final List<String> datasource = new ArrayList<>();

    private ListView listView;
    private BadAdapter exampleAdapter;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);

        // Fill dummy data for example.
        for (int i = 0; i < 1000; ++i) datasource.add(String.format("Sample item %d", i));

        // Create a bad adapter. It's bad.
        exampleAdapter = new BadAdapter(datasource);

        // Grab a reference to the list view in this activities XML layout
        listView = findViewById(R.id.list_view);

        // Attach the adapter to the list view so it knows what data it will be displaying on the screen
        listView.setAdapter(exampleAdapter);
    }

    static class BadAdapter extends BaseAdapter {

        private final List<String> datasource;

        BadAdapter(List<String> datasource) {
            this.datasource = datasource;
        }

        @Override
        public int getCount() {
            return datasource.size();
        }

        @Override
        public Object getItem(int position) {
            return datasource.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            return BaseAdapter.IGNORE_ITEM_VIEW_TYPE;
        }

        @Override
        @SuppressLint("ViewHolder")
        public View getView(int position, View convertView, ViewGroup parent) {
            final TextView itemView = (TextView) LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1,
                    parent,
                    false
            );

            itemView.setText(datasource.get(position));
            return itemView;
        }
    }
}
