package com.ezads;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class search_histories extends AppCompatActivity {
    private Context mContext;
    List<Search> searchList;
    RecyclerView recyclerView;
    RelativeLayout mRelativeLayout;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_histories);
        mContext = getApplicationContext();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.previous);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);
            }
        });

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchList = new ArrayList<>();

        searchList.add(
                new Search(
                        "Mobile"
                ));
        searchList.add(
                new Search(
                        "Bio Oil"
                ));
        searchList.add(
                new Search(
                        "T Shirt"
                ));
        searchList.add(
                new Search(
                        "calculator"
                ));

        searchList.add(
                new Search(
                        "vivo v11"
                ));
        searchList.add(
                new Search(
                        "Pen drive"
                ));
        searchList.add(
                new Search(
                        "Redmi note"
                ));




        mLayoutManager = new GridLayoutManager(mContext,3);
        recyclerView.setLayoutManager(mLayoutManager);

        SearchAdapter adapter = new SearchAdapter(this, searchList);


        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_history, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_search) {


            return true;

        }
        if (id==R.id.filter)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Filter/Sort",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }


}
