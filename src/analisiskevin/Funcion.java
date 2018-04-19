/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisiskevin;

import org.nfunk.jep.JEP;

/**
 *
 * @author joker
 */
public class Funcion {
    
    JEP jep= new JEP();
    
        public Funcion(String funcion){
            jep.addVariable("x", 0);
            jep.addStandardConstants();
            jep.addStandardFunctions();
            jep.parseExpression(funcion);
            if(jep.hasError()){
                System.out.println(jep.getErrorInfo());
            }
        
        }
    public double evaluar(double x){
        double resp;
        
        jep.addVariable("x", x);
        resp=jep.getValue();
            if(jep.hasError()){
                System.out.println(jep.getErrorInfo());
            }
         
        return resp;
        
    }
    
    public static double [] SacarCoeficientes(String funci){
          int k=0;
        String[] funcion;
         funcion = funci.split("[x^\\d\\*.|+-]");
        double [] separador = new double[funcion.length];
       
       
        for (String elemento : funcion) {    
            if(elemento.equals("")){
                
            }else{
            separador[k]=Double.parseDouble(elemento);
            k++;
        }
        }
        double [] coeficientes= new double [k];
     
        for (int i = 0; i <coeficientes.length; i++) { 
          coeficientes[i]=separador[i];
     }  

        for (int i = 0; i <coeficientes.length; i++) {
             System.out.println("posicion "+ i+"  value= "+coeficientes[i]); 
        }
        
        return coeficientes;
        
    }
       
        
}
