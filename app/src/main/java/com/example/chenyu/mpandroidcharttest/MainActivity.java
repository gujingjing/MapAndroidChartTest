package com.example.chenyu.mpandroidcharttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        BarCharFragment barCharFragment = new BarCharFragment();
        transaction.replace(R.id.content, barCharFragment);
        transaction.commit();
        //显示右上角的3个点
        makeActionOverflowMenuShown();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        int id = item.getItemId();
        switch (id) {
            case R.id.BarChart:
                BarCharFragment barCharFragment = new BarCharFragment();
                transaction.replace(R.id.content, barCharFragment);
                transaction.commit();
                return true;
            case R.id.LineChart:
                LineCharFragment lineCharFragment = new LineCharFragment();
                transaction.replace(R.id.content, lineCharFragment);
                transaction.commit();
                return true;
            case R.id.RadarChart:
                RadarCharFragment radarCharFragment = new RadarCharFragment();
                transaction.replace(R.id.content, radarCharFragment);
                transaction.commit();
                return true;
            case R.id.PieChart:
                PieCharFragment pieCharFragment = new PieCharFragment();
                transaction.replace(R.id.content, pieCharFragment);
                transaction.commit();
                return true;
            case R.id.ScatterChart:
                ScatterChartFragment scatterChartFragment = new ScatterChartFragment();
                transaction.replace(R.id.content, scatterChartFragment);
                transaction.commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void makeActionOverflowMenuShown() {
        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
        }
    }
}
