package com.alan.rockonapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alan.rockonapp.R;

/**
 * @author alan
 */
public class ConcertsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concerts);
        setTitle(R.string.title);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
