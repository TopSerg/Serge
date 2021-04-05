package com.company;
//package package1;

import javax.swing.*;

public class xo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JustGame");
        Mouse m = new Mouse();
        Mouse1 m1 = new Mouse1();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.addMouseListener(m);
        frame.addMouseMotionListener(m1);
        Display v = new Display(frame,m,m1);
        frame.add(v);
        frame.setVisible(true);
    }
}
