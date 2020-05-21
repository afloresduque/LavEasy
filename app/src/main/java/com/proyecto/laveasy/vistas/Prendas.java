package com.proyecto.laveasy.vistas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.laveasy.R;

import java.util.ArrayList;


public class Prendas extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> seleccionados = new ArrayList<>();
    String prenda;


    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_grid_prendas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        customizaActionBar();
        if(seleccionados.size()>0) seleccionados.clear();

    }

    /**
     * Este método crea un botón en el menú que permite ir a la actividad anterior
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    private void customizaActionBar() {
        ActionBar actionBar = getSupportActionBar();

        //actionBar.setTitle(actionBar.getTitle()+" - Simbología");
        actionBar.setSubtitle("Elige una prenda");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case (R.id.imlav_vaqueros):
                seleccionados.add(1); //lav 30
                seleccionados.add(17); //no lejia
                seleccionados.add(27); //no ssecadora
                seleccionados.add(39); //plancha 1
                seleccionados.add(52); //no limpie seco
                prenda="Vaqueros"; //Enviamos la prenda al Resultado por si luego queremos guardar
                lanzarIntent();

                break;

            case (R.id.imlav_camiseta):
                seleccionados.add(1);
                seleccionados.add(17); //no lejia
                seleccionados.add(27);
                seleccionados.add(40);
                seleccionados.add(52);
                prenda="Camiseta";
                lanzarIntent();

                break;

            case (R.id.imlav_camisa):
                seleccionados.add(1);
                seleccionados.add(17); //no lejia
                seleccionados.add(22);
                seleccionados.add(40);
                seleccionados.add(47);
                prenda="Camisa";
                lanzarIntent();

                break;

            case (R.id.imlav_vestido):
                seleccionados.add(4);
                seleccionados.add(17); //no lejia
                seleccionados.add(27);
                seleccionados.add(30);
                seleccionados.add(39);
                seleccionados.add(47);
                prenda="Vestido";
                lanzarIntent();

                break;

            case (R.id.imlav_chaqueta):
                seleccionados.add(14);
                seleccionados.add(17); //no lejia
                seleccionados.add(27);
                seleccionados.add(34);
                seleccionados.add(40);
                seleccionados.add(56);
                prenda="Chaqueta";
                lanzarIntent();

                break;

            case (R.id.imlav_jersey):
                seleccionados.add(15);
                seleccionados.add(17); //no lejia
                seleccionados.add(27);
                seleccionados.add(35);
                seleccionados.add(39);
                seleccionados.add(47);
                prenda="Jersey";
                lanzarIntent();

                break;

            case (R.id.imlav_delicado):
                seleccionados.add(15);
                seleccionados.add(18); //no lejia
                seleccionados.add(27);
                seleccionados.add(30);
                seleccionados.add(35);
                seleccionados.add(37);
                seleccionados.add(52);
                prenda="Ropa delicada";
                lanzarIntent();

                break;

            case (R.id.imlav_deporte):
                seleccionados.add(2);
                seleccionados.add(17); //no lejia
                seleccionados.add(27);
                seleccionados.add(31);
                seleccionados.add(37);
                seleccionados.add(52);
                prenda="Ropa deportiva";
                lanzarIntent();

                break;

            case (R.id.imlav_zapatos):
                seleccionados.add(4);
                seleccionados.add(17); //no lejia
                seleccionados.add(27);
                seleccionados.add(37);
                seleccionados.add(52);
                prenda="Zapatos";
                lanzarIntent();

                break;



            /**
             * Botón float para ver los resultados
             */
            //case (R.id.float_button):

                /**
                 * IMPORTANTE
                 * Compruebo los radios que están activados justo antes de continuar.
                 * Se ha decidido así porque puede cambiarse de opinión de selección hasta el final
                 * (No puede utilizarse un forEach porque requiere la API 24 como mínimo)
                 */
                /*
                for (int i = 0; i<radios.size(); i++){
                    if(radios.get(i).isChecked()) seleccionados.add(i+1);
                }
                */


            default:
                break;

        }

    }

    private void lanzarIntent() {
        Intent resultado = new Intent(this, Resultado.class);
        resultado.putExtra("simbolosSeleccionados", seleccionados);
        resultado.putExtra("prenda", prenda);
        startActivity(resultado);

        /**
         *Sentencia que borra el array para que al darle a la flecha de volver desde Resultado,
         *no se muestren los antiguos si se seleccionan nuevos
         */
        seleccionados.clear();
        prenda="";
    }

}
