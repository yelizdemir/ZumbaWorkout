package com.yelizdemir93.zumbaworkoutapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gotoFragment(new FragAnaMenu(), false);
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
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
*/
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
    private void displaySelectedScreen(int id){
        Fragment fragment=null;
        switch (id){

            case R.id.nav_pedometer:
                fragment=new PedometerPage();
                break;
            case R.id.nav_bmi:
            fragment=new BMIPage();
            break;
            case R.id.nav_basal:
                fragment=new BasalPage();
                break;
            case R.id.nav_ideal:
                fragment=new IdealPage();
                break;
            case R.id.nav_kcal:
                fragment=new KaloriPage();
                break;
            case R.id.nav_settings:
                fragment=new SettingPage();
                break;
            case R.id.nav_zumba:
                fragment=new ZumbaPage();
                break;
        }
        if (fragment != null)
        {
            gotoFragment(fragment, false);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);
        return true;
    }

    public void gotoFragment(Fragment f, boolean addToBackStack)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();//frahment manager nesnesi elde ederiz.
        ft.replace(R.id.content_frame, f); // yer değiştirme
        if(addToBackStack)
            ft.addToBackStack("Frag"+Math.random()); //Kullanıcının Fragment işlemleri arasında geriye dönebilmesini sağlamak için.
        ft.commit(); // tüm değişiklikleri kullanıcıya göstermek için replace methodu.

    }


}
