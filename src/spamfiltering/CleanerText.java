/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamfiltering;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author jleonp
 */
public class CleanerText {
    
    HashMap<String, Boolean> stopWords;

    public CleanerText() {
        initStopWords();     
    }
    
    private void initStopWords(){
        BufferedReader br ;
        stopWords = new HashMap();
        stopWords.put("", Boolean.TRUE);
        try{
            br = new BufferedReader(new FileReader("stopwords_spanish.txt"));
            String linea;
            while((linea=br.readLine())!=null){
                stopWords.put(linea.trim(), Boolean.TRUE);
            }
            br = new BufferedReader(new FileReader("stopwords_english.txt"));
            while((linea=br.readLine())!=null){
                stopWords.put(linea.trim(), Boolean.TRUE);
            }
            
        }catch(IOException e){
            
        }
    }
    public  boolean isStopWord(String word) {
        return stopWords.get(word);
    }

    /*public Boolean findStopWord(String word) {
        HashMap<String, Boolean> stopWords = reloadStopWords();
        return stopWords.get(word);
    }*/


    public static void main(String args[]) {
        try {
            CleanerText cleaner = new CleanerText();
            //System.out.println(cleaner.stopWords.get("que"));
            FileInputStream fstream = new FileInputStream("/local_home/markov/Downloads/SpamFiltering/mailtex.txt");
            InputStreamReader Fichero = new InputStreamReader(fstream, "ISO-8859-1");//ISO-8859-1
            BufferedReader br = new BufferedReader(Fichero);
            String linea;
            HashMap<String, Integer> hashmap = new HashMap<>();
            //int line=1;
            while ((linea = br.readLine()) != null) {
                String[] wordsInLine = linea.split("\\ ");
                for (String word : wordsInLine) {
                    word = word.toLowerCase().trim();
                    if (cleaner.stopWords.get(word)!=null) {
                        continue;
                    }
                    if (hashmap.get(word) == null) {
                        hashmap.put(word, 1);
                    } else {
                        int conteo = hashmap.get(word);
                        ++conteo;
                        hashmap.put(word, conteo);
                    }
                }
            }
            ListaOrdenada lista = new ListaOrdenada();
            Set<String> words = hashmap.keySet();
            for (String word : words) {
                lista.insertar(word, hashmap.get(word));
            }
            lista.imprimir();
        } catch (IOException ex) {
            System.out.println("Error en lectura y escritura: " + ex.getMessage());
        }
    }
}
