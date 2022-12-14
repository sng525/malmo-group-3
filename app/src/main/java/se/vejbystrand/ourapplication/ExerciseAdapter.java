package se.vejbystrand.ourapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    Context context;
    ArrayList<Exercise> exercises;

    public ExerciseAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.view_log_item, parent, false);

        ViewHolder holder = new ViewHolder(itemView);

        // click in to edit or delete page
        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, EditDeleteActivity.class);
            intent.putExtra("id", Integer.valueOf(holder.txtId.getText().toString()));
            context.startActivity(intent);
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.txtId.setText(String.valueOf(exercise.getId()));
        holder.txtActivity.setText(String.valueOf(exercise.getActivity()));
        holder.txtWeight.setText(String.valueOf(exercise.getWeight()));
        holder.txtSet.setText(String.valueOf(exercise.getSet()));
        holder.txtReps.setText(String.valueOf(exercise.getReps()));
        holder.txtDate.setText(String.valueOf(exercise.getDate()));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtId, txtActivity, txtWeight, txtSet, txtReps, txtDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtActivityId);
            txtActivity = itemView.findViewById(R.id.txtActivity);
            txtWeight = itemView.findViewById(R.id.numWeight);
            txtSet = itemView.findViewById(R.id.numSet);
            txtReps = itemView.findViewById(R.id.numReps);
            txtDate = itemView.findViewById(R.id.datetime);
        }
    }
}
