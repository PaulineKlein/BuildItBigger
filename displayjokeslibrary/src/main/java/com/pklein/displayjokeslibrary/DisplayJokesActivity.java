package com.pklein.displayjokeslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    private String mJokeText;
    private TextView mtv_joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        Intent intentThatStarted = this.getIntent();

        if (intentThatStarted.hasExtra("joke")) {
            mJokeText = intentThatStarted.getStringExtra("joke");
            mtv_joke = (TextView) findViewById(R.id.tv_joke);
            mtv_joke.setText(mJokeText);
        }
    }
}
