package gr.hua.dit.android.taskmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks",
        foreignKeys = @ForeignKey(entity = Status.class,
                parentColumns = "id",
                childColumns = "statusId",
                onDelete = ForeignKey.CASCADE))
public class Task {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    @NonNull
    private String title;

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "start_time")
    private String startTime;

    @ColumnInfo(name = "duration")
    private int duration;

    @ColumnInfo(name = "statusId")
    private int statusId;

    @ColumnInfo(name = "location")
    private String location;

    // Getters and setters...
    public Task(@NonNull String title, String description, String startTime, int duration, int statusId, String location) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.duration = duration;
        this.statusId = statusId;
        this.location = location;
    }
    public Task(String shortName, String description, String startTime, int duration, String statusName, String title) {
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NonNull
    public String getShortName() {
        return title;
    }

    public void setShortName(@NonNull String shortName) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startTime='" + startTime + '\'' +
                ", duration=" + duration +
                ", statusId=" + statusId +
                ", location='" + location + '\'' +
                '}';
    }
}
