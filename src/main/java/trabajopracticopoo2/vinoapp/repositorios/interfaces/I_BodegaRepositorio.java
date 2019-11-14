package trabajopracticopoo2.vinoapp.repositorios.interfaces;
import java.util.List;
import java.util.stream.Collectors;
import trabajopracticopoo2.vinoapp.entidades.Bodega;
public interface I_BodegaRepositorio {
    void save(Bodega bodega);
    void remove(Bodega bodega);
    void update(Bodega bodega);
    List<Bodega> getAll();
    
    default Bodega getById (int bodega_id){
    return getAll()
           .stream()
           .filter(b->b.getBodega_id()==bodega_id)
           .findFirst()
           .orElse(new Bodega());
    }
    
    default List<Bodega> getLikeNombre(String nombre_bodega){
        return getAll()
               .stream()
               .filter(b->b.getNombre_bodega().toLowerCase().contains(nombre_bodega.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Bodega> getLikePais(String pais){
        return getAll()
               .stream()
               .filter(b->b.getPais().toLowerCase().contains(pais.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Bodega> getLikeUbicacion(String ubicacion){
        return getAll()
               .stream()
               .filter(b->b.getUbicacion().toLowerCase().contains(ubicacion.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default Bodega getLikeFundacion(int fundacion){
        return getAll()
               .stream()
               .filter(b->b.getFundacion()==fundacion)
               .findFirst()
               .get();
    }
    
}
