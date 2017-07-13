package com.example.qin.a5_17;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Qin on 7/13/2017.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (NavUtils.getParentActivityName(DetailActivity.this) != null) {
           DetailActivity.this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (NavUtils.getParentActivityName(DetailActivity.this) != null) {
                NavUtils.navigateUpFromSameTask(DetailActivity.this);
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
