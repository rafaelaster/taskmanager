package gr.hua.dit.android.taskmanager;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;

import gr.hua.dit.android.taskmanager.AddTaskActivity;
import gr.hua.dit.android.taskmanager.R;import gr.hua.dit.android.taskmanager.TaskDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;

    private TaskAdapter adapter;
    private ArrayList<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerAdapter = new RecyclerAdapter();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button btnAddTask = findViewById(R.id.btn_add_task);
        btnAddTask.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });



//        startService(service_intent);
//        adapter = new TaskAdapter(this, tasks);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
//        TaskDatabase.getAllTasks().observe(this, new Observer<List<Task>>()){
//        @Override
//        public void onChanged(List<Task> tasks){
//                .taskDao()
//                .getAllTasks();
//        }

//    }

//    PeriodicWorkRequest changeStatus = new PeriodicWorkRequest.Builder().build();
//    public void setRecyclerView(RecyclerView recyclerView) {

    }
