package se.vejbystrand.ourapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COLUMN_ID = "id";
    public static final String WORKOUTS_TABLE = "WORKOUTS_TABLE";
    public static final String COLUMN_ACTIVITY = "COLUMN_ACTIVITY";
    public static final String COLUMN_WEIGHT = "COLUMN_WEIGHT";
    public static final String COLUMN_SETS = "COLUMN_SETS";
    public static final String COLUMN_REPS = "COLUMN_REPS";
    public static final String COLUMN_DATE = "COLUMN_DATE";

    private static DatabaseHelper instance = null;

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context.getApplicationContext());
        return instance;
    }

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
    public void onUpgrade(SQLiteDatabase db, int oldVers, int newVers) {
        db.execSQL("DROP TABLE IF EXISTS " + WORKOUTS_TABLE);
        onCreate(db);
    }
}
