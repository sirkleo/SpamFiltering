/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spamfiltering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jleonp
 */
public class SpamFiltering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
 
			
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    }
    
}
