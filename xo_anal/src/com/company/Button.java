package com.company;

import javax.swing.*;
import java.awt.*;

public class Button {
    int x, y, hight, width;
    boolean clik = false;
    Image image;
    Mouse mouse;

    public Button(int x,int y,int hight,int width, String str, Mouse mouse){
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.width = width;
        this.mouse = mouse;
        image = new ImageIcon(str).getImage();
    }

    public void Clicked(){
        if (mouse.getx() > x && mouse.getx() < x+width && mouse.gety() > y && mouse.gety() < y+hight){
            clik = true;
        }
        else{
            clik = false;
        }
    }

    public void paint(Graphics g){
        Clicked();
        g.drawImage(image, x, y, width, hight, null);
    }

    public boolean Restart(){
        if (clik){
            return true;
        }
        else{
            return false;
        }
    }
}
