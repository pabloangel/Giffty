package BSHELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pablo on 07-11-2017.
 */

public class DbClientes extends SQLiteOpenHelper{

    public String clientes = "CREATE TABLE clientes(nombre TEXT, apellido TEXT, direccion TEXT, listaRegalos TEXT)";

    public DbClientes(Context context){
        super(context,"clientes.bd",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(clientes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
