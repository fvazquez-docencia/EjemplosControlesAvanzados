package com.example.ejemploscontrolesavanzados;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class EjemploDatePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_date_picker);


        Button btEscogeFecha =( Button) findViewById(R.id.btEscogerFecha);

        btEscogeFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int anho = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpFecha= new DatePickerDialog(view.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int anhoSel, int mesSel, int diaSel) {
                        TextView tvFecha = (TextView) findViewById(R.id.tvFechaEscogida);
                        tvFecha.setText(diaSel + "/" + mesSel + "/" + anhoSel);

                    }
                },anho,mes,dia);

                dpFecha.show();
            }
        });
    }
}