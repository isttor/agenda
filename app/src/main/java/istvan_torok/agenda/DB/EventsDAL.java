package istvan_torok.agenda.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import istvan_torok.agenda.Entities.Event;

/**
 * Created by Isti on 12/7/2015.
 */
public class EventsDAL {

    private static final String TAG = "DAL";

    private final EventDbHelper dbHelper;

    public EventsDAL(final Context pContext) {
        dbHelper = new EventDbHelper(pContext);
    }

    public long insertEvent(final Event pEvent) {

        long lNewRowID;
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues lValues = new ContentValues();
        lValues.put(DbMapper.Event.COLUMN_NAME_EVENT_DESCRIPTION, pEvent.getDescription());
        lValues.put(DbMapper.Event.COLUMN_NAME_EVENT_DATETIME, pEvent.getDate());

        lNewRowID = db.insert(
            DbMapper.Event.TABLE_NAME,
            null,
            lValues
        );
        Log.d(TAG, "Inserted event: " + pEvent);

        return lNewRowID;
    }

    public long deleteEventById(Long id) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        return db.delete(
                DbMapper.Event.TABLE_NAME,
                DbMapper.Event._ID + " = ?",
                new String[]{id.toString()}
        );
    }

}
