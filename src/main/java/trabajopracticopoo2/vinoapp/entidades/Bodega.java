package trabajopracticopoo2.vinoapp.entidades;

import java.io.Serializable;

public class Bodega implements Serializable{
private transient int bodega_id;
private String nombre_bodega; 
private String pais; 
private String ubicacion;
private int    fundacion;

    public Bodega() {
    }

    public Bodega(String nombre_bodega, String pais, String ubicacion, int fundacion) {
        this.nombre_bodega = nombre_bodega;
        this.pais = pais;
        this.ubicacion = ubicacion;
        this.fundacion = fundacion;
    }

    public Bodega(int bodega_id, String nombre_bodega, String pais, String ubicacion, int fundacion) {
        this.bodega_id = bodega_id;
        this.nombre_bodega = nombre_bodega;
        this.pais = pais;
        this.ubicacion = ubicacion;
        this.fundacion = fundacion;
    }

    @Override
    public String toString() {
        return "Bodega{" + "bodega_id=" + bodega_id + ", nombre_bodega=" + nombre_bodega + ", pais=" + pais + ", ubicacion=" + ubicacion + ", fundacion=" + fundacion + '}';
    }
    public String toStringBodegaView() {
        return "Bodega: "+nombre_bodega+"\n"+ "País: "+pais+"\n"+ "Dirección ppal de la bodega: "+ubicacion+"\n"+"Año de fundación: "+fundacion+"\n";
    }
    
    public int getBodega_id() {
        return bodega_id;
    }

    public void setBodega_id(int bodega_id) {
        this.bodega_id = bodega_id;
    }

    public String getNombre_bodega() {
        return nombre_bodega;
    }

    public void setNombre_bodega(String nombre_bodega) {
        this.nombre_bodega = nombre_bodega;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    

}
