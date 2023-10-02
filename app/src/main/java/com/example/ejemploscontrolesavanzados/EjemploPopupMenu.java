package com.example.ejemploscontrolesavanzados;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EjemploPopupMenu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_popup_menu);

        ImageButton btPopup = (ImageButton) findViewById(R.id.btPopup);
        btPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getBaseContext(), view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.context_menu_1, popup.getMenu());
                popup.setOnMenuItemClickListener(EjemploPopupMenu.this);

                popup.show();
            }
        });

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(getBaseContext(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
        return false;
    }
}