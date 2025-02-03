package gr.hua.dit.android.taskmanager;

import androidx.lifecycle.LiveData;
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

//    void insertStatus(Status status);

//    Status getStatusByName(String statusName);

    @Query("SELECT * FROM tasks")
    List<Task> getAllTasks();

    @Query("SELECT *  FROM tasks WHERE id IN (:tasksIds) ")
    List<Task> loadAllbyIds(int[] tasksIds);

}
