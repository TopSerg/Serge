package com.company;

import javax.swing.*;
import java.awt.*;

public class Chel {

    int x, y, high, width, retur;
    Image img;
    Item needitem;
    Mouse mouse;


    public Chel(String s, int x,int y,int high,int width, Item item, Mouse mouse, int retur){
        this.retur = retur;
        needitem = item;
        img = new ImageIcon(s).getImage();
        this.x = x;
        this.y = y;
        this.high = high;
        this.width = width;
        this.mouse = mouse;
    }


    public void paint(Graphics g){
        g.drawImage(img, x, y, width, high, null);
    }

    public void take(Item item){

    }

    public boolean begin(){
        if (mouse.getx(1) > x &&mouse.getx(1) < x+width && mouse.gety(1) > y && mouse.gety(1) < y+high){
            //System.out.println("21341234142");
            return true;
        }
        return false;
    }

    public int getRetur() {
        return retur;
    }
}