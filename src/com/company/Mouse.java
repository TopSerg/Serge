package com.company;

import java.awt.*;
import java.awt.event.*;

public class Mouse extends Frame implements MouseListener{

   int xm = 100, ym = 550, i = 0, j = 0, oldx, oldy, x,y, but = 0;
   boolean clik = false;

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
      String str = e.toString();
      char[] ch = str.toCharArray();
      //System.out.println((int)'n');
      if ((int)ch[73]>47 && (int)ch[73]<58){
         but = ch[73]-48;
      }
      else if ((int)ch[74]>47 && (int)ch[74]<58){
         but = ch[74]-48;
      }
      else if ((int)ch[75]>47 && (int)ch[75]<58){
         but = ch[75]-48;
      }
      else if ((int)ch[76]>47 && (int)ch[76]<58){
         but = ch[76]-48;
      }
      else if ((int)ch[77]>47 && (int)ch[77]<58){
         but = ch[77]-48;
      }
       //System.out.println(but);
      clik = true;
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
   public boolean isClik(){
      if (clik){
         clik = false;
         return !clik;
      }
      return clik;
   }
   public int getx(int a){
      //System.out.println(clik);
      switch (a){
         case(1):
            if (xm > x && ym > y){
                  if (i == 0) {
                     i++;
                     return oldx;
                  }
            }
            else{
                  if (i == 0) {
                     i++;
                     oldx = xm;
                     return xm;
                  }
               return oldx;
            }
            return oldx;
         case(2):
            if (xm == oldx){
               return 0;
            }
            oldx = xm;
            return xm;
         default:
            return xm;
      }

//      if (i == 0) {
//         i++;
//         oldx = xm;
//         return xm;
//      }

   }
   public int gety(int a){
      switch (a){
         case(1):
            if (xm > x && ym > y){
                  if (j == 0) {
                     j++;
                     return oldy;
                  }
            }
            else{
                  if (j == 0) {
                     j++;
                     oldy = ym;
                     return ym;
                  }
               return oldy;
            }
            return oldy;
         case(2):
            //System.out.println(ym + " " + oldy);
            if (ym == oldy){
               return 0;
            }
            oldy = ym;
            return ym;
         default:
            return ym;
      }

   }

   public int getBut() {
      return but;
   }
}
