package com.example.user.buscaeltesoro.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.buscaeltesoro.MainActivity;
import com.example.user.buscaeltesoro.R;
import com.example.user.buscaeltesoro.models.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class EscenarioActivity extends AppCompatActivity {


    //creo  objetos de tipo <Button> que corresponderan a las casillas de la matriz
    Button  casilla1,casilla2,casilla3,casilla4,casilla5,
            casilla6,casilla7,casilla8,casilla9,casilla10,
            casilla11,casilla12,casilla13,casilla14,casilla15,
            casilla16,casilla17,casilla18,casilla19,casilla20,
            casilla21,casilla22,casilla23,casilla24,casilla25;

    TextView txtVPuntaje;
    int puntaje1,puntaje2,filaTesoro,columnaTesoro;

    List<Pregunta> cuestionario=new ArrayList<>();
    Pregunta pregunta;
    int jugador=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escenario);
        initViews();
        iniciarEscenario();

    }


    /*
    * Este metodo castea a todas las casillas de la escena del juego (casillas de la matriz de views)*/
    public void initViews(){

        casilla1=(Button)findViewById(R.id.btonCasilla1);
        casilla2=(Button)findViewById(R.id.btonCasilla2);
        casilla3=(Button)findViewById(R.id.btonCasilla3);
        casilla4=(Button)findViewById(R.id.btonCasilla4);
        casilla5=(Button)findViewById(R.id.btonCasilla5);
        casilla6=(Button)findViewById(R.id.btonCasilla6);
        casilla7=(Button)findViewById(R.id.btonCasilla7);
        casilla8=(Button)findViewById(R.id.btonCasilla8);
        casilla9=(Button)findViewById(R.id.btonCasilla9);
        casilla10=(Button)findViewById(R.id.btonCasilla10);
        casilla11=(Button)findViewById(R.id.btonCasilla11);
        casilla12=(Button)findViewById(R.id.btonCasilla12);
        casilla13=(Button)findViewById(R.id.btonCasilla13);
        casilla14=(Button)findViewById(R.id.btonCasilla14);
        casilla15=(Button)findViewById(R.id.btonCasilla15);
        casilla16=(Button)findViewById(R.id.btonCasilla16);
        casilla17=(Button)findViewById(R.id.btonCasilla17);
        casilla18=(Button)findViewById(R.id.btonCasilla18);
        casilla19=(Button)findViewById(R.id.btonCasilla19);
        casilla20=(Button)findViewById(R.id.btonCasilla20);
        casilla21=(Button)findViewById(R.id.btonCasilla21);
        casilla22=(Button)findViewById(R.id.btonCasilla22);
        casilla23=(Button)findViewById(R.id.btonCasilla23);
        casilla24=(Button)findViewById(R.id.btonCasilla24);
        casilla25=(Button)findViewById(R.id.btonCasilla25);

        txtVPuntaje =(TextView)findViewById(R.id.textVPuntajes);
    }


    /*
    Este metodo inicia el escenario del juego llenado las casillas de numeros aleatorios,posicionar el tesoro
    iniciar las ayudas y inicializar puntajes
    */
    public void iniciarEscenario(){

         //Genero la posicion del tesoro
         filaTesoro=getNumRandom(1,5);
         columnaTesoro=getNumRandom(1,5);

        casilla1.setText(String.valueOf(getNumRandom(1,100)));
        casilla2.setText(String.valueOf(getNumRandom(1,100)));
        casilla3.setText(String.valueOf(getNumRandom(1,100)));
        casilla4.setText(String.valueOf(getNumRandom(1,100)));
        casilla5.setText(String.valueOf(getNumRandom(1,100)));

        casilla6.setText(String.valueOf(getNumRandom(1,100)));
        casilla7.setText(String.valueOf(getNumRandom(1,100)));
        casilla8.setText(String.valueOf(getNumRandom(1,100)));
        casilla9.setText(String.valueOf(getNumRandom(1,100)));
        casilla10.setText(String.valueOf(getNumRandom(1,100)));

        casilla11.setText(String.valueOf(getNumRandom(1,100)));
        casilla12.setText(String.valueOf(getNumRandom(1,100)));
        casilla13.setText(String.valueOf(getNumRandom(1,100)));
        casilla14.setText(String.valueOf(getNumRandom(1,100)));
        casilla15.setText(String.valueOf(getNumRandom(1,100)));

        casilla16.setText(String.valueOf(getNumRandom(1,100)));
        casilla17.setText(String.valueOf(getNumRandom(1,100)));
        casilla18.setText(String.valueOf(getNumRandom(1,100)));
        casilla19.setText(String.valueOf(getNumRandom(1,100)));
        casilla20.setText(String.valueOf(getNumRandom(1,100)));

        casilla21.setText(String.valueOf(getNumRandom(1,100)));
        casilla22.setText(String.valueOf(getNumRandom(1,100)));
        casilla23.setText(String.valueOf(getNumRandom(1,100)));
        casilla24.setText(String.valueOf(getNumRandom(1,100)));
        casilla25.setText(String.valueOf(getNumRandom(1,100)));
        puntaje1=0;
        puntaje2=0;

        txtVPuntaje.setText("Jugador 1: "+puntaje1+" ptos"+" \uD83D\uDE4B " +
                "Jugador 2: "+puntaje2+" ptos");

        //comienzo a llenar la lista <cuestionario> con las preguntas de la partida

        //preguntas faciles
        cuestionario.add(new Pregunta("¿En qué carpetas se almacenan el código Java de una aplicación?" +
                "",1,"a","src","res y assets","res/raw y res/xml","xml"));
        cuestionario.add(new Pregunta("¿Qué componentes de una aplicación Android no se utiliza" +
                " en el Interfaz de usuario?",1,"d","Vistas","Layouts","Actividades","Servicios"));
        cuestionario.add(new Pregunta("son IDE (entornos de desarrollo integrados) que puede utilizarse para programar Aplicaciones para Android?"
                , 1, "b", "Google Apps","IntelliJ IDEA o Android Studio","Android Development","Eclipse Pro 3000"));
        cuestionario.add(new Pregunta("¿De qué forma marcamos una línea en Java como comentario?"
                ,1,"c","Comenzando la línea con \"**\""
                ,"Encerrando la línea entre \"/\" y \"/\"","Comenzando la línea con \"//\""
                ,"Encerrando la línea entre \"<--\" y \"!-->\""));

        cuestionario.add(new Pregunta("¿Qué es JVM?", 1, "a", "Java Virtual Machine: la máquina " +
                "virtual Java que traduce el bytecode para que se ejecute en la platorma donde está implementada"
                , "Java V Mobile: la versión 5 de Java para dispositivos móviles"
                , " Java Virtual Memory: el gestor de memoria virtual de Java " +
                "que permite liberar memoria RAM, moviendo objetos Java a una zona de disco duro", "Todas las anteriores"));


        //preguntas medio faciles
        cuestionario.add(new Pregunta(" ¿Qué código de los siguientes tiene que ver con la herencia?"
                ,2,"b","public class Componente inherit Producto"
                ,"public class Componente extends Producto"
                ,"public class Componente implements Producto","public class Componente belong to Producto"));
        cuestionario.add(new Pregunta(" ¿Qué significa instanciar una clase?"
                ,2,"a","Crear un objeto a partir de la clase","Duplicar una clase","Eliminar una clase","Conectar dos clases entre sí"));
        cuestionario.add(new Pregunta("¿Qué es Eclipse?"
                ,2,"c","Una libreria de Java","Una versión de Java especial para servidores"
                ,"Un IDE para desarrollar aplicaciones","Ninguna de las anteriores"));
        cuestionario.add(new Pregunta("¿Qué es una excepción?",2
                ,"d","Un objeto que no puede ser instanciado"
                ,"Un bucle que no finaliza"
                ,"Un tipo de evento muy utilizado al crear interfaces"
                ,"Un error que lanza un método cuando algo va mal"));
        cuestionario.add(new Pregunta("¿Cuáles de la siguiente son emuladores donde puedes probar una App Android?"
                ,2,"c","Rumble","VirtualAndroid","GenyMotion","YouWave 3000"));

        //preguntas de dificultad intermedia
        cuestionario.add(new Pregunta("¿Cuál es la descripción que crees que define mejor el concepto " +
                "'clase' en la programación orientada a objetos?",3,"d","Es un tipo particular de variable"
                ,"Es una categoria de datos ordenada secuencialmente","Es un concepto similar al de 'array'"
                ,"Es un modelo o plantilla a partir de la cual creamos objetos"));
        cuestionario.add(new Pregunta("¿Qué opción define mejor el concepto de ‘herencia’ en Java?"
                ,3,"d","Es la compatibilidad que presenta Java entre versiones: se pueden " +
                "ejecutar aplicaciones creadas en una versión antigua en una más moderna"
                ," Propiedad que permite crear múltiples objetos a partir de una sola clase","Todas la anteriores"
                ,"Permite crear una clase (subclase) basada en otra clase (superclase)"));
        cuestionario.add(new Pregunta("Fichero .jar",3,"a","Archivo que permite ejecutar aplicaciones" +
                " escritas en el lenguaje java","Archivo de codigo fuente","Extension para el lenguaje java"
                ,"Ninguna de las anteriores"));
        cuestionario.add(new Pregunta("¿En qué sistema se basa el núcleo de Android?\n" +
                "\n" +
                "  Chrome",3,"b","Chrome","Linux","MacOSX","BSD Unix"));
        cuestionario.add(new Pregunta("¿Qué es Dalvik?",3,"d","Es la librería para gestión de base de datos en Android"
                ,"Es el nombre de la futura versión de Android 5"
                ,"Es el emulador Android que incorpora Eclipse para testear las Apps que se desarrollan en este IDE"
                ,"Es la máquina virtual que ejecuta el bytecode propio de Android"));

        //preguntas dificiles
        cuestionario.add(new Pregunta("¿Permite Android la multitarea?",4,"a","Si","No","Solo a partir de la versión 4","No y si"));
        cuestionario.add(new Pregunta("Las siguientes son caracteristicas de la Plataforma Android, excepto:"
                ,4,"b","La Maquina Virtual Dalvik esta optimizada para moviles","No Soporta SQLite para almacenamiento de datos estructurados"
                ,"Los graficos 3d estan basados en la especificacion OpenGL ES 1.0","Todas las anterios"));
        cuestionario.add(new Pregunta("El siguiente componente se ejecuta en background por un período indefinido de tiempo:"
                ,4,"a","Servicio","Proveedor de Contenido"
                ,"Actividad","Proceso de background"));
        cuestionario.add(new Pregunta("¿Cuál de los siguientes NO es cierto sobre las aplicaciones en Android?"
                ,4,"d","Están escritas en Java y empaquetadas en Android Package (apk)"
                ,"Cada aplicación se ejecuta en su propio proceso de Linux"
                ,"Cada proceso tiene su propia máquina virtual de Java"
                ,"Todas las aplicaciones tienen interfase gráfica"));
        cuestionario.add(new Pregunta("Indica que afirmación es" +
                " cierta:",4,"c","Dos niveles de API pueden corresponder a la misma versión"
                ,"Dos nombres comerciales corresponden a la misma versión","Dos versiones de Android pueden tener un mismo nivel de API"
                ,"Ninguna de las anteriores"));


    }



    /*
    * este metodo se encarga de crear un toast personalizado a mi gusto
    * pasandole como parametro el texto personalizado
    * */
    public void toasPersonalizado(String mensaje){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_layout_toast,
                (ViewGroup) findViewById(R.id.toast_layout_root)); //"inflamos" nuestro layout
        //ImageView imageV=(ImageView) layout.findViewById(R.id.imageVToas);
        //imageV.setBackground(getResources().getDrawable(image));
        TextView text = (TextView) layout.findViewById(R.id.text_toast);
        text.setText(mensaje);//texto a mostrar y asignado al textView de nuestro layout

        Toast toast = new Toast(getApplicationContext()); //Instanciamos un objeto Toast
        //toast.setGravity(Gravity.BOTTOM, 0, 0); //lo situamos centrado verticalmente en la pantalla
        toast.setDuration(Toast.LENGTH_SHORT); //duracion del toast
        toast.setView(layout); //asignamos nuestro layout personalizado al objeto Toast
        toast.show(); //mostramos el Toast en pantalla

    }




    public String ayuda(){

        return "";
    }


    public void clickBtonCasillas(View view){
        jugador++;
        int filaCasilla=0
                ,columnaCasilla=0;

        switch (view.getId()) {

            case R.id.btonCasilla1:
                filaCasilla=1;
                columnaCasilla=1;
                break;
            case R.id.btonCasilla2:
                filaCasilla=1;
                columnaCasilla=2;
                break;
            case R.id.btonCasilla3:
                filaCasilla=1;
                columnaCasilla=3;
                break;
            case R.id.btonCasilla4:
                filaCasilla=1;
                columnaCasilla=4;
                break;
            case R.id.btonCasilla5:
                filaCasilla=1;
                columnaCasilla=5;
                break;
            case R.id.btonCasilla6:
                filaCasilla=2;
                columnaCasilla=1;
                break;

            case R.id.btonCasilla7:
                filaCasilla=2;
                columnaCasilla=2;
                break;
            case R.id.btonCasilla8:
                filaCasilla=2;
                columnaCasilla=3;
                break;

            case R.id.btonCasilla9:
                filaCasilla=2;
                columnaCasilla=4;
                break;
            case R.id.btonCasilla10:
                filaCasilla=2;
                columnaCasilla=5;
                break;
            case R.id.btonCasilla11:
                filaCasilla=3;
                columnaCasilla=1;
                break;

            case R.id.btonCasilla12:
                filaCasilla=3;
                columnaCasilla=2;
                break;
            case R.id.btonCasilla13:
                filaCasilla=3;
                columnaCasilla=3;
                break;

            case R.id.btonCasilla14:
                filaCasilla=3;
                columnaCasilla=4;
                break;
            case R.id.btonCasilla15:
                filaCasilla=3;
                columnaCasilla=5;
                break;
            case R.id.btonCasilla16:
                filaCasilla=4;
                columnaCasilla=1;
                break;

            case R.id.btonCasilla17:
                filaCasilla=4;
                columnaCasilla=2;
                break;
            case R.id.btonCasilla18:
                filaCasilla=4;
                columnaCasilla=3;
                break;
            case R.id.btonCasilla19:
                filaCasilla=4;
                columnaCasilla=4;
                break;
            case R.id.btonCasilla20:
                filaCasilla=4;
                columnaCasilla=5;
                break;
            case R.id.btonCasilla21:
                filaCasilla=5;
                columnaCasilla=1;
                break;

            case R.id.btonCasilla22:
                filaCasilla=5;
                columnaCasilla=2;
                break;
            case R.id.btonCasilla23:
                filaCasilla=5;
                columnaCasilla=3;
                break;

            case R.id.btonCasilla24:
                filaCasilla=5;
                columnaCasilla=4;
                break;
            case R.id.btonCasilla25:
                filaCasilla=5;
                columnaCasilla=5;
                break;
            default:

                break;

        }

        if(filaTesoro==filaCasilla & columnaTesoro==columnaCasilla){
            Intent intent = new Intent(getApplicationContext(), GanadorActivity.class);
            if(jugador==1) {
                intent.putExtra("puntaje", puntaje1);
                intent.putExtra("jugador","jugador 1");
            }else{
                intent.putExtra("puntaje", puntaje2);
                intent.putExtra("jugador","jugador 2");
            }
            startActivity(intent);
            finish();
        }else{
            pregunta=cuestionario.get(getNumRandom(1,19));
            dialogoCuestionario(view);
        }

    }


   Dialog customDialogo;


    private void dialogoCuestionario(final View view) {

        //con este tema personalizado evitamos los bordes por defecto
        customDialogo = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //pongo el fondo del dialogo transparente
        customDialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //establecemos el contenido de nuestro dialog
        customDialogo.setContentView(R.layout.dialog_cuestionario);

        ((TextView)customDialogo.findViewById(R.id.textVPregunta)).setText(pregunta.getDescripcion());
        ((TextView)customDialogo.findViewById(R.id.textVRespuestaA)).setText(pregunta.getRespuestaA());
        ((TextView)customDialogo.findViewById(R.id.textVRespuestaB)).setText(pregunta.getRespuestaB());
        ((TextView)customDialogo.findViewById(R.id.textVRespuestaC)).setText(pregunta.getRespuestaC());
        ((TextView)customDialogo.findViewById(R.id.textVRespuestaD)).setText(pregunta.getRespuestaD());


        ((RelativeLayout)customDialogo.findViewById(R.id.relativeLayoutA)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarClickDeRespuesta("a",view);
            }
        });

        ((RelativeLayout)customDialogo.findViewById(R.id.relativeLayoutB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarClickDeRespuesta("b",view);
            }
        });

        ((RelativeLayout)customDialogo.findViewById(R.id.relativeLayoutC)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarClickDeRespuesta("c",view);
            }
        });

        ((RelativeLayout)customDialogo.findViewById(R.id.relativeLayoutD)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarClickDeRespuesta("d",view);
            }
        });

        customDialogo.show();


    }


    /*
* metodo valida las preguntas que responda el jugador
* */
    public void validarClickDeRespuesta(String respuesta,View view){

        //usando el objeto <pregunta> y la variable <respuesta>
        //se valida la respuesta que escogio el jugar
        if(pregunta.getRespuesta().equals(respuesta)){

            //la variable <puntaje> es la que contiene el valor q tiene esa pregunta
            // que ha respondido el jugador(ej:100puntos..etc)
            int puntaje=validarPuntaje(pregunta.getDificultad());

            //se verifica que jugador fue el que respondio la pregunta
            if(jugador==1){
                //aqui se le pone a la casilla el color del jugador 1 que respondio la pregunta correctamente
                view.setBackgroundResource(getResources().getIdentifier("image_color" + MainActivity.colorJugador1, "drawable",
                        getApplicationInfo().packageName));
                puntaje1=puntaje1+puntaje;
            }else if(jugador==2){
                //aqui se le pone a la casilla el color del jugador 2 que respondio la pregunta correctamente
                view.setBackgroundResource(getResources().getIdentifier("image_color" + MainActivity.colorJugador2, "drawable",
                        getApplicationInfo().packageName));
                puntaje2=puntaje2+puntaje;
            }
            txtVPuntaje.setText("Jugador 1: "+puntaje1+" ptos"+" \uD83D\uDE4B " +
                    "Jugador 2: "+puntaje2+" ptos");
            toasPersonalizado("\uD83D\uDE0ERespuesta correcta");
            customDialogo.dismiss();
        }else{
            toasPersonalizado("\uD83D\uDE1ERespuesta incorrecta");
            customDialogo.dismiss();
        }
        if(jugador==2){
            jugador=0;
            Snackbar.make(view, "Turno del jugador 1", Snackbar.LENGTH_SHORT)
                    .show();
        }else{
            Snackbar.make(view, "Turno del jugador 2", Snackbar.LENGTH_SHORT)
                    .show();
        }

    }




    /*
    matodo que valida que puntaje tiene cada pregunta que respondan los jugadores
    */
    int validarPuntaje(int dificultad){

        if(dificultad==1){
            dificultad=1;
        }else if (dificultad==2){
            dificultad=2;
        }else if (dificultad==3){
            dificultad=3;
        }else if (dificultad==4){
            dificultad=5;
        }

        return dificultad;
    }



    /*
    * metodo que genera numeros aleatorios dentro de un intervalo cerrado [desde,hasta]*/
     int getNumRandom(int desde,int hasta){
        return (int) Math.floor(Math.random()*(hasta-desde+1)+desde);
    }



    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }


}
