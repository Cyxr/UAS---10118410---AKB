//11 Agustus 2021, 10118410, Ridwan Caesarahman Julian, IF-10
package com.ridwancaesarahmanjulian.uas10118410;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    profile_frag fragprofile;
    travel_frag fragtravel;
    map_frag fragmap;

    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        setupViewPager(viewPager);


        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.travel:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.map:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.profile:
                        viewPager.setCurrentItem(2);
                        break;

                }
                return false;
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapt adapter = new ViewPagerAdapt(getSupportFragmentManager());
        fragtravel = new travel_frag();
        fragmap = new map_frag();
        fragprofile = new profile_frag();

        adapter.addFragment(fragtravel);
        adapter.addFragment(fragmap);
        adapter.addFragment(fragprofile);
        viewPager.setAdapter(adapter);
    }
}