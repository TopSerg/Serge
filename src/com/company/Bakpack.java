package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Bakpack{

    Image inv = new ImageIcon("Invent.png").getImage();

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
        mouse.Setxy(frame.getWidth()-340+13, frame.getHeight()+13-446);
    }

    public void paint(Graphics g){
       // System.out.println(frame.getWidth() + " " + frame.getHeight());
        g.drawImage(inv, frame.getWidth()-1000, frame.getHeight()-720+yi, 1000, 500,null);
        mouse.Setxy(frame.getWidth()-340+13, frame.getHeight()+13-446+yi);
        for (int i = 0; i < 20; i++){
            //System.out.println(items[i] + " " + i/5);
            if (items[i] != null){
                items[i].found(mouse);
                items[i].SetXY(frame.getWidth()-340+13+65*i,frame.getHeight()+13-446+10*(i/5)+yi,  40,30*40/50);
                //g.drawImage(mas[i], 880+65*i,yi+277, 30*40/50, 40, null);
                //items[i].paint(g,frame.getWidth()-340+13+65*i,frame.getHeight()+13-446+yi, 30*40/50, 40);

                items[i].paint(g/*,frame.getWidth()-340+13+65*i,frame.getHeight()+13-446+10*(i/5)+yi, 30*40/50, 40*/);
                //items[i].paint(g,frame.getWidth()-340+13+65*i,frame.getHeight()+13-446+10*(i/5)+yi, 30*40/50, 40);
            }
//            else{
//                break;
//            }
        }
    }

    public void move(int xm1, int ym1){
        if (xm1 > frame.getWidth()-340 && ym1 > frame.getHeight()-446+yi&&yi > 200){
            a = true;
        }
        if (a){
            yi -= 15;
        }
        if (yi < 200){
            a = false;
            invop = true;
        }
        if (invop && (xm1 < frame.getWidth()-340 || ym1 < frame.getHeight()-446+yi)){
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
            if (mouse.getx(2) > 880+65*i && mouse.getx(2) < 880+65*i+30*40/50 && mouse.gety(2) < yi+277 && mouse.gety(2) > yi+277+40 && invop){
                items[i].setIsminus();
                items[i] = null;
                mas[i] = null;
            }
        }

    }
}
