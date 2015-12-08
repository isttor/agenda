package istvan_torok.agenda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import istvan_torok.agenda.DB.EventsDAL;
import istvan_torok.agenda.ListClasses.EventsAdapter;

public class ListActivity extends AppCompatActivity {

    @Bind(R.id.eventList) RecyclerView mRecyclerView;
    @Bind(R.id.txtSearch) EditText mSearchText;
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

        mSearchText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                mAdapter.setItems(mEventsDAL.readAll(s.toString()));
            }
        });

    }

    private void setUpRecycler() {
        mAdapter = new EventsAdapter(this);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //setUpSwipeToDismiss();
    }




}
