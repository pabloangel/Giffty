package duoc.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void agregar(View v){
        Intent agregarActivity = new Intent(MainActivity.this, AgrergarActivity.class);
        startActivity(agregarActivity);
    }

    public void mostrar(View v){
        Intent mostraActivity = new Intent(MainActivity.this,MostrarActivity.class);
        startActivity(mostraActivity);
    }

    public void eliminar(View v){
        Intent eliminarActivity = new Intent(MainActivity.this,EliminarActivity.class);
        startActivity(eliminarActivity);
    }
}
