package trabajopracticopoo2.vinoapp.entidades;
import java.io.Serializable;
import java.util.Objects;
import trabajopracticopoo2.vinoapp.enumerados.Categoria;
import trabajopracticopoo2.vinoapp.enumerados.Color;
public class Vino implements Serializable{
private transient int vino_id;
private String nombre;
private String cepas;
private Color color;
private int cosecha;
private Categoria categoria;
private String enologo;
private int bodega_id;
private String terruno;
private String nota_de_cata;

    public Vino() {
    }

    public Vino(String nombre, String cepas, Color color, int cosecha, Categoria categoria, String enologo, int bodega_id, String terruno) {
        this.nombre = nombre;
        this.cepas = cepas;
        this.color = color;
        this.cosecha = cosecha;
        this.categoria = categoria;
        this.enologo = enologo;
        this.bodega_id = bodega_id;
        this.terruno = terruno;
    }

    public Vino(int vino_id, String nombre, String cepas, Color color, int cosecha, Categoria categoria, String enologo, int bodega_id, String terruno) {
        this.vino_id = vino_id;
        this.nombre = nombre;
        this.cepas = cepas;
        this.color = color;
        this.cosecha = cosecha;
        this.categoria = categoria;
        this.enologo = enologo;
        this.bodega_id = bodega_id;
        this.terruno = terruno;
    }

    public Vino(String nombre, String cepas, Color color, int cosecha, Categoria categoria, String enologo, int bodega_id, String terruno, String nota_de_cata) {
        this.nombre = nombre;
        this.cepas = cepas;
        this.color = color;
        this.cosecha = cosecha;
        this.categoria = categoria;
        this.enologo = enologo;
        this.bodega_id = bodega_id;
        this.terruno = terruno;
        this.nota_de_cata = nota_de_cata;
    }

    
    @Override
    public String toString() {
        return "Vino{" + "vino_id=" + vino_id + ", nombre=" + nombre + ", cepas=" + cepas + ", color=" + color + ", cosecha=" + cosecha + ", categoria=" + categoria + ", enologo=" + enologo + ", bodega_id=" + bodega_id + ", terruno=" + terruno + '}';
    }
    
    public String toStringView(){
        return "Nombre: "+nombre+"\n"+"Cepas: "+cepas+"\n"+"Color: "+color+"\n"+"Cosecha: "+cosecha+"\n"+"Categoría: "+categoria+"\n"+"Enólogo: "+enologo+"\n"+"Terruño/Viñedo: "+terruno+"\n";
    }

    public int getVino_id() {
        return vino_id;
    }

    public void setVino_id(int vino_id) {
        this.vino_id = vino_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCepas() {
        return cepas;
    }

    public void setCepas(String cepas) {
        this.cepas = cepas;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCosecha() {
        return cosecha;
    }

    public void setCosecha(int cosecha) {
        this.cosecha = cosecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEnologo() {
        return enologo;
    }

    public void setEnologo(String enologo) {
        this.enologo = enologo;
    }

    public int getBodega_id() {
        return bodega_id;
    }

    public void setBodega_id(int bodega_id) {
        this.bodega_id = bodega_id;
    }

    public String getTerruno() {
        return terruno;
    }

    public void setTerruno(String terruno) {
        this.terruno = terruno;
    }
    
    public String getNota_de_cata(){
         return nota_de_cata;
    }
    
    public void setNota_de_cata(String nota_de_cata){
        this.nota_de_cata=nota_de_cata;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.vino_id;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vino other = (Vino) obj;
        if (this.vino_id != other.vino_id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    
}
