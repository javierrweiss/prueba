package trabajopracticopoo2.vinoapp.entidades;
public class Usuario {
private int usuario_id;
private String cuenta_usuario;    
private String nombre;    
private String apellido;
private String pais;
private String region;
private String ciudad;
private String email;
private String cod_postal;
private String nota_de_cata;

    public Usuario() {
    }

    public Usuario(String cuenta_usuario, String nombre, String apellido, String pais, String region, String ciudad, String email, String cod_postal, String nota_de_cata) {
        this.cuenta_usuario = cuenta_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.region = region;
        this.ciudad = ciudad;
        this.email = email;
        this.cod_postal = cod_postal;
        this.nota_de_cata = nota_de_cata;
    }

    public Usuario(int usuario_id, String cuenta_usuario, String nombre, String apellido, String pais, String region, String ciudad, String email, String cod_postal, String nota_de_cata) {
        this.usuario_id = usuario_id;
        this.cuenta_usuario = cuenta_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.region = region;
        this.ciudad = ciudad;
        this.email = email;
        this.cod_postal = cod_postal;
        this.nota_de_cata = nota_de_cata;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario_id=" + usuario_id + ", cuenta_usuario=" + cuenta_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", pais=" + pais + ", region=" + region + ", ciudad=" + ciudad + ", email=" + email + ", cod_postal=" + cod_postal + ", nota_de_cata=" + nota_de_cata + '}';
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getCuenta_usuario() {
        return cuenta_usuario;
    }

    public void setCuenta_usuario(String cuenta_usuario) {
        this.cuenta_usuario = cuenta_usuario;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getNota_de_cata() {
        return nota_de_cata;
    }

    public void setNota_de_cata(String nota_de_cata) {
        this.nota_de_cata = nota_de_cata;
    }


   
}
