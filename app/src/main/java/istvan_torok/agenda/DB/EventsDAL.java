package istvan_torok.agenda.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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

    public List<Event> readAll() {
        return readAll(null);
    }


    public List<Event> readAll(String pFilter) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DbMapper.Event._ID,
                DbMapper.Event.COLUMN_NAME_EVENT_DESCRIPTION,
                DbMapper.Event.COLUMN_NAME_EVENT_DATETIME,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                DbMapper.Event.COLUMN_NAME_EVENT_DATETIME + " DESC";

        Cursor cursor = db.query(
                DbMapper.Event.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                "",                                       // The columns for the WHERE clause
                new String[] {},                          // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        final List<Event> result = new ArrayList<>();

        while(cursor.moveToNext()) {
            final String lDescription = cursor.getString(
                    cursor.getColumnIndexOrThrow(DbMapper.Event.COLUMN_NAME_EVENT_DESCRIPTION)
            );
            if (pFilter != null && lDescription.toUpperCase().contains(pFilter.toUpperCase()) == false) {
                continue;
            }
            final long lDate = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DbMapper.Event.COLUMN_NAME_EVENT_DATETIME)
            );
            final long lID = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DbMapper.Event._ID)
            );

            final Event lEvent = new Event(lID, lDescription, lDate);
            result.add(lEvent);

            Log.d(TAG, "Read person: " + lEvent);
        }

        return result;
    }

}
