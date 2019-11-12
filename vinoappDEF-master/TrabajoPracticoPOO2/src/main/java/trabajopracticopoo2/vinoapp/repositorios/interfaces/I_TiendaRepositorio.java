package trabajopracticopoo2.vinoapp.repositorios.interfaces;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import trabajopracticopoo2.vinoapp.entidades.Tienda;
public interface I_TiendaRepositorio {
    void save(Tienda tienda);
    void remove(Tienda tienda);
    void update(Tienda tienda);
    
    List<Tienda> getAll();
    
    default Tienda getById(int tienda_id){
        return getAll()
               .stream()
               .filter(t->t.getTienda_id()==tienda_id)
               .findFirst()
               .orElse(new Tienda());
    }
    
    default List<Tienda> getLikeNombre(String nombre_T){
    if(nombre_T==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(t->t.getNombre_T().toLowerCase().contains(nombre_T.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Tienda> getByPais(String pais){
    if(pais==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(t->t.getPais().toLowerCase().contains(pais.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Tienda> getByCiudad(String ciudad){
    if(ciudad==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(t->t.getCiudad().toLowerCase().contains(ciudad.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Tienda> getLikeDireccion(String direccion){
    if(direccion==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(t->t.getDireccion().toLowerCase().contains(direccion.toLowerCase()))
               .collect(Collectors.toList());
    }
    
    default List<Tienda> getLikePaginaWeb(String pagina_web){
    if(pagina_web==null) return new ArrayList<>();
        return getAll()
               .stream()
               .filter(t->t.getPagina_web().contains(pagina_web))
               .collect(Collectors.toList());
    }
}
