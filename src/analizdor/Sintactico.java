package analizdor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @Edick Valdez
 */
public class Sintactico {
    int parentesis=0;
    Lexico l=new Lexico();
    public ArrayList<String> errors=new ArrayList<String>();
    Stack pc = new Stack();
    Stack pa = new Stack();
    
    boolean error;
    
public void AnalizarSintac(ArrayList<String> t1){
    
    for (int i = 0; i < t1.size(); i++) {
        
        if(CrearTabla(t1.get(i))){
            System.out.println("Linea: "+i+" Creacion de Tabla");
            System.out.println("Linea: "+i+" Modificacion de Tabla");
        }else if(Select(t1.get(i))){
            System.out.println("Linea: "+i+" Seleccion");
        }else if(Insert(t1.get(i))){
            System.out.println("Linea: "+i+" Insercion");
            pa.add("(");
            System.out.println("Linea: "+i+" Operador Relacional");
            parentesis++;
        }else if(t1.get(i).contains(")")){
            pc.add(")");
             System.out.println("Linea: "+i+" Operador Relacional");
             parentesis--;
        
        }else if(t1.get(i).equals("")){
             
         }else{
             errors.add("Linea: "+i+" Error Sintactico");
             error=true;
         }  
        }     
    }

public void Equilibrio(){
    if(pa.size()!=pc.size())
        {
            errors.add("Error Sintactico hacen falta parentesis");
            error=true;
        }
        else{
            System.out.println("Parentesis equilibrados");
        }
}

public boolean Insert(String linea){
    String linea2=linea.replace(",", "");

    int result1=linea2.compareToIgnoreCase("INSERTINTO");
    int result2=linea2.compareToIgnoreCase("VALUES()");
    int result3=linea2.compareToIgnoreCase("INSERTINTOVALUES()");
    if(result1==0||result2==0||result3==0){
        return true;
    }else{
        return false;
    }       
}

public boolean CrearTabla(String linea){
    int result1=linea.compareToIgnoreCase("CREATETABLE");
    if(result1==0){
        parentesis++;
        return true;
    }else{
        return false;
    }
}

public boolean Select(String linea){
    int result1=linea.compareToIgnoreCase("SELECT*FROMWHERE(=)");
    int result2=linea.compareToIgnoreCase("SELECT*FROMWHERE(>)");
    int result3=linea.compareToIgnoreCase("SELECT*FROMWHERE(<)");
    int result4=linea.compareToIgnoreCase("SELECT*FROMWHERE(>=)");
    int result5=linea.compareToIgnoreCase("SELECT*FROMWHERE(<=)");
    int result6=linea.compareToIgnoreCase("SELECT*FROM");
    int result7=linea.compareToIgnoreCase("SELECTFROMWHERE(=)");
    int result8=linea.compareToIgnoreCase("SELECTFROMWHERE(>)");
    int result9=linea.compareToIgnoreCase("SELECTFROMWHERE(<)");
    int result10=linea.compareToIgnoreCase("SELECTFROMWHERE(>=)");
    int result11=linea.compareToIgnoreCase("SELECTFROMWHERE(<=)");
    int result12=linea.compareToIgnoreCase("SELECTFROM");
    if(result1==0 || result2==0 ||result3==0 ||result4==0 ||result5==0 ||result6==0 ||result7==0 ||result8==0 ||result9==0 ||result10==0 || result11==0 || result12==0){
        return true;
    }else{
        return false;
    }
}
}

   


   
   

    

