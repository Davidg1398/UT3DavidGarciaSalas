package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout option_maps;
    LinearLayout option_contacts, option_salud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option_maps = findViewById(R.id.layoutMaps);

        // Añadimos actionListener a los botones
        option_maps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, MapsActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }

        });

        option_contacts = findViewById(R.id.layoutContacts);

        // Añadimos actionListener a los botones
        option_contacts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, MainActivity2.class);
                startActivity(i);
            }

        });

        option_salud = findViewById(R.id.layoutHealth);

        // Añadimos actionListener a los botones
        option_salud.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, SaludActivity.class);
                startActivity(i);
            }

        });
    }
}