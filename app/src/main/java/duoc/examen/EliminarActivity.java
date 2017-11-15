package duoc.examen;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import BSHELPER.Clientes;
import BSHELPER.DbClientes;


public class EliminarActivity extends AppCompatActivity {
    private EditText nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

    }


    public void asd(View v) {

        Log.v("depurando", "resultado del select");
        nombre = (EditText) findViewById(R.id.etnombre);
        Toast.makeText(EliminarActivity.this,"Cliente: "+nombre.getText().toString().toUpperCase() + " Eliminado", Toast.LENGTH_SHORT).show();


        DbClientes bh = new DbClientes(EliminarActivity.this);
        SQLiteDatabase writableDatabase = bh.getWritableDatabase();
        int eliminados = writableDatabase.delete("clientes", "Nombre = ?", new String[]{nombre.getText().toString() + ""});

    }



}
