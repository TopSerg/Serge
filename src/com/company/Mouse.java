package com.company;

import java.awt.*;
import java.awt.event.*;

class Mouse extends Frame implements MouseListener{

   int xm = 100, ym = 550;

   public Mouse(){

   }
   public void mousePressed(MouseEvent e)
   {
       //System.out.println("mouse pressed");
       this.xm = e.getX();
       this.ym = e.getY();
       //System.out.println(xm + " " + ym);
   }
   public void mouseReleased(MouseEvent e)
   {
       //System.out.println("mouse Released");
   }
   public void mouseClicked(MouseEvent e)
   {
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
}
