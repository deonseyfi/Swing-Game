
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ComponentListener;
import javax.swing.InputMap;
import javax.swing.ActionMap;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;


public class PongPanel extends JPanel implements KeyListener, ActionListener
{
    private Paddle p1;
    private Paddle p2;
    private PongBall ball;
    
     CardLayout card;
     JPanel jPan;
 
    public PongPanel()
    {
        

    
         
        setBackground(Color.BLACK);
        setSize(600, 400);
        setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        
        
        p1 = new Paddle(this, KeyEvent.VK_UP, KeyEvent.VK_DOWN, this.getWidth()- 36);
        p2 = new Paddle(this, KeyEvent.VK_W, KeyEvent.VK_S, 20);
        
        ball = new PongBall(this, KeyEvent.VK_SPACE);
        
        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(500, 5, 80, 35);
        
        add(quitButton);
        
        quitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                card.show(jPan, "mm");
               
            }
        });
        
        Timer timer = new Timer(27, this);
        timer.start();
        
       
        
       
       
        System.out.println(this.isFocusOwner());
    }
    
    public Paddle getPlayer1()
    {
        return p1;
    }
    
    public Paddle getPlayer2()
    {
        return p2;
    }
    
    public PongBall getBall()
    {
        return ball;
    }
    
    private void update() 
    {
       
        p1.update();
        p2.update();
        ball.update();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
       
      
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        
    }
    
    public void keyTyped(KeyEvent e)
    {
       
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Serif",Font.ITALIC,36));
        g.setColor(Color.YELLOW);
        g.drawString("Pong", 50, 30);
        g.setFont(new Font("Serif",Font.BOLD,36));
        g.setColor(Color.WHITE);
        g.drawString("Score:", 150, 30);
        g.drawLine(300, 5, 300, 35);
        g.drawLine(0, 50, 600, 50);
        g.drawString(String.valueOf(ball.p1Score), 260, 30);
        g.drawString(String.valueOf(ball.p2Score), 310, 30);
        if(ball.p1Score >= 3)
            g.drawString("P1 is the pong champion", 100 , 100);
        if(ball.p2Score >= 3)
            g.drawString("P2 is the pong champion", 100 , 100);
        
        ball.paint(g);
        p1.paint(g);
        p2.paint(g);
        
    }
    
    public void passCard(CardLayout input, JPanel jInput)
    {
        card = input;
        jPan = jInput;
    }
    
    
    
    
    
}
