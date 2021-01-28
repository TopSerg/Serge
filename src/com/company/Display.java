package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel implements ActionListener {
    JFrame frame;
    Image img = new ImageIcon("C:\\Users\\makovs.22\\IdeaProjects\\Serge\\Chel.png").getImage();
    Timer timer = new Timer(20, this);
    public Display(JFrame frame){
        this.frame = frame;
    }
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0,frame.getWidth(), frame.getHeight(), null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }
}
