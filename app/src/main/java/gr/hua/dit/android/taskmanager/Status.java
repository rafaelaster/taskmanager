package gr.hua.dit.android.taskmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "statuses")
public class Status {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "status_name")
    @NonNull
    private String statusName;

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
    @Ignore
    public void setStatusName(@NonNull String statusName) {
        this.statusName = statusName;
    }
    @Ignore
    public Status(int id) {
        this.id = id;
    }

    public Status(@NonNull String statusName) {
        this.statusName = statusName;
    }
}
