package gr.hua.dit.android.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Task> list;

    public TaskAdapter(Context context, ArrayList<Task> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.taskTitle.setText(list.get(position).getTitle());
        holder.menuPopUp.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, v);
            popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.export) {
                    Toast.makeText(context, "Exporting file..", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.location) {
                    Toast.makeText(context, "Finding location...", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.deletetask) {
                    // Get current position dynamically
                    int currentPosition = holder.getAdapterPosition();
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        deleteItem(currentPosition);
                    }
                }
                return false;
            });

            popupMenu.show();
        });
    }

    private void deleteItem(int position) {
        // Remove from database first (add your database logic here)
        Task taskToDelete = list.get(position);

        // Then update UI
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, list.size());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView taskTitle;
        ImageView menuPopUp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.taskTitle);
            menuPopUp = itemView.findViewById(R.id.menuPopUp);
        }
    }
}