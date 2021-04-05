package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Display extends JPanel implements ActionListener{

    Timer timer = new Timer(20, this);
    Mouse mouse;
    Mouse1 mouse1;
    JFrame frame;
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
    sosibibu xo;
    Gomik chapter1;
    int chapter = 0;

    public Display(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        this.frame = frame;
        this.mouse = mouse;
        this.mouse1 = mouse1;
        xo = new sosibibu(frame, mouse, mouse1);
        chapter1 = new Gomik(frame,mouse,mouse1);
        timer.start();
////        for (int i = 0; i < 12; i++){
////            for (int j =0; j < 12; j++){
////                pole[i][j] = 0;
////            }
////        }
//        pole[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[4] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[5] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[6] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[7] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[8] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[9] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[10] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        pole[11] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[4] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[5] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[6] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[7] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[8] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[9] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[10] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        anal[11] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
//        button = new Button(0,0,50,250,img,mouse);
    }
//
//    public boolean win(){
//        for (int i = 0; i < 12; i++){
//            it = 0;
//            sum = 0;
//            for (int j = 0; j < 12; j++){
//                if (it < 5){
//                    sum += pole[i][j];
//                    it++;
//                }
//                else{
//                    sum-=pole[i][j-it];
//                    sum += pole[i][j];
//                }
//                if (Math.abs(sum) == 5){
//                    return true;
//                }
//                //System.out.print(sum);
//            }
//            //System.out.println();
//        }
//        //System.out.println();
//        for (int j = 0; j < 12; j++){
//            it = 0;
//            sum = 0;
//            for (int i = 0; i < 12; i++){
//                if (it < 5){
//                    sum += pole[i][j];
//                    it++;
//                }
//                else{
//                    sum-=pole[i-it][j];
//                    sum += pole[i][j];
//                }
//                if (Math.abs(sum) == 5){
//                    return true;
//                }
//          //      System.out.print(sum + " ");
//            }
//            //System.out.println();
//        }
//        //System.out.println();
//        for (int i = 0; i < 12; i++){
//            it = 0;
//            sum = 0;
//            for (int j = 0; j < i; j++){
//                if (it < 5){
//                    sum += pole[i-j][j];
//                    it++;
//                }
//                else{
////                    System.out.println(1);
//                    sum-=pole[i-j+it][j-it];
//                    sum += pole[i-j][j];
//                }
//                if (Math.abs(sum) == 5){
//                    return true;
//                }//System.out.println(sum);
//            }
//        }
//        for (int i = 0; i < 12; i++){
//            it = 0;
//            sum = 0;
//            for (int j = 0; j < i; j++){
//                if (it < 5){
//                    sum += pole[11-(i-j)][j];
//                    it++;
//                }
//                else{
//                    sum-=pole[11-(i-j+it)][j-it];
//                    sum += pole[11-(i-j)][j];
//                }
//                if (Math.abs(sum) == 5){
//                    return true;
//                }
//                //System.out.println(sum);
//            }
//
//        }
//        return false;
//    }
//
    public void paint(Graphics g) {
        switch (chapter){
            case(0):
                chapter1.paint(g);
                break;
            case (1):
                xo.paint(g);
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
//
//    public void bot(){
//        int w1 = -1, w2 = 1, g1 = -1, g2 = 1;
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 12; j++) {
//                if (pole[i][j] == 1 || pole[i][j] == -1){
//                    switch (i){
//                        case (0):
//                            w1 = 0;
//                            break;
//                        case (11):
//                            w2 = 0;
//                            break;
//                    }
//                    switch (j){
//                        case (0):
//                            g1 = 0;
//                            break;
//                        case (11):
//                            g2 = 0;
//                            break;
//                    }
//                    for (int w = w1; w <= w2; w++){
//                        for (int g = g1; g <= g2; g++){
//                            made(i,j,w,g,1);
//                            //System.out.println(w+ " " + g);
//                        }
//                    }
//                }
////                if (pole[i][j] == -1){
////                    switch (i){
////                        case (0):
////                            w1 = 0;
////                            break;
////                        case (11):
////                            w2 = 0;
////                            break;
////                    }
////                    switch (j){
////                        case (0):
////                            g1 = 0;
////                            break;
////                        case (11):
////                            g2 = 0;
////                            break;
////                    }
////                    for (int w = w1; w < w2; w++){
////                        for (int g = g1; g < g2; g++){
////                            made(i,j,w,g,-1);
////                        }
////                    }
////                }
//            }
//        }
//        int max = 0, mi = 0, mj = 0;
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 12; j++) {
//                if (anal[i][j] > max){
//                    max = anal[i][j];
//                    mi = i;
//                    mj = j;
//                }
//            }
//        }
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 12; j++) {
//                System.out.print(anal[i][j]);
//
//            }
//            for (int j = 0; j < 12; j++) {
//                System.out.print(" " + pole[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//        pole[mi][mj] = turn;
//        turn *= -1;
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 12; j++) {
//                anal[i][j] = 0;
//            }
//        }
//    }
//
//    public void made(int a, int b, int w, int g, int hod){
//        int nw = 0, ng = 0;
//        //System.out.println(a + " " + b + " " + w + " " + g);
//        if((pole[a+w][b+g] == 1 || pole[a+w][b+g] == -1)&&w == 0 && g == 0){
//            //То ты лох
//        }
//        else if (pole[a+w][b+g] == 0){
//            //System.out.println(1);
//            anal[a+w][b+g] += hod;
//        }
//        else{
//            if (pole[a][b] == pole[a+w][b+g]){
//                hod *= 2;
//            }
//            else{
//                hod = -1;
//            }
//            if (w != 0){
//                nw = (Math.abs(w)+1)*w/Math.abs(w);
//            }
//            else{
//                nw = 0;
//            }
//            if (g != 0){
//                ng = (Math.abs(g)+1)*g/Math.abs(g);
//            }
//            else{
//                ng = 0;
//            }
//            made(a,b,nw,ng, hod);
//        }
//    }
//
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(1);
        //xo.chlenbolit();
        if (chapter1.start()){
            chapter = 1;
        }
        if (xo.exit()){
            chapter = 0;
        }
        switch (chapter){
            case(0):
                chapter1.actionPerformed();
                break;
            case (1):
                xo.chlenbolit();
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
