package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse1 extends Frame implements MouseMotionListener {
    int xm1 = 0, ym1 = 0;
    public Mouse1(){

    }
    public void mouseDragged (MouseEvent e){
        xm1 = e.getX();
        ym1 = e.getY();
    }
    public void mouseMoved (MouseEvent e){
        xm1 = e.getX();
        ym1 = e.getY();
    }
    public int getx1(){
        return xm1;
    }
    public int gety1(){
        return ym1;
    }
}