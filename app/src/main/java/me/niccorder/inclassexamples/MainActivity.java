package me.niccorder.inclassexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button listExampleButton;
    private Button recyclerExampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listExampleButton = findViewById(R.id.list_view_btn);
        listExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startListViewExample();
            }
        });

        recyclerExampleButton = findViewById(R.id.recycler_example_btn);
        recyclerExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecyclerViewExample();
            }
        });

    }

    private void startListViewExample() {
        Log.d(TAG, "Starting list view example.");

        final Intent listViewExampleIntent = new Intent(this, ListViewExampleActivity.class);
        startActivity(listViewExampleIntent);
    }

    private void startRecyclerViewExample() {
        Log.d(TAG, "Starting recycler view example.");

        final Intent recyclerExampleIntent = new Intent(this, RecyclerExampleActivity.class);
        startActivity(recyclerExampleIntent);
    }
}
