package ar.org.centro8.curso.java.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class FileText implements I_FileText{
    private File file;
    public FileText(File file)  { this.file = file;             }
    public FileText(String file){ this.file = new File(file);   }
    @Override public void print() {
        int car;
        try (FileReader in=new FileReader(file)) {
            while((car=in.read())!=-1){
                System.out.print((char)car);
            }
        } catch (Exception e) { e.printStackTrace(); }
        System.out.println();
    }
    @Override public String getText() {
        //String text="";
        StringBuilder sb=new StringBuilder();
        int car;
        try (FileReader in=new FileReader(file)) {
            while((car=in.read())!=-1){
                //text+=(char)car;
                sb.append((char)car);
            }
        } catch (Exception e) { e.printStackTrace(); }
        //return text;
        return sb.toString();
    }
    @Override public void setText(String text) {
        try (FileWriter out=new FileWriter(file)) {
            out.write(text);
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override public void append(String text) {
        try (FileWriter out=new FileWriter(file,true)) {
            out.write(text);
        } catch (Exception e) { e.printStackTrace(); } 
    }
    @Override public List<String> getLines() {
        List<String>list=new ArrayList();
        try (BufferedReader in=new BufferedReader(new FileReader(file))) {
            return in.lines().collect(Collectors.toList());
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }    

    @Override
    public void append(char[] text) {
    try (FileWriter out=new FileWriter(file,true)) {
            out.write(text);
        } catch (Exception e) { e.printStackTrace(); } 
    }
}