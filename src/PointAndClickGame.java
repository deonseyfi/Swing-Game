/***************************************************************
* file: PointAndClickGamejava
* author: Deon Seyfi, Camron Fortenbery
* class: CS 2450 - Graphical User Interface
*
* assignment: program 1 v1.0
* date last modified: 9/25/2019
*
* purpose: The purpose of this program is to create a functioning game menu to flip through pages and have a functioning game that keeps highscores.
*
****************************************************************/ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PointAndClickGame {
public static void main(String[] args) {
 SwingUtilities.invokeLater(new Runnable() {
 public void run() {
 createAndShowGUI();
 }
 });
 }

private static void createAndShowGUI() {
JPanel jPan = new JPanel(new CardLayout());

Score score = new Score();
   
 
 System.out.println("Created GUI on EDT? "+
 SwingUtilities.isEventDispatchThread());
 
 JFrame f = new JFrame("Basic JFrame");
 f.add(jPan);
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setSize(600,400);
JPanel start = new Start();
MainMenu mm = new MainMenu();
Credits credits = new Credits();
HighScore highScore = new HighScore();
Hangman hangman = new Hangman(score);
ColorGame colorGame = new ColorGame(score);
PongPanel pong = new PongPanel();
Sudoku sudoku = new Sudoku(score, highScore);






jPan.add(start,"start");
jPan.add(mm,"mm");
jPan.add(credits,"credits");
jPan.add(highScore,"highscore");
jPan.add(hangman,"hangman");
jPan.add(colorGame,"colorGame");
jPan.add(pong, "Pong");
jPan.add(sudoku, "Sudoku");


CardLayout card = (CardLayout) (jPan.getLayout());
card.show(jPan, "start");
credits.card = card;
credits.jPan = jPan;
highScore.card = card;
highScore.jPan = jPan;
hangman.card = card;
hangman.jPan = jPan;
colorGame.card = card;
colorGame.jPan = jPan;
pong.card = card;
pong.jPan = jPan;
sudoku.card = card;
sudoku.jPan = jPan;





 Timer t = new Timer(5000,new ActionListener() {

     public void actionPerformed(ActionEvent e) {
        System.out.println("Event Triggered");
        card.show(jPan, "mm");
        mm.passCard(card,jPan);    
     }
 }
 );
 t.setRepeats(false);
 t.start();
 
 f.setVisible(true);
 
 
 //Bindings will be put here Since they don't work anywhere else
  jPan.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "start"); 
  jPan.getActionMap().put("start", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getBall().pressed();
        
         }    
  }
  );
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke("W"), "P2Up");
  jPan.getActionMap().put("P2Up", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer2().pressedUp();
         }    
  }
  ); 
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke("S"), "P2Down");  
  jPan.getActionMap().put("P2Down", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer2().pressedDown();
         }    
  }
  );
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "P2DownR");
  jPan.getActionMap().put("P2DownR", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer2().released();
         }    
  }
  ); 
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "P2UpR");
  
  jPan.getActionMap().put("P2UpR", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer2().released();
         }    
  }
  );
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke("UP"), "P1Up");
  jPan.getActionMap().put("P1Up", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer1().pressedUp();
         }    
  }
  ); 
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "P1Down");  
  jPan.getActionMap().put("P1Down", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer1().pressedDown();
         }    
  }
  );
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "P1DownR");
  jPan.getActionMap().put("P1DownR", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer1().released();
         }    
  }
  ); 
  
  jPan.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "P1UpR");
  
  jPan.getActionMap().put("P1UpR", new AbstractAction() 
  {     
  public void actionPerformed(ActionEvent e) 
         {
          pong.getPlayer1().released();
         }    
  }
  ); 
  
 }

    
}
