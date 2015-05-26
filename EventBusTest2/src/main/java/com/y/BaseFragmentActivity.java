package com.y;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;

import com.y.util.AppUtils;

public class BaseFragmentActivity extends FragmentActivity {
    protected Context context;

    protected void onCreate(Bundle savedInstanceState, int layoutResID) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResID);

        context = getApplicationContext();
        AppUtils.initActionBar(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
        }
        return false;
    }
}
