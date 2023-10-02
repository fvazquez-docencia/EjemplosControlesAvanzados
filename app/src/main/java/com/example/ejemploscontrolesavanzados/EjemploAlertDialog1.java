package com.example.ejemploscontrolesavanzados;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class EjemploAlertDialog1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_alert_dialog1);

        Button btMostrarDialogo = (Button) findViewById(R.id.btMostrarDialogo);
        btMostrarDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    //builder.setMessage("Ejemplo");
                    builder.setTitle("Título");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setPositiveButton("Primero", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //código
                        }
                    });

                    builder.setNegativeButton("Segundo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //código
                        }
                    });

                    builder.setNeutralButton("Tercero", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //código
                        }
                    });

                    CharSequence[] elementos = new CharSequence[]{
                            "Caso 1", "Caso 2", "Caso 3", "Caso 4"
                    };

/*
                    builder.setItems(elementos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Código
                        }
                    });*/

/*
                    builder.setSingleChoiceItems(elementos, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });*/

                    builder.setMultiChoiceItems(elementos, null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                            if(isChecked){
                                //Código
                            }
                            else{
                                //Código
                            }
                        }
                    });

                    AlertDialog dg = builder.create();
                    dg.show();
                }catch (Exception ex){
                    Log.w("Error",ex.getMessage().toString());
                }
            }
        });
    }
}