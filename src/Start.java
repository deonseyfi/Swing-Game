/***************************************************************
* file: Start.java
* author: Deon Seyfi, Camron Fortenberry
* class: CS 2450 - Graphical User Interface
*
* assignment: program 1 v1.0
* date last modified: 9/25/2019
*
* purpose: The purpose of this program is to create the start page that displays when running the program
*
****************************************************************/ 
import javax.swing.*;
import java.awt.*;

class Start extends JPanel{
    Start()
    {
       setBackground(Color.BLACK);
       setSize(600,400);
       setLayout(null);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Serif",Font.ITALIC,36));
        g.setColor(Color.CYAN);
        g.drawString("CS 2450 Semester Project", 120, 50);
        g.drawString("By:Swingers", 120, 300);
    }
}
