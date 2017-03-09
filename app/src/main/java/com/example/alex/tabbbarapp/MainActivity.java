package com.example.alex.tabbbarapp;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    //Hay que importar esto para poder usar los tabbar compile 'com.android.support:design:25.2.0'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscamos el viewPager y lo conectamos a nuestro adapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        //viewPager.setAdapter(new SampleFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this));

        SampleFragmentPageAdapter pageAdapter = new SampleFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(pageAdapter);

        //TabLayout le pasamos el ViewPager
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Iterar por cada uno de los Tabs y establecer nuesta view customizada

        for(int i = 0; i < tabLayout.getTabCount(); i++){

            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pageAdapter.getTabView(i));

        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            //Aqui detectas si se ha cambiaod de tab
            public void onTabSelected(TabLayout.Tab tab) {
                if (tabLayout.getSelectedTabPosition() == 0)
                    tabLayout.setTabTextColors(Color.BLUE, Color.WHITE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
