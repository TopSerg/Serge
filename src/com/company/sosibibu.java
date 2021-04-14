package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class sosibibu {

    Mouse mouse;
    Mouse1 mouse1;
    JFrame frame;
    boolean v = false;
    int[][] pole = new int[12][12];
    int[][] anal = new int[12][12];
    int turn = 1, sum = 0, it = 0, iter = 0, xb=100, yb=100;
    Image pol = new ImageIcon("pole.png").getImage();
    Image x = new ImageIcon("x.png").getImage();
    Image o = new ImageIcon("o.png").getImage();
    Image kebok = new ImageIcon("kebok.png").getImage();
    String str = "";
    String img = "but.png";
    Button button;

    public sosibibu(JFrame frame, Mouse mouse, Mouse1 mouse1) {
        this.frame = frame;
        this.mouse = mouse;
        this.mouse1 = mouse1;
        pole[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[4] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[5] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[6] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[7] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[8] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[9] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[10] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        pole[11] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[4] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[5] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[6] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[7] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[8] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[9] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[10] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        anal[11] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        button = new Button(0,0,50,250,img,mouse);
    }

    public boolean win(){
        for (int i = 0; i < 12; i++){
            it = 0;
            sum = 0;
            for (int j = 0; j < 12; j++){
                if (it < 5){
                    sum += pole[i][j];
                    it++;
                }
                else{
                    sum-=pole[i][j-it];
                    sum += pole[i][j];
                }
                if (Math.abs(sum) == 5){
                    return true;
                }
            }
        }
        for (int j = 0; j < 12; j++){
            it = 0;
            sum = 0;
            for (int i = 0; i < 12; i++){
                if (it < 5){
                    sum += pole[i][j];
                    it++;
                }
                else{
                    sum-=pole[i-it][j];
                    sum += pole[i][j];
                }
                if (Math.abs(sum) == 5){
                    return true;
                }
            }
        }
        for (int i = 0; i < 12; i++){
            it = 0;
            sum = 0;
            for (int j = 0; j < i; j++){
                if (it < 5){
                    sum += pole[i-j][j];
                    it++;
                }
                else{
                    sum-=pole[i-j+it][j-it];
                    sum += pole[i-j][j];
                }
                if (Math.abs(sum) == 5){
                    return true;
                }
            }
        }
        for (int i = 0; i < 12; i++){
            it = 0;
            sum = 0;
            for (int j = 0; j < i; j++){
                if (it < 5){
                    sum += pole[11-(i-j)][j];
                    it++;
                }
                else{
                    sum-=pole[11-(i-j+it)][j-it];
                    sum += pole[11-(i-j)][j];
                }
                if (Math.abs(sum) == 5){
                    return true;
                }
            }

        }
        return false;
    }

    public void paint(Graphics g) {
        xb = frame.getWidth()/2-250;
        yb = frame.getHeight()/2-250;
        if (!win()){
            g.drawImage(pol, xb, yb, 500, 500, null);
            for (int i = 0; i < 12; i++){
                for (int j = 0; j < 12; j++){
                    if (pole[i][j] == 1){
                        g.drawImage(x, xb+39*(i+1), yb+37*(j+1), 400/13, 400/13, null);
                    }
                    if (pole[i][j] == -1){
                        g.drawImage(o, xb+39*(i+1), yb+37*(j+1), 400/13, 400/13, null);
                    }
                }
            }
        }
        else {
            g.drawImage(kebok, xb, yb, 500, 500, null);
            button.paint(g);
        }
        g.drawString(str,frame.getWidth()-200,10);
    }

    public void bot(){
        int w1 = -1, w2 = 1, g1 = -1, g2 = 1;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (pole[i][j] == 1 || pole[i][j] == -1){
                    switch (i){
                        case (0):
                            w1 = 0;
                            break;
                        case (11):
                            w2 = 0;
                            break;
                    }
                    switch (j){
                        case (0):
                            g1 = 0;
                            break;
                        case (11):
                            g2 = 0;
                            break;
                    }
                    for (int w = w1; w <= w2; w++){
                        for (int g = g1; g <= g2; g++){
                            made(i,j,w,g,1);
                        }
                    }
                }
            }
        }
        int max = 0, mi = 0, mj = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (anal[i][j] > max){
                    max = anal[i][j];
                    mi = i;
                    mj = j;
                }
            }
        }
        pole[mi][mj] = turn;
        turn *= -1;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                anal[i][j] = 0;
            }
        }
    }

    public void made(int a, int b, int w, int g, int hod){
        int nw = 0, ng = 0;
        if((pole[a+w][b+g] == 1 || pole[a+w][b+g] == -1)&&w == 0 && g == 0){
            //То ты лох
        }
        else if (pole[a+w][b+g] == 0){
            anal[a+w][b+g] += hod;
        }
        else{
            if (pole[a][b] == pole[a+w][b+g]){
                hod *= 2;
            }
            else{
                hod = -1;
            }
            if (w != 0){
                nw = (Math.abs(w)+1)*w/Math.abs(w);
            }
            else{
                nw = 0;
            }
            if (g != 0){
                ng = (Math.abs(g)+1)*g/Math.abs(g);
            }
            else{
                ng = 0;
            }
            made(a,b,nw,ng, hod);
        }
    }

    public boolean exit(){
        if (button.Restart()||v){
            return true;
        }
        return false;
    }


    public void chlenbolit() {
        int b = Math.round((mouse.gety(2) - yb) / 39) - 1;
        int a = Math.round((mouse.getx(2) - xb) / 39) - 1;
        if (a == 0 && b == 0){
            v = true;
        }
        System.out.println(a+ " " + b);
        if (mouse.isClik()){
            if (iter == 0) {
                iter++;
                if (a >= 0 && b >= 0) {
                    if (pole[a][b] == 0) {
                        pole[a][b] = turn;
                        turn *= -1;
                    }
                }
            }
        }
        if (!mouse.isClik()){
            iter = 0;
        }
        if (turn == -1){
            bot();
        }
        if (button.Restart()){
            pole[0] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[1] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[3] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[4] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[5] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[6] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[7] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[8] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[9] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[10] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            pole[11] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            turn = 1;
            sum = 0;
            it = 0;
            button.clik = false;
        }
    }
}
