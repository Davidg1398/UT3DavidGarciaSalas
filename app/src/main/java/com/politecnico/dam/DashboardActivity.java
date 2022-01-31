package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout option_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        option_maps = findViewById(R.id.layoutMaps);

        // Añadimos actionListener a los botones
        option_maps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent (DashboardActivity.this, MapsActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });


    }
}