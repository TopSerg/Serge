package com.company;


import java.awt.*;
import java.awt.event.*;

public class Mouse extends Frame implements MouseListener{

   int xm = 100, ym = 550, i = 0, j = 0, oldx, oldy, x,y, but = 0, xegg = 0, yegg = 0;
   boolean clik = false;
    Item item;

   public Mouse(){
      item = null;
   }
   public void setXY(int x, int y){
      this.xm = x;
      this.ym = y;
      oldy = y;
      oldx = x;
   }
   public void Setxy(int x, int y){
      this.x = x;
      this.y = y;
   }
   public void Add(Item item){
      this.item = item;
   }
   public void Delete(){
      this.item = null;
   }
   public boolean HasItem(){
      if (item == null){
         return false;
      }
      return true;
   }
   public Item getItem(){
      return item;
   }
   public void mousePressed(MouseEvent e)
   {
      String str = e.toString();
      char[] ch = str.toCharArray();
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
      if (but == 1){
         clik = true;
         this.xm = e.getX();
         this.ym = e.getY();
         i = 0;
         j = 0;
      }

      System.out.println(xm * 1920.0/1535 + " " + ym*1080.0/864);
   }
   public void mouseReleased(MouseEvent e)
   {
   }
   public void mouseClicked(MouseEvent e)
   {
   }
   public void mouseExited(MouseEvent e)
   {
   }
   public void mouseEntered(MouseEvent e)
   {
   }
   public boolean isClik(){
      if (clik){
         clik = false;
         return !clik;
      }
      return clik;
   }
   public int getx(int a){
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
//            if (xm == xegg){
//               return 0;
//            }
            xegg = xm;
            return xm;
         default:
            return xm;
      }
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
//            if (ym == yegg){
//               return 0;
//            }
            yegg = ym;
            return ym;
         default:
            return ym;
      }

   }

   public int getBut() {
      return but;
   }
}
