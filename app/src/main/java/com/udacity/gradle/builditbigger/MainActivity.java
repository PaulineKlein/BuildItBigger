package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.pklein.displayjokeslibrary.DisplayJokesActivity;


public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "joke";
    private ProgressBar mLoadingIndicator;

    // Only called FROM Tests : null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadingIndicator=findViewById(R.id.loading_indicator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        showLoadingIndicator(true);
        new BackendAsyncTask(new FetchMyDataTaskCompleteListener()).execute();

        //Joker mJoker = new Joker();
        //STEP 1. Toast.makeText(this, mJoker.getJoke(), Toast.LENGTH_SHORT).show();
        //STEP 2. Intent myIntent = new Intent(this, DisplayJokesActivity.class);
        //STEP 2. myIntent.putExtra("joke", mJoker.getJoke());
        //STEP 2. startActivity(myIntent);
    }

    public class FetchMyDataTaskCompleteListener implements AsyncTaskCompleteListener<String>
    {
        @Override
        public void onTaskComplete(String myjoke)
        {
            showLoadingIndicator(false);
            if (myjoke != null) {
                Intent myIntent = new Intent(getApplicationContext(), DisplayJokesActivity.class);
                myIntent.putExtra(EXTRA_JOKE,myjoke);
                startActivity(myIntent);
            } else {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showLoadingIndicator(Boolean show){
        if(show){
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }else{
            mLoadingIndicator.setVisibility(View.INVISIBLE);
        }
    }


}
