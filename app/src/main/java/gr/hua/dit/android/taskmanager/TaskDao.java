package gr.hua.dit.android.taskmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import gr.hua.dit.android.taskmanager.Status;
import gr.hua.dit.android.taskmanager.Task;

@Dao
public interface TaskDao {
    @Insert
    void insertTask(Task task);

    @Insert
    void insertStatus(Status status);

    @Query("SELECT * FROM statuses WHERE status_name = :statusName")
    Status getStatusByName(String statusName);

    @Query("SELECT * FROM tasks")
    List<Task> getAllTasks();
}
