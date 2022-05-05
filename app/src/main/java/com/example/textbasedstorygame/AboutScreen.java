package com.example.textbasedstorygame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


public class AboutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Create the main page using the activity_main XML markup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_screen);

        //Include a back button in the title bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Colour the status bar to match the background
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.cadet_blue));
        }
    }


    //When top back button is pressed, go back to the main menu
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent endGame = new Intent(getApplicationContext(), StartScreen.class);
        startActivity(endGame);
        return true;
    }

    //When nav bar back button is pressed, go back to the main menu
    public void onBackPressed() {
        Intent endGame = new Intent(getApplicationContext(), StartScreen.class);
        startActivity(endGame);
    }
}