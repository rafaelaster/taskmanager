package gr.hua.dit.android.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import gr.hua.dit.android.taskmanager.AddTaskActivity;
import gr.hua.dit.android.taskmanager.R;import gr.hua.dit.android.taskmanager.TaskDatabase;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Button btnAddTask = findViewById(R.id.btn_add_task);
        btnAddTask.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        TaskDatabase.getInstance(this)
                .taskDao()
                .getAllTasks();
       }

}
