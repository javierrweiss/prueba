package chat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
public class MapaDirecciones {
    public static Map<String,String>getMapa(){
        Map<String,String>mapa=new TreeMap();
        mapa.put("CarlosR","172.16.1.100");
        mapa.put("SebastianR","172.16.1.104");
        mapa.put("Gabriela","172.16.1.108");
        mapa.put("Gabriel","172.16.1.107");
        mapa.put("SebastianF","172.16.1.112");
        mapa.put("CarlosC","172.16.1.101");
        mapa.put("Francisco","172.16.1.102");
        mapa.put("Alejandro","172.16.1.106");
        mapa.put("Gaston","172.16.1.109");
        mapa.put("Javier","172.16.1.110");
        mapa.put("Sharbel","172.16.1.103");
        mapa.put("nn","172.16.1.105");
        mapa.put("nn2","172.16.1.111");
        return mapa;
    }
}
