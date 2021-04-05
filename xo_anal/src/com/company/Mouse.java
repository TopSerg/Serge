package com.company;

import java.awt.*;
import java.awt.event.*;

class Mouse extends Frame implements MouseListener{

    int xm, ym;
    boolean clik = false;

    public Mouse(){

    }
    public void mousePressed(MouseEvent e)
    {
        //System.out.println("mouse pressed");
        this.xm = e.getX();
        this.ym = e.getY();
        clik = true;
        //System.out.println(xm + " " + ym);
        //clik = false;
        //System.out.println(1);
        //System.out.println(xm + " " + ym);
    }
    public void mouseReleased(MouseEvent e)
    {
        clik = false;
        //System.out.println("mouse Released");
    }
    public void mouseClicked(MouseEvent e)
    {
//        clik = true;
//        clik = false;
        //System.out.println("mouse Clicked");
    }
    public void mouseExited(MouseEvent e)
    {
        //System.out.println("mouse Exited");
    }
    public void mouseEntered(MouseEvent e)
    {
        //System.out.println("mouse Entered");
    }
    public int getx(){
        return xm;
    }
    public int gety(){
        return ym;
    }
    public boolean isClik(){
        return clik;
    }
}