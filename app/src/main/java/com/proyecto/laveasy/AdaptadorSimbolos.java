package com.proyecto.laveasy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorSimbolos
        extends RecyclerView.Adapter<AdaptadorSimbolos.ViewHolderSimbolos>
        implements View.OnClickListener {

    ArrayList<SimboloO> listaSimbolos;
    //private View.OnClickListener listener;

    public AdaptadorSimbolos(ArrayList<SimboloO> listaSimbolos) {
        this.listaSimbolos = listaSimbolos;
    }

    @NonNull
    @Override
    public ViewHolderSimbolos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = R.layout.item_list_resultado;

        View view = LayoutInflater.from(parent.getContext()).inflate(layout,null,false);
        //view.setOnClickListener(this);
        return new ViewHolderSimbolos(view);
    }

    public class ViewHolderSimbolos extends RecyclerView.ViewHolder {
        TextView etiNombre, etiDescripcion;
        ImageView etiImagen;

        public ViewHolderSimbolos(@NonNull View itemView) {
            super(itemView);
            etiNombre = itemView.findViewById(R.id.idNombre);
            etiDescripcion = itemView.findViewById(R.id.idDescripcion);
            etiImagen = itemView.findViewById(R.id.idImagen);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSimbolos holder, int position) {
        holder.etiNombre.setText(listaSimbolos.get(position).getTitulo());
        holder.etiImagen.setImageResource(R.drawable.washingmachine);
        holder.etiDescripcion.setText(listaSimbolos.get(position).getDescripcion());

        //if(holder.etiNombre.getText().equals("Lavado a máquina 30º"))
          //  holder.etiImagen.setImageResource(R.drawable.lav1);

        String nombre = (String) holder.etiNombre.getText();

        switch (nombre){
            case "Lavado a máquina 30º":
                if(holder.etiDescripcion.getText().equals("Lavado a máquina sin superar los 30º")){
                    holder.etiImagen.setImageResource(R.drawable.lav10);
                }
                else holder.etiImagen.setImageResource(R.drawable.lav1);
                break;

            case "Lavado a máquina 60º":
                if(holder.etiDescripcion.getText().equals("Lavado a máquina sin superar los 60º")){
                    holder.etiImagen.setImageResource(R.drawable.lav11);
                }
                else holder.etiImagen.setImageResource(R.drawable.lav2);
                break;

            case "Lavado a máquina 90º":
                if(holder.etiDescripcion.getText().equals("Lavado a máquina sin superar los 90º")){
                    holder.etiImagen.setImageResource(R.drawable.lav12);
                }
                else holder.etiImagen.setImageResource(R.drawable.lav3);
                break;

            case "Lavado a máquina 30º corto": holder.etiImagen.setImageResource(R.drawable.lav4);
                break;

            case "Lavado a máquina 60º corto": holder.etiImagen.setImageResource(R.drawable.lav5);
                break;

            case "Lavado a máquina 90º corto": holder.etiImagen.setImageResource(R.drawable.lav6);
                break;

            case "Lavado a máquina 30º delicado": holder.etiImagen.setImageResource(R.drawable.lav7);
                break;

            case "Lavado a máquina 60º delicado": holder.etiImagen.setImageResource(R.drawable.lav8);
                break;

            case "Lavado a máquina 90º delicado": holder.etiImagen.setImageResource(R.drawable.lav9);
                break;

            case "Lavado a máquina": holder.etiImagen.setImageResource(R.drawable.lav13);
                break;

            case "No mojar": holder.etiImagen.setImageResource(R.drawable.lav14);
                break;

            case "Lavado a mano": holder.etiImagen.setImageResource(R.drawable.lav15);
                break;

            case "Permite lejía": holder.etiImagen.setImageResource(R.drawable.lav16);
                break;

            case "No permite lejía": holder.etiImagen.setImageResource(R.drawable.lav17);
                break;

            case "Permite lejía sin cloro": holder.etiImagen.setImageResource(R.drawable.lav18);
                break;

            case "Secado a máquina": holder.etiImagen.setImageResource(R.drawable.lav19);
                break;

            case "Secado a máquina corto": holder.etiImagen.setImageResource(R.drawable.lav20);
                break;

            case "Secado a máquina delicado": holder.etiImagen.setImageResource(R.drawable.lav21);
                break;

            case "Secado a máquina temperatura baja": holder.etiImagen.setImageResource(R.drawable.lav22);
                break;
            case "Secado a máquina temperatura media": holder.etiImagen.setImageResource(R.drawable.lav23);
                break;
            case "Secado a máquina temperatura alta": holder.etiImagen.setImageResource(R.drawable.lav24);
                break;
            case "Secado a máquina frío": holder.etiImagen.setImageResource(R.drawable.lav25);
                break;

            case "Secado a máquina frío corto": holder.etiImagen.setImageResource(R.drawable.lav26);
                break;

            case "No secar a máquina": holder.etiImagen.setImageResource(R.drawable.lav27_28);
                break;

            case "Secado vertical": holder.etiImagen.setImageResource(R.drawable.lav29);
                break;

            case "Secado vertical a la sombra": holder.etiImagen.setImageResource(R.drawable.lav30);
                break;

            case "Secar horizontal": holder.etiImagen.setImageResource(R.drawable.lav31);
                break;

            case "Secar horizontal a la sombra": holder.etiImagen.setImageResource(R.drawable.lav32);
                break;
            case "Secar a la sombra": holder.etiImagen.setImageResource(R.drawable.lav33);
                break;
            case "Colgar para secar": holder.etiImagen.setImageResource(R.drawable.lav34);
                break;
            case "Colgar para secar a la sombra": holder.etiImagen.setImageResource(R.drawable.lav35);
                break;
            case "No retorcer": holder.etiImagen.setImageResource(R.drawable.lav36);
                break;
            case "Todo tipo de planchado": holder.etiImagen.setImageResource(R.drawable.lav37);
                break;
            case "No planchar": holder.etiImagen.setImageResource(R.drawable.lav38);
                break;
            case "Planchar sin vapor": holder.etiImagen.setImageResource(R.drawable.lav39);
                break;
            case "Planchar máximo 110º": holder.etiImagen.setImageResource(R.drawable.lav40);
                break;
            case "Planchar máximo 150º": holder.etiImagen.setImageResource(R.drawable.lav41);
                break;
            case "Planchar máximo 200º": holder.etiImagen.setImageResource(R.drawable.lav42);
                break;
            case "Planchar máximo 110º sin vapor": holder.etiImagen.setImageResource(R.drawable.lav43);
                break;
            case "Planchar máximo 150º sin vapor": holder.etiImagen.setImageResource(R.drawable.lav44);
                break;
            case "Planchar máximo 200º sin vapor": holder.etiImagen.setImageResource(R.drawable.lav45);
                break;
            case "Limpieza en seco": holder.etiImagen.setImageResource(R.drawable.lav46);
                break;
            case "Limpieza en seco solvente": holder.etiImagen.setImageResource(R.drawable.lav47);
                break;
            case "Limpieza en seco percloroetileno": holder.etiImagen.setImageResource(R.drawable.lav48);
                break;
            case "Limpieza en seco solventes fluorados": holder.etiImagen.setImageResource(R.drawable.lav49);
                break;
            case "Limpieza en seco hidrocarburos": holder.etiImagen.setImageResource(R.drawable.lav50);
                break;
            case "Limpieza en seco siliconas": holder.etiImagen.setImageResource(R.drawable.lav51);
                break;
            case "Limpieza húmeda": holder.etiImagen.setImageResource(R.drawable.lav52);
                break;
            case "No limpiar en seco": holder.etiImagen.setImageResource(R.drawable.lav53);
                break;
            case "Limpieza en seco humedad reducida": holder.etiImagen.setImageResource(R.drawable.lav54);
                break;
            case "Limpieza en seco sin vapor": holder.etiImagen.setImageResource(R.drawable.lav55);
                break;
            case "Limpieza en seco corto": holder.etiImagen.setImageResource(R.drawable.lav56);
                break;
            case "Limpieza en seco baja temperatura": holder.etiImagen.setImageResource(R.drawable.lav57);
                break;



                default:
                    break;

        }



    }

    @Override
    public int getItemCount() {
        return listaSimbolos.size();
    }

    @Override
    public void onClick(View v) {

    }
    public ArrayList<SimboloO> getListaSimbolos() {
        return listaSimbolos;
    }

    public void setListaSimbolos(ArrayList<SimboloO> listaSimbolos) {
        this.listaSimbolos = listaSimbolos;
    }



}
