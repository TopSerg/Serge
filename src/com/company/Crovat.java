package com.company;

import javax.swing.*;
import java.awt.*;

public class Crovat {

    Image img1, img2;
    int x,y,height,width;
    boolean comleted = false;
    String needItem;
    Mouse mouse;

    public Crovat(String str1, String str2, String needItem, int x, int y, int width, int height, Mouse mouse){
        img1 = new ImageIcon(str1).getImage();
        img2 = new ImageIcon(str2).getImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.needItem = needItem;
        this.mouse = mouse;
    }

    public void paint(Graphics g){
        if (!comleted){
            g.drawImage(img1, x,y,width,height,null);
        }
        else{
            g.drawImage(img2, x,y,width,height,null);
        }
        Complet();
    }

    public void Complet(){
        if (mouse.getx(3) > x && mouse.gety(3) > y && mouse.getx(3) < x+width && mouse.gety(3) < y+height && mouse.HasItem()){
            if (mouse.getItem().getName().equals(needItem)){
                comleted = true;
                mouse.Delete();
            }
        }
    }
}
