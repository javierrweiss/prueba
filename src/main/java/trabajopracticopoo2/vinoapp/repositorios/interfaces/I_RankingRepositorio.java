package trabajopracticopoo2.vinoapp.repositorios.interfaces;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import trabajopracticopoo2.vinoapp.entidades.Ranking;
import trabajopracticopoo2.vinoapp.entidades.Vino;
import trabajopracticopoo2.vinoapp.enumerados.RankingEnum;
public interface I_RankingRepositorio {
    void save(Ranking ranking);
    void remove(Ranking ranking);
    void update(Ranking ranking);
    List<Ranking> getAll();
    
    default Ranking getById(int ranking_id){
        return getAll()
               .stream()
               .filter(r->r.getRanking_id()==ranking_id)
               .findFirst()
               .orElse(new Ranking());
    }
    
    default Ranking getLastRankingid(){
    return getById(getAll()
            .stream()
            .max(Comparator.comparingInt(Ranking::getRanking_id))
            .get()
            .getRanking_id());
    }
    
    default List<Ranking> getByRanking(RankingEnum ranking){
        return getAll()
               .stream()
               .filter(r->r.getRanking().equals(ranking))
               .collect(Collectors.toList());
    }
    default Ranking getByUsuario(int usuario_id){
        return getAll()
               .stream()
               .filter(r->r.getUsuario_id()==usuario_id)
               .findFirst()
               .get();
    }
    default Ranking getByVinoId(int vino_id){
        return getAll()
               .stream()
               .filter(r->r.getVino_id()==vino_id)
               .findFirst()
               .get();
    }
    default Ranking getLikeTienda(int tienda_id){
        return getAll()
               .stream()
               .filter(r->r.getTienda_id()==tienda_id)
               .findFirst()
               .get();
    }
    
    default List<Ranking> getVinoByUser(int usuario_id){
        return getAll()
               .stream()
               .filter(r->r.getUsuario_id()==usuario_id)
               .sorted(Comparator.comparing(Ranking::getVino_id))
               .collect(Collectors.toList());
    }
    
}
