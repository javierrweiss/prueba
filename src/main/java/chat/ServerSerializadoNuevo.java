package chat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerSerializadoNuevo {
    public static void main(String[] args) {
        try (ServerSocket ss=new ServerSocket(5000)){
            while(true){
                System.out.println("Esperando conexión de cliente.");
                try (Socket so=ss.accept();
                    ObjectInputStream in=new ObjectInputStream(so.getInputStream());
                    ObjectOutputStream out=new ObjectOutputStream(so.getOutputStream());){
                    try {
                        System.out.println("Se conectó "+so.getInetAddress());
                        ObjectInputStream.GetField v=in.readFields();
                        System.out.println(v);
                        out.writeUTF("Objecto recibido.");
                    } catch (ClassCastException | ClassNotFoundException e) {
                        out.writeUTF("Objecto recibido de clase incorrecta.");
                    }
                } catch (Exception e) { e.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}