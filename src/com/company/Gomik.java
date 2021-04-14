package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Gomik{

    Image gnom = new ImageIcon("gnom.png").getImage();
    Image bigdick = new ImageIcon("kebok.png").getImage();
    Image inv = new ImageIcon("Invent.png").getImage();
    Player gnom1;
    Move move;
    Item item1;
    Item item2;
    Bakpack bakpack;
    JFrame frame;
    int xm = 0, ym = 0, xd, yd, dx = 0, dy = 0, speed = 10, i =0, level = 1;
    int divx = 0, divy = 0;
    int y1 = 550, yi = 390, ym1 = 0;
    int x1 = 100, xm1 = 0;
    boolean find = false, a = false, invop = false, item1f = false;
    Mouse1 mouse1;
    Mouse mouse;
    String str = "";
    Level lvl1;
    Level lvl2;
    Button button2;
    Chel wizard;
    Chel but;

    public Gomik(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        move = new Move(mouse, speed, x1, y1);
        this.mouse1 = mouse1;
        this.mouse = mouse;
        xd = (int)(Math.random()*1300);
        yd = (int)(Math.random()*730);
        this.frame = frame;
        double[][] stena1 = new double[3][4];
        stena1[0] = new double[]{0, 333.0/1280, 390.0/720, 390.0/720};
        stena1[1] = new double[]{745.0/1280, 1024.0/1280, 390.0/720, 390.0/720};
        stena1[2] = new double[]{333.0/1280, 457.0/1280, 383.0/720, 0.0/720};
        bakpack = new Bakpack(frame, mouse, mouse1);
        gnom1 = new Player("gnom.png", x1, y1,  80,50, move);
        item1 = new Item("but.png", "L_egg", 600, 100, 40, 50, mouse1,1, "R_egg");
        lvl1 = new Level("fon1.png", "no", frame, bakpack, 1, gnom1, mouse, stena1);
        lvl1.plusitem(item1);
        lvl2 = new Level("fon21.png", "fon22.png", frame, bakpack, 1, gnom1, mouse, stena1);
        lvl2.plusitem(item2);
        wizard = new Chel("wizard.png", 0,0,200,200,item1, mouse);
        but = new Chel("but.png", 500,500,200,200,item1, mouse);
    }

    public void Itemp(Item item){
        bakpack.plus(item);
    }

    public boolean find(int x, int y, int xd, int yd){
        if (x > xd && x < xd+100 && y > yd && yd < yd+100){
            return true;
        }
        return false;
    }

    public void bigdick(Graphics g){
        if (find){
            g.drawImage(bigdick, xd, yd, 100, 100, null);
            i++;
            if (i == 1){
                find = false;
                i = 0;
                xd = (int)(Math.random()*1300);
                yd = (int)(Math.random()*730);
            }
        }
    }

    public void move2(int x, int y){
        if (y1 < 200){
            x1 += x;
            y1 = 200;
        }
        else if ((y1 < (295*x1/63 - 28985/7))&&x1>927){

        }
        else if (y1 > 700){
            level = 1;
            x1 = 600;
            y1 =120;
            mouse.xm = 600;
            mouse.ym = 120;
        }
        else {
            x1 += x;
            y1 += y;
        }
    }

    public void paint(Graphics g) {

        switch (level){
            case (1):
                //lvl1(g);
                lvl1.paintb(g, x1, y1);
                break;
            case (2):
                lvl2.paintb(g, x1, y1);
                break;
        }
        wizard.paint(g);
        but.paint(g);
        bakpack.paint(g);
        g.drawString(str,frame.getWidth()-200,10);
        bigdick(g);
    }

    public int start(){
        if (wizard.begin()){
            return 1;
        }
        else if(but.begin()){
            return 2;
        }
        return 0;
    }

    public void actionPerformed() {
        // TODO Auto-generated method stub
        dx = xm-x1;
        dy = ym-y1;
        str = frame.getHeight() + " " + divy + " " + xm1 + " " + ym1 + " " + x1 + " " + y1 + " " + xd + " " + yd + " " + yi;

        find = find(xm, ym, xd, yd);
        x1 = move.getXY()[0];
        y1 = move.getXY()[1];
        bakpack.move(xm1, ym1);
        bakpack.minus();
        if (xm > 870 && ym > 470 && bakpack.invop){
        }
        else{
            xm = mouse.getx(1);
            ym = mouse.gety(1);
        }
        xm1 = mouse1.getx1();
        ym1 = mouse1.gety1();
    }
}