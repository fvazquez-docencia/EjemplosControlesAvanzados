package com.example.ejemploscontrolesavanzados;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EjemploBaseAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_array_adapter);

        //Ahora los datos son un ArrayList
        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos("Titulo 1","Valor 1"));
        datos.add(new Datos("Titulo 2","Valor 2"));
        datos.add(new Datos("Titulo 3","Valor 3"));
        datos.add(new Datos("Titulo 4","Valor 4"));
        datos.add(new Datos("Titulo 5","Valor 5"));


        ListView miLista = (ListView) findViewById(R.id.miLista);
        AdaptadorBase miAdaptador = new AdaptadorBase(this,datos);
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


class AdaptadorBase extends BaseAdapter {
    private ArrayList<Datos> datos;
    private Context contexto;

    public AdaptadorBase(Context context, ArrayList<Datos> datos){
        super();
        this.contexto=context;
        this.datos=datos;
    }


    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int posicion) {
        return datos.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento,parent,false);
        TextView texto1 = elemento.findViewById(R.id.miTexto1);
        texto1.setText(((Datos)getItem(position)).getTexto1());
        TextView texto2 = elemento.findViewById(R.id.miTexto2);
        texto2.setText(((Datos)getItem(position)).getTexto2());

        return elemento;
    }
}//AdaptadorBase


