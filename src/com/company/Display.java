package com.company;

import com.company.vzlom.Dsaper;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//класс картинки, встающей в рамку
public class Display extends JPanel implements ActionListener{


    //задание необходимых переменных
    Timer timer = new Timer(20, this);
    Mouse mouse;
    Mouse1 mouse1;
    JFrame frame;
    boolean d = false, sanya = false;
    Dsaper dsaper;

    int h, w;
//    int[][] pole = new int[12][12];
//    int[][] anal = new int[12][12];
//    int turn = 1, sum = 0, it = 0, iter = 0;
//    Image pol = new ImageIcon("pole.png").getImage();
//    Image x = new ImageIcon("x.png").getImage();
//    Image o = new ImageIcon("o.png").getImage();
//    Image kebok = new ImageIcon("2.png").getImage();
//    String str = "";
//    String img = "but.png";
//    Button button;
//
    bibu xo;
    Gnnomik chapter1;
    int chapter = 0;
    Item itm2;

    //конструктор
    public Display(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        this.frame = frame;
        this.mouse = mouse;
        this.mouse1 = mouse1;
        //b = new BallGame();
        xo = new bibu(frame, mouse, mouse1);
        chapter1 = new Gnnomik(frame,mouse,mouse1);
        dsaper = new Dsaper(frame,mouse,mouse1);
        timer.start();
        itm2 = new Item("l_egg.png", "R_egg", 0,0,0,0,mouse1,0, "L_egg", null, frame, null);
    }

    //класс отрисовки
    public void paint(Graphics g) {
        switch (chapter){
            case(0):
                chapter1.paint(g);
                break;
            case (1):
                if (!sanya){
                    xo.paint(g);
                }
                //b.kuk();
                break;
            case(2):
                dsaper.paint(g);
                break;
            default:
                System.out.println("ERROR");
        }
        //xo.paint(g);
//        if (!win()){
//            g.drawImage(pol, 100, 100, 500, 500, null);
//            for (int i = 0; i < 12; i++){
//                for (int j = 0; j < 12; j++){
//                    if (pole[i][j] == 1){
//                        //System.out.println(i + " " + j);
//                        g.drawImage(x, 100+39*(i+1), 100+37*(j+1), 400/13, 400/13, null);
//                    }
//                    if (pole[i][j] == -1){
//                        //System.out.println(i + " " + j);
//                        g.drawImage(o, 100+39*(i+1), 100+37*(j+1), 400/13, 400/13, null);
//                    }
//                }
//            }
//            //System.out.println(1);
//        }
//        else {
//            g.drawImage(kebok, 100, 100, 500, 500, null);
//            button.paint(g);
//        }
//        g.drawString(str,frame.getWidth()-200,10);
////        System.out.println(1);
////        if (mouse.isClik()) {
////            pole[Math.round((mouse.getx() - 100) / 39) - 1][Math.round((mouse.gety() - 100) / 39) - 1] = turn;
////            System.out.println(Math.round(((mouse.getx() - 100) / 39) - 1) + " " + Math.round(((mouse.gety() - 100) / 39) - 1));
////        }
    }

    //класс таймера
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(1);
        //xo.chlenbolit();
        if (chapter == 0){
            chapter = chapter1.start();
        }
        if (xo.exit() && d){
            itm2.find = true;
            chapter1.Itemp(itm2);
            chapter = 0;
            d = false;
            sanya =true;
        }
        //System.out.println(chapter);
        switch (chapter){
            case(0):
                chapter1.actionPerformed();
                break;
            case (1):
                if (!sanya){
                    d = true;
                    xo.bol();
                }
                else {
                    chapter = 0;
                }
                break;
            case(2):
                dsaper.actionPerformed();
                break;
            default:
                System.out.println("ERROR");
        }
//        if (mouse.isClik()){
//            if (iter == 0) {
//                iter++;
//                if (Math.round((mouse.getx() - 100) / 39) - 1 >= 0 && Math.round((mouse.gety() - 100) / 39) - 1 >= 0) {
//                    if (pole[Math.round((mouse.getx() - 100) / 39) - 1][Math.round((mouse.gety() - 100) / 39) - 1] == 0) {
//                        pole[Math.round((mouse.getx() - 100) / 39) - 1][Math.round((mouse.gety() - 100) / 39) - 1] = turn;
//                        turn *= -1;
//                    }
//                }
//            }
//        }
//        if (!mouse.isClik()){
//            iter = 0;
//        }
//        if (turn == -1){
//            bot();
//        }
//        if (button.Restart()){
//            pole[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[4] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[5] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[6] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[7] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[8] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[9] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[10] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            pole[11] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//            turn = 1;
//            sum = 0;
//             it = 0;
//             button.clik = false;
//        }
////        System.out.println(Math.round(((mouse.getx()-100)/39)-1) + " " + Math.round(((mouse.gety()-100)/39)-1));
        repaint();
    }
}
