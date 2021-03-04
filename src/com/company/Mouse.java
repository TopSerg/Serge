package com.company;

import java.awt.*;
import java.awt.event.*;

class Mouse extends Frame implements MouseListener{

   int xm = 100, ym = 550, i = 0, j = 0, oldx, oldy, x,y;

   public Mouse(){

   }
   public void Setxy(int x, int y){
      this.x = x;
      this.y = y;
   }
   public void mousePressed(MouseEvent e)
   {
       //System.out.println("mouse pressed");
//      oldx = xm;
//      oldy = ym;
      this.xm = e.getX();
      this.ym = e.getY();
      i = 0;
      j = 0;
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
      System.out.println(xm+ " "+ym+ " " +oldx+ " "+oldy);
//      if (i == 0) {
//         i++;
//         oldx = xm;
//         return xm;
//      }
      if (xm > x && ym > y){
         if (a == 1){
            if (i == 0) {
               i++;
               return oldx;
            }
         }
         if (a == 2){
            return xm;
         }
      }
      else{
         if (a == 1) {
            if (i == 0) {
               i++;
               oldx = xm;
               return xm;
            }
         }
         if (a == 2){
            return xm;
         }
         return oldx;
      }
      return oldx;
   }
   public int gety(int a){
      if (xm > x && ym > y){
         if (a == 1){
            if (j == 0) {
               j++;
               return oldy;
            }
         }
         if (a == 2){
            return ym;
         }
      }
      else{
         if (a == 1) {
            if (j == 0) {
               j++;
               oldy = ym;
               return ym;
            }
         }
         if (a == 2){
            return ym;
         }
         return oldy;
      }
      return oldy;
   }
}
