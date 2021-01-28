package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Bakpack{

    Image inv = new ImageIcon("C:\\Users\\Serge\\Pictures\\Invent.png").getImage();

    JFrame frame;
    Mouse1 mouse1;
    Mouse mouse;

    Item[] items = new Item[20];
    Image[] mas = new Image[20];

    int yi = 390;
    boolean a = false, invop = false, errorbf = false, b = true;

    public Bakpack(JFrame frame, Mouse mouse, Mouse1 mouse1){
        this.frame = frame;
        this.mouse = mouse;
        this.mouse1 = mouse1;
    }

    public void paint(Graphics g){
        g.drawImage(inv, 210, yi, 1000, 500,null);
        for (int i = 0; i < 20; i++){
            if (mas[i] != null){
                g.drawImage(mas[i], 880+65*i,yi+277, 30*40/50, 40, null);
                if (items[i].isminus && !items[i].isget){
                    g.drawImage(mas[i], mouse1.getx1(), mouse1.gety1(), items[i].wight, items[i].high, null);
                }
            }
//            else{
//                break;
//            }
        }
    }

    public void move(int xm1, int ym1){
        if (xm1 > 870 && ym1 > 650&&yi > 200){
            a = true;
        }
        if (a){
            yi -= 15;
        }
        if (yi < 200){
            a = false;
            invop = true;
        }
        if (invop && (xm1 < 870 || ym1 < 470)){
            yi += 15;
        }
        if (yi > 380){
            invop = false;
        }
        //if (!item1f) {
        //  item1f = find(x1, y1, 600, 300);
        //}
    }

    public void plus(Item itm){
        for (int i = 0; i < 20; i++){
            if (mas[i] == null && b){
                items[i] = itm;
                mas[i] = itm.getImage();
                break;
            }
            errorbf = true;
        }
    }

    public void minus(){
        for (int i = 0; i < 20; i++){
            if (mouse.getx() > 880+65*i && mouse.getx() < 880+65*i+30*40/50 && mouse.gety() < yi+277 && mouse.gety() > yi+277+40 && invop){
                items[i].setIsminus();
                items[i] = null;
                mas[i] = null;
            }
        }

    }
}
