package istvan_torok.agenda;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.Calendar;
import java.util.GregorianCalendar;

import Controls.CustomDatePicker;
import butterknife.Bind;
import butterknife.ButterKnife;
import istvan_torok.agenda.DB.EventsDAL;
import istvan_torok.agenda.Entities.Event;

public class AddEventActivity extends AppCompatActivity {

    private static final String TAG = "AddEventActivity";
    private EventsDAL mDAL;

    @Bind(R.id.txtEventDescription) EditText txtDescription;
    @Bind(R.id.datePicker) DatePicker dtpDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        ButterKnife.bind(this);
        setTitle("Add");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDAL = new EventsDAL(this);
    }

    @Override
    public boolean onSupportNavigateUp(){
        String lDescription = txtDescription.getText().toString();
        Integer lYear = dtpDate.getYear();
        Integer lMonth = dtpDate.getMonth();
        Integer lDay = dtpDate.getDayOfMonth();

        Calendar lCalendar = new GregorianCalendar(lYear, lMonth, lDay);

        if (lDescription.equals("") == false)
        {
            Event lEvent = new Event(lDescription, lCalendar.getTimeInMillis());
            try {
                mDAL.insertEvent(lEvent);
            }
            catch(Exception ex) {
                Log.d(TAG, "Exception while adding new event!");
            }
        }

        finish();
        return true;
    }


}
