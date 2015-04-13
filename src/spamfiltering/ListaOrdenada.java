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
public class ListaOrdenada {
    
    class Nodo {
        int info;
        String word;
        Nodo sig;
    }
    
    private Nodo raiz;
    
    public ListaOrdenada() {
        raiz=null;
    }
      
    void insertar(String word,int x)
    {
        Nodo nuevo = new Nodo ();
        nuevo.info = x;
        nuevo.word = word;
        
        if (raiz==null) {
            raiz=nuevo;
        } else {
            if (x<raiz.info) {
                nuevo.sig=raiz;
                raiz=nuevo;
            } else {
                Nodo reco=raiz;
                Nodo atras=raiz;
                while (x>=reco.info && reco.sig!=null) {
                    atras=reco;
                    reco=reco.sig;
                }
                if (x>=reco.info) {
                    reco.sig=nuevo;
                } else {
                    nuevo.sig=reco;
                    atras.sig=nuevo;
                }
            }
        }
    }

    public void imprimir () {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.println(reco.word+" - "+reco.info);
            reco = reco.sig;
        }
        System.out.println();
    }
        
    
    public static void main(String[] ar) {
        ListaOrdenada lo=new ListaOrdenada();
        lo.insertar("hola",10);
        lo.insertar("hi",5);
        lo.insertar("te",7);
        lo.insertar("holaa",50);
        lo.insertar("rw",1);
        lo.imprimir();
    }
}
