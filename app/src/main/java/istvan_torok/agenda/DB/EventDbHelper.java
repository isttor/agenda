package istvan_torok.agenda.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Isti on 12/7/2015.
 */
public class EventDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Events.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " NUMBER";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DbMapper.Event.TABLE_NAME + " (" +
                    DbMapper.Event._ID + " INTEGER PRIMARY KEY," +
                    DbMapper.Event.COLUMN_NAME_EVENT_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    DbMapper.Event.COLUMN_NAME_EVENT_DATETIME + NUMBER_TYPE +
                    " )";

    public EventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DbMapper.Event.TABLE_NAME;

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
