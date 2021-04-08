package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Item{

    Image item;
    int x, y, wight, high, level = 0;
    boolean find = false, isminus = false, isget = false, kaka = false;
    String name;
    Mouse1 mouse1;

    public Item(String s, String name, int x, int y, int wight, int high, Mouse1 mouse1, int level){
        item = new ImageIcon(s).getImage();
        this.level = level;
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
        this.mouse1 = mouse1;
        this.name = name;
    }

    public void find(int x, int y){
        if (x > this.x && x < this.x+wight && y > this.y && y < this.y+high && !find){
            find = true;
        }
    }

    public void found(Mouse mouse){
//        int x = mouse1.getx1();
//        int y = mouse1.gety1();
        if (mouse1.getx1() >= this.x && mouse1.getx1() < this.x+wight && mouse1.gety1() >= this.y && mouse1.gety1() < this.y+high && find){
            kaka = true;
        }
        else{
            kaka = false;
        }
        if (mouse.getx(2)>= this.x && mouse.getx(2) < this.x+wight && mouse.gety(2) >= this.y && mouse.gety(2) < this.y+high && find && kaka){
            setIsminus();
        }
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
        System.out.println(kaka);
        if (kaka){
            g.drawString(name, x,y);
        }
        //System.out.println(x+" "+ y+" "+ wight+" "+ high+"               asdfasdf              ");
    }
    public void paint(Graphics g, int x, int y, int wight, int high){
        if (find) {
            g.drawImage(item, x, y, wight, high, null);
        }
        //System.out.println(x+" "+ y+" "+ wight+" "+ high);
        //if (isminus&&!isget){
        //  g.drawImage(item, mouse1.getx1(), mouse1.gety1(), wight, high, null);
        //}
    }

    public void setIsminus(){
        if (!isminus){
            isminus = true;
        }
        else{
            isminus = false;
        }
    }

    public String getName(){
        return name;
    }

    public boolean equals(Item item){
        if (name == item.getName()){
            return true;
        }
        else{
            return false;
        }
    }

    public Image getImage(){
        return item;
    }

}