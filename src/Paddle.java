
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paddle 
{
    private int paddleWidth = 10;
    private int paddleHeight = 60;
    private int panelHeight;
    private int panelWidth;
    private int up, down;
    private int x;
    private int y;
    private int ya;

    public Paddle(JPanel Panel, int upValue, int downValue, int xValue) 
    {
        panelHeight = Panel.getHeight();
        panelWidth = Panel.getWidth();
        x = xValue;
        y = Panel.getHeight() / 2;
        up = upValue;
        down = downValue;
    }

    public void update() 
    {
        if (y > 0 && y < 380)
        {
            y += ya;
        }
        else if (y > 380)
            y--;
        else if (y <= 50)
            y++;
    }

    public void pressedUp() 
    {
        
            ya = -5;
        
    }
    
    public void pressedDown() 
    {
            ya = 5;
    }

    public void released() 
    {
        
            ya = 0;
    }

    public Rectangle getBounds() 
    {
        return new Rectangle(x, y, paddleWidth, paddleHeight);
    }

    public void paint(Graphics g) 
    {
        g.fillRect(x, y, paddleWidth, paddleHeight);
    }
}