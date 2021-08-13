/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dion
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HighScore extends JPanel{
    private JButton backHighScoreBtn;
    CardLayout card;
    JPanel jPan;
    int highScoreValue [] = {480,350,200,0,0};
    String highScoreName [] = {"Bill","Bob","Joe","abc","abc"};
    HighScore()
    {
        setBackground(Color.BLACK);
        setSize(600,400);
       setLayout(null);
       backHighScoreBtn = new JButton("Back");
       backHighScoreBtn.setBounds(10,300,70,50);
       add(backHighScoreBtn);
       backHighScoreBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPan, "mm");
            }

        });
    }
    
    public void newHighScore(Score score)
    {
        for(int x = 0; x < highScoreValue.length; x++)
        {
            if(score.getPoints() > highScoreValue[x])
            {
                int temp = highScoreValue[x];
                String tempName = highScoreName[x];
                highScoreValue[x] = score.getPoints();
                highScoreName[x] = score.getName();
                score.setName(tempName);
                score.setPoints(temp);
            }
        }
    }
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Serif",Font.ITALIC,36));
        g.setColor(Color.GREEN);
        g.drawString("HighScores", 200, 50);
        g.setFont(new Font("Serif",Font.ITALIC,18));
        g.setColor(Color.WHITE);
        g.drawString(highScoreName[0]+"....."+highScoreValue[0], 200, 120);
        g.drawString(highScoreName[1]+"....."+highScoreValue[1], 200, 140);
        g.drawString(highScoreName[2]+"....."+highScoreValue[2], 200, 160);
        g.drawString(highScoreName[3]+"....."+highScoreValue[3], 200, 180);
        g.drawString(highScoreName[4]+"....."+highScoreValue[4], 200, 200);
        
    }
}