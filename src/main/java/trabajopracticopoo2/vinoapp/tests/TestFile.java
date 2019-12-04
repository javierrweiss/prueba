package trabajopracticopoo2.vinoapp.tests;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import ar.org.centro8.curso.java.utils.FileText;
import ar.org.centro8.curso.java.utils.I_FileText;
import java.io.File;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.VinoRepositorio;

public class TestFile {
   static VinoRepositorio vr=new VinoRepositorio(Connector.getConnection());  
    public static void main(String[] args) {
        //File f = new File("~/NetBeansProjects/prueba/"+vr.getUltimo().getNombre()+".txt");
        String file=vr.getUltimo().getNombre()+".txt";
        I_FileText ft= new FileText(file);
        System.out.println(file);
        ft.setText("ljdfkljfkljfsjklfdjklfjsfddklfjklsfkljfgjfklsnkldcnakldnfjafKÑLKdfaldfladsfñadsgkldfsagfewpjpafjdsnaklvnnvkldjfkj");
        ft.getLines().forEach(System.out::println);
    }
    
}
