package com.example.ejemploscontrolesavanzados;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EjemploArrayAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_array_adapter);

        Datos[] datos = new Datos[]{
                new Datos("Titulo 1","Valor 1"),
                new Datos("Titulo 2","Valor 2"),
                new Datos("Titulo 3","Valor 3"),
                new Datos("Titulo 4","Valor 4"),
                new Datos("Titulo 5","Valor 5")
        };

        ListView miLista = (ListView) findViewById(R.id.miLista);
        Adaptador miAdaptador = new Adaptador(this,datos);
        miLista.setAdapter(miAdaptador);

        miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                String elementoSeleccionado = ((Datos)adapterView.getItemAtPosition(posicion)).getTexto1();
                Toast.makeText(getBaseContext(),elementoSeleccionado,Toast.LENGTH_SHORT).show();
            }
        });

    }
}


class Datos {
    private String texto1;
    private String texto2;

    public Datos(String texto1, String texto2) {
        this.texto1 = texto1;
        this.texto2 = texto2;
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }
}

class Adaptador extends ArrayAdapter<Datos>{
    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos){
        super(context,R.layout.elemento,datos);
        this.datos=datos;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento,parent,false);
        TextView texto1 = elemento.findViewById(R.id.miTexto1);
        texto1.setText(datos[position].getTexto1());
        TextView texto2 = elemento.findViewById(R.id.miTexto2);
        texto2.setText(datos[position].getTexto2());

        return elemento;
    }
}//Adaptador


