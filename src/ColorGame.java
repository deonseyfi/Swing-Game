import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.lang.String;
import javax.swing.border.Border;

public class ColorGame extends JPanel {


    private CircleButton redBtn;
    private CircleButton blueBtn;
    private CircleButton greenBtn;
    private CircleButton yellowBtn;
    private CircleButton purpleBtn;
    Random rand = new Random();
    Score score;
    
    
    CardLayout card;
    JPanel jPan;


    String colors[] = {"Red","Blue","Green","Yellow","Purple"};
    String colorArr[] = new String[6];
    int gameCount;
    
    ColorGame(Score newScore)
    {
        score = newScore;
        setSize(600,400);
        setLayout(null);
        gameCount = 0;
        for (int i = 0; i < 5;i++)
        {
            colorArr[i] = colors[rand.nextInt(5)];
        }
        colorArr[5] = "";
        redBtn = new CircleButton();
        redBtn.setBounds(100, 50, 100, 100);
        redBtn.setHoverBackgroundColor(new Color(190,0,0).brighter());
        redBtn.setPressedBackgroundColor(new Color(190,0,0).darker());
        redBtn.setBackground(new Color(190,0,0));
        redBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Red");
                compareColor("Red");
                gameCount++;
                checkGame(gameCount);
                System.out.println("Score: "+score.getPoints());
                System.out.println("GameCount: "+gameCount);
                repaint();
            }
        });
        redBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(redBtn);
        
        
        blueBtn = new CircleButton();
        blueBtn.setBounds(400, 50, 100, 100);
        blueBtn.setHoverBackgroundColor(new Color(0,0,190).brighter());
        blueBtn.setPressedBackgroundColor(new Color(0,0,190).darker());
        blueBtn.setBackground(new Color(0,0,190));
        blueBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Blue");
                compareColor("Blue");
                gameCount++;
                checkGame(gameCount);
                System.out.println("Score: "+score.getPoints());
                System.out.println("GameCount: "+gameCount);
                repaint();
            }
        });
        blueBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(blueBtn);
        
        
        greenBtn = new CircleButton();
        greenBtn.setBounds(100, 200, 100, 100);
        greenBtn.setHoverBackgroundColor(new Color(0,190,0).brighter());
        greenBtn.setPressedBackgroundColor(new Color(0,190,0).darker());
        greenBtn.setBackground(new Color(0,190,0));
        greenBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Green");
                compareColor("Green");
                gameCount++;
                checkGame(gameCount);
                System.out.println("Score: "+score.getPoints());
                System.out.println("GameCount: "+gameCount);
                repaint();
            }
        });
        greenBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(greenBtn);
        
        
        
        yellowBtn = new CircleButton();
        yellowBtn.setBounds(400, 200, 100, 100);
        yellowBtn.setHoverBackgroundColor(new Color(210,210,0).brighter());
        yellowBtn.setPressedBackgroundColor(new Color(210,210,0).darker());
        yellowBtn.setBackground(new Color(210,210,0));
        yellowBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Yellow");
                compareColor("Yellow");
                gameCount++;
                checkGame(gameCount);
                System.out.println("Score: "+score.getPoints());
                System.out.println("GameCount: "+gameCount);
                repaint();
            }
        });
        yellowBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(yellowBtn);
        
        
        
        purpleBtn = new CircleButton();
        purpleBtn.setBounds(250, 200, 100, 100);
        purpleBtn.setHoverBackgroundColor(new Color(128,0,128).brighter());
        purpleBtn.setPressedBackgroundColor(new Color(128,0,128).darker());
        purpleBtn.setBackground(new Color(128,0,128));
        purpleBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Purple");
                compareColor("Purple");
                gameCount++;
                checkGame(gameCount);
                System.out.println("Score: "+score.getPoints());
                System.out.println("GameCount: "+gameCount);
                repaint();
            }
        });
        purpleBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(purpleBtn);
        
        
    }
    public Color getRandColor(){
        Color color;
        int randomNum = rand.nextInt(5);
        if (randomNum == 0)
        {
            color = new Color(255,0,0);
            return color;
        }
        else if (randomNum == 1)
        {
            color = new Color(0,255,0);
            return color;
        }
        else if (randomNum == 2)
        {
            color = new Color(0,255,0);
            return color;
        }
        else if (randomNum == 3)
        {
            color = new Color(255,255,0);
            return color;
        }
        else
        {
            color = new Color(128,0,128);
            return color;
                   
        }
 
    }
    public void paintComponent(Graphics g){
    super.paintComponent(g);

    g.setFont(new Font("TimesRoman", Font.BOLD, 36)); 
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(getRandColor());
    g2.drawString(colorArr[gameCount], 250, 100);
    }
    public void compareColor(String input)
    {
        if(input.equals(colorArr[gameCount]))
            score.addPoints(100);
               
        
    }    
    
    public void checkGame(int gameCount)
    {
        if (gameCount == 5)
            card.show(jPan,"Sudoku");
    }
}
