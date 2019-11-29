package trabajopracticopoo2.vinoapp.tests;
import ar.org.centro8.curso.java.utils.Table;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_VinoRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.VinoRepositorio;
/*
Buscamos un método para obtener el vino recién registrado por el usuario e imprimirlo en el textArea y en una Tabla. 
Por eso buscamos el último índice "lastIndexOf()" "indexOf()".
*/

public class TestRecuperacionVinoPorIndice {
          
        public static void main(String[] args) {
    I_RankingRepositorio rr=new RankingRepositorio(Connector.getConnection());
    I_VinoRepositorio vr=new VinoRepositorio(Connector.getConnection());
    I_BodegaRepositorio br=new BodegaRepositorio(Connector.getConnection());
    int contador_indice=vr.getAll().size();
    JTable jTable = new JTable();
    List<String>lista=new ArrayList<>();
        
   lista.add(vr.getAll().get(contador_indice-1).toStringView());
        
    Table table = new Table();//La tabla está mandando excepciones
    table.cargar(jTable, lista);   
  
    System.out.println("Contador_Indice: "+contador_indice);
    System.out.println(lista);
        
    System.out.println(table);
    }

}