package com.example.riderlog;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
//import android.support.v7.widget.Toolbar;



public class Main2Activity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager myViewPager;
    private TabLayout myTabLayout;
    private TabsAcessAdapter myTabsAcessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        //setSupportActionBar(mToolbar);
        //getSupportActionBar().setTitle("RiderAPP");

        myViewPager = (ViewPager) findViewById(R.id.main_tabs_pager);
        myTabsAcessAdapter = new TabsAcessAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myTabsAcessAdapter);

        myTabLayout = (TabLayout) findViewById(R.id.main_tabs);
        myTabLayout.setupWithViewPager(myViewPager);


    }

    private void sendToStart(){

        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.menu_orders_page, menu);
        //  return true;

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //---   int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //---   if (id == R.id.action_settings) {
        //        return true;
        //  }

        //return super.onOptionsItemSelected(item);


        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.main_logout_button){

            FirebaseAuth.getInstance().signOut();
            sendToStart();
        }

        return true;

    }


}
