/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptest;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author mark
 */
public class MainPanel extends JPanel{
    
    PPanel pPanel;
    ArrayList<String> resultSet = new ArrayList();
    
    public MainPanel() throws IOException{
        
        super();
        
        setLayout(null);
       // setBackground(Color.BLUE);
       // pPanel = new PPanel();
        addPanel();
        
    }
   
    public void addPanel() throws IOException{
        
        if(ptest.Ptest.sizes.size()>0){// if(ptest.Ptest.attempts>0){
       // this.remove(pPanel);
        pPanel = new PPanel(getArraySize(), this);
        pPanel.setBounds(100,60,1000,600);
        add(pPanel);
        }else{
          setBackground(Color.GREEN);  
          System.out.println("the array size is " + resultSet.size());
          pPanel.wordRandomizer.createFile(resultSet);
        }
    } // end add panel
    
    
     public void updatePanel() throws IOException{
        
       remove(pPanel);
    //   setBackground(Color.yellow);
        addPanel();
        repaint();
    } 
    
    public int getArraySize(){
       
        int arrayElement = (int)(Math.random() * ptest.Ptest.sizes.size());
       // System.out.println("array element = " + arrayElement + ", size = " + ptest.Ptest.sizes.size());
        int t = ptest.Ptest.sizes.get(arrayElement);
       // System.out.println("t = " + t); 
        ptest.Ptest.sizes.remove(arrayElement);
        return t;
        }
    
    
}
