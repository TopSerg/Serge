package com.company;

import javax.swing.*;
import java.awt.*;

public class Chel {

    int x, y, high, width;
    double xq,yq,widthq, highq;
    int retur;
    Image img;
    Item needitem;
    Mouse mouse;
    JFrame frame;


    public Chel(String s, double x, double y,double high,double width, Item item, Mouse mouse, int retur, JFrame frame){
        this.retur = retur;
        needitem = item;
        img = new ImageIcon(s).getImage();
        this.frame = frame;
        this.xq = x;
        this.yq = y;
        this.widthq = width;
        this.highq = high;
        this.mouse = mouse;
    }


    public void paint(Graphics g){
        x = (int) (xq*frame.getWidth());
        y = (int) (yq*frame.getHeight());
        width = (int) (widthq*frame.getWidth());
        high = (int) (highq*frame.getHeight());
        g.drawImage(img, x, y, width, high, null);
    }

    public void take(Item item){

    }

    public boolean begin(){
        if (mouse.getx(1) > x &&mouse.getx(1) < x+width && mouse.gety(1) > y && mouse.gety(1) < y+high && mouse.isClik()){
            //System.out.println("21341234142");
            return true;
        }
        return false;
    }

    public int getRetur() {
        return retur;
    }
}