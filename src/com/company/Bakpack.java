package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//класс рюкзака
class Bakpack{

    //задание необходимых переменных
    Image inv = new ImageIcon("Invent.png").getImage();

    JFrame frame;
    Mouse1 mouse1;
    Mouse mouse;

    Item[] items = new Item[20];
    Image[] mas = new Image[20];

    int yi = 390;
    boolean a = false, invop = false, errorbf = false, b = true;

    //конструктор
    public Bakpack(JFrame frame, Mouse mouse, Mouse1 mouse1){
        this.frame = frame;
        this.mouse = mouse;
        this.mouse1 = mouse1;
        mouse.Setxy(frame.getWidth()-340+13, frame.getHeight()+13-446);
    }
//отрисовка предметов в объекте backpack
    public void paint(Graphics g){
        Item item = null;
        g.drawImage(inv, frame.getWidth()-1000, frame.getHeight()-720+yi, 1000, 500,null);
        mouse.Setxy(frame.getWidth()-340+13, frame.getHeight()+13-446+yi);
        for (int i = 0; i < 20; i++){
            if (items[i] != null){
                items[i].found(mouse);
                items[i].SetXY(frame.getWidth()-340+13+65*i,frame.getHeight()+13-446+10*(i/5)+yi,  40,30*40/50);
                items[i].paint(g);
                if (items[i].IsGet()){
                    for (int j = 0; j < 20; j++){
                        if (items[j] != null){
                            if (items[i].eguals(items[j])){
                                if (items[i].getItm() != null){
                                    item = items[i].getItm();
                                }
                                if (items[j].getItm() != null){
                                    item = items[j].getItm();
                                }
                                items[j] = null;
                                items[i] = item;
                                items[i].find = true;
                            }
                        }
                    }
//                    items[i+1] = null;
                }
            }
        }
    }
//передвижение предметов из рюкзака
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
    }

    //добавление предметов в рюкзак
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
//удаление предметов из рюкзака при сложении
    public void minus(){
        for (int i = 0; i < 20; i++){
            if (mouse.getx(2) > 880+65*i && mouse.getx(2) < 880+65*i+30*40/50 && mouse.gety(2) < yi+277 && mouse.gety(2) > yi+277+40 && invop){
                items[i].setIsminus(true);
                items[i] = null;
                mas[i] = null;
            }
        }

    }
}
