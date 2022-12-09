package se.vejbystrand.ourapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String COLUMN_ID = "ID";
    public static final String WORKOUTS_TABLE = "WORKOUTS_TABLE";
    public static final String COLUMN_ACTIVITY = "COLUMN_ACTIVITY";
    public static final String COLUMN_WEIGHT = "COLUMN_WEIGHT";
    public static final String COLUMN_SETS = "COLUMN_SETS";
    public static final String COLUMN_REPS = "COLUMN_REPS";
    public static final String COLUMN_DATE = "COLUMN_DATE";


    //CONSTRUCTOR
    public DatabaseHelper(@Nullable Context context) {
        super(context, "workOuts.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + WORKOUTS_TABLE + " (" + COLUMN_ID
                + " STRING PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ACTIVITY + " TEXT, " + COLUMN_WEIGHT + " STRING, " + COLUMN_SETS
                + " STRING, " + COLUMN_REPS + " STRING, " + COLUMN_DATE + " TEXT)";

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

        long insert = db.insert(WORKOUTS_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

//CREATE METHODS TO PULL ALL ITEMS OUT OF THE DATABASE

//DEFINE THE PROPERTIES THAT WE WANT THE LIST TO RETURN

    public ArrayList<Exercise> selectAll() {
        ArrayList<Exercise> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM WORKOUTS_TABLE" + WORKOUTS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);                   //EXECUTES QUERY

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String activity = cursor.getString(1);
                int weights = cursor.getInt(2);
                int sets = cursor.getInt(3);
                int reps = cursor.getInt(4);
                String date = cursor.getString(5);

                Exercise newWorkout = new Exercise(id, activity, weights, sets, reps, date);


            } while (cursor.moveToFirst());

            cursor.close();
        }
        return returnList;
    }
}