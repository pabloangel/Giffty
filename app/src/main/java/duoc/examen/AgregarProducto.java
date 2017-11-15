package duoc.examen;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import BSHELPER.DbProductos;

public class AgregarProducto extends AppCompatActivity {
    private EditText producto;
    private EditText descripcion;
    private EditText precio;
    private EditText stock;
    private EditText categoria;

    private String APP_DIRECTORY = "myPictureApp/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";
    private final int PHOTO_CODE = 100;
    private final int SELECT_PICTURE = 200;
    private ImageView imageView;
    private Context context;




    @Override
    protected void onCreate(Bundle b) {


        //////////////////////////////////////////
        super.onCreate(b);
        setContentView(R.layout.activity_agregar_producto);

        producto = (EditText)    findViewById(R.id.edProducto);
        descripcion = (EditText) findViewById(R.id.edDescripcion);
        precio = (EditText)      findViewById(R.id.edPrecio);
        stock = (EditText)       findViewById(R.id.edStock);
        categoria = (EditText)   findViewById(R.id.edCategoria);

        tomarFoto();
    }

    private void tomarFoto() {

        imageView = (ImageView) findViewById(R.id.setPicture);
        Button button = (Button) findViewById(R.id.btnFotografia);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] option = {"Abrir camara", "Elegir de la galeria", "Cancelar"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(AgregarProducto.this);
                builder.setTitle("Elija una opcion");
                builder.setItems(option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selecion) {
                        if (option[selecion] == "Abrir camara") {
                            openCamera();

                        } else if (option[selecion] == "Elegir de la galeria") {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");

                            startActivityForResult(Intent.createChooser(intent, "Seleccione aoo de imagenes"), SELECT_PICTURE);
                        }else if(option[selecion] == "Cancelar"){
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }

        });

    }

    private void openCamera() {
        File file = new File(Environment.getExternalStorageDirectory(), MEDIA_DIRECTORY);
        file.mkdirs();
        String path = Environment.getExternalStorageDirectory() + File.separator +
                MEDIA_DIRECTORY + File.separator + TEMPORAL_PICTURE_NAME;
        File newFile = new File(path);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
        startActivityForResult(intent, PHOTO_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case PHOTO_CODE:
                if (resultCode == RESULT_OK){
                    String dir = Environment.getExternalStorageDirectory() + File.separator
                            + MEDIA_DIRECTORY + File.separator + TEMPORAL_PICTURE_NAME;
                    decodeBitmap(dir);
                }
                break;

            case SELECT_PICTURE:
                if (resultCode == RESULT_OK){
                    Uri path = data.getData();
                    imageView.setImageURI(path);
                }
        }
    }

    private void decodeBitmap(String dir) {
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeFile(dir);
        imageView.setImageBitmap(bitmap);

    }

    //////////////////////////////////////////7


    public void agregarProducto(View v){
       //Intent agregarProducto = new Intent(AgregarProducto.this, AgregarProducto.class);
       //startActivity(agregarProducto);

        if(ComprobarCamposProducto()){
            String pro;
            String des;
            String pre;
            String sto;
            String cate;

            pro = producto.getText().toString();
            des = descripcion.getText().toString();
            pre = precio.getText().toString();
            sto = stock.getText().toString();
            cate = categoria.getText().toString();

            DbProductos bh = new DbProductos(AgregarProducto.this);
            if (bh!=null){
                SQLiteDatabase db = bh.getWritableDatabase();
                ContentValues con = new ContentValues();
                con.put("producto", pro);
                con.put("descripcion", des);
                con.put("precio", pre);
                con.put("stock", sto);
                con.put("categoria", cate);
                long insertado = db.insert("productos",null,con);

                if (insertado<0){
                    Toast.makeText(AgregarProducto.this, "No inserto", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AgregarProducto.this,"INSERTADO PRODUCTO CORRECTAMENTE", Toast.LENGTH_LONG).show();
                    producto.setText("");
                    descripcion.setText("");
                    precio.setText("");
                    stock.setText("");
                    categoria.setText("");
                }

                String sql = "SELECT producto, descripcion FROM productos";
                SQLiteDatabase rbd = bh.getReadableDatabase();
                Cursor cursor =rbd.rawQuery(sql,null);
                while(cursor.moveToNext()){
                    Log.v("depurado",cursor.getString(1));
                }

            }
        }else{
            Toast.makeText(AgregarProducto.this, "  SI HAY CAMPOS VACIOS",Toast.LENGTH_LONG).show();
        }
    }

    public boolean ComprobarCamposProducto(){
        if (producto.getText().toString().isEmpty() || descripcion.getText().toString().isEmpty() || precio.getText().toString().isEmpty()
                || stock.getText().toString().isEmpty()||categoria.getText().toString().isEmpty()){
            return false;
        }else{
            return true;
        }
    }


}
