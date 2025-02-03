package gr.hua.dit.android.taskmanager;

import android.content.Context;
import android.util.Log;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;

public class TaskWork extends Worker {


    private static final String TAG = "TaskWork";

    public TaskWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @androidx.annotation.NonNull
    @Override
    public Result doWork() {
        final int wait_sec = 10;
        Log.i(TAG, "doWork() START - wait ... " + wait_sec + " sec");
        for (int i = 0; i < wait_sec; i++) {
            Log.i(TAG, "doWork() index: " + i);
            try { Thread.sleep(1000); } catch (Throwable t) {}
        }
        Log.i(TAG, "doWork() END");
        return Result.success();
    }
}