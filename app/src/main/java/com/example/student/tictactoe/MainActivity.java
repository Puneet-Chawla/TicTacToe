package com.example.student.tictactoe;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
//import android.app.AlertDialog;
public class MainActivity extends AppCompatActivity {
    MediaPlayer mySound;

    boolean gameOver = false;
    int activePlayer = 0;                                     // 0 is for zero
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};            // 2 means unplayed
    int[][] winningLocations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    String msg = "";

    public void gameLogic(View view) {
        ImageView tappedView = (ImageView) view;
        int tappedLocation = Integer.parseInt(tappedView.getTag().toString());
        if (gameState[tappedLocation] == 2 && gameOver == false) {
            gameState[tappedLocation] = activePlayer;
            tappedView.setTranslationY(-3000f);  //removing the image view from screen initially
            if (activePlayer == 0) {
                tappedView.setImageResource(R.drawable.zero);  //setting image source
                activePlayer = 1;
            } else {
                tappedView.setImageResource(R.drawable.x);
                activePlayer = 0;
            }
            tappedView.animate().translationYBy(3000f).setDuration(500);  //returning the image back to it's position


            for (int[] winningPosition : winningLocations) {
                if ((gameState[winningPosition[0]] == gameState[winningPosition[1]])
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]] && (gameState[winningPosition[0]] != 2)) {
                    if (activePlayer == 0) {
                        msg = "X is winner";
                    }
                    if (activePlayer == 1) {
                        //      Toast.makeText(getApplicationContext(), "zero is winner", Toast.LENGTH_LONG).show();
                        msg = "zero is winner";
                    }


                }
                }
            }
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mySound = MediaPlayer.create(this, R.raw.ajstyles);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        mySound.start();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mySound.release();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.board);
        builder.setMessage("do u want to leave?");
        builder.setTitle("Tic-Tac-Toe");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mySound.start();
    }

  /* public void PlayAgain(View view)
    {
        LinearLayout winnerLayout=(LinearLayout)findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);
        gameOver=false;
        activePlayer=0;
        int d;
        for(d=0;d<gameState.length;d++)
        {
            gameState[d]=2;
            GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
            for(int q=0;q<gridLayout.getChildCount();q++)
            {
                ((ImageView)gridLayout.getChildAt(q)).setImageResource(R.drawable.white);
            }
        }
    }*/
}