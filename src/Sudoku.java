import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.util.Random;
import java.lang.String;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.KeyEvent;
public class Sudoku extends JPanel  implements KeyListener {
    private SudokuBox sudokuLayout[][] = new SudokuBox[9][9];


    CardLayout card;
    JPanel jPan;


    private int answerMatrix[][] = {
            {8, 3, 5, 4, 1, 6, 9, 2, 7},
            {2, 9, 6, 8, 5, 7, 4, 3, 1},
            {4, 1, 7, 2, 9, 3, 6, 5, 8},
            {5, 6, 9, 1, 3, 4, 7, 8, 2},
            {1, 2, 3, 6, 7, 8, 5, 4, 9},
            {7, 4, 8, 5, 2, 9, 1, 6, 3},
            {6, 5, 2, 7, 8, 1, 3, 9, 4},
            {9, 8, 1, 3, 4, 5, 2, 7, 6},
            {3, 7, 4, 9, 6, 2, 8, 1, 5}
    };
    private int currentMatrix[][] = {
            {8, 0, 0, 4, 0, 6, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 4, 0, 0},
            {0, 1, 0, 0, 0, 0, 6, 5, 0},
            {5, 0, 9, 0, 3, 0, 7, 8, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 4, 8, 0, 2, 0, 1, 0, 3},
            {0, 5, 2, 0, 0, 0, 0, 9, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {3, 0, 0, 9, 0, 2, 0, 0, 5}
    };
    private int startMatrix[][] = {
            {8, 0, 0, 4, 0, 6, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 4, 0, 0},
            {0, 1, 0, 0, 0, 0, 6, 5, 0},
            {5, 0, 9, 0, 3, 0, 7, 8, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 4, 8, 0, 2, 0, 1, 0, 3},
            {0, 5, 2, 0, 0, 0, 0, 9, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {3, 0, 0, 9, 0, 2, 0, 0, 5}
    };
    private int xCur;
    private int yCur;
    private Score score;
    private HighScore highScore;
    JTextField textField[][] = new JTextField[9][9];

    public Sudoku(Score newScore, HighScore newHighScore) {

        score = newScore;
        highScore = newHighScore;
        setSize(600, 400);
        setLayout(null);
        addKeyListener(this);
        JButton submit = new JButton("Submit");
        submit.setBounds(10,300,80,30);
        submit.setToolTipText("Submit the score!");
        add(submit);
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                submitPressed();

            }
        });

        JButton quit = new JButton("Quit");
        quit.setToolTipText("Quit the game");
        quit.setBounds(480,300,80,30);
        add(quit);
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                score.setName((String)JOptionPane.showInputDialog("Enter name"));
                System.out.println(score.getName());
                highScore.newHighScore(score);
                card.show(jPan,"mm");
                
                

            }
        });


        this.setFocusable(true);
        this.requestFocus();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                textField[i][j] = new JTextField();
                textField[i][j].setDocument(new JTextFieldLimit(1));
                if (startMatrix[i][j] > 0) {


                    textField[i][j].setText(Integer.toString(startMatrix[i][j]));
                    textField[i][j].setEditable(false);


                } else {
                    textField[i][j].setToolTipText("Please enter a value of 1-9");
                    int finalI = i;
                    int finalJ = j;
                    textField[i][j].addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = textField[finalI][finalJ].getText();
                            int l = value.length();

                            if (e.getKeyChar() >= '1' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                textField[finalI][finalJ].setEditable(true);

                            } else {
                                textField[finalI][finalJ].setEditable(false);
                                JOptionPane.showMessageDialog(null, "Please press a number.");

                            }


                        }
                    });
                }
                textField[i][j].setBounds((100 + (40 * j)), (1 + (40 * i)), 40, 40);
                textField[i][j].setFont(new Font("TimesNewRoman", Font.BOLD, 24));
                textField[i][j].setBackground(Color.WHITE);
                textField[i][j].setHorizontalAlignment(JTextField.CENTER);


                // add(sudokuLayout[i][j]);
                add(textField[i][j]);
            }


    }


    @Override
    public void keyPressed(KeyEvent e) {
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void submitPressed() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if(textField[i][j].getText().length() > 0)
                currentMatrix[i][j] = Integer.parseInt(textField[i][j].getText());
            }


        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if(!(currentMatrix[i][j] == answerMatrix[i][j]))
                {
                    JOptionPane.showMessageDialog(null, "Sudoku is Incorrect, you lose 10 points.");
                    score.takePoints(10);
                    return;
                }
            }
        JOptionPane.showMessageDialog(null, "You won sudoku!.");
        card.show(jPan,"mm");
    }

}
class JTextFieldLimit extends PlainDocument {
    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException, BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }

    }
}