package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Item{

    Image item;
    int x, y, wight, high, level = 0, a = 0, b = 0;
    boolean find = false, isminus = false, isget = false, kaka = false, buka = false;
    String name;
    Mouse1 mouse1;
    String canmerge;

    public Item(String s, String name, int x, int y, int wight, int high, Mouse1 mouse1, int level, String canmerge){
        item = new ImageIcon(s).getImage();
        this.level = level;
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
        this.mouse1 = mouse1;
        this.name = name;
        this.canmerge = canmerge;
    }

    public void find(int x, int y){
        if (x > this.x && x < this.x+wight && y > this.y && y < this.y+high && !find){
            find = true;
        }
    }

    public void found(Mouse mouse){
        if (mouse1.getx1() >= this.x && mouse1.getx1() < this.x+wight && mouse1.gety1() >= this.y && mouse1.gety1() < this.y+high && find){
            kaka = true;
        }
        else{
            kaka = false;
        }
        if (a == 0&&mouse.getx(2)>= this.x && mouse.getx(2) < this.x+wight && mouse.gety(2) >= this.y && mouse.gety(2) < this.y+high && find){
            if (buka && !mouse.HasItem()){
                setIsminus(true);
                a++;
                b = 0;
                mouse.Add(this);
            }
            else{
                buka = true;
            }
            if (mouse.HasItem()){
                if (equals(mouse.getItem())){
                    isget = true;
                }
            }
        }
        if (mouse.getBut() == 3&&b == 0){
            setIsminus(false);
            mouse.Delete();
            b++;
            a = 0;
        }
    }

    public boolean IsGet(){
        return isget;
    }

    public boolean getfind(){
        return find;
    }

    public void SetXY(int x, int y, int high, int wight){
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
    }

    public void paint(Graphics g){
        if (!find||find){
            g.drawImage(item, x, y, wight, high, null);
        }
        if (isminus){
            g.drawImage(item, mouse1.getx1(), mouse1.gety1(), wight, high, null);
        }
        if (kaka){
            g.drawString(name, x,y);
        }
    }

    public void setIsminus(boolean a){
        isminus = a;
    }

    public String getName(){
        return name;
    }

    public boolean equals(Item item){
        return canmerge.equals(item.getName());
    }

    public Image getImage(){
        return item;
    }

}