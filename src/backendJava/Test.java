package backendJava;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Test
{
  public static void main(String[] args) 
  {
    //create a frame
    JFrame frame = new JFrame("JButton Example");
    //create button
    JButton btn = new JButton("Click here");
    //set button position
    btn.setBounds(70,80,100,30);
    //Round the button with radius = 15
    btn.setBorder(new RoundBtn(15));   
    //add button to frame
    frame.add(btn);
    frame.setSize(250,250);
    frame.setLayout(null);
    frame.setVisible(true);  
  }
}

class RoundBtn implements Border 
{
    private int r;

    RoundBtn(int r) {
        this.r = r;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, 
    int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}