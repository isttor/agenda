package istvan_torok.agenda;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import istvan_torok.agenda.Entities.Event;

public class AddEventActivity extends AppCompatActivity {

    @Bind(R.id.txtEventDescription) EditText txtDescription;
    @Bind(R.id.datePicker) DatePicker dtpDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        ButterKnife.bind(this);
        setTitle("Add");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        String lDescription = txtDescription.getText().toString();
        if (lDescription.equals("")) {
            txtDescription.setError("Please enter event infos!");
            return false;
        }
        //TODO SAVE EVENT HERE!!

        finish();
        return true;
    }
}
