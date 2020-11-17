package cl.desafiolatam.multipleintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    //private static final String TAG = "Results";
    private Button webBtn;
    private Button shareBtn;
    private String url;
    private Boolean resultado_imagen;


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            //Log.d(TAG, "URL" + data.getStringExtra("url_desafiolatam"));
            //Log.d(TAG, "URL" + data.getBooleanExtra("resultado_imagen", false));

            Toast.makeText(getApplicationContext(), "URL: " + url, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Resultado imágen: " + resultado_imagen, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        url = getIntent().getStringExtra("url_desafiolatam");
        resultado_imagen = getIntent().getBooleanExtra("resultado_imagen", false);
        webBtn = findViewById(R.id.btnURL);
        shareBtn = findViewById(R.id.btnCompartir);

        //Botón Lanzar Web
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirURL();
            }
        });

        //Botón Compartir
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void abrirURL() {
        Uri uriWeb = Uri.parse(url);
        Intent intentURL = new Intent(Intent.ACTION_VIEW, uriWeb);
        startActivity(intentURL);
    }
}