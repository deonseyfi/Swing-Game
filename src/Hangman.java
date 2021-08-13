import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.lang.String;


class Hangman extends JPanel{
        private JButton jbtnA;
        private JButton jbtnB;
        private JButton jbtnC;
        private JButton jbtnD;
        private JButton jbtnE;
        private JButton jbtnF;
        private JButton jbtnG;
        private JButton jbtnH;
        private JButton jbtnI;
        private JButton jbtnJ;
        private JButton jbtnK;
        private JButton jbtnL;
        private JButton jbtnM;
        private JButton jbtnN;
        private JButton jbtnO;
        private JButton jbtnP;
        private JButton jbtnQ;
        private JButton jbtnR;
        private JButton jbtnS;
        private JButton jbtnT;
        private JButton jbtnU;
        private JButton jbtnV;
        private JButton jbtnW;
        private JButton jbtnX;
        private JButton jbtnY;
        private JButton jbtnZ;
        private JButton skipButton;
        private String words[] = {"abstract", "cemetery", "nurse","pharmacy", "climbing"};
        int selectedWord;
        int hangmanCount = 0;
        int numCorrect = 0;
        int drawCharStorage[];
        CardLayout card;
        JPanel jPan;
        Random rand = new Random();
        Score score;
        
    public Hangman(Score newScore)
    {
        score = newScore;
        score.setPoints(100);
        score.setName("ABC");
        selectedWord = rand.nextInt(5);
        drawCharStorage = new int[words[selectedWord].length()];
        setSize(600,400);
        setLayout(null);
        jbtnA = new JButton("A");
        jbtnA.setBounds(22,240,50,35);
        jbtnB = new JButton("B");
        jbtnB.setBounds(77,240,50,35);
        jbtnC = new JButton("C");
        jbtnC.setBounds(132,240,50,35);
        jbtnD = new JButton("D");
        jbtnD.setBounds(187,240,50,35);
        jbtnE = new JButton("E");
        jbtnE.setBounds(242,240,50,35);
        jbtnF = new JButton("F");
        jbtnF.setBounds(297,240,50,35);
        jbtnG = new JButton("G");
        jbtnG.setBounds(352,240,50,35);
        jbtnH = new JButton("H");
        jbtnH.setBounds(407,240,50,35);
        jbtnI = new JButton("I");
        jbtnI.setBounds(462,240,50,35);
        jbtnJ = new JButton("J");
        jbtnJ.setBounds(517,240,50,35);
        jbtnK = new JButton("K");
        jbtnK.setBounds(22,280,50,35);
        jbtnL = new JButton("L");
        jbtnL.setBounds(77,280,50,35);
        jbtnM = new JButton("M");
        jbtnM.setBounds(132,280,50,35);
        jbtnN = new JButton("N");
        jbtnN.setBounds(187,280,50,35);
        jbtnO = new JButton("O");
        jbtnO.setBounds(242,280,50,35);
        jbtnP = new JButton("P");
        jbtnP.setBounds(297,280,50,35);
        jbtnQ = new JButton("Q");
        jbtnQ.setBounds(352,280,50,35);
        jbtnR = new JButton("R");
        jbtnR.setBounds(407,280,50,35);
        jbtnS = new JButton("S");
        jbtnS.setBounds(462,280,50,35);
        jbtnT = new JButton("T");
        jbtnT.setBounds(517,280,50,35);
        jbtnU = new JButton("U");
        jbtnU.setBounds(132,320,50,35);
        jbtnV = new JButton("V");
        jbtnV.setBounds(187,320,50,35);
        jbtnW = new JButton("W");
        jbtnW.setBounds(242,320,50,35);
        jbtnX = new JButton("X");
        jbtnX.setBounds(297,320,50,35);
        jbtnY = new JButton("Y");
        jbtnY.setBounds(352,320,50,35);
        jbtnZ = new JButton("Z");
        jbtnZ.setBounds(407,320,50,35);
        
        
        skipButton = new JButton("Skip");
        skipButton.setBounds(480,80,100,35);
        
        add(jbtnA);
        add(jbtnB);
        add(jbtnC);
        add(jbtnD);
        add(jbtnE);
        add(jbtnF);
        add(jbtnG);
        add(jbtnH);
        add(jbtnI);
        add(jbtnJ);
        add(jbtnK);
        add(jbtnL);
        add(jbtnM);
        add(jbtnN);
        add(jbtnO);
        add(jbtnP);
        add(jbtnQ);
        add(jbtnR);
        add(jbtnS);
        add(jbtnT);
        add(jbtnU);
        add(jbtnV);
        add(jbtnW);
        add(jbtnX);
        add(jbtnY);
        add(jbtnZ);
        add(skipButton);
        
        
        skipButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                skipGame();
               
            }
        });
        
        
        jbtnA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnA.setEnabled(false);
                checkLetter('a');
                repaint();
                checkGame();
            }
        });
        jbtnB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnB.setEnabled(false);
                checkLetter('b');
                repaint();
                checkGame();
            }
        });
        
        jbtnC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnC.setEnabled(false);
                checkLetter('c');
                repaint();
                checkGame();
            }
        });
        
        jbtnD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnD.setEnabled(false);
                checkLetter('d');
                repaint();
                checkGame();
            }
        });
        
        jbtnE.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnE.setEnabled(false);
                checkLetter('e');
                repaint();
                checkGame();
            }
        });
        jbtnF.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnF.setEnabled(false);
                checkLetter('f');
                repaint();
                checkGame();
            }
        });
        jbtnG.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnG.setEnabled(false);
                checkLetter('g');
                repaint();
                checkGame();
            }
        });
        jbtnH.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnH.setEnabled(false);
                checkLetter('h');
                repaint();
                checkGame();
            }
        });
        jbtnI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnI.setEnabled(false);
                checkLetter('i');
                repaint();
                checkGame();
            }
        });
        jbtnJ.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnJ.setEnabled(false);
                checkLetter('j');
                repaint();
                checkGame();
            }
        });
        jbtnK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnK.setEnabled(false);
                checkLetter('k');
                repaint();
                checkGame();
            }
        });
        jbtnL.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnL.setEnabled(false);
                checkLetter('l');
                repaint();
                checkGame();
            }
        });
        jbtnM.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnM.setEnabled(false);
                checkLetter('m');
                repaint();
                checkGame();
            }
        });
        jbtnN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnN.setEnabled(false);
                checkLetter('n');
                repaint();
                checkGame();
            }
        });
        jbtnO.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnO.setEnabled(false);
                checkLetter('o');
                repaint();
                checkGame();
            }
        });
        jbtnP.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnP.setEnabled(false);
                checkLetter('p');
                repaint();
                checkGame();
            }
        });
        jbtnQ.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnQ.setEnabled(false);
                checkLetter('q');
                repaint();
                checkGame();
            }
        });
        jbtnR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnR.setEnabled(false);
                checkLetter('r');
                repaint();
                checkGame();
            }
        });
        jbtnS.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnS.setEnabled(false);
                checkLetter('s');
                repaint();
                checkGame();
            }
        });
        jbtnT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnT.setEnabled(false);
                checkLetter('t');
                repaint();
                checkGame();
            }
        });
        jbtnU.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnU.setEnabled(false);
                checkLetter('u');
                repaint();
                checkGame();
            }
        });
        jbtnV.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnV.setEnabled(false);
                checkLetter('v');
                repaint();
                checkGame();
            }
        });
        jbtnW.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnW.setEnabled(false);
                checkLetter('w');
                repaint();
                checkGame();
            }
        });
        jbtnX.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnX.setEnabled(false);
                checkLetter('x');
                repaint();
                checkGame();
            }
        });
        
        jbtnY.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnY.setEnabled(false);
                checkLetter('y');
                repaint();
                checkGame();
            }
        });
        jbtnZ.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jbtnZ.setEnabled(false);
                checkLetter('z');
                repaint();
                checkGame();
            }
        });
        
        
    }
    public void paintComponent(Graphics g){
    super.paintComponent(g);

    Font font = new Font("Serif",Font.ITALIC,36);
    Graphics2D g2 = (Graphics2D) g;
    g2.setFont(font);
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(Color.cyan);
    g2.drawString("HangMan", 10, 40);
    g.setColor(Color.BLACK);
    g.fillRect(275, 50, 5, 100);
    g.fillRect(275, 50, 100, 5);
    g.fillRect(370, 50, 5, 20);
    g.fillRect(175,150, 250,5);
    
    for (int i = 0; i < words[selectedWord].length();i++)
    {
        g.fillRect(180+(i*30), 195, 21,3);
    }
    for (int j = 0;j <words[selectedWord].length(); j++ )
    {
        if(drawCharStorage[j] == 1)    
            g.drawString(String.valueOf(words[selectedWord].charAt(j)), 180+(j*30), 190);
    }
    if (hangmanCount == 1){
        g.fillRect(362, 70, 20, 20);//head
    }
    
    if (hangmanCount == 2){
        g.fillRect(362, 70, 20, 20);//head 
        g.fillRect(371,90,3,25);//body
    }
    if (hangmanCount == 3){
    g.fillRect(362, 70, 20, 20);//head
    g.fillRect(371,90,3,25);//body
    g.fillRect(355,100,16,3);//left arm
    }
    if (hangmanCount == 4){
    g.fillRect(362, 70, 20, 20);//head
    g.fillRect(371,90,3,25);//body
    g.fillRect(355,100,16,3);//left arm
    g.fillRect(370, 100, 21,3);//right arm
    }
    if (hangmanCount == 5){
    g.fillRect(362, 70, 20, 20);//head
    g.fillRect(371,90,3,25);//body
    g.fillRect(355,100,16,3);//left arm
    g.fillRect(370, 100, 21,3);//right arm
    g.drawLine(371,115,361,130);//left leg

    }
    if (hangmanCount == 6){
    g.fillRect(362, 70, 20, 20);//head
    g.fillRect(371,90,3,25);//body
    g.fillRect(355,100,16,3);//left arm
    g.fillRect(370, 100, 21,3);//right arm
    g.drawLine(371,115,361,130);//left leg
    g.drawLine(373,115,384,130);//right leg
    }
 }
    public boolean checkLetter(char input)
    {
        if (words[selectedWord].indexOf(input) > -1)
        {

            System.out.println("Word: "+words[selectedWord]);
            System.out.println("Hangman Count: "+hangmanCount+"\nScore: "+score.getPoints()+"\nNumCorrect: "+numCorrect);
            for (int i = 0; i < words[selectedWord].length();i++)
            {
                if (words[selectedWord].charAt(i) == input)
                {
                    drawCharStorage[i] = 1;
                    numCorrect++;
                }
            }    
                
            for (int j = 0; j < drawCharStorage.length;j++)
                System.out.print(drawCharStorage[j]+" ");
            
            return true;
        }
        else
        {
        hangmanCount++;
        score.takePoints(10);
        System.out.println("Word: "+words[selectedWord]);
        System.out.println("Hangman Count: "+hangmanCount+"\nScore: "+score.getPoints()+"\nNumCorrect: "+numCorrect);
        return false;
        }


    }
    public void checkGame()
    {
        if (numCorrect == words[selectedWord].length() || hangmanCount == 6)
        {
            System.out.println("True");
            
           


            card.show(jPan, "colorGame");

            hangmanCount = 0;
            numCorrect = 0;
            selectedWord = rand.nextInt(5);
            drawCharStorage = new int[words[selectedWord].length()];
            reenableButtons();
            score.setPoints(100);
            
        }
    }
    public void reenableButtons()
    {
        jbtnA.setEnabled(true);
        jbtnB.setEnabled(true);
        jbtnC.setEnabled(true);
        jbtnD.setEnabled(true);
        jbtnE.setEnabled(true);
        jbtnF.setEnabled(true);
        jbtnG.setEnabled(true);
        jbtnH.setEnabled(true);
        jbtnI.setEnabled(true);
        jbtnJ.setEnabled(true);
        jbtnK.setEnabled(true);
        jbtnL.setEnabled(true);
        jbtnM.setEnabled(true);
        jbtnN.setEnabled(true);
        jbtnO.setEnabled(true);
        jbtnP.setEnabled(true);
        jbtnQ.setEnabled(true);
        jbtnR.setEnabled(true);
        jbtnS.setEnabled(true);
        jbtnT.setEnabled(true);
        jbtnU.setEnabled(true);
        jbtnV.setEnabled(true);
        jbtnW.setEnabled(true);
        jbtnX.setEnabled(true);
        jbtnY.setEnabled(true);
        jbtnZ.setEnabled(true);

    }    
    public void skipGame()
    {

        card.show(jPan, "colorGame");
        
        hangmanCount = 0;
        numCorrect = 0;
        selectedWord = rand.nextInt(5);
        drawCharStorage = new int[words[selectedWord].length()];
        score.setPoints(0);
        reenableButtons();
    }
        
}