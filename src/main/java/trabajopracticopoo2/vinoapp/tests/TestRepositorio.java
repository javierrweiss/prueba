package trabajopracticopoo2.vinoapp.tests;
import java.sql.Connection;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import trabajopracticopoo2.vinoapp.entidades.Bodega;
import trabajopracticopoo2.vinoapp.entidades.Premio;
import trabajopracticopoo2.vinoapp.entidades.Ranking;
import trabajopracticopoo2.vinoapp.entidades.Tienda;
import trabajopracticopoo2.vinoapp.entidades.Usuario;
import trabajopracticopoo2.vinoapp.entidades.Vino;
import trabajopracticopoo2.vinoapp.enumerados.Categoria;
import trabajopracticopoo2.vinoapp.enumerados.Color;
import trabajopracticopoo2.vinoapp.enumerados.Medalla;
import trabajopracticopoo2.vinoapp.enumerados.RankingEnum;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_PremiosRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_TiendaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_VinoRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.PremioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.TiendaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.VinoRepositorio;
public class TestRepositorio {
    public static void main(String[] args) {
        try (Connection conn=Connector.getConnection()){
            I_UsuarioRepositorio ur=new UsuarioRepositorio(conn);
            Usuario usuario=new Usuario("pperozo", "Pedro", "Perozo", "México", "Baja California", "Ensenada", "pedroperozo@gmail.com", "22785", null);
            ur.save(usuario);
            System.out.println(usuario);
            System.out.println("****************************");
            ur.remove(ur.getById(40));
            usuario=ur.getById(15);
            usuario.setCuenta_usuario("tomalcantaraa");
            usuario.setNombre("Tomas");
            usuario.setCiudad("Guayaquil");
            usuario.setRegion("Guayas");
            ur.update(usuario);
            ur.getAll().forEach(System.out::println);
            System.out.println("*****************************");
            
            I_BodegaRepositorio br=new BodegaRepositorio(conn);
            Bodega bodega = new Bodega("Casa de Piedra", "México", "Carretera Tecate Ensenada Km 93.5", 1997);
            br.save(bodega);
            System.out.println(bodega);
            System.out.println("****************************");
            br.remove(br.getById(31));
            bodega=br.getById(25);
            bodega.setNombre_bodega("Bodega y Viñedos Hija de Aníbal S.L.");
            bodega.setUbicacion("C/Celeiro 3, 24516 Otero del Toral");
            bodega.setPais("España");
            bodega.setFundacion(2016);
            br.update(bodega);
            br.getAll().forEach(System.out::println);
            System.out.println("*****************************");
            
            I_TiendaRepositorio tr=new TiendaRepositorio(conn);
            Tienda tienda=new Tienda("La Europea", "México", "Tijuana", "Blvd. Agua Caliente No. 9640", "https://www.laeuropea.com.mx");
            tr.save(tienda);
            System.out.println(tienda);
            System.out.println("****************************");
            tr.remove(tr.getById(39));
            tienda=tr.getById(15);
            tienda.setNombre_T("Ligier Vinoteca");
            tienda.setPais("Argentina");
            tienda.setCiudad("CABA");
            tienda.setDireccion("Av. Callao 1111");
            tienda.setPagina_web("www.ligiervinoteca.com.ar");
            tr.update(tienda);
            tr.getAll().forEach(System.out::println);
            System.out.println("*****************************");
            
            I_VinoRepositorio vr=new VinoRepositorio(conn);
            Vino vino=new Vino("Piedra de sol", "Chardonnay", Color.blanco, 2017, Categoria.joven, null, 30,"San Antonio de las minas");
            vr.save(vino);
            System.out.println(vino);
            System.out.println("****************************");
            vr.remove(vr.getById(70));
            vino=vr.getById(58);
            vino.setNombre("Anibal de Otero Viña Centenaria");
            vino.setCepas("Mencía");
            vino.setColor(Color.tinto);
            vino.setCosecha(2014);
            vino.setCategoria(Categoria.reserva);
            vino.setEnologo("Pepe Hidalgo");
            vino.setTerruno("Bierzo");
            vr.update(vino);
            vr.getAll().forEach(System.out::println);
            System.out.println("*****************************");
            
            I_RankingRepositorio rr=new RankingRepositorio(conn); 
            Ranking ranking=new Ranking(RankingEnum.r4, 2, 13, 20);
            rr.save(ranking);
            System.out.println(ranking);
            System.out.println("****************************");
            rr.remove(rr.getById(1));
            ranking=rr.getById(10);
            ranking.setRanking(RankingEnum.r5);
            ranking.setUsuario_id(1);
            ranking.setVino_id(58);
            ranking.setTienda_id(1);
            rr.update(ranking);
            rr.getAll().forEach(System.out::println);
            System.out.println("*****************************");
            
            I_PremiosRepositorio pr=new PremioRepositorio(conn);
            Premio premio = new Premio(0,"Robert Parker Wine Advocate", 0,Medalla.oro,2010, 13);
            pr.save(premio);
            pr.remove(pr.getById(80));
            System.out.println(premio);
            System.out.println("****************************");
            premio=pr.getById(81);
            premio.setNombre_premio("jamessuckling.com");
            premio.setPuntaje(95);
            premio.setMedalla(Medalla.plata);
            premio.setAno(2012);
            pr.update(premio);
            pr.getAll().forEach(System.out::println);
            System.out.println("*****************************");
            
        } catch (Exception e) {e.printStackTrace();}
    }   
    
}
