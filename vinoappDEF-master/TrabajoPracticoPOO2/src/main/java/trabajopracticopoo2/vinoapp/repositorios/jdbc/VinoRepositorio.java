package trabajopracticopoo2.vinoapp.repositorios.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajopracticopoo2.vinoapp.entidades.Vino;
import trabajopracticopoo2.vinoapp.enumerados.Categoria;
import trabajopracticopoo2.vinoapp.enumerados.Color;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_VinoRepositorio;
public class VinoRepositorio implements I_VinoRepositorio{
private Connection conn;
    public VinoRepositorio(Connection conn) {this.conn = conn;}
    @Override
    public void save(Vino vino) {
    if(vino==null) return;
        try (PreparedStatement ps=conn.prepareStatement("insert into vinos (nombre,cepas,"
                + "color,cosecha,categoria,enologo,bodega_id,terruno) "
                + "values(?,?,?,?,?,?,?,?)", 
                PreparedStatement.RETURN_GENERATED_KEYS
        )){
          ps.setString(1, vino.getNombre());
          ps.setString(2, vino.getCepas());
          ps.setString(3, vino.getColor().toString());
          ps.setInt(4, vino.getCosecha());
          ps.setString(5, vino.getCategoria().toString());
          ps.setString(6, vino.getEnologo());
          ps.setInt(7, vino.getBodega_id());
          ps.setString(8, vino.getTerruno());
          ps.execute();
          ResultSet rs=ps.getGeneratedKeys();
          if(rs.next()) vino.setVino_id(rs.getInt(1));
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void remove(Vino vino) {
    if(vino==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from vinos where vino_id=?")
             ){
            ps.setInt(1, vino.getVino_id());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(Vino vino) {
    if(vino==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "update vinos set nombre=?, cepas=?, color=?, cosecha=?, "
                    + "categoria=?, enologo=?, bodega_id=?, terruno=? where vino_id=?"
        )) {
            ps.setString(1, vino.getNombre());
            ps.setString(2, vino.getCepas());
            ps.setString(3, vino.getColor().toString());
            ps.setInt(4, vino.getCosecha());
            ps.setString(5, vino.getCategoria().toString());
            ps.setString(6, vino.getEnologo());
            ps.setInt(7, vino.getBodega_id());
            ps.setString(8, vino.getTerruno());
            ps.setInt(9, vino.getVino_id());
            ps.execute();
        } catch (Exception e) { e.printStackTrace(); }
    }
   
    @Override
    public List<Vino> getAll() {
    List<Vino>list=new ArrayList<>();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from vinos");
            ){
            while (rs.next()) { //inicio bloque while
              list.add(new Vino(
              rs.getInt("vino_id"),
              rs.getString("nombre"),
              rs.getString("cepas"),
              Color.valueOf(rs.getString("color")),
              rs.getInt("cosecha"),
              Categoria.valueOf(rs.getString("categoria")),
              rs.getString("enologo"),
              rs.getInt("bodega_id"),
              rs.getString("terruno")
              ));
            } //fin bloque while
        } catch (Exception e) {e.printStackTrace();}
    return list;
    }
    
} //fin de clase
