package duoc.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    }

        //esto nos sirve para redireccionar las paginas y los layouts respectivos
    public void agregarProducto(View v){
        Intent i = new Intent(ProductoActivity.this, AgregarProducto.class);
        startActivity(i);
    }

    public void mostrarProducto(View v){
        Intent mostrarProducto = new Intent(ProductoActivity.this,MostrarProducto.class);
        startActivity(mostrarProducto);
    }
}
