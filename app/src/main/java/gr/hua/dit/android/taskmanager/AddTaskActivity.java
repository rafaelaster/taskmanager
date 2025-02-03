package gr.hua.dit.android.taskmanager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.Arrays;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity {

    private EditText shortNameInput, descriptionInput, startTimeInput, durationInput, locationInput;
    private Spinner statusSpinner;
    private Button saveTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Initialize UI components
        shortNameInput = findViewById(R.id.short_name);
        descriptionInput = findViewById(R.id.description);
        startTimeInput = findViewById(R.id.start_time);
        durationInput = findViewById(R.id.duration);
        locationInput = findViewById(R.id.location);
        statusSpinner = findViewById(R.id.status_spinner);
        saveTaskButton = findViewById(R.id.btn_save_task);

        // Populate Status Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                getStatuses());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter);

        // Save Task on Button Click
        saveTaskButton.setOnClickListener(v -> saveTask());
    }

    private List<String> getStatuses() {
        return Arrays.asList("recorded", "in-progress", "expired", "completed");
    }

    private void saveTask() {
        String shortName = shortNameInput.getText().toString().trim();
        String description = descriptionInput.getText().toString().trim();
        String startTime = startTimeInput.getText().toString().trim();
        String durationStr = durationInput.getText().toString().trim();
        String location = locationInput.getText().toString().trim();
        String statusName = statusSpinner.getSelectedItem().toString();

        // Validation
        if (shortName.isEmpty() || durationStr.isEmpty() || !isPositiveInteger(durationStr)) {
            Toast.makeText(this, "Please provide valid inputs.", Toast.LENGTH_SHORT).show();
            return;
        }

        int duration = Integer.parseInt(durationStr);

        // Insert Task
        new Thread(() -> {
            TaskDatabase db = Room.databaseBuilder(getApplicationContext(), TaskDatabase.class, "task.sqlite")
                    .build();
            Task task = new Task(shortName, description, startTime, duration, statusName, location);
            db.taskDao().insertTask(task);
            runOnUiThread(() -> {
                Toast.makeText(AddTaskActivity.this, "Task Saved!", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity after saving
            });
        }).start();
    }

    private boolean isPositiveInteger(String value) {
        try {
            return Integer.parseInt(value) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}