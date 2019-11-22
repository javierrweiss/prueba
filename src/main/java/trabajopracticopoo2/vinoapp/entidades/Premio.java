package trabajopracticopoo2.vinoapp.entidades;
import java.io.Serializable;
import trabajopracticopoo2.vinoapp.enumerados.Medalla;
public class Premio implements Serializable{
private transient int premio_id;
private String  nombre_premio;    
private int     puntaje;
private Medalla medalla;  
private int     ano;
private int vino_id;

    public Premio() {
    }

/**
 * Constructor con todos los parámetros 
 * @param premio_id
 * @param nombre_premio
 * @param puntaje
 * @param medalla
 * @param ano
 * @param vino_id 
 */
    public Premio(int premio_id, String nombre_premio, int puntaje, Medalla medalla, int ano, int vino_id) {
        this.premio_id = premio_id;
        this.nombre_premio = nombre_premio;
        this.puntaje = puntaje;
        this.medalla = medalla;
        this.ano = ano;
        this.vino_id = vino_id;
    }

    @Override
    public String toString() {
        return "Premio{" + "premio_id=" + premio_id + ", nombre_premio=" + nombre_premio + ", puntaje=" + puntaje + ", medalla=" + medalla + ", ano=" + ano + ", vino_id=" + vino_id + '}';
    }

    public int getPremio_id() {
        return premio_id;
    }

    public void setPremio_id(int premio_id) {
        this.premio_id = premio_id;
    }

    public String getNombre_premio() {
        return nombre_premio;
    }

    public void setNombre_premio(String nombre_premio) {
        this.nombre_premio = nombre_premio;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Medalla getMedalla() {
        return medalla;
    }

    public void setMedalla(Medalla medalla) {
        this.medalla = medalla;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVino_id() {
        return vino_id;
    }

    public void setVino_id(int vino_id) {
        this.vino_id = vino_id;
    }



    

}