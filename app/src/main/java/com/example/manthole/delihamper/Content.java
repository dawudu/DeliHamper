package com.example.manthole.delihamper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Content extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView hamperA, hamperB, hamperC, hamperD, hamperE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        hamperA = (ImageView) findViewById(R.id.hamperA);
        hamperB = (ImageView) findViewById(R.id.hamperB);
        hamperC = (ImageView) findViewById(R.id.hamperC);
        hamperD = (ImageView) findViewById(R.id.hamperD);
        hamperE = (ImageView) findViewById(R.id.hamperE);

        hamperA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent packageA = new Intent(getApplicationContext(), HamperA.class);
                startActivity(packageA);

            }
        });

        hamperB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent packageB = new Intent(getApplicationContext(), HamperB.class);
                startActivity(packageB);


            }
        });

        hamperC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent packageC = new Intent(getApplicationContext(), HamperC.class);
                startActivity(packageC);

            }
        });

        hamperD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent packageD = new Intent(getApplicationContext(), HamperD.class);
                startActivity(packageD);

            }
        });

        hamperE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent packageE = new Intent(getApplicationContext(), HamperE.class);
                startActivity(packageE);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_healthbenefits) {

            Intent intent = new Intent(getApplicationContext(), HealthBenefits.class);
            startActivity(intent);

        } else if (id == R.id.nav_cart) {


        } else if (id == R.id.nav_orders) {

        } else if (id == R.id.nav_log_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
