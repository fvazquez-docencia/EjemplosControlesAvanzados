package com.example.ejemploscontrolesavanzados;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class EjemploNotificacionBasica extends AppCompatActivity {

    String CHANNEL_ID = "mi_canal_de_notificacion";
    NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_notificacion_basica);

        Button btNotificar = (Button) findViewById(R.id.btNotificar);
        btNotificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarNotificacionConActividadDestino();
            }
        });

        createNotificationChannel();
        notificationManager = NotificationManagerCompat.from(this);
    }

    private void createNotificationChannel() {
        // Verifica si la versión de Android es igual o superior a Android 8.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String nombre = "Mi Canal de Notificación";
            String descripcion = "Descripción de mi canal de notificación";
            int importancia = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, nombre, importancia);
            channel.setDescription(descripcion);

            // Registrar el cannal en el sustema. Después de esto no se podrá cambiar su importancia
            // ni otros comportamientos.
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            // Registra el canal en el sistema
            notificationManager.createNotificationChannel(channel);

        }
    }

    private void enviarNotificacionSimple() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.android)
                .setContentTitle("Prueba de notificación")
                .setContentText("Esta es una notificación simple")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);



        // notificationId is a unique int for each notification that you must define
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            notificationManager.notify(1, builder.build());
        }
    }


    private void enviarNotificacionConActividadDestino(){
        // Create an explicit intent for an Activity in your app.
        Intent intent = new Intent(this, EjemploListView.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.android)
                .setContentTitle("Notificación con actividad")
                .setContentText("Esta es una notificación con actividad asociada")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Se indica el intent que se lanzará cuando se pulse en la notificación.
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            notificationManager.notify(1, builder.build());
        }

    }

}

