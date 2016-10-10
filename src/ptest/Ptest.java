/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark
 */
public class Ptest {

    
    static int height = 720;//720
    static int width = 1280;//1280
    static int rows = 3;//9
    static int columns = 3;//5
    static PFrame p;
    static long unixTimeStartTest;
     long unixTimeEnd;
    static int attempts;
    static ArrayList<Integer> sizes;
   // static int[] sizes = {1,2,3,4};
    //static int[] sizes = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};
    
    
    
    public static void main(String[] args) {
      
        unixTimeStartTest = System.currentTimeMillis();
        
        fillSizes();
        
         attempts = sizes.size();
            
        try {
            p = new PFrame(width, height);
        } catch (IOException ex) {
            Logger.getLogger(Ptest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }  // end main
    
    
    
  static void fillSizes(){
      
      sizes = new ArrayList();
      
      sizes.add(1);
      sizes.add(2);
      sizes.add(3);
    
      sizes.add(4);
      sizes.add(5);
      sizes.add(6);
      sizes.add(7);
      sizes.add(8);
      sizes.add(9);
      sizes.add(10);
      sizes.add(1);
      sizes.add(2);
      sizes.add(3);
      sizes.add(4);
      sizes.add(5);
      sizes.add(6);
      sizes.add(7);
      sizes.add(8);
      sizes.add(9);
      sizes.add(10);
      sizes.add(1);
      sizes.add(2);
      sizes.add(3);
      sizes.add(4);
      sizes.add(5);
      sizes.add(6);
      sizes.add(7);
      sizes.add(8);
      sizes.add(9);
      sizes.add(10);
      sizes.add(1);
      sizes.add(2);
      sizes.add(3);
      sizes.add(4);
      sizes.add(5);
      sizes.add(6);
      sizes.add(7);
      sizes.add(8);
      sizes.add(9);
      sizes.add(10);

  } 
    
    
    
    
} // end
