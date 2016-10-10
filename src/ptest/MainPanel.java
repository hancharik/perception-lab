/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
    JLabel titleLabel;
    JLabel endLabel;
    JButton startButton;// = new JButton("start");
    JButton pictureButton;// = new JButton("start");
    
    ImageIcon background = new ImageIcon("images/jacuzzi.jpg"); // photo from https://www.emaze.com/@AFRLOTIO/Jacuzzi
    Image backgroundImage = background.getImage();
    
    
    
    
    public MainPanel() throws IOException{
        
        super();
        
        setLayout(null);
         endLabel = new JLabel("Objective: find and click the jacuzzi button");
          endLabel.setBounds(320,100,600,180);
          setLabel(endLabel);
          add(endLabel);
         titleLabel = new JLabel("Find The Jacuzzi Game");
          titleLabel.setBounds(320,10,600,80);
          setLabel(titleLabel);
          add(titleLabel);
        startButton = new JButton("begin game");//startButton = new JButton("begin test");
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
        pPanel.setBounds(140,30,1000,600);
        add(pPanel);
        }else{
          setBackground(Color.GREEN);  
          startButton.setVisible(true);
           endLabel.setVisible(true);
          endLabel.setText("Thank You for participating.");//endLabel = new JLabel("Thank You");
         // endLabel.setBounds(400,200,200,200);
          setLabel(endLabel);
           titleLabel.setVisible(true);
          titleLabel.setText("You found the jacuzzi!");//endLabel = new JLabel("Thank You");
         // endLabel.setBounds(400,200,200,200);
          setLabel(titleLabel);
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
    
    
    
    public void setLabel(JLabel e){
       // http://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jendLabel-to-take-the-maximum-size 
        
        Font endLabelFont = e.getFont();
String endLabelText = e.getText();

int stringWidth = e.getFontMetrics(endLabelFont).stringWidth(endLabelText);
int componentWidth = e.getWidth();

// Find out how much the font can grow in width.
double widthRatio = (double)componentWidth / (double)stringWidth;

int newFontSize = (int)(endLabelFont.getSize() * widthRatio);
int componentHeight = e.getHeight();

// Pick a new font size so it will not be larger than the height of endLabel.
int fontSizeToUse = Math.min(newFontSize, componentHeight);

// Set the endLabel's font size to the newly determined size.
e.setFont(new Font(endLabelFont.getName(), Font.PLAIN, fontSizeToUse));
        
    }

        @Override
    public void actionPerformed(ActionEvent event) {
       
        	Object obj = event.getSource();
        
       
    
             
                 if (obj ==  startButton){
                     
                     if(startButton.getText().equals("quit")){
                         System.exit(0);
                     }else{
                         
                    
                     
                    try {
                        
                        startButton.setVisible(false);
                        endLabel.setVisible(false);
                        titleLabel.setVisible(false);
                        startButton.setText("quit");
                        addPanel();
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } // end try/catch
                    
                     }
                 } // end if
    }
    
    
    
    //https://www.emaze.com/@AFRLOTIO/Jacuzzi
    
    
      public void paintComponent(Graphics g) 
	{
    	super.paintComponent(g); 
    	g.drawImage(backgroundImage, 0, 0, this);
     }
     
    
} // end class
