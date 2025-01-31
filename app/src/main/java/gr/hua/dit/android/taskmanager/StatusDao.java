package gr.hua.dit.android.taskmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import gr.hua.dit.android.taskmanager.Status;

@Dao
public interface StatusDao {

    @Insert
    void insertStatus(Status status);

    @Query("SELECT * FROM status WHERE statusName = :statusName LIMIT 1")
    Status getStatusByName(String statusName);

    @Query("SELECT * FROM status")
    List<Status> getAllStatuses();
}