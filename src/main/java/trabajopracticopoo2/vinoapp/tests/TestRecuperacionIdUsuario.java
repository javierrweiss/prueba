package trabajopracticopoo2.vinoapp.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import trabajopracticopoo2.vinoapp.entidades.Usuario;
import trabajopracticopoo2.vinoapp.gui.FormularioDeRegistro;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.UsuarioRepositorio;

public class TestRecuperacionIdUsuario {
    
    public static void main(String[] args) {
     I_UsuarioRepositorio ur=new UsuarioRepositorio(Connector.getConnection());
     Usuario us = new Usuario();  
     FormularioDeRegistro.username="amandaloveswines";
     //us.getCuenta_usuario();
     List<Usuario>lista_usuario=new ArrayList<>();
     lista_usuario=ur.getAll().stream().filter(u->u.getCuenta_usuario()
             .equalsIgnoreCase(FormularioDeRegistro.username)).collect(Collectors.toList());
     int usuario_id=lista_usuario.get(0).getUsuario_id();
     System.out.println(usuario_id);
//     int resultado;
//        resultado =Integer.valueOf(ur.getAll().stream().filter(u->u.getUsuario_id()==Integer.valueOf(flujo_usuario)).toString());
//        System.out.println(flujo_usuario);
//     int usuario_id=Integer.getInteger(resultado);
  //      System.out.println(usuario_id);
    }
}
