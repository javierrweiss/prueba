package trabajopracticopoo2.vinoapp.repositorios.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajopracticopoo2.vinoapp.entidades.Tienda;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_TiendaRepositorio;
public class TiendaRepositorio implements I_TiendaRepositorio{
    private Connection conn;
    public TiendaRepositorio(Connection conn) {this.conn = conn;}
    @Override
    public void save(Tienda tienda) {
    if(tienda==null) return;
        try (PreparedStatement ps=conn.prepareStatement("insert into tiendas (nombre_T, pais,"
                + "ciudad,direccion,pagina_web) values(?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
                )){
                ps.setString(1, tienda.getNombre_T());
                ps.setString(2, tienda.getPais());
                ps.setString(3, tienda.getCiudad());
                ps.setString(4, tienda.getDireccion());
                ps.setString(5, tienda.getPagina_web());
                ps.execute();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()) tienda.setTienda_id(rs.getInt(1));
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void remove(Tienda tienda) {
    if(tienda==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from tiendas where tienda_id=?")
            ){
            ps.setInt(1, tienda.getTienda_id());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(Tienda tienda) {
    if(tienda==null) return;
        try (PreparedStatement ps=conn.prepareStatement("update tiendas set nombre_T=?, pais=?,"
                + "ciudad=?, direccion=?, pagina_web=? where tienda_id=?"
        )){
           ps.setString(1, tienda.getNombre_T());
           ps.setString(2, tienda.getPais());
           ps.setString(3, tienda.getCiudad());
           ps.setString(4, tienda.getDireccion());
           ps.setString(5, tienda.getPagina_web());
           ps.setInt(6, tienda.getTienda_id());
           ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public List<Tienda> getAll() {
    List<Tienda>list=new ArrayList<>();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from tiendas");
            ){
            while (rs.next()) {//inicio bloque while
                list.add(new Tienda(
                        rs.getInt("tienda_id"),
                        rs.getString("nombre_T"), 
                        rs.getString("pais"), 
                        rs.getString("ciudad"),
                        rs.getString("direccion"),
                        rs.getString("pagina_web")
                ));
            } //fin bloque while
        } catch (Exception e) {e.printStackTrace();}
    return list;
    }
}//fin de clase
