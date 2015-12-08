package istvan_torok.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import istvan_torok.agenda.DB.EventsDAL;
import istvan_torok.agenda.ListClasses.EventsAdapter;

public class ListActivity extends AppCompatActivity {

    @Bind(R.id.eventList) RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private EventsAdapter mAdapter;
    private EventsDAL mEventsDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lIntent = new Intent(getBaseContext(), AddEventActivity.class);
                startActivity(lIntent);
            }
        });

        setUpRecycler();
        mEventsDAL = new EventsDAL(this);
        mAdapter.setItems(mEventsDAL.readAll());
    }

    private void setUpRecycler() {
        mAdapter = new EventsAdapter(this);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //setUpSwipeToDismiss();
    }




}
