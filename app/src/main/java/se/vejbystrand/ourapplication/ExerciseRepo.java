package se.vejbystrand.ourapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ExerciseRepo implements Repository{

    private static final String TABLE_NAME = "WORKOUTS_TABLE";
    private SQLiteOpenHelper sqlite;

    private static ExerciseRepo instance = null;
    public static ExerciseRepo getInstance(Context context){
        if(instance == null)
            instance = new ExerciseRepo(context);

        return instance;
    }
    private ExerciseRepo(Context context){
        sqlite = DatabaseHelper.getInstance(context);
    }

    @Override
    public Exercise findExerciseById(int id) {
        SQLiteDatabase db = sqlite.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = " + id;

        Cursor cursor = db.rawQuery(query, null);

        Exercise exercise = cursor.moveToFirst()
                ? new Exercise()
                .setId(cursor.getInt(0))
                .setActivity(cursor.getString(1))
                .setWeight(cursor.getInt(2))
                .setSet(cursor.getInt(3))
                .setReps(cursor.getInt(4))
                .setDate(cursor.getString(5))
                : null;

        cursor.close();
        return exercise;
    }

    @Override
    public ArrayList<Exercise> findAllExercises() {
        ArrayList<Exercise> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String activity = cursor.getString(1);
                int weights = cursor.getInt(2);
                int sets = cursor.getInt(3);
                int reps = cursor.getInt(4);
                String date = cursor.getString(5);

                Exercise newWorkout = new Exercise(id, activity, weights, sets, reps, date);
                returnList.add(newWorkout);

            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();

        return returnList;
    }

    @Override
    public void save(Exercise exercise) {
        SQLiteDatabase db = sqlite.getWritableDatabase();
        ContentValues c = getContentValues(exercise);
        db.insert(TABLE_NAME, null, c);
    }


    public void deleteActivity(int id) {
        SQLiteDatabase db = sqlite.getWritableDatabase();
        String[] args = getWhereArgs(id);
        db.delete(TABLE_NAME, "id = ?", args);
    }

    public void update(Exercise exercise) {
        SQLiteDatabase db = sqlite.getWritableDatabase();

        ContentValues cv = getContentValues(exercise);
        String[] whereArgs = getWhereArgs(exercise.getId());

        db.update(TABLE_NAME, cv, "id = ?", whereArgs);
    }

    private String[] getWhereArgs(int id) {
        String[] whereArgs = {String.valueOf(id)};
        return whereArgs;
    }

    private ContentValues getContentValues(Exercise exercise) {
        ContentValues cv = new ContentValues();

        cv.put("COLUMN_ACTIVITY", exercise.getActivity());
        cv.put("COLUMN_WEIGHT", exercise.getWeight());
        cv.put("COLUMN_SETS", exercise.getSet());
        cv.put("COLUMN_REPS", exercise.getReps());
        cv.put("COLUMN_DATE", exercise.getDate());

        return cv;
    }
}

