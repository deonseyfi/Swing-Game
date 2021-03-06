import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class CircleButton extends JButton {

        private Color hoverBackgroundColor;
        private Color pressedBackgroundColor;
   

        public CircleButton() {
            this(null);
        }

        public CircleButton(String text) {
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
            g.fillOval(0,0, getWidth(), getHeight());
            super.paintComponent(g);
        }





        public void setHoverBackgroundColor(Color hoverBackgroundColor) {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }
        public void setPressedBackgroundColor(Color pressedBackgroundColor) {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }



}