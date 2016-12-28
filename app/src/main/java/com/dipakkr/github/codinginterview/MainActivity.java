package com.dipakkr.github.codinginterview;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mdrawerLayout;
    private NavigationView mNavigation;
    private ActionBarDrawerToggle mdrawerToggle;
    private Toolbar toolbar;
    private final String FRAGMENT_TAG_HOME = "Home";
    private boolean backpressedonce = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mdrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mNavigation = (NavigationView)findViewById(R.id.nvView);
        setupDrawerContent(mNavigation);
        mdrawerToggle = setupDrawerToggle();
        mdrawerLayout.addDrawerListener(mdrawerToggle);

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_content, new FirstFragment());
        tx.commit();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mdrawerLayout, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }
    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new
                        NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }
    private void selectDrawerItem(MenuItem menuItem){
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.nav_time_complexity :
                fragmentClass = FirstFragment.class;
                break;
            case R.id.nav_algo :
                fragmentClass = SingleLinkedListFragment.class;
                break;
            case R.id.nav_share:
                 shareapp();
            default:
                fragmentClass = ArrayFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager =getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_content,fragment).commit();

        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mdrawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment homefragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG_HOME);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mdrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mdrawerLayout.closeDrawer(GravityCompat.START);
        } else if (homefragment != null && homefragment.isVisible()) {
            if (backpressedonce) {
                finish();
            }
            if (!backpressedonce) {
                Toast.makeText(this, "Tap once more to exit", Toast.LENGTH_SHORT).show();
            }
            backpressedonce = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backpressedonce = false;
                }
            }, 2000);
        }else {
            fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.list_array, new ArrayFragment(), FRAGMENT_TAG_HOME).commit();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }
        mNavigation.setCheckedItem(R.id.nav_time_complexity);
    }
  }

    private void shareapp(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mdrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mdrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mdrawerToggle.syncState();
    }
}
