package trabajopracticopoo2.vinoapp.repositorios.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import trabajopracticopoo2.vinoapp.entidades.Premio;
import trabajopracticopoo2.vinoapp.enumerados.Medalla;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_PremiosRepositorio;
public class PremioRepositorio implements I_PremiosRepositorio{
private Connection conn;
    public PremioRepositorio(Connection conn) {this.conn = conn;}
    @Override
    public void save(Premio premio) {
    if (premio==null) return;
        try (PreparedStatement ps= conn.prepareStatement("insert into premios (nombre_premio,puntaje,"
                + "medalla,ano,vino_id) values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setString(1, premio.getNombre_premio());
            ps.setInt(2, premio.getPuntaje());
            ps.setString(3, premio.getMedalla().toString());
            ps.setInt(4, premio.getAno());
            ps.setInt(5, premio.getVino_id());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) premio.setPremio_id(rs.getInt(1));
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void remove(Premio premio) {
    if(premio==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from premios where premio_id=?")){
        ps.setInt(1, premio.getPremio_id());
        ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(Premio premio) {
    if(premio==null) return;
        try (PreparedStatement ps=conn.prepareStatement("update premios set nombre_premio=?,"
                + "puntaje=?, medalla=?, ano=?, vino_id=? where premio_id=?"
        )){
        ps.setString(1, premio.getNombre_premio());
        ps.setInt(2, premio.getPuntaje());
        ps.setString(3, premio.getMedalla().toString());
        ps.setInt(4, premio.getAno());
        ps.setInt(5, premio.getVino_id());
        ps.setInt(6, premio.getPremio_id());
        ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

   @Override
    public List<Premio> getAll() {
       List<Premio> list=new ArrayList<>();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from premios");
            ){
            while (rs.next()){ //inicio bloque while
                String medalla=rs.getString("medalla");
                if (medalla==null || medalla.isEmpty()) medalla="nula"; 
                list.add(new Premio(
                        rs.getInt("premio_id"),
                        rs.getString("nombre_premio"),
                        rs.getInt("puntaje"), 
                        Medalla.valueOf(medalla),
                        rs.getInt("ano"),
                        rs.getInt("vino_id")
                ));
            } //fin bloque while
            
        }catch (Exception e) {e.printStackTrace();}
return list;
    } 
}
