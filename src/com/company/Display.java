package com.company;

import com.company.vzlomzopy.Dsaper;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Display extends JPanel implements ActionListener{

    Timer timer = new Timer(20, this);
    Mouse mouse;
    Mouse1 mouse1;
    JFrame frame;
    boolean d = false, sanya = false;
    Dsaper dsaper;

    int h, w;
    sosibibu xo;
    Gomik chapter1;
    int chapter = 0;
    Item itm2;

    public Display(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        this.frame = frame;
        this.mouse = mouse;
        this.mouse1 = mouse1;
        xo = new sosibibu(frame, mouse, mouse1);
        chapter1 = new Gomik(frame,mouse,mouse1);
        dsaper = new Dsaper(frame,mouse,mouse1);
        timer.start();
        itm2 = new Item("l_egg.png", "R_egg", 0,0,0,0,mouse1,0, "L_egg");
    }

    public void paint(Graphics g) {
        switch (chapter){
            case(0):
                chapter1.paint(g);
                break;
            case (1):
                if (!sanya){
                    xo.paint(g);
                }
                //b.kuk();
                break;
            case(2):
                dsaper.paint(g);
                break;
            default:
                System.out.println("ERROR");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (chapter == 0){
            chapter = chapter1.start();
        }
        if (xo.exit() && d){
            itm2.find = true;
            chapter1.Itemp(itm2);
            chapter = 0;
            d = false;
            sanya =true;
        }
        switch (chapter){
            case(0):
                chapter1.actionPerformed();
                break;
            case (1):
                if (!sanya){
                    d = true;
                    xo.chlenbolit();
                }
                else {
                    chapter = 0;
                }
                break;
            case(2):
                dsaper.actionPerformed();
                break;
            default:
                System.out.println("ERROR");
        }
        repaint();
    }
}
