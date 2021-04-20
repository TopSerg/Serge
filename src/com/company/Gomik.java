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
    int xm = 0, ym = 0, xd, yd, dx = 0, dy = 0, speed = 10, i =0, level = 1, l = 0;
    int divx = 0, divy = 0;
    int y1 = 550, yi = 390, ym1 = 0;
    int x1 = 100, xm1 = 0;
    boolean find = false, a = false, invop = false, item1f = false;
    Mouse1 mouse1;
    Mouse mouse;
    String str = "";
    Level lvl1;
    Level lvl2, lvl3;
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
        stena1[1] = new double[]{745.0/1280, 1280.0/1280, 390.0/720, 390.0/720};
        stena1[2] = new double[]{333.0/1280, 457.0/1280, 383.0/720, 0.0/720};
        double[][] stena2 = new double[4][4];
        stena2[0] = new double[]{0, 118.0/1920, 721.0/1080, 442.0/1080};
        stena2[1] = new double[]{368.0/1920, 720.0/1920, 387.0/1080, 532.0/1080};
        stena2[2] = new double[]{720.0/1920, 1157.0/1920, 532.0/1080, 368.0/1080};
        stena2[3] = new double[]{1415.0/1920, 1534.0/1920, 475.0/1080, 664/1080};
        double[][] stena3 = new double[1][4];
        stena3[0] = new double[]{212.0/1280, 1001.0/1280, 502.0/720, 502.0/720};
        double[][] next1 = new double[1][7];
        next1[0] = new double[]{457.0/1280, 0/1280, 747.0/1280, 35.0/720, 2, 221.0/1280, 375.0/720};
        double[][] next2 = new double[2][7];
        next2[0] = new double[]{963.0/1280, 306.0/720, 1164.0/1280, 417.0/720, 3, 50.0/1280, 650.0/720};
        next2[1] = new double[]{98.0/1280, 367.0/720, 316.0/1280, 327.0/720, 1, 221.0/1280, 375.0/720};
        bakpack = new Bakpack(frame, mouse, mouse1);
        gnom1 = new Player("gnom.png", x1, y1,  80,50, move);
        item1 = new Item("but.png", "L_egg", 600, 100, 40, 50, mouse1,1, "R_egg");
        lvl1 = new Level("fon1.png", "no", frame, bakpack, 1, gnom1, mouse, stena1, next1);
        lvl1.plusitem(item1);
        lvl2 = new Level("holl.jpg", "no", frame, bakpack, 2, gnom1, mouse, stena2, next2);
        lvl3 = new Level("gostinaya.jpg", "no", frame, bakpack, 3, gnom1, mouse, stena3, next1);
//        wizard = new Chel("wizard.png", 0,0,200,200,item1, mouse);
//        but = new Chel("but.png", 500,500,200,200,item1, mouse);
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

    public void paint(Graphics g) {
        switch (level){
            case (1):
                //lvl1(g);
                lvl1.paintb(g, x1, y1);
                break;
            case (2):
                lvl2.paintb(g, x1, y1);
                break;
            case(3):
                lvl3.paintb(g,x1,y1);
        }
//        wizard.paint(g);
//        but.paint(g);
        bakpack.paint(g);
        g.drawString(str,frame.getWidth()-200,10);
        bigdick(g);
//        g.setColor(new Color(255, 100, 100));
//        g.drawRect((int) (457.0/1280*frame.getWidth()), 0/1280, (int)(747.0/1280*frame.getWidth())-(int) (457.0/1280*frame.getWidth()), (int)(35.0/720*frame.getHeight()));
        //TestStena(g);
    }

    public void TestStena(Graphics g){
        int x1 = 0, x2 = 0,y1 = 0,y2 = 0;
        if (mouse.isClik()){
            switch (l){
                case(0):
                    x1 = mouse.getx(3);
                    y1 = mouse.gety(3);
                    l++;
                    break;
                case (1):
                    x2 = mouse.getx(3);
                    y2 = mouse.gety(3);
                    l = 0;
                    break;
            }
        }
        //if (l == 0){
            double k = ((double)y2-(double)y1)/((double)x2-(double)x1);
            for (int j = x1; j <= x2; j++){
                g.setColor(new Color(255, 100, 100));
                g.drawLine(j,y1+(int)(k*(double)j),j,0);
            }
            g.setColor(new Color(0, 0, 0));
        //}
    }

    public int start(){
//        if (wizard.begin()){
//            return 1;
//        }
//        else if(but.begin()){
//            return 2;
//        }
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
        if (Level.Nextlvl() != 0){

        }
        level = Level.Nextlvl();
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