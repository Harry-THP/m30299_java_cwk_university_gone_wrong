package com.example.textbasedstorygame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Server server;
    Node currentNode;
    int nextNodeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Create the main page using the activity_main XML markup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //Link to the data.csv file
        Resources res = getResources();
        InputStream filePath = res.openRawResource(R.raw.data);

        //Create server object
        try { server = new Server(filePath); }
        catch (FileNotFoundException e) { }

        //Set start node to nodeID 1 and put it's contents into the buttons / text field
        currentNode = server.getNode(1);
        currentNode.setNewValues(currentNode, this);
    }


    //Creates an alert box asking the user to confirm ending the game when they hit either of the back buttons
    public void quitAlertBox() {
        AlertDialog.Builder quitGame = new AlertDialog.Builder(this);
        quitGame.setTitle("End Game");
        quitGame.setMessage("Are you sure you want to end this game?");

        quitGame.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent endGame = new Intent(getApplicationContext(), StartScreen.class);
                startActivity(endGame);
            }
        });

        quitGame.setPositiveButton("Continue Playing", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        quitGame.show();
    }


    //When top back button is pressed, show a dialogue asking the user to confirm ending the game
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        quitAlertBox();
        return true;
    }


    //When nav bar back button is pressed, show a dialogue asking the user to confirm ending the game
    @Override
    public void onBackPressed() {
        quitAlertBox();
    }


    //When buttonOne is clicked, get the node id that option one points to, load that Node in as currentNode and display it's contents on the buttons and text field
    public void buttonOneClickHandler(View view){
        nextNodeID = currentNode.getDecisionOneID();
        currentNode = server.getNode(nextNodeID);
        currentNode.setNewValues(currentNode, this);
    }


    //When buttonTwo is clicked, get the node id that option two points to, load that Node in as currentNode and display it's contents on the buttons and text field
    public void buttonTwoClickHandler(View view){
        nextNodeID = currentNode.getDecisionTwoID();
        currentNode = server.getNode(nextNodeID);
        currentNode.setNewValues(currentNode, this);
    }
}