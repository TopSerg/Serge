package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import xo_anal.*;

class Gomik{

    Image gnom = new ImageIcon("gnom.png").getImage();
    Image bigdick = new ImageIcon("kebok.png").getImage();
    Image inv = new ImageIcon("Invent.png").getImage();

    Player gnom1;

    Move move;

    Item item1;
    Item item2;

    //Timer timer = new Timer(20, this);

    Bakpack bakpack;

    JFrame frame;
    int xm = 0, ym = 0, xd, yd, dx = 0, dy = 0, speed = 10, i =0, level = 1, l = 0;
    int divx = 0, divy = 0;
    int y1 = 650, yi = 390, ym1 = 0;
    int x1 = 100, xm1 = 0;
    boolean find = false, a = false, invop = false, item1f = false;
    Mouse1 mouse1;
    Mouse mouse;
    String str = "";
    Level lvl1;
    Level lvl2, lvl3;
    Level[] mas;
    Button button2;

    Chel wizard;
    Chel but;


    public Gomik(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        mas = new Level[20];
        move = new Move(mouse, speed, x1, y1);
        this.mouse1 = mouse1;
        this.mouse = mouse;
        xd = (int)(Math.random()*1300);
        yd = (int)(Math.random()*730);
        this.frame = frame;
        //timer.start();
        double[][] stena1 = new double[3][4];
        stena1[0] = new double[]{366.0/1920, 1920.0/1920, 746.0/1080, 746.0/1080};
        stena1[1] = new double[]{1035.0/1920, 1556.0/1920, 949.0/1080, 949.0/1080};
        stena1[2] = new double[]{1556.0/1920, 1866.0/1920, 949.0/1080, 644.0/1080};
        double[][] stena2 = new double[4][4];
        stena2[0] = new double[]{0, 62.0/1920, 897.0/1080, 897.0/1080};
        stena2[1] = new double[]{62.0/1920, 226.0/1920, 897.0/1080, 897.0/1080};
        stena2[2] = new double[]{226.0/1920, 1444.0/1920, 662.0/1080, 459.0/1080};
        stena2[3] = new double[]{1771.0/1920, 1920.0/1920, 587.0/1080, 823.0/1080};
        double[][] stena3 = new double[1][4];
        stena3[0] = new double[]{212.0/1280, 1001.0/1280, 502.0/720, 502.0/720};
        double[][] next1 = new double[1][7];
        next1[0] = new double[]{457.0/1280, 0/1280, 747.0/1280, 35.0/720, 2, 221.0/1280, 400.0/720};
        double[][] next2 = new double[2][7];
        next2[0] = new double[]{963.0/1280, 306.0/720, 1164.0/1280, 417.0/720, 3, 50.0/1280, 650.0/720};
        next2[1] = new double[]{98.0/1280, 327.0/720, 316.0/1280, 367.0/720, 1, 929.0/1920, 209.0/1080};
        double[][] next3 = new double[2][7];
        next3[0] = new double[]{87.0/1920, 816.0/1080, 256.0/1920, 874.0/1080, 2, 50.0/1920, 650.0/1080};
        next3[1] = new double[]{1544.0/1920, 756.0/1080, 1838.0/1920, 794.0/1080, 1, 50.0/1920, 650.0/1080};
        bakpack = new Bakpack(frame, mouse, mouse1);
        gnom1 = new Player("gnom.png", x1, y1,  80,50, move);
        item1 = new Item("but.png", "L_egg", 600, 100, 40, 50, mouse1,1, "R_egg");
        lvl1 = new Level("room5.jpg", "no", frame, bakpack, 1, gnom1, mouse, stena1, next1);
        lvl1.plusitem(item1);
        wizard = new Chel("wizard.png", 0,0,200,200,item1, mouse, 1);
        but = new Chel("but.png", 500,500,200,200,item1, mouse, 2);
        lvl1.pluschel(wizard);
        lvl2 = new Level("holl.jpg", "no", frame, bakpack, 2, gnom1, mouse, stena1, next2);
        lvl3 = new Level("gostinaya.jpg", "no", frame, bakpack, 3, gnom1, mouse, stena3, next3);
        pluslvl(lvl1);
        pluslvl(lvl2);
        pluslvl(lvl3);
    }

    public void pluslvl(Level level){
        mas[level.getLevel()-1] = level;
    }

    public void Itemp(Item item){
        bakpack.plus(item);
    }

    //Поиск пасхалки
    public boolean find(int x, int y, int xd, int yd){
        if (x > xd && x < xd+100 && y > yd && yd < yd+100){
            return true;
        }
        return false;
    }

    //Пасхалка
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

    //Границы локации 1
//    public void move1(int x, int y){
//        if (y1 < 390 && (x1 < 333 || x1 > 745)){
//            x1 += x;
//            y1 = 390;
//        }
//        else if ((y1 < (-197*x1/65 + 89909/65)+40+y1/15*40/100)&&x1>330&&x1<457){
//            x1 += x+40+y1/15*40/100;
//            y1 = -197*x1/65 + 89909/65+y1/15+100;
//        }
//        else if (x1 > 705 && y1 < 380){
//            y1 += y;
//            x1 = 704;
//        }
//        else if (y1 < 30){
//            level = 2;
//            x1 = 760;
//            y1 = 540;
//            mouse.xm = 760;
//            mouse.ym = 540;
//        }
//        else{
//            x1 += x;
//            y1 += y;
//        }
//    }

    //Границы локации 2
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

    //Перемещение разделение по локациям
//    public void mov(int x, int y){
//        switch (level){
//            case (1):
//                move1(x,y);
//                break;
//            case (2):
//                move2(x,y);
//                break;
//        }
//    }

    //Перемещение (вычисления + скорость)
//    public void div(){
//        if (dx != 0 && dy != 0){
//            divx = dx;
//            divy = dy;
//        }
//        if (divx != 0){
//            mov(speed*divx/Math.abs(divx),0);
//
//            if ((divx-speed*divx/Math.abs(divx))*divx/Math.abs(divx) < 0){
//                divx = 0;
//            }
//            else {
//                divx -= speed*divx/Math.abs(divx);
//            }
//        }
//        if (divy != 0){
//            mov(0,speed*divy/Math.abs(divy));
//            if ((divy-speed*divy/Math.abs(divy))*divy/Math.abs(divy) < 0){
//                divy = 0;
//            }
//            else {
//                divy -= speed*divy/Math.abs(divy);
//            }
//        }
//    }

    // Метод отрисовки
    public void paint(Graphics g) {
        //System.out.println(frame.getWidth() + " " + frame.getHeight());
//        switch (level){
//            case (1):
//                //lvl1(g);
//                lvl1.paintb(g, x1, y1);
//                break;
//            case (2):
//                lvl2.paintb(g, x1, y1);
//                break;
//            case(3):
//                lvl3.paintb(g,x1,y1);
//        }
        mas[level-1].paintb(g,x1,y1);
        //wizard.paint(g);
        //but.paint(g);
        bakpack.paint(g);
        g.drawString(str,frame.getWidth()-200,10);
        //System.out.println(frame.getWidth());
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
//        switch (level){
//            case (1):
//                //lvl1(g);
//                return lvl1.getNext();
//            case (2):
//                return lvl2.getNext();
//            case(3):
//                return lvl3.getNext();
//        }
        return mas[level-1].getNext();
//        if (wizard.begin()){
//            return 1;
//        }
//        else if(but.begin()){
//            return 2;
//        }
    }

    // Метод таймера
    public void actionPerformed() {
        // TODO Auto-generated method stub
        dx = xm-x1;
        dy = ym-y1;
        str = frame.getHeight() + " " + divy + " " + xm1 + " " + ym1 + " " + x1 + " " + y1 + " " + xd + " " + yd + " " + yi;

        find = find(xm, ym, xd, yd);
        //div();
        //move.set(dx, dy);
        x1 = move.getXY()[0];
        y1 = move.getXY()[1];
        //gnom1.move(mouse.getx(), mouse.gety());
//        move.div();
        bakpack.move(xm1, ym1);
        bakpack.minus();
        if (level!= Level.Nextlvl()) {
            level = Level.Nextlvl();
            mouse.setXY(gnom1.x, gnom1.y);
        }
        else{
            xm = mouse.getx(1);
            ym = mouse.gety(1);
        }
        xm1 = mouse1.getx1();
        ym1 = mouse1.gety1();
        //repaint();
    }

}