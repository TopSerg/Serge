package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Display extends JPanel implements ActionListener{

    Image gnom = new ImageIcon("gnom.png").getImage();
    Image bigdick = new ImageIcon("2.png").getImage();
    Image inv = new ImageIcon("Invent.png").getImage();

    Player gnom1;

    Move move;

    Item item1;
    Item item2;

    Timer timer = new Timer(20, this);

    Bakpack bakpack;

    JFrame frame;
    int xm = 0, ym = 0, xd, yd, dx = 0, dy = 0, speed = 3, i =0, level = 1;
    int divx = 0, divy = 0;
    int y1 = 550, yi = 390, ym1 = 0;
    int x1 = 100, xm1 = 0;
    boolean find = false, a = false, invop = false, item1f = false;
    Mouse1 mouse1;
    Mouse mouse;
    String str = "";
    Level lvl1;
    Level lvl2;


    public Display(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        move = new Move(mouse, speed, x1, y1);
        this.mouse1 = mouse1;
        this.mouse = mouse;
        xd = (int)(Math.random()*1300);
        yd = (int)(Math.random()*730);
        this.frame = frame;
        timer.start();
        int[][] stena1 = new int[4][4];
        stena1[0] = new int[]{0, 333, 390, 390};
        stena1[1] = new int[]{745, 1024, 390, 390};
        stena1[2] = new int[]{333, 457, 383, 0};
        stena1[3] = new int[]{745, 745, 383, 0};
        bakpack = new Bakpack(frame, mouse, mouse1);
        gnom1 = new Player("gnom.png", x1, y1,  frame.getHeight()/20/*+y1/15*40/10*/,frame.getWidth()/100, move);
        item1 = new Item("l_egg.png", "L_egg", 600, 100, 40, 50, mouse1,1);
        item2 = new Item("l_egg.png", "R_egg", 763, 264, 40, 50, mouse1,2);
        lvl1 = new Level("fon1.png", "no", frame, bakpack, 1, gnom1, mouse, stena1);
        lvl1.plusitem(item1);
        lvl2 = new Level("fon21.png", "fon22.png", frame, bakpack, 1, gnom1, mouse, stena1);
        lvl2.plusitem(item2);
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
            if (i == 20){
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

        switch (level){
            case (1):
                //lvl1(g);
                lvl1.paintb(g, x1, y1);
                break;
            case (2):
                lvl2.paintb(g, x1, y1);
                break;
        }
//        g.drawImage(gnom,x1-(40+y1/15*40/100),y1-(y1/15+100),40+y1/15*40/100,y1/15+100,null);
//        switch (level){
//            case (1):
//                //lvl1(g);
//                lvl1.paintf(g);
//                break;
//            case (2):
//                //lvl2(g);
//                lvl2.paintf(g);
//                break;
//        }
        bakpack.paint(g);
        g.drawString(str,frame.getWidth()-200,10);
        bigdick(g);
    }

    // Метод таймера
    @Override
    public void actionPerformed(ActionEvent e) {
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
        if (xm > 870 && ym > 470 && bakpack.invop){
        }
        else{
            xm = mouse.getx();
            ym = mouse.gety();
        }
        xm1 = mouse1.getx1();
        ym1 = mouse1.gety1();
        repaint();
    }

}