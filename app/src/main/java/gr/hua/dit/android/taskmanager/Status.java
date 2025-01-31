package gr.hua.dit.android.taskmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "status")
public class Status {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "statusName")
    @NonNull
    private String statusName;

    public Status() {

    }


    // Constructor, getters, setters...


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(@NonNull String statusName) {
        this.statusName = statusName;
    }


    public Status(@NonNull String statusName) {
        this.statusName = statusName;
    }
}
