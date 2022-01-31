package com.politecnico.dam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder2> {

    ArrayList<String> nombres;
    ArrayList<String> direcciones;
    ArrayList<String> poblaciones;
    ArrayList<String> telefonos;
    Context context;

    public CustomAdapter2(Context context, ArrayList<String> nombres, ArrayList<String> direcciones, ArrayList<String> poblaciones, ArrayList<String> telefonos) {
        this.context = context;
        this.nombres = nombres;
        this.direcciones = direcciones;
        this.poblaciones = poblaciones;
        this.telefonos = telefonos;
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.saludlayout, parent, false);
        MyViewHolder2 vh = new MyViewHolder2(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder2 holder, final int position) {
        // set the data in items
        holder.nombre2.setText(nombres.get(position));
        holder.direccion2.setText(direcciones.get(position));
        holder.poblacion2.setText(poblaciones.get(position));
        holder.telefono2.setText(telefonos.get(position));

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, telefonos.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView nombre2, direccion2, poblacion2, telefono2;// init the item view's

        public MyViewHolder2(View itemView) {
            super(itemView);

            // get the reference of item view's
            nombre2 = (TextView) itemView.findViewById(R.id.nombre2);
            direccion2 = (TextView) itemView.findViewById(R.id.direccion2);
            poblacion2 = (TextView) itemView.findViewById(R.id.poblacion2);
            telefono2 = (TextView) itemView.findViewById(R.id.telefono2);

        }
    }
}
