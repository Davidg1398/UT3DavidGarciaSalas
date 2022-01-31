package com.politecnico.dam;

import android.os.Bundle;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class SaludActivity extends AppCompatActivity {
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> direcciones = new ArrayList<>();
    ArrayList<String> poblaciones = new ArrayList<>();
    ArrayList<String> telefonos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);

        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray userArray = obj.getJSONArray("ITEMS");
            // implement for loop for getting users list data
            for (int i = 0; i < userArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject userDetail = userArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                nombres.add(userDetail.getString("NOMBRE"));
                direcciones.add(userDetail.getString("DIRECCION"));
                poblaciones.add(userDetail.getString("LOCALIDAD"));
                telefonos.add(userDetail.getString("TELÉFONO"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter2 customAdapter2 = new CustomAdapter2(SaludActivity.this, nombres, direcciones, poblaciones,telefonos);
        recyclerView.setAdapter(customAdapter2); // set the Adapter to RecyclerView
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("CentrosSanitarios.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}