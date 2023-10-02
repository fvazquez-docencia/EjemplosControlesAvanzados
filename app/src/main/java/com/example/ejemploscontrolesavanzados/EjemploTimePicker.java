package com.example.ejemploscontrolesavanzados;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class EjemploTimePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_time_picker);

        Button btEscogeHora =( Button) findViewById(R.id.btEscogerHora);

        btEscogeHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int hora = cal.get(Calendar.HOUR);
                int minuto = cal.get(Calendar.MINUTE);
                TimePickerDialog dpHora = new TimePickerDialog(view.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int horaSel, int minutoSel) {
                                TextView tvFecha = (TextView) findViewById(R.id.tvHoraEscogida);
                                tvFecha.setText(horaSel + ":" + minutoSel);
                            }


                        },hora,minuto,true);

                dpHora.show();
            }
        });
    }
}