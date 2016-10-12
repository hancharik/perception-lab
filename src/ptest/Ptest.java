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

    static void fillSizes() {

        sizes = new ArrayList();

        // set number of repetitions to four
        for (int repetitions = 0; repetitions < 2; repetitions++) {

            // set sizes 1-10
            for (int i = 1; i < 11; i++) {
                sizes.add(i);
            }
        }

    }

} // end
