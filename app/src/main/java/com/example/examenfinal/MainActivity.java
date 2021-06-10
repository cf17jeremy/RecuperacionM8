package com.example.examenfinal;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private BDDCreation BDCreation;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigation = findViewById(R.id.nav_view);

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.logo, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            BDCreation = new BDDCreation(getApplicationContext());
            db = BDCreation.getWritableDatabase();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openFragment(Home.newInstance());
                    return true;
                case R.id.navigation_search:
                    openFragment(Maps.newInstance("a", "b"));
                    BDCreation.close();
                    db.close();
                    return true;
                case R.id.navigation_myplaces:
                    openFragment(Myplaces.newInstance());
                    return true;
            }
            return false;
        }
    };

}