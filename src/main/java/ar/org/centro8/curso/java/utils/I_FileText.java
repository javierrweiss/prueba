package ar.org.centro8.curso.java.utils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
public interface I_FileText {
    void print();
    String getText();
    void setText(String text);
    void append(String text);
    void append(char[] text);
    default void addLine(String line)   { append(line+"\n");    }
    default void clear()                { setText("");          }
    List<String>getLines();
    default List<String>getLines(String filter){
        if(filter==null) return new ArrayList<>();
        return getLines()
                .stream()
                .filter(line->line.toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<String>getSortedLines(){
        return getLines()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
    default List<String>getReversedSortedLines(){
        return getLines()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    default LinkedHashSet<String>getLinkedHashSetLines(){
        LinkedHashSet<String> set=new LinkedHashSet();
        set.addAll(getLines());
        return set;
    }
    default TreeSet<String>getTreeSetLines(){
        TreeSet<String> set = new TreeSet();
        set.addAll(getLines());
        return set;
    }
    default void removeLine(String line){
        if(line==null) return;
        List<String>list=getLines();
        list.remove(line);
        clear();
        list.forEach(this::addLine);
    }
}
