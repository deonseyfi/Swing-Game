/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dion
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
public class MainMenu extends JPanel {
    private JButton jbtnPlayPong;
    private JButton jbtnPlay;
    private JButton jbtnHighScore;
    private JButton jbtnCredits;
    private JButton addBtn;
    public static Score currentPlayer;
    CardLayout card;
    JPanel jPan;
    MainMenu()
    {
        setBackground(Color.BLACK);
        setSize(600,400);
        setLayout(null);
        
        jbtnPlayPong = new JButton("Play Pong");
        jbtnPlayPong.setBounds(450,155,100,40);
        add(jbtnPlayPong);
        jbtnPlayPong.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPan, "Pong");
                
            }
        });
        
        jbtnPlay = new JButton("Play");
        jbtnPlay.setBounds(450,200,100,40);
        add(jbtnPlay);
        jbtnPlay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPan, "hangman");
                 currentPlayer = new Score();
            }

        });
        jbtnHighScore = new JButton("HighScore");
        jbtnHighScore.setBounds(450,245,100,40);
        add(jbtnHighScore);
        jbtnHighScore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPan, "highscore");
            }

        });
        jbtnCredits = new JButton("Credits");
        jbtnCredits.setBounds(450,290,100,40);
        add(jbtnCredits);
        card = null;
        jPan = null;
        jbtnCredits.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPan, "credits");
            }

        });
    }
    public void passCard(CardLayout input, JPanel jInput)
    {
        card = input;
        jPan = jInput;
    }
    
}
