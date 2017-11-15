package BSHELPER;

/**
 * Created by pablo on 08-11-2017.
 */

public class Producto {

    private String producto;
    private String descripcion;
    private int precio;
    private int stock;
    private String categoria;

    public Producto(String producto, String descripcion, int precio, int stock, String categoria){
        setProducto(producto);
        setDescripcion(descripcion);
        setPrecio(precio);
        setStock(stock);
        setCategoria(categoria);
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
