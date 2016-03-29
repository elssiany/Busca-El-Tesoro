package com.example.user.buscaeltesoro.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.buscaeltesoro.R;

public class GanadorActivity extends AppCompatActivity {

    //ImageView imageGif;
    TextView textVDescripcion;
    String puntaje="",jugador="";
    Button btonSeguirJugando,btonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        //valido que el intent que me envio el otro activity <EscenarioActivity> no este nulo
        //sino esta nulo entonces procedo a obtener los valores que me envio por medio del putExtra()...
        if(getIntent()!=null){
            //obtengo los valores que me han enviado
            puntaje=String.valueOf(getIntent().getExtras().getInt("puntaje"));
            jugador=getIntent().getExtras().getString("jugador");
        }
        textVDescripcion =(TextView)findViewById(R.id.textVDescripcionGanador);
        textVDescripcion.setText("Ganador Jugador"+jugador+"\n"+" Puntaje\n"+puntaje+" puntos\n"+"\uD83D\uDE4B");

        btonSalir=(Button)findViewById(R.id.btonSalir);
        btonSeguirJugando=(Button)findViewById(R.id.btonSeguir);

        btonSeguirJugando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),EscenarioActivity.class));
            }
        });

        btonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
