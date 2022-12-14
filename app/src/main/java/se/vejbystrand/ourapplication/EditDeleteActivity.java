package se.vejbystrand.ourapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditDeleteActivity extends AppCompatActivity {

    private int activityId;
    ExerciseRepo db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        Exercise exercise = getExerciseFromViewAll();
        activityId = exercise.getId();

        db = ExerciseRepo.getInstance(getApplicationContext());

        initViewFromExercise(exercise);

    }

    private void initViewFromExercise(Exercise exercise) {
        setText(R.id.txtActivity, exercise.getActivity());
        setText(R.id.numWeight, exercise.getWeight());
        setText(R.id.numSet, exercise.getSet());
        setText(R.id.numReps, exercise.getReps());
        setText(R.id.datetime, exercise.getDate());
    }

    private void setText(int resId, String value) {
        TextView view = findViewById(resId);
        view.setText(value);
    }

    private void setText(int resId, int value) {
        setText(resId, String.valueOf(value));
    }

    private Exercise getExerciseFromViewAll() {
        Intent intent = getIntent();
        int activityId = intent.getIntExtra("id", 0);

        Exercise exercise = db.findExerciseById(activityId);
        return exercise == null ? new Exercise() : exercise;
    }

    public void onBtnSaveClick(View view) { // update workout
        Exercise exercise = new Exercise()
                .setId(activityId)
                .setActivity(getTextFromView(R.id.txtActivity))
                .setWeight(getIntFromView(R.id.numWeight))
                .setSet(getIntFromView(R.id.numSet))
                .setReps(getIntFromView(R.id.numReps))
                .setDate(getTextFromView(R.id.datetime));

        db.update(exercise);
        backToViewAll();
    }

    public void onBtnRemoveClick(View view) {
        db.deleteActivity(activityId);
        backToViewAll();
    }

    private String getTextFromView(int resId) {
        TextView view = findViewById(resId);
        return view.getText().toString();
    }

    private int getIntFromView(int resId) {
        return Integer.parseInt(getTextFromView(resId));
    }

    private void backToViewAll() {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }
}