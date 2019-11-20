package trabajopracticopoo2.vinoapp.repositorios.interfaces;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import trabajopracticopoo2.vinoapp.entidades.Premio;
import trabajopracticopoo2.vinoapp.enumerados.Medalla;
public interface I_PremiosRepositorio {
    void save(Premio premio);
    void remove(Premio premio);
    void update(Premio premio);
    List<Premio> getAll();
    
    default Premio getById(int premio_id){
    return getAll()
           .stream()
           .filter(p->p.getPremio_id()==premio_id)
           .findFirst()
           .orElse(new Premio());
    }
    
    default List<Premio> getLikeNombre(String nombre_premio){
    if(nombre_premio==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(p->p.getNombre_premio().toLowerCase().contains(nombre_premio.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Premio> getByPuntaje(int puntaje){
        return getAll()
               .stream()
               .filter(p->p.getPuntaje()==puntaje)
               .collect(Collectors.toList());
    }
    
    default List<Premio> getByMedalla(Medalla medalla){
        return getAll()
               .stream()
               .filter(p->p.getMedalla().equals(medalla))
               .collect(Collectors.toList());
    }
    
    default List<Premio> getByAno(int ano){
        return getAll()
               .stream()
               .filter(p->p.getAno()==ano)
               .collect(Collectors.toList());
    }
    
  }
    

