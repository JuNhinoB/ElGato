package com.ebm.elgato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;
    private Button playAgainButton;
    private Button homeButton;
    private TextView playerTurn;
    private String[] playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        playAgainButton = findViewById(R.id.playAgainButton);
        homeButton = findViewById(R.id.homeButton);
        playerTurn = findViewById(R.id.displayTurn);

        playAgainButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
        playerNames = getIntent().getStringArrayExtra("JUGADORES");

        if (playerNames != null){
            playerTurn.setText((playerNames[0] + " tu turno"));
        }


        ticTacToeBoard.setUpGame(playAgainButton, homeButton, playerTurn, playerNames);
    }

    public void jugarOtravezButttonClick(View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void inicioButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}