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

/**
 * Clase que gestionará la interfaz de las prendas predefinidas
 */
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

    /**
     * Método que permite personalizar la barra de subtítulo
     */
    private void customizaActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("Elige una prenda");
    }

    /**
     * Con este método recogemos el clicado en cada ImageView correspondiente
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            /*
            Al clicar una prenda, se añade al array que se mandará por el bundle para consultar
            los valores de los símbolos que le corresponden a su etiqueta y se lanza el intent
            de Resultado, que nos mostrará la información consultada a la bdd.
             */
            case (R.id.imlav_vaqueros):
                seleccionados.add(1);
                seleccionados.add(17);
                seleccionados.add(27);
                seleccionados.add(39);
                seleccionados.add(52);
                prenda="Vaqueros"; //Se manda el tipo de prenda para luego añadir subtítulo
                lanzarIntent();
                break;

            case (R.id.imlav_camiseta):
                seleccionados.add(1);
                seleccionados.add(17);
                seleccionados.add(27);
                seleccionados.add(40);
                seleccionados.add(52);
                prenda="Camiseta";
                lanzarIntent();
                break;

            case (R.id.imlav_camisa):
                seleccionados.add(1);
                seleccionados.add(17);
                seleccionados.add(22);
                seleccionados.add(40);
                seleccionados.add(47);
                prenda="Camisa";
                lanzarIntent();
                break;

            case (R.id.imlav_vestido):
                seleccionados.add(4);
                seleccionados.add(17);
                seleccionados.add(27);
                seleccionados.add(30);
                seleccionados.add(39);
                seleccionados.add(47);
                prenda="Vestido";
                lanzarIntent();
                break;

            case (R.id.imlav_chaqueta):
                seleccionados.add(14);
                seleccionados.add(17);
                seleccionados.add(27);
                seleccionados.add(34);
                seleccionados.add(40);
                seleccionados.add(56);
                prenda="Chaqueta";
                lanzarIntent();
                break;

            case (R.id.imlav_jersey):
                seleccionados.add(15);
                seleccionados.add(17);
                seleccionados.add(27);
                seleccionados.add(35);
                seleccionados.add(39);
                seleccionados.add(47);
                prenda="Jersey";
                lanzarIntent();
                break;

            case (R.id.imlav_delicado):
                seleccionados.add(15);
                seleccionados.add(18);
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
                seleccionados.add(17);
                seleccionados.add(27);
                seleccionados.add(31);
                seleccionados.add(37);
                seleccionados.add(52);
                prenda="Ropa deportiva";
                lanzarIntent();
                break;

            case (R.id.imlav_zapatos):
                seleccionados.add(4);
                seleccionados.add(17);
                seleccionados.add(27);
                seleccionados.add(37);
                seleccionados.add(52);
                prenda="Zapatos";
                lanzarIntent();
                break;

            default:
                break;
        }
    }

    /**
     * Método que lanza la activity Resultado donde se mostrará la información obtenida de la bdd
     */
    private void lanzarIntent() {
        Intent resultado = new Intent(this, Resultado.class);
        resultado.putExtra("simbolosSeleccionados", seleccionados);
        resultado.putExtra("prenda", prenda);
        startActivity(resultado);

        /**
         *Borramos el array para que al darle a la flecha de volver desde Resultado,
         *no se muestren los antiguos si se seleccionan nuevos
         */
        seleccionados.clear();
        prenda="";
    }
}