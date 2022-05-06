package com.example.textbasedstorygame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Create the main page using the activity_main XML markup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        //Colour the status bar to match the background
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.dark_slate_green));
        }
    }

    //When the play button is pressed, go to the main activity
    public void playButtonClickHandler(View view){
        Intent playGame = new Intent(StartScreen.this, MainActivity.class);
        startActivity(playGame);
    }

    //When the about button is pressed, go to the about screen activity
    public void aboutButtonClickHandler(View view){
        Intent playGame = new Intent(StartScreen.this, AboutScreen.class);
        startActivity(playGame);
    }

    //When nav bar back button is pressed, quit the app
    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}