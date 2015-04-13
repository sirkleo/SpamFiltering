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
public class Word {
    String word;
    double media;
    double varianza;

    public Word(String word, double media, double varianza) {
        this.word = word;
        this.media = media;
        this.varianza = varianza;
    }
    
    
    
}
