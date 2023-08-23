package com.ebm.elgato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {

    private EditText jugador1;
    private EditText jugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        jugador1 = findViewById(R.id.player1Name);
        jugador2 = findViewById(R.id.player2Name);
    }

    public void aceptarButtonClick(View view){

        String jugador1n = jugador1.getText().toString();
        String jugador2n = jugador2.getText().toString();

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("JUGADORES", new String[] {jugador1n, jugador2n});
        startActivity(intent);

    }
}