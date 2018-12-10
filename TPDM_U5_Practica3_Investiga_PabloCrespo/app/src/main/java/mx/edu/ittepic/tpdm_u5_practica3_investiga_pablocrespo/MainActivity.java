package mx.edu.ittepic.tpdm_u5_practica3_investiga_pablocrespo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button llamar;
    EditText telefono;
    String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llamar = findViewById(R.id.llamar);
        telefono = findViewById(R.id.telefono);

        solicitarPermiso();

        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero=telefono.getText().toString();
                Toast.makeText(MainActivity.this, "Estas marcando a "+numero, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+numero));
                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE)
                        !=PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(i);
            }
        });
    }

    private void solicitarPermiso() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.CALL_PHONE},1);
        }
    }

}
