package com.company;

import java.awt.*;
import java.awt.event.*;

class Mouse extends Frame implements MouseListener{

   int xm = 100, ym = 550, i = 0;

   public Mouse(){

   }
   public void mousePressed(MouseEvent e)
   {
       //System.out.println("mouse pressed");
       this.xm = e.getX();
       this.ym = e.getY();
       i = 0;
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
   public int getx(int a){
//      if (i == 0) {
//         i++;
         return xm;
//      }
//      else{
//         return 0;
//      }
   }
   public int gety(int a){
//      if (i == 0) {
//         i++;
         return ym;
//      }
//      else{
//         return 0;
//      }
   }
}
