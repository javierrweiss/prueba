package trabajopracticopoo2.vinoapp.repositorios.interfaces;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import trabajopracticopoo2.vinoapp.entidades.Usuario;
public interface I_UsuarioRepositorio {
    void save(Usuario usuario);
    void remove(Usuario usuario);
    void update(Usuario usuario);
    List<Usuario>getAll();
    
    default Usuario getById(int usuario_id){
        return getAll()
                .stream()
                .filter(u->u.getUsuario_id()==usuario_id)
                .findFirst()
                .orElse(new Usuario());
    }
    default List<Usuario> getLikeCuenta(String cuenta_usuario){
        if(cuenta_usuario==null) return new ArrayList<>();
        return getAll()
                .stream()
                .filter(u->u.getCuenta_usuario().contains(cuenta_usuario))
                .collect(Collectors.toList());
    } 
    default List<Usuario> getByPais(String pais){
        if(pais==null) return new ArrayList<>();
        return getAll()
                .stream()
                .filter(u->u.getPais().toLowerCase().contains(pais.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Usuario> getByCiudad(String ciudad){
        if(ciudad==null) return new ArrayList<>();
        return getAll()
                .stream()
                .filter(u->u.getCiudad().toLowerCase().contains(ciudad.toLowerCase()))
                .collect(Collectors.toList());
    }

}
