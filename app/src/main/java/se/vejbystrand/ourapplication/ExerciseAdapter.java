package se.vejbystrand.ourapplication;

import android.content.Context;
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
        View itemView = inflater.inflate(R.layout.logview, parent, false);

        ViewHolder holder = new ViewHolder(itemView);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Exercise exercise = exercises.get(position);
        holder.txtId.setText(String.valueOf(exercise.getId()));
        holder.txtAcitivty.setText(String.valueOf(exercise.getActivity()));
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
        public final TextView txtId, txtAcitivty, txtWeight, txtSet, txtReps, txtDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtActivityId);
            txtAcitivty = itemView.findViewById(R.id.txtActivityp2);
            txtWeight = itemView.findViewById(R.id.numWeight3);
            txtSet = itemView.findViewById(R.id.numSet3);
            txtReps = itemView.findViewById(R.id.numRepoa3);
            txtDate = itemView.findViewById(R.id.dateTime3);
        }
    }
}
