package gr.hua.dit.android.taskmanager;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Task.class, Status.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();
    public abstract StatusDao statusDao();

}