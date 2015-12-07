package istvan_torok.agenda.DB;

import android.provider.BaseColumns;

/**
 * Created by Isti on 12/7/2015.
 */
public final class DbMapper {

    public DbMapper(){}

    public static abstract class Event implements BaseColumns {
        public static final String TABLE_NAME = "events";
        public static final String COLUMN_NAME_EVENT_ID = "entry_id";
        public static final String COLUMN_NAME_EVENT_DESCRIPTION = "description";
        public static final String COLUMN_NAME_EVENT_DATETIME = "date";
    }

}
