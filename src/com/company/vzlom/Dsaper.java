package com.company.vzlom;


import com.company.Mouse;
import com.company.Mouse1;

import javax.swing.*;
import java.awt.*;

//класс сапера
public class Dsaper{

    //задание необходимых переменных
    JFrame frame;
    Mouse mouse;
    Mouse1 mouse1;
    String but = "kakapress.jpg", but0 = "kaka.jpg", but1 = "1.jpg", but2 = "2.jpg", but3 = "3.jpg", but4 = "4.jpg", but5 = "5.jpg", but6 = "6.jpg", but7 = "7.jpg", but8 = "8.jpg", but9 = "9.jpg", but10 = "net.jpg", def = "def.jpg";
    Buttonvz[][] buttons = new com.company.vzlom.Buttonvz[20][20];
    com.company.Button b;
    Image wini = new ImageIcon("win.png").getImage();
    Image losi = new ImageIcon("lose.png").getImage();

    boolean lose = false, win = false;
    int[][] pole = new int[20][20];

    //конструктор класса
    public Dsaper(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        this.mouse1 = mouse1;
        this.mouse = mouse;
        this.frame = frame;
        pole[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[4] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[5] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[6] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[7] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[8] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[9] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[10] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[11] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[12] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[13] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[14] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[15] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[16] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[17] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[18] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        pole[19] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        made();
        for (int j = 0; j < 20; j++){
            for (int e = 0; e < 20; e++){
                switch (pole[j][e]){
                    case (1):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but1,mouse);
                        break;
                    case (2):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but2,mouse);
                        break;
                    case (3):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but3,mouse);
                        break;
                    case (4):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but4,mouse);
                        break;
                    case (5):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but5,mouse);
                        break;
                    case (6):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but6,mouse);
                        break;
                    case (7):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but7,mouse);
                        break;
                    case (8):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but8,mouse);
                        break;
                    case (9):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,but9,mouse);
                        break;
                    case (-1):
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0, but10,mouse);
                        break;
                    default:
                        buttons[j][e] = new com.company.vzlom.Buttonvz(j*20, e*20, 20,20,but,but0,def,mouse);
                        break;
                }
            }
        }

    }

    //прибавление 1 к клетке вокруг мины
    public void made1(int a, int b, int w, int g, int hod){
        int nw = 0, ng = 0;
        if (pole[a+w][b+g] != -1){
            pole[a+w][b+g]++;
        }
        else{
            
        }
    }

    //задание поля
    public void made(){
        int a = 0;
        int q;
        int s;
        while (a < 40){
            q = (int)(Math.random()*19);
            s = (int)(Math.random()*19);
            if (pole[q][s] == 0){
                pole[q][s] = -1;
                a++;
            }
        }
        int w1 = -1, w2 = 1, g1 = -1, g2 = 1;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                w1 = -1;
                w2 = 1;
                g1 = -1;
                g2 = 1;
                if (pole[i][j] == -1){
                    switch (i){
                        case (0):
                            w1 = 0;
                            break;
                        case (19):
                            w2 = 0;
                            break;
                    }
                    switch (j){
                        case (0):
                            g1 = 0;
                            break;
                        case (19):
                            g2 = 0;
                            break;
                    }
                    for (int w = w1; w <= w2; w++){
                        for (int g = g1; g <= g2; g++){
                            made1(i,j,w,g,1);
                        }
                    }
                }
            }
        }
    }

    //отладочная функция
    public void openAll(){
        for (int j = 0; j < 20; j++){
            for (int e = 0; e < 20; e++){
                buttons[j][e].isopen = true;
            }
        }
    }

    //проверка закончена ли игра
    public void win(){
        int a = 0;
        if (buttons[19][19] != null) {
            for (int j = 0; j < 20; j++) {
                for (int e = 0; e < 20; e++) {
                    if (buttons[j][e].IsOpen()) {
                        a++;
                        if (buttons[j][e].getNumber() == 'm' && !buttons[j][e].flagok) {
                            lose = true;
                        }
                    }
                }
            }
            if (a >= 20 * 20 - 40) {
                win = true;
            }
        }
    }

    //метод отрисовки
    public void paint(Graphics g) {
        //g.drawImage(wini, 0, 0, frame.getWidth(), frame.getHeight(), null);
        if (win){
            g.drawImage(wini, 0, 0, frame.getWidth(), frame.getHeight(), null);
        }
        else if (lose){
            g.drawImage(losi, 0, 0, frame.getWidth(), frame.getHeight(), null);
        }
        else {
            int w1 = -1, w2 = 1, g1 = -1, g2 = 1;
            for (int j = 0; j < 20; j++) {
                for (int e = 0; e < 20; e++) {
                    w1 = -1;
                    w2 = 1;
                    g1 = -1;
                    g2 = 1;
                    if (buttons[j][e].IsOpen() && buttons[j][e].getNumber() == 'd') {
                        switch (j) {
                            case (0):
                                w1 = 0;
                                break;
                            case (19):
                                w2 = 0;
                                break;
                        }
                        switch (e) {
                            case (0):
                                g1 = 0;
                                break;
                            case (19):
                                g2 = 0;
                                break;
                        }
                        for (int w = w1; w <= w2; w++) {
                            for (int z = g1; z <= g2; z++) {
                                buttons[j + w][e + z].isopen = true;
                            }
                        }
                    }
                    buttons[j][e].paint(g);
                }
            }
        }
    }

    //то что передается в таймер
    public void actionPerformed() {
        win();
    }
}