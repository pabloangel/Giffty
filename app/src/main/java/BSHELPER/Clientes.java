package BSHELPER;

import java.util.Date;

/**
 * Created by pablo on 07-11-2017.
 */

public class Clientes {


    private String nombre;
    private String apellido;
    private String direccion;
    private String listaRegalos;

    public Clientes(String nombre, String apellido,String direccion,String listaRegalos){

        setNombre(nombre);
        setApellido(apellido);
        setDireccion(direccion);
        setListaRegalos(listaRegalos);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public String getListaRegalos() {
        return listaRegalos;
    }

    public void setListaRegalos(String listaRegalos) {
        this.listaRegalos = listaRegalos;
    }
}
