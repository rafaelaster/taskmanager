package gr.hua.dit.android.taskmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface StatusDao {
    @Insert
    long insert(Status status);

    @Insert
    List<Long> insert(List<Status> statusList);

    @Query("SELECT * FROM status")
    List<Status> getStatusAll();

    @Query("SELECT * FROM status WHERE statusName = :statusName")
    Status getStatusByName(String statusName);
}
