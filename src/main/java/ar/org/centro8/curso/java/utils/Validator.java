package ar.org.centro8.curso.java.utils;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Validator {
    private JTextField txt;
    public Validator(JTextField txt) { this.txt = txt; }
        private boolean error(String mensaje){
        JOptionPane.showMessageDialog(txt, mensaje,"Error",
                JOptionPane.ERROR_MESSAGE);
        txt.selectAll();
        txt.requestFocus();
        return false;
    }
    public boolean length(int length){
        if(txt.getText().length()==length) return true;
        return error("Debe tener "+length+" caracteres.");
    }
    public boolean length(int min,int max){
        if(txt.getText().length()>=min && txt.getText().length()<=max)
            return true;
        return error("Debe tener entre "+min+" y "+max+" caracteres.");
    }
    public boolean isInteger(){
        try {
            Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            return error("Debe ser un número entero.");
        }
    }
    public boolean isInteger(int min,int max){
        if(!isInteger()) return isInteger();
        int nro=Integer.parseInt(txt.getText());
        if(nro>=min && nro<=max) return true;
        return error("Debe ser un número entero entre "+min+" y "+max);
    }
}