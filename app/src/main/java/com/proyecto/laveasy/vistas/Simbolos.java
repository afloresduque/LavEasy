package com.proyecto.laveasy.vistas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.proyecto.laveasy.R;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;


public class Simbolos extends AppCompatActivity implements View.OnClickListener {

    RadioButton rblav1, rblav2, rblav3, rblav4, rblav5, rblav6, rblav7, rblav8, rblav9, rblav10,
        rblav11, rblav12, rblav13,rblav14, rblav15, rblav16, rblav17, rblav18, rblav19, rblav20,
        rblav21, rblav22, rblav23,rblav24, rblav25, rblav26, rblav27, rblav28, rblav29, rblav30,
        rblav31, rblav32, rblav33, rblav34, rblav35, rblav36, rblav37, rblav38, rblav39, rblav40,
        rblav41, rblav42, rblav43, rblav44, rblav45, rblav46, rblav47, rblav48, rblav49, rblav50,
            rblav51, rblav52, rblav53, rblav54, rblav55, rblav56;


    RadioGroup rglav1, rglav2, rglav3,rglav4, rglav5, rglav6, rglav7, rglav8, rglav9, rglav10,
            rglav11, rglav12, rglav13, rglav14, rglav15, rglav16, rglav17, rglav18, rglav19;

    TextView txvBorrar;
    ImageView imagenBorrar;
    FloatingActionButton float_button;

    ArrayList<Integer> seleccionados = new ArrayList<>();
    ArrayList<RadioButton> radios;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simbolos_float);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        customizaActionBar();
        if(seleccionados.size()>0) seleccionados.clear();

        //LAVADO
        //Radios de Lavado, Lejia, Secado, Planchado, Limpieza en seco
        rblav1 = findViewById(R.id.rblav1);
        rblav2 = findViewById(R.id.rblav2);
        rblav3 = findViewById(R.id.rblav3);
        rblav4 = findViewById(R.id.rblav4);
        rblav5 = findViewById(R.id.rblav5);
        rblav6 = findViewById(R.id.rblav6);
        rblav7 = findViewById(R.id.rblav7);
        rblav8 = findViewById(R.id.rblav8);
        rblav9 = findViewById(R.id.rblav9);
        rblav10 = findViewById(R.id.rblav10);
        rblav11 = findViewById(R.id.rblav11);
        rblav12 = findViewById(R.id.rblav12);
        rblav13 = findViewById(R.id.rblav13);
        rblav14 = findViewById(R.id.rblav14);
        rblav15 = findViewById(R.id.rblav15);

        rblav16 = findViewById(R.id.rblav16);
        rblav17 = findViewById(R.id.rblav17);
        rblav18 = findViewById(R.id.rblav18);

        rblav19 = findViewById(R.id.rblav19);
        rblav20 = findViewById(R.id.rblav20);
        rblav21 = findViewById(R.id.rblav21);
        rblav22 = findViewById(R.id.rblav22);
        rblav23 = findViewById(R.id.rblav23);
        rblav24 = findViewById(R.id.rblav24);
        rblav25 = findViewById(R.id.rblav25);
        rblav26 = findViewById(R.id.rblav26);
        rblav27 = findViewById(R.id.rblav27);
        rblav28 = findViewById(R.id.rblav28);
        rblav29 = findViewById(R.id.rblav29);
        rblav30 = findViewById(R.id.rblav30);
        rblav31 = findViewById(R.id.rblav31);
        rblav32 = findViewById(R.id.rblav32);
        rblav33 = findViewById(R.id.rblav33);
        rblav34 = findViewById(R.id.rblav34);
        rblav35 = findViewById(R.id.rblav35);

        rblav36 = findViewById(R.id.rblav36);
        rblav37 = findViewById(R.id.rblav37);
        rblav38 = findViewById(R.id.rblav38);
        rblav39 = findViewById(R.id.rblav39);
        rblav40 = findViewById(R.id.rblav40);
        rblav41 = findViewById(R.id.rblav41);
        rblav42 = findViewById(R.id.rblav42);
        rblav43 = findViewById(R.id.rblav43);
        rblav44 = findViewById(R.id.rblav44);

        rblav45 = findViewById(R.id.rblav45);
        rblav46 = findViewById(R.id.rblav46);
        rblav47 = findViewById(R.id.rblav47);
        rblav48 = findViewById(R.id.rblav48);
        rblav49 = findViewById(R.id.rblav49);
        rblav50 = findViewById(R.id.rblav50);
        rblav51 = findViewById(R.id.rblav51);
        rblav52 = findViewById(R.id.rblav52);
        rblav53 = findViewById(R.id.rblav53);
        rblav54 = findViewById(R.id.rblav54);
        rblav55 = findViewById(R.id.rblav55);
        rblav56 = findViewById(R.id.rblav56);

        //Creo un array de los radios para poder comprobar al pulsar buscar, los que siguen activos
        radios= new ArrayList<RadioButton>(){
            {
                add(rblav1);
                add(rblav2);
                add(rblav3);
                add(rblav4);
                add(rblav5);
                add(rblav6);
                add(rblav7);
                add(rblav8);
                add(rblav9);
                add(rblav10);
                add(rblav11);
                add(rblav12);
                add(rblav13);
                add(rblav14);
                add(rblav15);
                add(rblav16);
                add(rblav17);
                add(rblav18);
                add(rblav19);
                add(rblav20);
                add(rblav21);
                add(rblav22);
                add(rblav23);
                add(rblav24);
                add(rblav25);
                add(rblav26);
                add(rblav27);
                add(rblav28);
                add(rblav29);
                add(rblav30);
                add(rblav31);
                add(rblav32);
                add(rblav33);
                add(rblav34);
                add(rblav35);
                add(rblav36);
                add(rblav37);
                add(rblav38);
                add(rblav39);
                add(rblav40);
                add(rblav41);
                add(rblav42);
                add(rblav43);
                add(rblav44);
                add(rblav45);
                add(rblav46);
                add(rblav47);
                add(rblav48);
                add(rblav49);
                add(rblav50);
                add(rblav51);
                add(rblav52);
                add(rblav53);
                add(rblav54);
                add(rblav55);
                add(rblav56);
            }
        };


        //Radiogroups de Lavado, Lejia, Secado, Planchado, Limpieza en seco
        rglav1 = findViewById(R.id.rglav1);
        rglav2 = findViewById(R.id.rglav2);
        rglav3 = findViewById(R.id.rglav3);
        rglav4 = findViewById(R.id.rglav4);
        rglav5 = findViewById(R.id.rglav5);

        rglav6 = findViewById(R.id.rglav6);

        rglav7 = findViewById(R.id.rglav7);
        rglav8 = findViewById(R.id.rglav8);
        rglav9 = findViewById(R.id.rglav9);
        rglav10 = findViewById(R.id.rglav10);
        rglav11 = findViewById(R.id.rglav11);
        rglav12 = findViewById(R.id.rglav12);

        rglav13 = findViewById(R.id.rglav13);
        rglav14 = findViewById(R.id.rglav14);
        rglav15 = findViewById(R.id.rglav15);

        rglav16 = findViewById(R.id.rglav16);
        rglav17 = findViewById(R.id.rglav17);
        rglav18 = findViewById(R.id.rglav18);
        rglav19 = findViewById(R.id.rglav19);

        //Texto e imagen de borrar selección y float de actividad Resultado
        txvBorrar = findViewById(R.id.textViewBorrar);
        imagenBorrar = findViewById(R.id.imageViewBorrar);
        float_button = findViewById(R.id.float_button);

        //Referencias para método onClick de Lavado, Lejia, Secado, Planchado, Limpieza en seco
        rblav1.setOnClickListener(this);
        rblav2.setOnClickListener(this);
        rblav3.setOnClickListener(this);
        rblav4.setOnClickListener(this);
        rblav5.setOnClickListener(this);
        rblav6.setOnClickListener(this);
        rblav7.setOnClickListener(this);
        rblav8.setOnClickListener(this);
        rblav9.setOnClickListener(this);
        rblav10.setOnClickListener(this);
        rblav11.setOnClickListener(this);
        rblav12.setOnClickListener(this);
        rblav13.setOnClickListener(this);
        rblav14.setOnClickListener(this);
        rblav15.setOnClickListener(this);

        rblav16.setOnClickListener(this);
        rblav17.setOnClickListener(this);
        rblav18.setOnClickListener(this);

        rblav19.setOnClickListener(this);
        rblav20.setOnClickListener(this);
        rblav21.setOnClickListener(this);
        rblav22.setOnClickListener(this);
        rblav23.setOnClickListener(this);
        rblav24.setOnClickListener(this);
        rblav25.setOnClickListener(this);
        rblav26.setOnClickListener(this);
        rblav27.setOnClickListener(this);
        rblav28.setOnClickListener(this);
        rblav29.setOnClickListener(this);
        rblav30.setOnClickListener(this);
        rblav31.setOnClickListener(this);
        rblav32.setOnClickListener(this);
        rblav33.setOnClickListener(this);
        rblav34.setOnClickListener(this);
        rblav35.setOnClickListener(this);

        rblav36.setOnClickListener(this);
        rblav37.setOnClickListener(this);
        rblav38.setOnClickListener(this);
        rblav39.setOnClickListener(this);
        rblav40.setOnClickListener(this);
        rblav41.setOnClickListener(this);
        rblav42.setOnClickListener(this);
        rblav43.setOnClickListener(this);
        rblav44.setOnClickListener(this);

        rblav45.setOnClickListener(this);
        rblav46.setOnClickListener(this);
        rblav47.setOnClickListener(this);
        rblav48.setOnClickListener(this);
        rblav49.setOnClickListener(this);
        rblav50.setOnClickListener(this);
        rblav51.setOnClickListener(this);
        rblav52.setOnClickListener(this);
        rblav53.setOnClickListener(this);
        rblav54.setOnClickListener(this);
        rblav55.setOnClickListener(this);
        rblav56.setOnClickListener(this);

        txvBorrar.setOnClickListener(this);
        imagenBorrar.setOnClickListener(this);
        float_button.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_simbolos, menu);
        return true;
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
        actionBar.setSubtitle("Elige los símbolos");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem simbolos) {

        switch (simbolos.getItemId()){
            case R.id.accion_borrar:
                borrarSeleccion();
                return true;

            default:
                return super.onOptionsItemSelected(simbolos);
        }
    }

    @Override
    public void onClick(View v) {
        //boolean clicado = v.isActivated();


        switch (v.getId()) {

            //Clicado en símbolos de lavado
            case (R.id.imlav1):   //Si clicamos la imagen correspondiente
            case (R.id.rblav1):   //Si clicamos el radio correspondiente
                rblav1.toggle();  //Se activa el radio
                //seleccionados.add(1);

                rglav2.clearCheck(); //Se desactivan todos los radios de los demás radiogroups
                rglav3.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                /*iv1.setSelected(!bt1.isSelected());
                if (clicado){
                //btGrid.setActivated(true);
                    bt1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
                 else bt1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                //btGrid.setActivated(false);
                //buttonQR_click();
                */
                break;

            case (R.id.imlav2):
            case (R.id.rblav2):
                rblav2.toggle();
                //seleccionados.add(2);

                rglav2.clearCheck();
                rglav3.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                //buttonGRID_click();
                //Toast toast1 = Toast.makeText(getApplicationContext(),"Toast por defecto", Toast.LENGTH_SHORT);
                //toast1.show();
                break;

            /*case (R.id.button):
                //Log.d("prueba", String.valueOf(rb1.isChecked()));
                switch (rg1.getCheckedRadioButtonId()){

                    case R.id.rb1:
                        Toast.makeText(this,"has clicado el rb1", Toast.LENGTH_SHORT);
                        break;
                    case R.id.rb2:
                        Toast.makeText(this,"has clicado el rb2", Toast.LENGTH_SHORT);
                        break;
                    case R.id.rb3:
                        Toast.makeText(this,"has clicado el rb3", Toast.LENGTH_SHORT);
                        break;
                }
                break;
*/

            case (R.id.imlav3):
            case (R.id.rblav3):
                rblav3.toggle();
                //seleccionados.add(3);

                rglav2.clearCheck();
                rglav3.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav4):
            case (R.id.rblav4):
                rblav4.toggle();
                //seleccionados.add(4);

                rglav1.clearCheck();
                rglav3.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav5):
            case (R.id.rblav5):
                rblav5.toggle();
                //seleccionados.add(5);

                rglav1.clearCheck();
                rglav3.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav6):
            case (R.id.rblav6):
                rblav6.toggle();
                //seleccionados.add(6);

                rglav1.clearCheck();
                rglav3.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav7):
            case (R.id.rblav7):
                rblav7.toggle();
                //seleccionados.add(7);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav8):
            case (R.id.rblav8):
                rblav8.toggle();
                //seleccionados.add(8);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav9):
            case (R.id.rblav9):
                rblav9.toggle();
                //seleccionados.add(9);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav4.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav10):
            case (R.id.rblav10):
                rblav10.toggle();
                //seleccionados.add(10);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav3.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav11):
            case (R.id.rblav11):
                rblav11.toggle();
                //seleccionados.add(11);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav3.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav12):
            case (R.id.rblav12):
                rblav12.toggle();
                //seleccionados.add(12);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav3.clearCheck();
                rglav5.clearCheck();

                break;

            case (R.id.imlav13):
            case (R.id.rblav13):
                rblav13.toggle();
                //seleccionados.add(13);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav4.clearCheck();
                rglav3.clearCheck();

                break;

            case (R.id.imlav14):
            case (R.id.rblav14):
                rblav14.toggle();
                //seleccionados.add(14);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav4.clearCheck();
                rglav3.clearCheck();

                break;

            case (R.id.imlav15):
            case (R.id.rblav15):
                rblav15.toggle();
                //seleccionados.add(15);

                rglav2.clearCheck();
                rglav1.clearCheck();
                rglav4.clearCheck();
                rglav3.clearCheck();

                break;

            case (R.id.imlav16):
            case (R.id.rblav16):
                rblav16.toggle();
                //seleccionados.add(16);

                break;

            case (R.id.imlav17):
            case (R.id.rblav17):
                rblav17.toggle();
                //seleccionados.add(17);

                break;

            case (R.id.imlav18):
            case (R.id.rblav18):
                rblav18.toggle();
                //seleccionados.add(18);

                break;

            case (R.id.imlav19):
            case (R.id.rblav19):
                rblav19.toggle();
                //seleccionados.add(19);

                rglav12.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav20):
            case (R.id.rblav20):
                rblav20.toggle();
                // seleccionados.add(20);

                rglav12.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav21):
            case (R.id.rblav21):
                rblav21.toggle();
                //seleccionados.add(21);

                rglav12.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav22):
            case (R.id.rblav22):
                rblav22.toggle();
                //seleccionados.add(22);

                rglav7.clearCheck();
                rglav12.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav23):
            case (R.id.rblav23):
                rblav23.toggle();
                //seleccionados.add(23);

                rglav7.clearCheck();
                rglav12.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav24):
            case (R.id.rblav24):
                rblav24.toggle();
                //seleccionados.add(24);

                rglav7.clearCheck();
                rglav12.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav25):
            case (R.id.rblav25):
                rblav25.toggle();
                //seleccionados.add(25);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav12.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav26):
            case (R.id.rblav26):
                rblav26.toggle();
                //seleccionados.add(26);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav12.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav27):
            case (R.id.rblav27):
                rblav27.toggle();
                //seleccionados.add(27);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav12.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav29):
            case (R.id.rblav28):
                rblav28.toggle();
                //seleccionados.add(28);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav12.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav30):
            case (R.id.rblav29):
                rblav29.toggle();
                //seleccionados.add(29);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav12.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav31):
            case (R.id.rblav30):
                rblav30.toggle();
                //seleccionados.add(30);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav11.clearCheck();
                rglav12.clearCheck();

                break;

            case (R.id.imlav32):
            case (R.id.rblav31):
                rblav31.toggle();
                //seleccionados.add(31);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav12.clearCheck();

                break;

            case (R.id.imlav33):
            case (R.id.rblav32):
                rblav32.toggle();
                //seleccionados.add(32);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav12.clearCheck();

                break;

            case (R.id.imlav34):
            case (R.id.rblav33):
                rblav33.toggle();
                //seleccionados.add(33);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav12.clearCheck();

                break;

            case (R.id.imlav35):
            case (R.id.rblav34):
                rblav34.toggle();
                //seleccionados.add(34);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav36):
            case (R.id.rblav35):
                rblav35.toggle();
                //seleccionados.add(35);

                rglav7.clearCheck();
                rglav8.clearCheck();
                rglav9.clearCheck();
                rglav10.clearCheck();
                rglav11.clearCheck();

                break;

            case (R.id.imlav37):
            case (R.id.rblav36):
                rblav36.toggle();
                //seleccionados.add(36);

                rglav14.clearCheck();
                rglav15.clearCheck();


                break;

            case (R.id.imlav38):
            case (R.id.rblav37):
                rblav37.toggle();
                //seleccionados.add(37);

                rglav14.clearCheck();
                rglav15.clearCheck();

                break;

            case (R.id.imlav39):
            case (R.id.rblav38):
                rblav38.toggle();
                //seleccionados.add(38);

                rglav14.clearCheck();
                rglav15.clearCheck();

                break;

            case (R.id.imlav40):
            case (R.id.rblav39):
                rblav39.toggle();
                //seleccionados.add(39);

                rglav13.clearCheck();
                rglav15.clearCheck();

                break;

            case (R.id.imlav41):
            case (R.id.rblav40):
                rblav40.toggle();
                //seleccionados.add(40);

                rglav13.clearCheck();
                rglav15.clearCheck();

                break;

            case (R.id.imlav42):
            case (R.id.rblav41):
                rblav41.toggle();
                //seleccionados.add(41);

                rglav13.clearCheck();
                rglav15.clearCheck();

                break;

            case (R.id.imlav43):
            case (R.id.rblav42):
                rblav42.toggle();
                //seleccionados.add(42);

                rglav13.clearCheck();
                rglav14.clearCheck();

                break;

            case (R.id.imlav44):
            case (R.id.rblav43):
                rblav43.toggle();
                //seleccionados.add(43);

                rglav13.clearCheck();
                rglav14.clearCheck();

                break;

            case (R.id.imlav45):
            case (R.id.rblav44):
                rblav44.toggle();
                //seleccionados.add(44);

                rglav13.clearCheck();
                rglav14.clearCheck();

                break;

            case (R.id.imlav46):
            case (R.id.rblav45):
                rblav45.toggle();
                //seleccionados.add(45);

                rglav17.clearCheck();
                rglav18.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav47):
            case (R.id.rblav46):
                rblav46.toggle();
                //seleccionados.add(46);

                rglav17.clearCheck();
                rglav18.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav48):
            case (R.id.rblav47):
                rblav47.toggle();
                //seleccionados.add(47);

                rglav17.clearCheck();
                rglav18.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav49):
            case (R.id.rblav48):
                rblav48.toggle();
                //seleccionados.add(48);

                rglav16.clearCheck();
                rglav18.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav50):
            case (R.id.rblav49):
                rblav49.toggle();
                //seleccionados.add(49);

                rglav16.clearCheck();
                rglav18.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav51):
            case (R.id.rblav50):
                rblav50.toggle();
                //seleccionados.add(50);

                rglav16.clearCheck();
                rglav18.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav52):
            case (R.id.rblav51):
                rblav51.toggle();
                //seleccionados.add(51);

                rglav16.clearCheck();
                rglav17.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav53):
            case (R.id.rblav52):
                rblav52.toggle();
                //seleccionados.add(52);

                rglav16.clearCheck();
                rglav17.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav54):
            case (R.id.rblav53):
                rblav53.toggle();
                //seleccionados.add(53);

                rglav16.clearCheck();
                rglav17.clearCheck();
                rglav19.clearCheck();

                break;

            case (R.id.imlav55):
            case (R.id.rblav54):
                rblav54.toggle();
                //seleccionados.add(54);

                rglav16.clearCheck();
                rglav17.clearCheck();
                rglav18.clearCheck();

                break;

            case (R.id.imlav56):
            case (R.id.rblav55):
                rblav55.toggle();
                //seleccionados.add(55);

                rglav16.clearCheck();
                rglav17.clearCheck();
                rglav18.clearCheck();

                break;

            case (R.id.imlav57):
            case (R.id.rblav56):
                rblav56.toggle();
                //seleccionados.add(56);

                rglav16.clearCheck();
                rglav17.clearCheck();
                rglav18.clearCheck();

                break;


            /**
             * Deselecciona todos los seleccionados
             */
            case (R.id.textViewBorrar):
            case (R.id.imageViewBorrar):
                borrarSeleccion();
                break;


            /**
             * Botón float para ver los resultados
             */
            case (R.id.float_button):

                /**
                 * IMPORTANTE
                 * Compruebo los radios que están activados justo antes de continuar.
                 * Se ha decidido así porque puede cambiarse de opinión de selección hasta el final
                 * (No puede utilizarse un forEach porque requiere la API 24 como mínimo)
                 */

                for (int i = 0; i<radios.size(); i++){
                    if(radios.get(i).isChecked()) seleccionados.add(i+1);
                }

                Intent resultado = new Intent(this, Resultado.class);
                resultado.putExtra("simbolosSeleccionados", seleccionados);
                resultado.putExtra("prenda", " ");
                startActivity(resultado);


                /**
                *Sentencia que borra el array para que al darle a la flecha de volver desde Resultado,
                *no se muestren los antiguos si se seleccionan nuevos
                */
                seleccionados.clear();
                borrarRadioGroups();

            default:
                break;

        }

    }

    private void borrarSeleccion() {
        borrarRadioGroups();
        seleccionados.clear();
        FancyToast.makeText(this,"Selección borrada", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,false).show();
    }

    private void borrarRadioGroups() {
        rglav1.clearCheck();
        rglav2.clearCheck();
        rglav3.clearCheck();
        rglav4.clearCheck();
        rglav5.clearCheck();
        rglav6.clearCheck();
        rglav7.clearCheck();
        rglav8.clearCheck();
        rglav9.clearCheck();
        rglav10.clearCheck();
        rglav11.clearCheck();
        rglav12.clearCheck();
        rglav13.clearCheck();
        rglav14.clearCheck();
        rglav15.clearCheck();
        rglav16.clearCheck();
        rglav17.clearCheck();
        rglav18.clearCheck();
        rglav19.clearCheck();
    }
}



/*public class Filtrar extends AppCompatActivity {

    CheckBox checkDrama,checkCiencia,checkComedia,checkHistorica,checkTerror,checkSuspense,checkAccion,checkAventuras;
    ArrayList<String> generosFiltrados = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_filtrar);


        checkDrama = (CheckBox) findViewById(R.id.cbDrama);
        checkCiencia = (CheckBox) findViewById(R.id.cbCiencia);
        checkComedia = (CheckBox) findViewById(R.id.cbComedia);
        checkHistorica = (CheckBox) findViewById(R.id.cbHistorica);
        checkTerror = (CheckBox) findViewById(R.id.cbTerror);
        checkSuspense = (CheckBox) findViewById(R.id.cbSuspense);
        checkAccion = (CheckBox) findViewById(R.id.cbAccion);
        checkAventuras = (CheckBox) findViewById(R.id.cbAventuras);


    }
    public void btValidar_onClick(View v){

        Intent intentGeneros = new Intent();

        validar();

        intentGeneros.putExtra("generos",generosFiltrados);
        setResult(Activity.RESULT_OK, intentGeneros);
        finish();
    }

    private void validar(){
        if(checkDrama.isChecked()){
            generosFiltrados.add("Drama");
        }
        if(checkCiencia.isChecked()){
            generosFiltrados.add("Ciencia-ficción");
        }
        if(checkComedia.isChecked()){
            generosFiltrados.add("Comedia");
        }
        if(checkHistorica.isChecked()){
            generosFiltrados.add("Histórica");
        }
        if(checkTerror.isChecked()){
            generosFiltrados.add("Terror");
        }
        if(checkSuspense.isChecked()){
            generosFiltrados.add("Suspense");
        }
        if(checkAccion.isChecked()){
            generosFiltrados.add("Acción");
        }
        if(checkAventuras.isChecked()){
            generosFiltrados.add("Aventuras");
        }
    }
}*/
