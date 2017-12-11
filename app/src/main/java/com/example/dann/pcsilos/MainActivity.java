package com.example.dann.pcsilos;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.race604.drawable.wave.WaveDrawable;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import static android.graphics.Color.BLUE;



public class MainActivity extends AppCompatActivity
         implements MenuResumen.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener,
        MenuConfiguration.OnFragmentInteractionListener, MenuConsumo.OnFragmentInteractionListener,
        MenuPeso.OnFragmentInteractionListener, MenuReport.OnFragmentInteractionListener,
        MenuTiempoReal.OnFragmentInteractionListener, DatePickerDialog.OnDateSetListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


// Use as common drawable

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        WaveDrawable chromeWave = new WaveDrawable(this, R.drawable.silo_estado);
        imageView2.setImageDrawable(chromeWave);
        chromeWave.setIndeterminate(true);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
        }else if (id == R.id.date){
            /*************************DATE PICKER - FECHA ****************************************/
            Calendar now = Calendar.getInstance();
            DatePickerDialog dpd = DatePickerDialog.newInstance(
                    MainActivity.this,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );
            dpd.show(getFragmentManager(), "Datepickerdialog");
            dpd.setVersion(DatePickerDialog.Version.VERSION_2);
            /**************************FIN DATEPICKER - FECHA***************************************/
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Boolean fragmentSelected = false;

        if(id ==R.id.nav_resumen){
            fragment = new MenuResumen();
            fragmentSelected = true;
        }else if (id == R.id.nav_tiempo_real) {
            fragment = new MenuTiempoReal();
            fragmentSelected = true;
        } else if (id == R.id.nav_consumo) {
            fragment = new MenuConsumo();
            fragmentSelected = true;
        } else if (id == R.id.nav_peso) {
            fragment = new MenuPeso();
            fragmentSelected = true;
        } else if (id == R.id.nav_report) {
            fragment = new MenuReport();
            fragmentSelected = true;
        } else if (id == R.id.nav_config) {
            fragment = new MenuConfiguration();
            fragmentSelected = true;
        }

        if(fragmentSelected){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenMain, fragment).commit();



        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //Metodo por implementar OnDatePciker
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

    }


}

