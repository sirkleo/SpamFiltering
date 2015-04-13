/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spamfiltering;

/**
 *
 * @author jleonp
 */
public class NaiveBayes {
    public double getVarianza(double[] muestra){
        double resultado=0;
        for(double elemento: muestra){
            resultado+=Math.pow(elemento, 2);
        }
        resultado= resultado/muestra.length;
        resultado= resultado - Math.pow(getMedia(muestra),2);
        return resultado;
    }
    public double getMedia(double[] muestra){
        double resultado=0;
        for(double elemento: muestra)
            
            resultado+=elemento;
        return resultado/muestra.length;
    }
    public static void main(String args[]){
        NaiveBayes naive = new NaiveBayes();
        double[] muestra ={9, 40, 99, 192, 143,112,15};
        System.out.println(naive.getMedia(muestra));
        System.out.println(naive.getVarianza(muestra));
    }
}
