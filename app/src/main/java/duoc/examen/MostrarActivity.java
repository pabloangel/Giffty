package duoc.examen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import BSHELPER.Clientes;
import BSHELPER.DbClientes;

/**
 * Created by pablo on 07-11-2017.
 */

public class MostrarActivity extends AppCompatActivity {

    private ArrayList<Clientes> clientes = new ArrayList<>();
    private ListView lista;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.mostrar_activity);
        lista = (ListView) findViewById(R.id.LVmostrar);
        llenarLista();
    }
    public void llenarLista(){
        DbClientes bh = new DbClientes(MostrarActivity.this);
        if (bh!=null){
            SQLiteDatabase db = bh.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM clientes",null);
            if (c.moveToFirst()){
                do{
                    clientes.add(new Clientes(c.getString(0),c.getString(1),c.getString(2),c.getString(3)));
                }while(c.moveToNext());


            }
        }
        String[] arreglo = new String[clientes.size()];
        for (int i= 0;i<arreglo.length;i++){
            arreglo[i] = clientes.get(i).getNombre();
     }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(MostrarActivity.this,android.R.layout.simple_list_item_1,arreglo);
        lista.setAdapter(adaptador);
    }
}
