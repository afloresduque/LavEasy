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
import com.shashank.sony.fancytoastlib.FancyToast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.proyecto.laveasy.R;
import java.util.ArrayList;

/**
 * Clase que gestionará la interfaz principal
 */
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

    /**
     * Referenciamos la barra de menú superior
     * @param menu
     * @return
     */
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

    /**
     * Método que permite personalizar la barra de subtítulo
     */
    private void customizaActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("Te ayuda con el tratamiento de tu ropa");
    }

    /**
     * Método que gestiona la opción clicada del menú superior
     * @param icono
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem icono) {

        switch (icono.getItemId()){
            case R.id.accion_compartir:
                compartir();
                return true;

            default:
                return super.onOptionsItemSelected(icono);
        }
    }

    /**
     * Método que lanza las opciones de compartir de que dispone el dispositivo.
     * En este caso, se predefine el mensaje a enviar, aunque puede ser modificado.
     */
    private void compartir() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
        String mensaje = "Mira qué app más útil para no equivocarte cuando laves tu ropa:\n\n" +
                "LavEasy\n\n";

        /*
        Comento la siguiente línea porque mi app no está en play store
        mensaje = mensaje + "https://play.google.com/store/apps/details?id=" + getBaseContext().getPackageName();
        */

        // Se decide incluir el enlace a la apk subida a MEGA, para poder descargarla.
        mensaje = mensaje + "https://mega.nz/file/dNcghCCB#3eDI4nMsHR33Ilh7_3vCoJp7RHJRxHQg979k6qDUuj4";

        sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        // En API 26, la siguiente línea aparece como título al compartir.
        Intent shareIntent = Intent.createChooser(sendIntent, "Info de lavado: ");
        startActivity(shareIntent);
    }

    /**
     * Con este método recogemos el clicado en cada ImageButton o TextView correspondiente
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.imageButtonQR):
                buttonQR_click();
                break;

            case(R.id.imageButtonGrid):
                abrirSimbolos_click();
                break;

            case(R.id.textViewPrenda):
                abrirPrendas_click();
                break;

            default:
                break;
        }
    }

    /**
     * Lanzamos la activity Prendas para seleccionar la que nos interesa consultar
     */
    private void abrirPrendas_click() {
        Intent intent = new Intent(this, Prendas.class);
        startActivity(intent);
    }

    /**
     * Lanzamos la activity Simbolos para seleccionar los que nos interesa consultar
     */
    private void abrirSimbolos_click() {
        Intent intent = new Intent(this, Simbolos.class);
        startActivity(intent);
    }

    /**
     * Lanzamos la cámara para escanear el QR
     */
    private void buttonQR_click() {
        /*
         * En el build graddle implemento la api de ZXing
         * y en el manifest se configuran las líneas de la activity para portrait
         */
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Escanear el QR de la etiqueta");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(true);

        integrator.initiateScan();
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

                    /**
                     * En el caso de que los valores leídos del QR no sean válidos para la app
                     */
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
