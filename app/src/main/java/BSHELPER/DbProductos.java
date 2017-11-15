package BSHELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pablo on 13-11-2017.
 */

public class DbProductos extends SQLiteOpenHelper {

    public String productos = "CREATE TABLE productos(producto TEXT, descripcion TEXT, precio TEXT, stock TEXT, categoria TEXT)";

    public DbProductos(Context context){
        super(context, "productos.bd", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(productos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
