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
        text.setFocusable(true);
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
            Intent intent = new Intent(getApplicationContext(), search_histories.class);
            startActivity(intent);
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "NOTHING",
//                    Toast.LENGTH_SHORT);
//            toast.show();

            return true;

        }
     if (id==R.id.filter)
       {
           Toast toast = Toast.makeText(getApplicationContext(),
                   "Filter/Sort",
                   Toast.LENGTH_SHORT);
           toast.show();
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

                break;

            case R.id.button2:
                Fragment fragment2 = null;
                Class fragmentClass2 = null;
                fragmentClass2 =topoffer_2.class;
                try {
                    fragment2 = (Fragment) fragmentClass2.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager2 = getSupportFragmentManager();
                fragmentManager2.beginTransaction().replace(R.id.frame_layout, fragment2).commit();
                break;

            case R.id.button3:

                Fragment fragment3 = null;
                Class fragmentClass3 = null;
                fragmentClass3 =mobile_3.class;
                try {
                    fragment3 = (Fragment) fragmentClass3.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager3 = getSupportFragmentManager();
                fragmentManager3.beginTransaction().replace(R.id.frame_layout, fragment3).commit();
                break;

            case R.id.button4:
                Fragment fragment4 = null;
                Class fragmentClass4 = null;
                fragmentClass4 =electronics_4.class;
                try {
                    fragment4 = (Fragment) fragmentClass4.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager4 = getSupportFragmentManager();
                fragmentManager4.beginTransaction().replace(R.id.frame_layout, fragment4).commit();

                break;
            case R.id.button5:
                Fragment fragment5 = null;
                Class fragmentClass5 = null;
                fragmentClass5 =beauty_5.class;
                try {
                    fragment5 = (Fragment) fragmentClass5.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager5 = getSupportFragmentManager();
                fragmentManager5.beginTransaction().replace(R.id.frame_layout, fragment5).commit();

                break;

            case R.id.button6:
                Fragment fragment6 = null;
                Class fragmentClass6 = null;
                fragmentClass6 =fashion_6.class;
                try {
                    fragment6 = (Fragment) fragmentClass6.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager6 = getSupportFragmentManager();
                fragmentManager6.beginTransaction().replace(R.id.frame_layout, fragment6).commit();

                break;

            case R.id.button7:

                Fragment fragment7 = null;
                Class fragmentClass7 = null;
                fragmentClass7 =homeappliances_7.class;
                try {
                    fragment7 = (Fragment) fragmentClass7.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager7 = getSupportFragmentManager();
                fragmentManager7.beginTransaction().replace(R.id.frame_layout, fragment7).commit();
                break;

            case R.id.button8:
                Fragment fragment8 = null;
                Class fragmentClass8 = null;
                fragmentClass8 =toysbaby_8.class;
                try {
                    fragment8 = (Fragment) fragmentClass8.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager8 = getSupportFragmentManager();
                fragmentManager8.beginTransaction().replace(R.id.frame_layout, fragment8).commit();

                break;

            case R.id.button9:
                Fragment fragment9 = null;
                Class fragmentClass9= null;
                fragmentClass9 =sports_9.class;
                try {
                    fragment9 = (Fragment) fragmentClass9.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FragmentManager fragmentManager9 = getSupportFragmentManager();
                fragmentManager9.beginTransaction().replace(R.id.frame_layout, fragment9).commit();


                break;
            default:
                break;

        }
    }
}