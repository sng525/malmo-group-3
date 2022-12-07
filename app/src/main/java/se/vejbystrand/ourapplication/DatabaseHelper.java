package se.vejbystrand.ourapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String COLUMN_ID = "ID";
    public static final String WORKOUTS_TABLE = "WORKOUTS_TABLE";
    public static final String COLUMN_ACTIVITY ="COLUMN_ACTIVITY";
    public static final String COLUMN_WEIGHT="COLUMN_WEIGHT";
    public static final String COLUMN_SETS = "COLUMN_SETS";
    public static final String COLUMN_REPS = "COLUMN_REPS";
    public static final String COLUMN_DATE = "COLUMN_DATE";



    //CONSTRUCTOR
    public DatabaseHelper(@Nullable Context context) {
        super(context, "workOuts.db", null, 1 );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + WORKOUTS_TABLE + " (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ACTIVITY + " TEXT, " + COLUMN_WEIGHT + " INT, " + COLUMN_SETS
                + " INT, " + COLUMN_REPS + " INT, " + COLUMN_DATE + " TEXT)";

                db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addWorkout(Exercise exercise) {

        //REFERS TO THE DATABASE CREATED
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ACTIVITY, Exercise.getActivity());
        cv.put(COLUMN_WEIGHT, Exercise.getWeight());
        cv.put(COLUMN_SETS, Exercise.getSet());
        cv.put(COLUMN_REPS, Exercise.getReps());
        cv.put(COLUMN_DATE, Exercise.getDate());
        
        return true;
    }
}
