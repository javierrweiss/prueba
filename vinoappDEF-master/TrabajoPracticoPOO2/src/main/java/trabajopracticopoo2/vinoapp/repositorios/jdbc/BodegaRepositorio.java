package trabajopracticopoo2.vinoapp.repositorios.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajopracticopoo2.vinoapp.entidades.Bodega;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_BodegaRepositorio;
public class BodegaRepositorio implements I_BodegaRepositorio{
private Connection conn;
    public BodegaRepositorio(Connection conn) {this.conn = conn; }
    @Override
    public void save(Bodega bodega) {
        if (bodega==null) return;
        try (PreparedStatement ps= conn.prepareStatement("insert into bodegas (nombre_bodega,pais,"
                + "ubicacion,fundacion) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setString(1, bodega.getNombre_bodega());
            ps.setString(2, bodega.getPais());
            ps.setString(3, bodega.getUbicacion());
            ps.setInt(4, bodega.getFundacion());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) bodega.setBodega_id(rs.getInt(1));
        } catch (Exception e) {e.printStackTrace();}
    }
    
    @Override
    public void update(Bodega bodega) {
        if(bodega==null) return;
        try (PreparedStatement ps=conn.prepareStatement("update bodegas set nombre_bodega=?,"
                + "pais=?, ubicacion=?, fundacion=? where bodega_id=?"
        )){
        ps.setString(1, bodega.getNombre_bodega());
        ps.setString(2, bodega.getPais());
        ps.setString(3, bodega.getUbicacion());
        ps.setInt(4, bodega.getFundacion());
        ps.setInt(5, bodega.getBodega_id());
        ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }
    
    @Override
    public void remove(Bodega bodega) {
    if(bodega==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from bodegas where bodega_id=?")){
        ps.setInt(1, bodega.getBodega_id());
        ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public List<Bodega> getAll() {
    List<Bodega> list=new ArrayList<>();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from bodegas"))
            {
            while (rs.next()){ //inicio bloque while
                list.add(new Bodega(
                        rs.getInt("bodega_id"),
                        rs.getString("nombre_bodega"),
                        rs.getString("pais"),
                        rs.getString("ubicacion"),
                        rs.getInt("fundacion")
                ));
            } //fin bloque while
            
        }catch (Exception e) {e.printStackTrace();}
    return list;
    }
    
} //fin de clase
