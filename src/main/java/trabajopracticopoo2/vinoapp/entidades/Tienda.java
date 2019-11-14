package trabajopracticopoo2.vinoapp.entidades;
public class Tienda {
private int tienda_id;    
private String nombre_T;    
private String pais;    
private String ciudad;    
private String direccion;    
private String pagina_web;

    public Tienda() {
    }

    public Tienda(String nombre_T, String pais, String ciudad, String direccion, String pagina_web) {
        this.nombre_T = nombre_T;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.pagina_web = pagina_web;
    }

    public Tienda(int tienda_id, String nombre_T, String pais, String ciudad, String direccion, String pagina_web) {
        this.tienda_id = tienda_id;
        this.nombre_T = nombre_T;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.pagina_web = pagina_web;
    }

    @Override
    public String toString() {
        return "Tienda{" + "tienda_id=" + tienda_id + ", nombre_T=" + nombre_T + ", pais=" + pais + ", ciudad=" + ciudad + ", direccion=" + direccion + ", pagina_web=" + pagina_web + '}';
    }
    

    public int getTienda_id() {
        return tienda_id;
    }

    public void setTienda_id(int tienda_id) {
        this.tienda_id = tienda_id;
    }

    public String getNombre_T() {
        return nombre_T;
    }

    public void setNombre_T(String nombre_T) {
        this.nombre_T = nombre_T;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }


   

}
