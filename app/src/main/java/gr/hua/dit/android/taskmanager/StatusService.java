package gr.hua.dit.android.taskmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class StatusService extends Service {
    @Override
    public int onStartCommand(Intent intent , int flags , int startId){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.e("Service" , "Service is running...");
                        try {
                            Thread.sleep(2000);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
        return super.onStartCommand(intent, flags , startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
