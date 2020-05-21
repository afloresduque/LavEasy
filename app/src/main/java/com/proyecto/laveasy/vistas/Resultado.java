package com.proyecto.laveasy.vistas;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.shashank.sony.fancytoastlib.FancyToast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.laveasy.AdaptadorSimbolos;
import com.proyecto.laveasy.R;
import com.proyecto.laveasy.SimboloO;
import com.proyecto.laveasy.Utilidades;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class Resultado extends AppCompatActivity {

    HttpClient httpClient = new DefaultHttpClient(); //para REST
    RecyclerView recyclerSimbolos;
    AdaptadorSimbolos adapter;
    ArrayList<SimboloO> listaSimbolos = new ArrayList<>();
    ArrayList<Integer> seleccionados = new ArrayList<>();
    boolean encontrado = false;
    String prenda=" ";

    //directorio donde se va a guardar la foto
    private final String CARPETA_RAIZ="/misCapturas_LavEasy/";
    private final String RUTA_IMAGEN=CARPETA_RAIZ+"misCapturas";
    String path="";

    //Necesario pedirlos a partir de la API 23
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    protected void onCreate(Bundle savedInstanceState) {
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Recupero el array de los simbolos seleccionados
        seleccionados = getIntent().getIntegerArrayListExtra("simbolosSeleccionados");

        //Recupero el origen de la consulta para configurar el subtítulo
        prenda = getIntent().getStringExtra("prenda");

        if (seleccionados.isEmpty()) {
            // Log.d("encontrado", String.valueOf(encontrado));
            //Log.d("encontrado", String.valueOf(listaSimbolos.size()));
            FancyToast.makeText(this, "No ha seleccionado ningún símbolo", FancyToast.LENGTH_SHORT, FancyToast.INFO,false).show();
            //finish();

        }


        /**
         * Establecer botón de retroceso y personalizar título de barra superior
         */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        customizaActionBar();


        /**
         * Si en la pantalla Simbolos no seleccionamos ninguno, no se consulta y vuelve a Simbolos
         */
        if (!seleccionados.isEmpty()) {
            construirRecycler();
        }else{
            onSupportNavigateUp();
        }

    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    /*private void validaPermisos() {

            if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            }
            if((checkSelfPermission(CAMERA)== PackageManager.PERMISSION_GRANTED)&&
                    (checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            }
            if((shouldShowRequestPermissionRationale(CAMERA)) ||
                    (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))){
            }else{
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }

    }*/
/*

      Método para corregir los fallos por la vulnerabilidad de SSL

    private void upgradeSecurityProvider() {
        try {
            ProviderInstaller.installIfNeeded(getApplicationContext());
            SSLContext sslContext;
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);
            sslContext.createSSLEngine();
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException
                | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }



        try {
            ProviderInstaller.installIfNeeded(this);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }



         ProviderInstaller.installIfNeededAsync(this, new ProviderInstaller.ProviderInstallListener() {
            @Override
            public void onProviderInstalled() {
            }
            @Override
            public void onProviderInstallFailed(int i, Intent recoveryIntent) {
                GoogleApiAvailability.getInstance().showErrorNotification(Resultado.this, i);
            }
        });
    }*/

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

        if(prenda.equals(" ")){
            actionBar.setSubtitle("¿Qué debo hacer?");

        }else if(prenda.equals("Lectura de QR")){
            actionBar.setSubtitle(prenda);

        }else{
        actionBar.setSubtitle(prenda);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_resultado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem simbolos) {

        switch (simbolos.getItemId()){
            case R.id.accion_guardar:
                comprobar();
                return true;

            case R.id.accion_compartir:
                compartir();
                return true;

            case R.id.accion_correo:
                enviarCorreo();
                return true;

            case R.id.accion_web:
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://es.wikipedia.org/wiki/Simbolo_de_lavado"));
                startActivity(webIntent);
                return true;

            default:
                return super.onOptionsItemSelected(simbolos);
        }
    }

    private void comprobar() {
        //CharSequence[] opciones={"Guardar","Cancelar"};
        AlertDialog.Builder alertOpciones=new AlertDialog.Builder(this);
        alertOpciones.setMessage("¿Seguro que quiere guardar el resultado?")
                .setCancelable(false)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                        noGuardar();

                    }
                })

                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        guardar();

                    }
                });
        alertOpciones.show();
    }

    private void noGuardar() {
        FancyToast.makeText(this,"Captura cancelada", FancyToast.LENGTH_SHORT, FancyToast.WARNING,false).show();
    }

    private void guardar() {
        verifyStoragePermissions(this);
        Log.d("perisos", String.valueOf(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)));
        Log.d("perisos", String.valueOf(PackageManager.PERMISSION_GRANTED));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmm", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);

        try {

            //este file es para crear la ruta
            File fileImagen = new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);

            boolean isCreada = fileImagen.exists();
            Log.d("llega", String.valueOf(fileImagen.exists()));
            String nombreImagen="";

            //Para que tenga en cuenta si la ruta estaba creada o no
            if(!isCreada){
                isCreada = fileImagen.mkdirs();
                Log.d("llega", String.valueOf(fileImagen.exists()));
            }

            if(isCreada){
                nombreImagen = (fecha) + ".jpg";
                //nombreImagen = (System.currentTimeMillis()/1000) + ".jpg";
            }

            path = Environment.getExternalStorageDirectory() + File.separator +
                    RUTA_IMAGEN + File.separator + nombreImagen;

            //este file es para crear el propio archivo
            File imagen = new File(path);


            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            FileOutputStream outputStream = new FileOutputStream(imagen);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            FancyToast.makeText(this,"Captura guardada en\n'misCapturas_LavEasy'", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,false).show();


        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }

    private void compartir() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        String mensaje = "App útil para lavar correctamente:\n\n" +
                getString(R.string.app_name)+
                "\nhttps://play.google.com/store/apps/details?id=com.phuongpn.emptyfoldercleaner&hl=es_419";
                //"\nLa app que te dice cómo lavar tus prendas";

        sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        //En API 26 aparece como título al compartir.
        Intent shareIntent = Intent.createChooser(sendIntent, "Info de lavado: ");
        startActivity(shareIntent);
    }

    private void enviarCorreo() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        //Asunto del mensaje
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ya puedo lavar mi ropa sin miedo");
        //Descripcion del mensaje
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Mira qué útil para lavar:\n\n" +
                getString(R.string.app_name)+
                "\nLa app que te dice cómo lavar tus prendas");
        startActivity(emailIntent);
    }

    /**
     * Método que se encarga de rellenar el recycler con los datos que extrae de la BDD
     */
    private void construirRecycler() {

        //Vinculo el recycler de la interfaz
        recyclerSimbolos = findViewById(R.id.RecyclerId);
        recyclerSimbolos.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdaptadorSimbolos(listaSimbolos);
        recyclerSimbolos.setAdapter(adapter);
        obtenerLaLista();
    }

    private void obtenerLaLista() {

        //OPCION 1
        //Se obtienen todos, se comparan, se lanza al adapter
        ConseguirTodosSimbolos selecSimbolos = new ConseguirTodosSimbolos(this);
        selecSimbolos.execute();


        //OPCION 2
        //Se consultan de uno en uno los seleccionados y se añaden a la lista
        /*
         ObtenSimbolo selecSimbolos2 = new ObtenSimbolo(this);

         for(int s = 0; s < seleccionados.size(); s++ ){
            selecSimbolos2.execute(seleccionados.get(s));

         }

        adapter.setListaSimbolos(listaSimbolos);
        adapter.notifyDataSetChanged();
        */

    }

    //************
    //OPCION 1
    //Se consultan todos
    //Cuando se tenga un objeto json, comprobar con un for con los seleccionados
    //************

    private class ConseguirTodosSimbolos extends AsyncTask<String, Integer, ArrayList<SimboloO>> {

        ProgressDialog pdialog;
        Context context;
        int response_code = 0;


        public ConseguirTodosSimbolos(Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            pdialog = new ProgressDialog(context);
            pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pdialog.setMessage("Obteniendo del servicio...");
            pdialog.setMax(100);
            pdialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pdialog.setProgress(values[0]);
        }

        @Override
        protected ArrayList<SimboloO> doInBackground(String... strings) {
            String strRespuesta= "";
            ArrayList<SimboloO> listResultante = new ArrayList<>();
            //listResultante.add(new SimboloO(0, "Cargando...",null));

            try {
                URL url = new URL(Utilidades.DIRECCION_REST_PYTHON + Utilidades.POST_GET_ALL);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                conexion.setDoInput(true);
                conexion.setRequestMethod("GET");
                conexion.setRequestProperty("Content-Type", "application/json");
                response_code = conexion.getResponseCode();
                Log.e("code", String.valueOf(response_code));


                publishProgress(20);


                //Si obtiene respuesta correcta
                if (response_code == HttpURLConnection.HTTP_OK) {

                    //Extraemos la respuesta del servidor
                    String linea;
                    BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                    while ((linea=br.readLine()) != null) {
                        strRespuesta += linea;
                    }

                    publishProgress(40);

                    JSONArray jsonArray = new JSONArray(strRespuesta);

                    SimboloO simbolo = null;

                    publishProgress(60);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject JSONobj = jsonArray.getJSONObject(i);

                        for (int j = 0; j < seleccionados.size(); j++){
                            Integer idJson = JSONobj.getInt("id");

                            if(seleccionados.get(j) == idJson){
                                simbolo = new SimboloO(JSONobj.getInt("id"), JSONobj.getString("nombre"), JSONobj.getString("descripcion"));
                                listResultante.add(simbolo);

                                break;
                            }
                        }
                    }
                    publishProgress(100);
                }


                /**
                 * Si el servidor web no está activo
                 */
                if(response_code == HttpURLConnection.HTTP_NOT_FOUND){

                    /**
                     * Es necesario implementar un objeto de la clase Runnable para poder mostrar Toast en Asyntask
                     */
                    runOnUiThread(new Runnable() {
                        public void run() {
                           FancyToast.makeText(getApplicationContext(), "\t\t\t\t\t\t\t\t\t\tSin servicio\nRecargue el servidor pythonanywhere",
                                    FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                            onSupportNavigateUp();
                        }
                    });
                }

                return listResultante;

            } catch (IOException ioe) {
                Log.e("REST API", "Error al realizar petición GET " + Utilidades.DIRECCION_REST_LOCAL_IP + Utilidades.POST_GET_ALL + ".");
                ioe.printStackTrace();
                return null;
            } catch (JSONException jsone) {
                Log.e("REST API", "PETICIÓN GET ALL - Error al leer JSON.");
                jsone.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<SimboloO> simbolos) {
            super.onPostExecute(simbolos);
            listaSimbolos = simbolos;
            adapter.setListaSimbolos(listaSimbolos);
            adapter.notifyDataSetChanged();
            pdialog.dismiss();
        }
    }


    //************
    //OPCION 2
    //Se va a obtener de una en una las veces que seleccionados haya y se añade a la listaSimbolos
    //************

    /*
    private class ObtenSimbolo extends AsyncTask<Integer, Integer, SimboloO> {

        ProgressDialog pdialog;
        Context context;

        public ObtenSimbolo(Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            pdialog = new ProgressDialog(context);
            pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pdialog.setMessage("Obteniendo del servicio...");
            pdialog.setMax(100);
            pdialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pdialog.setProgress(values[0]);
        }

        @Override
        protected SimboloO doInBackground(Integer... integers) {

            HttpGet getSimbolo = new HttpGet(Utilidades.DIRECCION_REST_PYTHON + Utilidades.GET_PUT_DELETE_ID + String.valueOf(integers[0]));
            getSimbolo.setHeader("content-type", "application-json");
            publishProgress(20);

            try {
                HttpResponse respuesta = httpClient.execute(getSimbolo);
                String strResp = EntityUtils.toString(respuesta.getEntity());

                publishProgress(40);

                JSONObject jsonObj = new JSONObject(strResp);

                publishProgress(60);

                SimboloO simbolo = new SimboloO(jsonObj.getInt("id"), jsonObj.getString("nombre"), jsonObj.getString("descripcion"));

                publishProgress(100);

                return simbolo;


            } catch (IOException ioe) {
                Log.e("REST API", "Error al realizar peticion GET " + Utilidades.DIRECCION_REST_PYTHON + Utilidades.GET_PUT_DELETE_ID + String.valueOf(integers[0]) + ".");
                ioe.printStackTrace();
                return null;
            } catch (JSONException jsone) {
                Log.e("REST API", "Error a la hora de leer JSON.");
                jsone.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(SimboloO objSimbolo) {
            super.onPostExecute(objSimbolo);
            listaSimbolos.add(objSimbolo);
            adapter.setListaSimbolos(listaSimbolos);
            adapter.notifyDataSetChanged();
            pdialog.dismiss();
        }
    }*/

}


