
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Random;

public class PongBall 
{
    private PongPanel panel;
    private int ballWidth = 15;
    private int ballHeight = 15;
    private int panelHeight;
    private int panelWidth;
    private int x;
    private int y;
    private int xa = 0;
    private int ya = 0;
    private int start;
    public int p1Score = 0;
    public int p2Score = 0;

    public PongBall(PongPanel Panel, int StartKeyValue) 
    {
        panel = Panel;
        panelHeight = Panel.getHeight();
        panelWidth = Panel.getWidth();
        x = Panel.getWidth() / 2;
        y = Panel.getHeight() / 2;
        start = StartKeyValue;
        
    }

    public void update() 
    {
        x += xa;
        y += ya;
        if (x < 20) 
        {
            x = panelWidth / 2;
            y = panelHeight / 2;
            xa = 0;
            ya = 0;
            p2Score++;
        }
        else if (x > 580) 
        {
            x = panelWidth / 2;
            y = panelHeight / 2;
            xa = 0;
            ya = 0;
            p1Score++;
        }
        else if (y < 55 || y > 345)
        {
            ya = -ya;
        }
        checkCollision();
    }
    
    public void pressed()
    {
         
            int r1 = new Random().nextInt(2);
            int r2 = new Random().nextInt(2);
            if(r1 == 1)
                xa = -5;
            else
                xa = 5;
            if(r2 == 1)
                ya = 5;
            else
                ya = -5;
        
    }

    public void checkCollision() 
    {
        if (panel.getPlayer1().getBounds().intersects(getBounds()) ||
                panel.getPlayer2().getBounds().intersects(getBounds()))
        {
            xa = -xa;
        }
    }

    public Rectangle getBounds() 
    {
        return new Rectangle(x, y, ballWidth, ballHeight);
    }

    public void paint(Graphics g)
    {
        g.fillRect(x, y, ballWidth, ballHeight);
    }
}