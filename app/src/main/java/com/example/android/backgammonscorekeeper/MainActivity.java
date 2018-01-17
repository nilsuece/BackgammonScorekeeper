package com.example.android.backgammonscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    String winnerText = "";

    private static final String SCORE_PLAYER_1 = "scorePlayer1";
    private static final String SCORE_PLAYER_2 = "scorePlayer2";
    private static final String WINNER = "winnerText";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            scorePlayer1 = savedInstanceState.getInt(SCORE_PLAYER_1, 0);
            scorePlayer2 = savedInstanceState.getInt(SCORE_PLAYER_2, 0);
            winnerText = savedInstanceState.getString(WINNER, "");
        }
        displayForPlayer1(R.id.player_1_score, scorePlayer1);
        displayForPlayer2(R.id.player_2_score, scorePlayer2);
        TextView winnerView = (TextView) findViewById(R.id.winner_text);
        showWinner(winnerView);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // call the super method so that the states of our views are saved
        super.onSaveInstanceState(outState);
        // Save the app state
        outState.putInt(SCORE_PLAYER_1, scorePlayer1);
        outState.putInt(SCORE_PLAYER_2, scorePlayer2);
        outState.putString(WINNER, winnerText);
    }

    /**
     * Displays the given score for Player 1.
     */

    public void displayForPlayer1(int player_1_score, int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForPlayer1(View view) {
        scorePlayer1 = scorePlayer1 + 3;
        displayForPlayer1(R.id.player_1_score, scorePlayer1);
        showWinner(view);
    }

    public void addTwoForPlayer1(View view) {
        scorePlayer1 = scorePlayer1 + 2;
        displayForPlayer1(R.id.player_1_score, scorePlayer1);
        showWinner(view);
    }

    public void addOneForPlayer1(View view) {
        scorePlayer1 = scorePlayer1 + 1;
        displayForPlayer1(R.id.player_1_score, scorePlayer1);
        showWinner(view);
    }


    public void showWinner(View view) {
        if (scorePlayer1 >= 5) {
            TextView showWinner = (TextView) findViewById(R.id.winner_text);
            showWinner.setText("Player 1 Won!");
        }
        if (scorePlayer2 >= 5) {
            TextView showWinner = (TextView) findViewById(R.id.winner_text);
            showWinner.setText("Player 2 Won!");
        }

        if (scorePlayer1 >= 5 || scorePlayer2 >= 5) {
            Button rightOne = (Button) findViewById(R.id.right1);
            rightOne.setEnabled(false);
            Button rightTwo = (Button) findViewById(R.id.right2);
            rightTwo.setEnabled(false);
            Button rightThree = (Button) findViewById(R.id.right3);
            rightThree.setEnabled(false);
            Button leftOne = (Button) findViewById(R.id.left1);
            leftOne.setEnabled(false);
            Button leftTwo = (Button) findViewById(R.id.left2);
            leftTwo.setEnabled(false);
            Button leftThree = (Button) findViewById(R.id.left3);
            leftThree.setEnabled(false);
        }
    }

    /**
     * Displays the given score for Player 2.
     */

    public void displayForPlayer2(int player_2_score, int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForPlayer2(View view) {
        scorePlayer2 = scorePlayer2 + 3;
        displayForPlayer2(R.id.player_2_score, scorePlayer2);
        showWinner(view);
    }

    public void addTwoForPlayer2(View view) {
        scorePlayer2 = scorePlayer2 + 2;
        displayForPlayer2(R.id.player_2_score, scorePlayer2);
        showWinner(view);
    }

    public void addOneForPlayer2(View view) {
        scorePlayer2 = scorePlayer2 + 1;
        displayForPlayer2(R.id.player_2_score, scorePlayer2);
        showWinner(view);
    }


    /**
     * Resets the scores for both players.
     */

    public void reset(View view) {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        displayForPlayer1(R.id.player_1_score, scorePlayer1);
        displayForPlayer2(R.id.player_2_score, scorePlayer2);
        TextView showWinner = (TextView) findViewById(R.id.winner_text);
        showWinner.setText(String.valueOf(""));
        Button rightOne = (Button) findViewById(R.id.right1);
        rightOne.setEnabled(true);
        Button rightTwo = (Button) findViewById(R.id.right2);
        rightTwo.setEnabled(true);
        Button rightThree = (Button) findViewById(R.id.right3);
        rightThree.setEnabled(true);
        Button leftOne = (Button) findViewById(R.id.left1);
        leftOne.setEnabled(true);
        Button leftTwo = (Button) findViewById(R.id.left2);
        leftTwo.setEnabled(true);
        Button leftThree = (Button) findViewById(R.id.left3);
        leftThree.setEnabled(true);
    }


}