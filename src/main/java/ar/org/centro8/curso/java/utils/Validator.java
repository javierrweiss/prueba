package ar.org.centro8.curso.java.utils;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Validator {
    private JTextField txt;

    public Validator() {
    }
    
    public Validator(JTextField txt) { this.txt = txt; }

        private boolean error(String mensaje){
        JOptionPane.showMessageDialog(txt, mensaje,"Error",
                JOptionPane.ERROR_MESSAGE);
        txt.selectAll();
        txt.requestFocusInWindow();
        return false;
    }
    public boolean length(int length){
        if(txt.getText().length()==length) return true;
        //return error("El campo "+txt.getName()+" debe tener "+length+" caracteres.");
        return error(txt.getToolTipText());
    }
    public boolean length(int min,int max){
        if(txt.getText().length()>=min && txt.getText().length()<=max)
            return true;
        //return error("El campo "+txt.getName()+" debe tener entre "+min+" y "+max+" caracteres.");
        return error(txt.getToolTipText());
    }
    public boolean isInteger(){
        try {
            Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            //return error("El campo "+txt.getName()+" debe ser un número entero.");
            return error(txt.getToolTipText());
        }
    }
    public boolean isInteger(int min,int max){
        if(!isInteger()) return isInteger();
        int nro=Integer.parseInt(txt.getText());
        if(nro>=min && nro<=max) return true;
        //return error("El campo "+txt.getName()+" debe ser un número entero entre "+min+" y "+max);
        return error(txt.getToolTipText());
    }
    
//    public boolean isEmailValid(JTextField txt){
//        while (!txt.getText().matches("[^A-Za-z0-9.@_-~#]")){
//            error("Usted ha proporcionado una dirección de email no válida");
//            break;
//        }    
//        return true;
//        }
    /*
    La presente expresión regular para validar email fue tomada de 
    https://programacion.net/articulo/expresiones_regulares_en_java_127
    */             
    }
    
