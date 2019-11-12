package trabajopracticopoo2.vinoapp.repositorios.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajopracticopoo2.vinoapp.entidades.Ranking;
import trabajopracticopoo2.vinoapp.enumerados.RankingEnum;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_RankingRepositorio;
public class RankingRepositorio implements I_RankingRepositorio{
    private Connection conn;
    public RankingRepositorio(Connection conn) {this.conn = conn;}
    @Override
    public void save(Ranking ranking) {
       if(ranking==null) return;
        try (PreparedStatement ps=conn.prepareStatement("insert into rankings (ranking,"
                + "usuario_id, vino_id, tienda_id) "
                + "values(?,?,?,?)", 
                PreparedStatement.RETURN_GENERATED_KEYS
        )){
          ps.setString(1, ranking.getRanking().toString());
          ps.setInt(2, ranking.getUsuario_id());
          ps.setInt(3, ranking.getVino_id());
          ps.setInt(4, ranking.getTienda_id());
          ps.execute();
          ResultSet rs=ps.getGeneratedKeys();
          if(rs.next()) ranking.setRanking_id(rs.getInt(1));
        } catch (Exception e) {e.printStackTrace();} 
    }

    @Override
    public void remove(Ranking ranking) {
    if(ranking==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from rankings where ranking_id=?")
             ){
            ps.setInt(1, ranking.getRanking_id());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}    
    }

    @Override
    public void update(Ranking ranking) {
    if(ranking==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "update rankings set ranking=?, usuario_id=?, vino_id=?, tienda_id=? "
                    +"where ranking_id=?"
        )) {
            ps.setString(1, ranking.getRanking().toString());
            ps.setInt(2, ranking.getUsuario_id());
            ps.setInt(3, ranking.getVino_id());
            ps.setInt(4, ranking.getTienda_id());
            ps.setInt(5, ranking.getRanking_id());
            ps.execute();
        } catch (Exception e) { e.printStackTrace(); }    
    }

    @Override
    public List<Ranking> getAll() {
        List<Ranking>list=new ArrayList<>();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from rankings");
            ){ 
            while (rs.next()) {//inicio bloque while
                list.add(new Ranking(
                        rs.getInt("ranking_id"),
                        RankingEnum.valueOf(rs.getString("ranking")), 
                        rs.getInt("usuario_id"),
                        rs.getInt("vino_id"), 
                        rs.getInt("tienda_id")
                ));
            }//fin bloque while
        } catch (Exception e) {e.printStackTrace();}
    return list;
    }
}
