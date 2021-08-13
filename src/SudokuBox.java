import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SudokuBox extends JButton {

        private Color hoverBackgroundColor = new Color(0,0,190).brighter();
        private Color pressedBackgroundColor = new Color(0,0,190);
        int xPosBox;
        int yPosBox;
   

        public SudokuBox() {
            this(null);
        }

        public SudokuBox(String text) {
            super(text);
            super.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) 
            {
                g.setColor(pressedBackgroundColor);
            }
            else if (getModel().isRollover()) 
            {
                g.setColor(hoverBackgroundColor);
            } 
            else {
                g.setColor(getBackground());
            }
            g.fillRect(0,0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(0,0, getWidth(), getHeight());
            super.paintComponent(g);
        }





        public void setHoverBackgroundColor(Color hoverBackgroundColor) {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }
        public void setPressedBackgroundColor(Color pressedBackgroundColor) {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }



}