package duoc.examen;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import BSHELPER.DbClientes;

/**
 * Created by pablo on 07-11-2017.
 */

public class AgrergarActivity extends AppCompatActivity{
    private EditText nombre;
    private EditText apellido;
    private EditText direccion;
    private EditText listaRegalos;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_agregar);

        nombre = (EditText)       findViewById(R.id.etNombre);
        apellido = (EditText)     findViewById(R.id.edApellido);
        direccion = (EditText)    findViewById(R.id.edDireccion);
        listaRegalos = (EditText) findViewById(R.id.edLista);

    }

    public void agregar(View v){
        if (ComprobarCampos()){
            String nom;
            String ape;
            String dir;
            String lis;

            nom = nombre.getText().toString();
            ape = apellido.getText().toString();
            dir = direccion.getText().toString();
            lis = listaRegalos.getText().toString();

            DbClientes bh = new DbClientes(AgrergarActivity.this);
            if (bh!=null){
                SQLiteDatabase db = bh.getWritableDatabase();
                ContentValues con = new ContentValues();
                con.put("nombre",nom);
                con.put("apellido", ape);
                con.put("direccion",dir);
                con.put("listaRegalos", lis);
                long insertado = db.insert("clientes",null,con);

                if(insertado < 0) {
                    // error
                    Toast.makeText(AgrergarActivity.this,"No inserto", Toast.LENGTH_SHORT).show();
                    Log.v("depurando", "resultado del select");
                } else {
                    Toast.makeText(AgrergarActivity.this,"INSERTADO CON EXITO",Toast.LENGTH_LONG).show();
                    nombre.setText("");
                    apellido.setText("");
                    direccion.setText("");
                    listaRegalos.setText("");
                }

                String sql = "SELECT nombre FROM clientes";
                SQLiteDatabase rbd = bh.getReadableDatabase();
                Cursor cursor = rbd.rawQuery(sql, null);
                while(cursor.moveToNext()){
                    Log.v("depurando", cursor.getString(0));
                }
            }

        }else{
            Toast.makeText(AgrergarActivity.this, "Si hay campos vacios",Toast.LENGTH_LONG).show();
        }
    }

    public boolean ComprobarCampos(){
        if (nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty()
                || direccion.getText().toString().isEmpty() || listaRegalos.getText().toString().isEmpty())  {

            return false;
        }else{
            return true;
        }
    }
}
