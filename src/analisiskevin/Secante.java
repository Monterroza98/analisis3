/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisiskevin;
/**
 *
 * @author joker
 */
public class Secante {
 double x2,Ea,x0,x1;
 
 int k;
    public double [] raiz(Funcion f,double x0,double x1,double Err){
       double r=Double.NaN;
         x2=x0;
         //contador de iteraciones
         k=1;
        Ea=100;
        while(Math.abs(f.evaluar(x2))>Err){
            x2=x0-f.evaluar(x0)*(x1-x0)/(f.evaluar(x1)-f.evaluar(x0));
            x0=x1;
            x1=x2;
            Ea=f.evaluar(x2);
         k++;   
        }
       
        r=x2;
        double valores[]={r,Ea};
        return valores;
    }

 
    

   
    
    
    
}
