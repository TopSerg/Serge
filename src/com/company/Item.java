package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//класс предмета
class Item{

    //задание необходимых переменных
    Image item;
    int x, y, wight, high;
    double xq,yq,widthq, highq;
    int level = 0, a = 0, b = 0;
    boolean find = false, isminus = false, isget = false, kaka = false, buka = false;
    String name;
    Mouse1 mouse1;
    String canmerge;
    Item itm;
    JFrame frame;
    Player player;

    //конструктор
    public Item(String s, String name, double x, double y, double wight, double high, Mouse1 mouse1, int level, String canmerge, Item itm, JFrame frame, Player player){
        this.frame = frame;
        this.player = player;
        item = new ImageIcon(s).getImage();
        this.level = level;
        this.xq = x;
        this.yq = y;
        this.widthq = wight;
        this.highq = high;
        this.mouse1 = mouse1;
        this.name = name;
        this.canmerge = canmerge;
        this.itm = itm;
    }

    //находка предмета
    public void find(){
        if (player.Go(x,y,wight,high)&&!find){
            find = true;
        }
    }

    //все действия с предметом
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
                if (eguals(mouse.getItem())){
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

    //серия булевых методов возвращающих нужные величины
    public boolean IsGet(){
        return isget;
    }

    public boolean getfind(){
        return find;
    }

    //задание координат предмета
    public void SetXY(int x, int y, int high, int wight){
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
        this.xq = (double) x/frame.getWidth();
        this.yq = (double) y/frame.getHeight();
        this.widthq = (double) wight/frame.getWidth();
        this.highq = (double) high/frame.getHeight();
    }

    //метод отрисовки
    public void paint(Graphics g){
//        int xq,yq,widthq, highq;
        x = (int) (xq*frame.getWidth());
        y = (int) (yq*frame.getHeight());
        wight = (int) (widthq*frame.getWidth());
        high = (int) (highq*frame.getHeight());
        if (!isminus){
            g.drawImage(item, x, y, wight, high, null);
        }
        if (isminus){
            g.drawImage(item, mouse1.getx1(), mouse1.gety1(), wight, high, null);
        }
        if (kaka){
            g.drawString(name, x,y);
        }
    }

    //серия булевых методов возвращающих нужные величины
    public void setIsminus(boolean a){
        isminus = a;
    }

    public String getName(){
        return name;
    }

    public boolean eguals(Item item){
        return canmerge.equals(item.getName());
    }

    public boolean equals(Item item){
        return name.equals(item.getName());
    }

    public Image getImage(){
        return item;
    }

    public Item getItm() {
        return itm;
    }
}