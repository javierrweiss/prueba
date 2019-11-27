package chat;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import javax.swing.JTextArea;
public class ServidorChatR implements Runnable{
    private final JTextArea txa;
    public ServidorChatR(JTextArea txa) {
        this.txa = txa;
    }
    @Override
    public void run(){
        try (ServerSocket ss=new ServerSocket(8900);) {
            while(true){
                try (Socket so=ss.accept();
                    BufferedReader in=new BufferedReader(
                        new InputStreamReader(so.getInputStream())
                    )
                ){
                    String ip=so.getInetAddress().getHostAddress();
                    String nombre=ip;
                    for(String s:MapaDirecciones.getMapa().keySet()){
                        if(MapaDirecciones.getMapa().get(s).equals(ip)) nombre=s;
                    }
                } catch (Exception ee) { ee.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}