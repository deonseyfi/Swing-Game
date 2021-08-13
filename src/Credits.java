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

class Credits extends JPanel{
    private JButton backCreditsBtn;
    CardLayout card;
    JPanel jPan;
    Credits()
    {
        setBackground(Color.BLACK);
        setSize(600,400);
       setLayout(null);
       backCreditsBtn = new JButton("Back");
       backCreditsBtn.setBounds(10,300,70,50);
       add(backCreditsBtn);
       backCreditsBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPan, "mm");
            }

        });
    }
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Serif",Font.ITALIC,36));
        g.setColor(Color.RED);
        g.drawString("Credits", 200, 50);
        g.setFont(new Font("Serif",Font.ITALIC,18));
        g.setColor(Color.WHITE);
        g.drawString("Deon Seyfi", 200, 200);
        g.drawString("Camron Fortenbery", 200, 250);
    }
}
