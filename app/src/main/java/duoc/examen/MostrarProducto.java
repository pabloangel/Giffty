package duoc.examen;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import BSHELPER.Producto;
import BSHELPER.DbProductos;

public class MostrarProducto extends AppCompatActivity {

    private ArrayList<Producto> productos = new ArrayList<>();
    private ListView lista;
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_mostrar_producto);
        lista = (ListView) findViewById(R.id.LVmostrar);
        llenarLista();
    }
    public void llenarLista(){
        DbProductos bh =new DbProductos(MostrarProducto.this);
        if (bh!=null){
            SQLiteDatabase db = bh.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM productos", null);
            if(c.moveToFirst()){
                do {
                productos.add(new Producto(c.getString(0),c.getString(1),c.getInt(2),c.getInt(3),c.getString(4)));

                }while(c.moveToNext());
            }


        }
        String[] arreglo =new String[productos.size()];
        for (int i=0;i<arreglo.length;i++){
            arreglo[i]=productos.get(i).getProducto();
        }

    }
}
