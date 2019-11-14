package trabajopracticopoo2.vinoapp.repositorios.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajopracticopoo2.vinoapp.entidades.Usuario;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_UsuarioRepositorio;
public class UsuarioRepositorio implements I_UsuarioRepositorio {
    private Connection conn; 
    public UsuarioRepositorio(Connection conn) {this.conn = conn;}
    @Override
    public void save(Usuario usuario) {
    if(usuario==null) return;    
        try (PreparedStatement ps=conn.prepareStatement("insert into usuarios (cuenta_usuario,"
                + "nombre,apellido,pais,region,ciudad,email,cod_postal,nota_de_cata)"
                + "values(?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
             )){
             ps.setString(1, usuario.getCuenta_usuario());
             ps.setString(2, usuario.getNombre());
             ps.setString(3, usuario.getApellido());
             ps.setString(4, usuario.getPais());
             ps.setString(5, usuario.getRegion());
             ps.setString(6, usuario.getCiudad());
             ps.setString(7, usuario.getEmail());
             ps.setString(8, usuario.getCod_postal());
             ps.setString(9, usuario.getNota_de_cata());
             ps.execute();
             ResultSet rs=ps.getGeneratedKeys();
             if(rs.next()) usuario.setUsuario_id(rs.getInt(1));
        } catch (Exception e) {e.printStackTrace();}
           
    }

    @Override
    public void remove(Usuario usuario) {
    if(usuario==null) return;    
    try (PreparedStatement ps=conn.prepareStatement("delete from usuarios where usuario_id=?")
            ){
            ps.setInt(1, usuario.getUsuario_id());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}    
    }

    @Override
    public void update(Usuario usuario) {
    if(usuario==null) return;    
    try (PreparedStatement ps=conn.prepareStatement("update usuarios set cuenta_usuario=?,"
            + "nombre=?,apellido=?,pais=?,region=?,ciudad=?,email=?,cod_postal=?,nota_de_cata=? "
            + "where usuario_id=?")
            ){
            ps.setString(1, usuario.getCuenta_usuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getPais());
            ps.setString(5, usuario.getRegion());
            ps.setString(6, usuario.getCiudad());
            ps.setString(7, usuario.getEmail());
            ps.setString(8, usuario.getCod_postal());
            ps.setString(9, usuario.getNota_de_cata());
            ps.setInt(10, usuario.getUsuario_id());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}    
    }

    @Override
    public List<Usuario> getAll() {
    List<Usuario>list=new ArrayList<>();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from usuarios");
             ){while (rs.next()) { //inicio bucle while
                list.add(new Usuario(
                        rs.getInt("usuario_id"),
                        rs.getString("cuenta_usuario"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getString("pais"), 
                        rs.getString("region"), 
                        rs.getString("ciudad"), 
                        rs.getString("email"), 
                        rs.getString("cod_postal"), 
                        rs.getString("nota_de_cata")
                ));
            } //fin del bucle while
            
        } catch (Exception e) {e.printStackTrace();}
    return list; 
    }
} //fin de clase