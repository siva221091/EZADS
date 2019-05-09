package com.ezads;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ezads.Sqllite.DbAdapter;

import java.util.ArrayList;

public class menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,promotional_1.OnFragmentInteractionListener,View.OnClickListener {
Button button;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    AutoCompleteTextView text;
    DbAdapter helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text=(AutoCompleteTextView)findViewById(R.id.searchtext);
        helper = new DbAdapter(this);
        String[] col = {"Name"};
        Cursor cursor = helper.getWordMatches(text.getText().toString(),col);
        ArrayList<String> mArrayList = new ArrayList<String>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            mArrayList.add(cursor.getString(cursor.getColumnIndex("Name"))); //add the item
            cursor.moveToNext();
        }
        ArrayAdapter adapter = new
                ArrayAdapter(this,android.R.layout.simple_list_item_1 ,mArrayList);

        text.setAdapter(adapter);
        text.setThreshold(1);

        if (savedInstanceState == null) {
            Fragment fragment = null;
            Class fragmentClass = null;
            fragmentClass = promotional_1.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
        }

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(this);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerview = navigationView.getHeaderView(0);
        headerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);

            }
        });


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu_drawer, menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notification) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "NOTHING",
                    Toast.LENGTH_SHORT);
            toast.show();

            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    private void ShowFragment(int itemId) {

        Fragment fragment = null;
        switch (itemId) {
            case R.id.promotinaloffer:
                fragment = new promotional_1();
                break;
            case R.id.topoffer:
                fragment = new topoffer_2();
                break;
            case R.id.mobile:
                fragment = new mobile_3();
                break;
            case R.id.electronics:
                fragment = new electronics_4();
                break;
            case R.id.beauty:
                fragment = new beauty_5();
                break;
            case R.id.fashion:
                fragment = new fashion_6();
                break;
            case R.id.homeappliances:
                fragment = new homeappliances_7();
                break;
            case R.id.toysbaby:
                fragment = new toysbaby_8();
                break;
            case R.id.sports:
                fragment = new sports_9();
                break;

        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        ShowFragment(item.getItemId());
        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.promotinaloffer) {
//            Intent intent = new Intent(getApplicationContext(), menu.class);
//            startActivity(intent);
//
//        }
//       else if (id == R.id.topoffer) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "THIS PAGE NOT YET DESIGN",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        }
//        else if (id == R.id.mobile) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "THIS PAGE NOT YET DESIGN",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        } else if (id == R.id.electronics) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "THIS PAGE NOT YET DESIGN",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        } else if (id == R.id.beauty) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "THIS PAGE NOT YET DESIGN",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        } else if (id == R.id.fashion) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                "THIS PAGE NOT YET DESIGN",
//                Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        } else if (id == R.id.homeappliances) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "THIS PAGE NOT YET DESIGN",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        } else if (id == R.id.toysbaby){
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "THIS PAGE NOT YET DESIGN",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        }
//        else if (id == R.id.sports){
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "THIS PAGE NOT YET DESIGN",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.button1:

//                Intent intent = new Intent(getApplicationContext(), menu.class);
//                startActivity(intent);

                break;

            case R.id.button2:

                break;

            case R.id.button3:


                break;

            case R.id.button4:


                break;
            case R.id.button5:


                break;

            case R.id.button6:


                break;

            case R.id.button7:


                break;

            case R.id.button8:


                break;

            case R.id.button9:


                break;
            default:
                break;

        }
    }
}