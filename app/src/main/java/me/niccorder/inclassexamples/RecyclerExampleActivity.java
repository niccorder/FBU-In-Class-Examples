package me.niccorder.inclassexamples;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerExampleActivity extends AppCompatActivity {

    final List<String> names = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 1000; ++i) names.add(String.format("Thing %d", i));

        setContentView(R.layout.activity_recycler_example);

        recyclerView = findViewById(R.id.recycler);

        final RecyclerView.LayoutManager manager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        recyclerView.setLayoutManager(manager);

        ExampleAdapter adapter = new ExampleAdapter(names);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    static class ExampleViewHolder extends RecyclerView.ViewHolder {

        final TextView nameText;

        public ExampleViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.name_tv);
        }
    }

    static class ExampleAdapter extends RecyclerView.Adapter<ExampleViewHolder> {

        final List<String> names;

        ExampleAdapter(List<String> names) {
            this.names = names;
        }

        @NonNull
        @Override
        public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ExampleViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_name,
                            parent,
                            false
                    )
            );
        }

        @Override
        public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
            final String name = names.get(position);

            holder.nameText.setText(name);
        }

        @Override
        public int getItemCount() {
            return names.size();
        }
    }
}
