package com.example.user.buscaeltesoro;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.buscaeltesoro.activities.EscenarioActivity;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    //variable que me guarda los colores que han eligido los jugadores para jugar la partida
    public static String colorJugador1;
    public static String colorJugador2;
    //variable que me dira aque jugador le toca seleccionar su color
    int jugador=0;
    //objeto Dialog con el que se crea el dialogo
    private Dialog customDialog;
    Animation animFadeOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =(TextView)findViewById(R.id.textVIniciarJuego);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //doy inicio al juego pero antes llamo al metodo <dialogoSeleccionarColor()> para que los
               // jugadores escojan su color de partida
               dialogoSeleccionarColor();
           }
       });
        //inflo la animacion que tengo en los recursos <anim> xml
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

    }





    /*
    * metodo que se encargar de crear un dialogo personalizado
    * */
    private void dialogoSeleccionarColor() {

        //con este tema personalizado evitamos los bordes por defecto
        customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //pongo el fondo del dialogo transparente
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //establecemos el contenido(la vista personalizada que se creo llamada <dialog__select_color>) de nuestro dialog
        customDialog.setContentView(R.layout.dialog__select_color);
        //lanzo el dialogo(lo muestro)
        customDialog.show();
    }


/*
* metodo que captura a los views que se le esten dando click
* */
    public void onClickBtons(View view){
        //variable que captura el color que elijan los jugadores
        String color="";
        switch (view.getId()){
            case R.id.btonCancelar:
                 jugador=0;
                //cierro el dialogo que se esta mostrando
                 customDialog.dismiss();
                break;
            case R.id.btonColor1:
                jugador++;
                color="1";
                //cuando el jugador le da click al color1 entonces se procede a deshabilitar el
                //color1 para el otro jugador no tome ese mismo color
                 view.setVisibility(View.INVISIBLE);
                break;
            case R.id.btonColor2:
                jugador++;
                color="2";
                 view.setVisibility(View.INVISIBLE);
                break;
            case R.id.btonColor3:
                jugador++;
                color="3";
                 view.setVisibility(View.INVISIBLE);
                break;
            case R.id.btonColor4:
                jugador++;
                color="4";
                 view.setVisibility(View.INVISIBLE);
                break;
            case R.id.btonColor5:
                jugador++;
                color="5";
                 view.setVisibility(View.INVISIBLE);
                break;
            case R.id.btonColor6:
                jugador++;
                color="6";
                 view.setVisibility(View.INVISIBLE);
                break;

        }

        if(jugador==1){
            colorJugador1=color;
            //jugador=2;
            //hago un pequeño casteo al textview <textVTitleDialog>
            //y le seteo un mensaje(texto) para que el jugador 2 elija su color de juego
            ((TextView) customDialog.findViewById(R.id.textVTitleDialog)).setText("" +
                    "Seleccione un \ncolor para el jugador 2");

            //le agrego la animacion <animFadeOut> que infle, al relative layout <relativeLayout> del dialogo personalizado
            RelativeLayout relativeLayout=(RelativeLayout) customDialog.findViewById(R.id.relativeLayout);
                    relativeLayout.startAnimation(animFadeOut);

        }else if (jugador==2){
            //cuando los jugadores ya tengan los colores para jugar la partida ,entonces se procede
            //a iniciar el juego llamando al activity <EscenarioActivity> que es el encargado del escenario de juego
            jugador=0;
            colorJugador2=color;
            //lanzo al activity <EscenarioActivity>
            startActivity(new Intent(getApplicationContext(), EscenarioActivity.class));
            customDialog.dismiss();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
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



}
