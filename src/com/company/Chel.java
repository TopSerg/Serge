package com.company;

import javax.swing.*;
import java.awt.*;

public class Chel {

    int x, y, high, width;
    Image img;
    Item needitem;


    public Chel(String s, int x,int y,int high,int width, Item item){
        needitem = item;
        img = new ImageIcon(s).getImage();
        this.x = x;
        this.y = y;
        this.high = high;
        this.width = width;
    }


    public void paint(Graphics g){
        g.drawImage(img, x, y, width, high, null);
    }

    public void take(Item item){
        if (needitem.equals(item)){

        }
    }

}