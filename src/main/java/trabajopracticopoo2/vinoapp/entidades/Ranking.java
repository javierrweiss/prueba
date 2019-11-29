package trabajopracticopoo2.vinoapp.entidades;
import java.io.Serializable;
import trabajopracticopoo2.vinoapp.enumerados.RankingEnum;
public class Ranking implements Serializable{
private transient int ranking_id;
private RankingEnum ranking;
private transient int usuario_id;
private transient int vino_id;
private transient int tienda_id;

    public Ranking() {
    }

    public Ranking(RankingEnum ranking, int usuario_id, int vino_id, int tienda_id) {
        this.ranking = ranking;
        this.usuario_id = usuario_id;
        this.vino_id = vino_id;
        this.tienda_id = tienda_id;
    }

    public Ranking(int ranking_id, RankingEnum ranking, int usuario_id, int vino_id, int tienda_id) {
        this.ranking_id = ranking_id;
        this.ranking = ranking;
        this.usuario_id = usuario_id;
        this.vino_id = vino_id;
        this.tienda_id = tienda_id;
    }

    @Override
    public String toString() {
        return "Ranking{" + "ranking_id=" + ranking_id + ", ranking=" + ranking + ", usuario_id=" + usuario_id + ", vino_id=" + vino_id + ", tienda_id=" + tienda_id + '}';
    }
    
    public String toStringRankingView(){
     return "Ranking: "+ranking;
    }

    public int getRanking_id() {
        return ranking_id;
    }

    public void setRanking_id(int ranking_id) {
        this.ranking_id = ranking_id;
    }

    public RankingEnum getRanking() {
        return ranking;
    }

    public void setRanking(RankingEnum ranking) {
        this.ranking = ranking;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getVino_id() {
        return vino_id;
    }

    public void setVino_id(int vino_id) {
        this.vino_id = vino_id;
    }

    public int getTienda_id() {
        return tienda_id;
    }

    public void setTienda_id(int tienda_id) {
        this.tienda_id = tienda_id;
    }




}
