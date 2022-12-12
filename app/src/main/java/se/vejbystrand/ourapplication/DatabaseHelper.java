package se.vejbystrand.ourapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String COLUMN_ID = "ID";
    public static final String WORKOUTS_TABLE = "WORKOUTS_TABLE";
    public static final String COLUMN_ACTIVITY = "COLUMN_ACTIVITY";
    public static final String COLUMN_WEIGHT = "COLUMN_WEIGHT";
    public static final String COLUMN_SETS = "COLUMN_SETS";
    public static final String COLUMN_REPS = "COLUMN_REPS";
    public static final String COLUMN_DATE = "COLUMN_DATE";

    private static DatabaseHelper instance = null;
    public static DatabaseHelper getInstance(Context context){
        if (instance == null)
            instance = new DatabaseHelper(context.getApplicationContext());
        return instance;
    }

    //CONSTRUCTOR
    public DatabaseHelper(@Nullable Context context) {
        super(context, "workOuts.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + WORKOUTS_TABLE + " (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ACTIVITY + " TEXT," + COLUMN_WEIGHT + " INTEGER," + COLUMN_SETS
                + " INTEGER," + COLUMN_REPS + " INTEGER," + COLUMN_DATE + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVers, int newvers) {
        db.execSQL("DROP TABLE IF EXISTS " + WORKOUTS_TABLE);
        onCreate(db);
    }

    public boolean addWorkout(Exercise exercise) {

        //REFERS TO THE DATABASE CREATED
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ACTIVITY, exercise.getActivity());
        cv.put(COLUMN_WEIGHT, exercise.getWeight());
        cv.put(COLUMN_SETS, exercise.getSet());
        cv.put(COLUMN_REPS, exercise.getReps());
        cv.put(COLUMN_DATE, exercise.getDate());

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

        String queryString = "SELECT * FROM " + WORKOUTS_TABLE;
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
                returnList.add(newWorkout);

            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();

        return returnList;
    }

    public void save(Exercise exercise) {
        if(exercise.getId() == 0)   // if the id is 0, the book does not exist
            insertWorkOut(exercise);   // therefore insert it
    }

    private void insertWorkOut(Exercise exercise){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = getContentValues(exercise);
        db.insert(WORKOUTS_TABLE, null, c);
    }

    private ContentValues getContentValues(Exercise exercise) {
        // Creates the column-value pairs given a book
        ContentValues c = new ContentValues();

        c.put(COLUMN_ACTIVITY, exercise.getActivity());
        c.put(COLUMN_WEIGHT, exercise.getWeight());
        c.put(COLUMN_SETS, exercise.getSet());
        c.put(COLUMN_REPS, exercise.getReps());
        c.put(COLUMN_DATE, exercise.getDate());

        return c;
    }
}