package trabajopracticopoo2.vinoapp.repositorios.interfaces;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import trabajopracticopoo2.vinoapp.enumerados.Color;
import trabajopracticopoo2.vinoapp.enumerados.Categoria;
import trabajopracticopoo2.vinoapp.entidades.Vino;
public interface I_VinoRepositorio {
    void save(Vino vino);
    void remove(Vino vino);
    void update(Vino vino);
    List<Vino>getAll();
    
    default Vino getById(int vino_id){
    return getAll()
            .stream()
            .filter(v->v.getVino_id()==vino_id)
            .findFirst()
            .orElse(new Vino());
    }
    
    default Vino getUltimo(){
        return getById(getAll()
                .stream()
        .max(Comparator.comparingInt(Vino::getVino_id))
        .get()
        .getVino_id()
        );
    } 
    
    default List<Vino> getByNombre(String nombre){
    if(nombre==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(v-> v.getNombre().toLowerCase().contains(nombre.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Vino> getByCepas(String cepas){
    if(cepas==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(v->v.getCepas().toLowerCase().contains(cepas.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Vino> getByColor(Color color){
    if(color==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(v->v.getColor().equals(color))
               .collect(Collectors.toList());
    }
    
    default List<Vino> getByCosecha(int cosecha){
        return getAll()
               .stream()
               .filter(v->v.getCosecha()==cosecha)
               .collect(Collectors.toList());
    }
    
    default List<Vino> getByCategoria(Categoria categoria){
        if(categoria==null) return new ArrayList<>();
            return getAll()
                    .stream()
                    .filter(v->v.getCategoria().equals(categoria))
                    .collect(Collectors.toList());
    }
    
     default List<Vino> getLikeEnologo(String enologo){
     if(enologo==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(v->v.getEnologo().toLowerCase().contains(enologo.toLowerCase()))
               .collect(Collectors.toList());
     }
    
     default Vino getLikeBodega(int bodega_id){
     return getAll()
            .stream()
            .filter(v->v.getBodega_id()==bodega_id)
            .findFirst()
            .orElse(new Vino());
     }
    
     default List<Vino> getLikeTerruno(String terruno){
     if(terruno==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(v->v.getTerruno().toLowerCase().contains(terruno.toLowerCase()))
               .collect(Collectors.toList());
     }
}
