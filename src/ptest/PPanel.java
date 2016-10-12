/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mark
 */
public class PPanel extends JPanel implements ActionListener {

    int buttonNumber = 1;
    int randomNumber = 1;
    int height = 600;//720
    int width = 1000;//1280
    int rows = 3;//9
    int columns = 3;//5

    int errors = 0;

    long unixTimeStart;
    long unixTimeEnd;

    MainPanel main;

    ArrayList<JButton> pButtons;
    WordRandomizer wordRandomizer;

    public PPanel(int r, MainPanel p) throws IOException {

        super();
        setLayout(null);
        main = p;
        setBackground(Color.white);

        wordRandomizer = new WordRandomizer();

        rows = r;//(int)(Math.random() * 10) + 1;
        columns = rows;
        // pick a random number within range, this will be the target button
        randomNumber = (int) (Math.random() * rows * rows) + 1;
        addButtons();

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();

        for (int i = 0; i < pButtons.size(); i++) {

            if (obj == pButtons.get(i)) {
                if (pButtons.get(i).getText().equals("jacuzzi")) {//if (pButtons.get(i).getText().equals("dog")) {//
                    try {
                        unixTimeEnd = System.currentTimeMillis();
                        long totalTime = unixTimeEnd - unixTimeStart;
                        String rSet = rows * rows + "\t" + totalTime + "\t" + errors;

                        //System.out.println(rSet);
                        main.resultSet.add(rSet);

                        ptest.Ptest.p.mainPanel.updatePanel();

                    } catch (IOException ex) {
                        Logger.getLogger(PPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    pButtons.get(i).setText("error");
                    errors++;
                }

                break;
            }

        }

    } // end action listener

    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////
     ////////////////////ROWS AND COLUMNS FOR NULL LAYOUT////////////////////
     /////////////////////////////////////////////////////////>>>>>>>>>>>>>>>>>
    
    // RETURNS INTEGERS (column,row) FOR GRIDS
    
    
    private int row(int r) {
        int pixelNumber = ((r - 1) * (int) (height / 11)) + 20;
        return pixelNumber;
    }

    private int column(int c) {
        int columnPixelNumber = 0;

        switch (c) {  // these arent in cardinal order, i've been readjusting layouts
            //case 1: columnPixelNumber = ( width/8)*1; break;

            case 1:
                columnPixelNumber = (int) (width * .00);
                break;
            case 2:
                columnPixelNumber = (int) (width * .10);
                break;
            case 3:
                columnPixelNumber = (int) (width * .20);
                break;
            case 4:
                columnPixelNumber = (int) (width * .30);
                break;
            case 5:
                columnPixelNumber = (int) (width * .40);
                break;
            case 6:
                columnPixelNumber = (int) (width * .50);
                break;
            case 7:
                columnPixelNumber = (int) (width * .60);
                break;
            case 8:
                columnPixelNumber = (int) (width * .70);
                break;
            case 9:
                columnPixelNumber = (int) (width * .80);
                break;
            case 10:
                columnPixelNumber = (int) (width * .90);
                break;
        }
        return columnPixelNumber;
    } // end column  

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<////////////////////////////////////////
     ////////////////////ROWS AND COLUMNS FOR NULL LAYOUT////////////////////
     ////////////////////////////////////////////////////////////////////////
    
    
    
    
    private void addButtons() {
        unixTimeStart = System.currentTimeMillis();
        pButtons = new ArrayList();

        for (int i = 1; i < columns + 1; i++) {
            for (int j = 1; j < rows + 1; j++) {

                JButton b = new JButton("" + buttonNumber);
                if (buttonNumber == randomNumber) {
                   b.setText("jacuzzi");// b.setText("dog");//
                } else {
                    b.setText(wordRandomizer.getRandomWord());
                }
                b.setBounds(column(i), row(j), width / 11, 40);
                b.addActionListener(this);
                add(b);
                pButtons.add(b);
                buttonNumber++;
            }
        }

    } // end add buttons

} // end
