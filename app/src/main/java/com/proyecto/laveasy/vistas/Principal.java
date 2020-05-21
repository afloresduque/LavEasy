package com.proyecto.laveasy.vistas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.shashank.sony.fancytoastlib.FancyToast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.proyecto.laveasy.R;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btQR;
    private ImageButton btGrid;
    private TextView textPrendas;
    final Activity activity = this;
    ArrayList<Integer> seleccionados = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        customizaActionBar();

        btQR = (ImageButton) findViewById(R.id.imageButtonQR);
        btGrid = (ImageButton) findViewById(R.id.imageButtonGrid);
        textPrendas = (TextView) findViewById(R.id.textViewPrenda);

        btQR.setOnClickListener(this);
        btGrid.setOnClickListener(this);
        textPrendas.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_inicio, menu);
        return true;
    }

    /**
     * Se personaliza para que termine todos los procesos y vuelva a lanzar la app
     * (de esta manera, evitamos que se quede en la SplashScreen)
     */
    @Override
    public void onBackPressed (){
            android.os.Process.killProcess(android.os.Process.myPid());
    }


    private void customizaActionBar() {
        ActionBar actionBar = getSupportActionBar();

        //actionBar.setTitle(actionBar.getTitle()+" - Simbología");
        actionBar.setSubtitle("Te ayuda con el tratamiento de tu ropa");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem simbolos) {

        switch (simbolos.getItemId()){
            case R.id.accion_compartir:
                //Toast.makeText(getBaseContext(),"Compartiendo app", Toast.LENGTH_SHORT).show();
                compartir();
                return true;

            default:
                return super.onOptionsItemSelected(simbolos);
        }
    }

    private void compartir() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
        String mensaje = "Mira qué app más útil para no equivocarte cuando laves tu ropa:\n\n" +
                "LavEasy\n";

        //Comento la siguiente línea porque mi app no está en play store
        //mensaje = mensaje + "https://play.google.com/store/apps/details?id=" + getBaseContext().getPackageName();

        //Incluyo código de una app que sí está en play store
        mensaje = mensaje + "https://play.google.com/store/apps/details?id=com.phuongpn.emptyfoldercleaner&hl=es_419";

        sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        //En API 26 aparece como título al compartir.
        Intent shareIntent = Intent.createChooser(sendIntent, "Info de lavado: ");
        startActivity(shareIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.imageButtonQR):
                buttonQR_click();
                break;

            case(R.id.imageButtonGrid):

                /*
                video miuto 3,50 para ver clicado y desclicado del boton
                https://www.youtube.com/watch?v=atesSu0DT3o

                video para grid de botones
                https://www.youtube.com/watch?v=vlpPy7K2e_Y
                 */

                abrirSimbolos_click();
                break;

            case(R.id.textViewPrenda):
                abrirPrendas_click();

            default:
                break;
        }

    }

    private void abrirPrendas_click() {
        Intent intent = new Intent(this, Prendas.class);
        startActivity(intent);
    }

    private void abrirSimbolos_click() {
        Intent intent = new Intent(this, Simbolos.class);
        startActivity(intent);
    }

    private void buttonQR_click() {
        /*
         * en el build graddle meto las dos lineas que implementan la api de zxing
         * y en el manifest se configuran las líneas de la activity para portrait, ya añadido
         * en borrador en el proyecto
         */
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Escanear el QR de la etiqueta");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(true);

        //integrator.setOrientationLocked(true);
        //integrator.setCaptureActivity (CaptureActivity.class);
        //integrator.setScanningRectangle(500,500);
        //integrator.setBarcodeImageEnabled(false);


        integrator.initiateScan();

        /*
        Intent intent = new Intent(getApplicationContext(),CapturaQrActivity.class);
        intent.setAction("com.google.zxing.client.android.SCAN");
        //Para guardar un historial de scaneado
        intent.putExtra("SAVE_HISTORY", false);
        startActivityForResult(intent,0);
        */



    }

    /**
     * Este método se ejecuta al volver del lector de QR
     * @param requestCode
     * @param resultCode
     * @param data
     */
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null){
            /**
             * Si cancelamos sin escanear
             */
            if(result.getContents()==null){
                FancyToast.makeText(this,"Has cancelado el escaneo", FancyToast.LENGTH_SHORT, FancyToast.INFO, false).show();
            }
            /**
             * Si escaneamos un QR
             */
            else {
                //Toast.makeText(this,result.getContents(),Toast.LENGTH_SHORT).show();
                String lectura = result.getContents();

                try{
                    /**
                     * Extrae los valores separados por espacio y los almacena en un array
                     */
                    String[] valores = lectura.split(" ");
                    for (int i = 0; i<valores.length;i++){
                        seleccionados.add(Integer.parseInt(valores[i]));
                    }

                    /**
                     * Lanza la activity de Resultado adjuntando el array de los seleccionados
                     */
                    Intent resultado = new Intent(this, Resultado.class);
                    resultado.putExtra("simbolosSeleccionados", seleccionados);
                    resultado.putExtra("prenda", "Lectura de QR");
                    startActivity(resultado);

                } catch (Exception e) {
                    FancyToast.makeText(this,"   Error al leer la etiqueta\n" +
                            "No contiene datos válidos", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                }

            }
        }
        else {
            super.onActivityResult(requestCode,resultCode,data);
        }

    }
}
