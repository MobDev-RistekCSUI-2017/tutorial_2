package id.prihantoro.tutorial2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wahyu on 09 Maret 2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tutorial_2_database";
    private static final String USER_TABLE = "user_database";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + USER_TABLE + " (ID INT PRIMARY KEY NOT NULL, " +
            "USERNAME TEXT NOT NULL," +
            "EMAIL TEXT NOT NULL," +
            "PASSWORD TEXT NOT NULL)";

    private static Database database;

    private Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static Database getInstance(Context context) {
        if (database == null) {
            database = new Database(context);
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", user.getId());
        contentValues.put("username", user.getUsername());
        contentValues.put("email", user.getEmail());
        contentValues.put("password", user.getPassword());
        db.insert(USER_TABLE, null, contentValues);
        Log.d("wahyu", user.getUsername());
    }

    public User getUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE ID = " + id, null);
        cursor.moveToFirst();
        String username = cursor.getString(1);
        String email = cursor.getString(2);
        String password = cursor.getString(3);
        return new User(id, username, email, password);
    }
}
