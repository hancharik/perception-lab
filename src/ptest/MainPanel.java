/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mark
 */
public class MainPanel extends JPanel implements ActionListener{
    
    PPanel pPanel;
    ArrayList<String> resultSet = new ArrayList();
    JLabel endLabel;
    JButton startButton;// = new JButton("start");
    
    
    public MainPanel() throws IOException{
        
        super();
        
        setLayout(null);
         endLabel = new JLabel("Objective: click the jacuzzi button");
          endLabel.setBounds(320,100,600,280);
          setLabel();
          add(endLabel);
        startButton = new JButton("begin test");
        startButton.setBounds(550,340,120,40);
        startButton.addActionListener(this);
        add(startButton);
       // setBackground(Color.BLUE);
       // pPanel = new PPanel();
        //addPanel();
        
    }
   
    public void addPanel() throws IOException{
        
        if(ptest.Ptest.sizes.size()>0){// if(ptest.Ptest.attempts>0){
       // this.remove(pPanel);
        pPanel = new PPanel(getArraySize(), this);
        pPanel.setBounds(100,60,1000,600);
        add(pPanel);
        }else{
          setBackground(Color.GREEN);  
          startButton.setVisible(true);
           endLabel.setVisible(true);
          endLabel.setText("Thank You");//endLabel = new JLabel("Thank You");
         // endLabel.setBounds(400,200,200,200);
          setLabel();
          //add(endLabel);
          long unixTimeEndTest = System.currentTimeMillis();
          double totalTime = (unixTimeEndTest - ptest.Ptest.unixTimeStartTest)/1000;
          System.out.println("total time in seconds is " + (int)totalTime/60 + " minutes and " + totalTime%60 + " seconds");// System.out.println("the array size is " + resultSet.size() + ", total time in seconds is " + totalTime);
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
    
    
    
    public void setLabel(){
       // http://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jendLabel-to-take-the-maximum-size 
        
        Font endLabelFont = endLabel.getFont();
String endLabelText = endLabel.getText();

int stringWidth = endLabel.getFontMetrics(endLabelFont).stringWidth(endLabelText);
int componentWidth = endLabel.getWidth();

// Find out how much the font can grow in width.
double widthRatio = (double)componentWidth / (double)stringWidth;

int newFontSize = (int)(endLabelFont.getSize() * widthRatio);
int componentHeight = endLabel.getHeight();

// Pick a new font size so it will not be larger than the height of endLabel.
int fontSizeToUse = Math.min(newFontSize, componentHeight);

// Set the endLabel's font size to the newly determined size.
endLabel.setFont(new Font(endLabelFont.getName(), Font.PLAIN, fontSizeToUse));
        
    }

        @Override
    public void actionPerformed(ActionEvent event) {
       
        	Object obj = event.getSource();
        
       
    
             
                 if (obj ==  startButton){
                     
                     if(startButton.getText().equals("quit")){
                         System.exit(0);
                     }else{
                         
                    
                     
                    try {
                        addPanel();
                        startButton.setVisible(false);
                        endLabel.setVisible(false);
                        startButton.setText("quit");
                    } catch (IOException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } // end try/catch
                    
                     }
                 } // end if
    }
    
    
    
    
    
    
    
    
} // end class
