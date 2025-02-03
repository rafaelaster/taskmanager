package gr.hua.dit.android.taskmanager;

import android.app.LauncherActivity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public  class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    private List<Task> taskItems;
    private Context context;


    public RecyclerAdapter(List<Task> taskItems, Context context) {
        this.taskItems = taskItems;
        this.context = context;
    }

    //    καλείται κάθε φορά που δημιουργείται ο viewholder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent , false);
        return new ViewHolder(v);
    }
// Διαδικασία binding data
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//                 taskItem = taskItems.get(position);
//                holder.im;
//                holder.tv;
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // define ta duo view objects

        public TextView tv;

        public ImageView im;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            im = (ImageView) itemView.findViewById(R.id.imageView);

            tv = (TextView) itemView.findViewById(R.id.taskTitle);
        }
    }

}
