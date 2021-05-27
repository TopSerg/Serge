package com.company;

import java.awt.*;

//клас перемещений
public class Move {
    //задание необходимых переменных
    int level = 1, x1 = 0, y1 = 0, dx, dy, divx, divy, speed, px, py;
    int[][] stena;
    int[] next;
    double k, xdiv = 0, ydiv = 0;
    boolean a = true;
    Mouse mouse;

    //конструктор
    public Move(Mouse mouse, int speed, int x1, int y1){
        this.mouse = mouse;
        this.speed = speed;
        this.x1 = x1;
        this.y1 = y1;
    }

    //метод движения
    public void moves(Player player, int[][] mas, int qx, int qy){
        stena = mas;
        player.x = x1;
        player.y = y1;
        int mx = qx, my = qy, x = x1, y = y1,  b1, b2, xp, yp, nx = 0, ny = 0, dx = 0, dy = 0;
        double k1 = 1, k2 = 1;
        boolean a = false;
        for (int i = 0; i < stena.length; i++){
            if (mx > stena[i][0] && mx < stena[i][1]){
                if (mx != x){
                    k2 = (double)(my-y)/(double)(mx-x);
                }
                if (stena[i][1]-stena[i][0] != 0){
                    k1 = (double)(stena[i][3]-stena[i][2])/(double)(stena[i][1]-stena[i][0]);
                }

                b1 = stena[i][2];
                b2 = (int)((double)(y*mx-my*x)/(double)(mx-x)) ;
                xp = (int)((b2-b1)/(k1-k2));
                yp = (int)(k1*xp) + b1;
                if ((mx-xp)*(x-xp) < 0){
                    dx = (int)((Math.abs(my - mx*k1- b1))/Math.sqrt(1+k1*k1));
                    dy = (int)(-dx/k2);
                    if (x < mx){
                        nx = mx+dx;
                    }
                    else{
                        nx = mx-dx;
                    }
                    if (y < my){
                        ny = my-dy;
                    }
                    else{
                        ny = my+dy;
                    }
                    a = true;
                }
                else{
                    nx = mx;
                    ny = my;
                    a = true;
                }
            }
            if (!a){
                nx = mx;
                ny = my;
                a = true;
            }
        }
        div(nx, ny);
    }

    //метод движения
    public void div(int x, int y){
        dx = x - x1;
        dy = y - y1;
        if (dx != 0 && dy != 0){
            divx = dx;
            divy = dy;
        }
        if (divx != 0 && divy != 0){
            if (Math.abs(divy) > Math.abs(divx)){
                k = (double)divx/(double)divy;
                a = false;
            }
            else{
                k = (double)divy/(double)divx;
                a = true;
            }
        }
        if (divx != 0){
            if ((divx-speed*divx/Math.abs(divx))*divx/Math.abs(divx) <= 0){
                divx = 0;
                dx = 0;
                xdiv = 0;
            }
            else {
                if (!a){
                    xdiv = k*ydiv;
                    divx -= k*divy;
                }
                else{
                    xdiv = (double)speed*divx/Math.abs(divx);
                    divx -= (double)speed*divx/Math.abs(divx);
                }
            }

        }
        if (divy != 0){
            if ((divy-speed*divy/Math.abs(divy))*divy/Math.abs(divy) <= 0){
                divy = 0;
                dy = 0;
                ydiv = 0;
            }
            else {
                if (a){
                    ydiv = k*xdiv;
                    divy -= k*divx;
                }
                else{
                    ydiv = speed*divy/Math.abs(divy);
                    divy -= speed*divy/Math.abs(divy);
                }
            }
        }
        move1((int)xdiv, (int)ydiv);
    }

    //метод движения
    public void move1(int x, int y) {
        int b1;
        double k1 = 1;
        for (int i = 0; i < stena.length; i++) {
            if (x1 + x > stena[i][0] && x1 + x < stena[i][1]) {
                if (stena[i][1] - stena[i][0] != 0) {
                    k1 = (double) (stena[i][3] - stena[i][2]) / (double) (stena[i][1] - stena[i][0]);
                }
                b1 = stena[i][2];
                if (y1 + y < k1 * (x1 - stena[i][0]) + b1) {
                    y1 -= y;
                }
                if (y1 < k1 * ((x1 - stena[i][0]) + x) + b1) {
                    x1 -= x;
                }
            }
        }
        x1 += x;
        y1 += y;
    }

    //вывод координат
    public int[] getXY() {
            int[] ans = new int[2];
            ans[0] = x1;
            ans[1] = y1;
            return ans;
    }

    //задание координат
    public void setXY(int x, int y){
        x1 = x;
        y1 = y;
    }

    //метод возвращающий нужные переменные
    public int getDx(){
        return (int)xdiv;
    }

    public int getDy(){
        return (int)ydiv;
    }

    //метод возвращающий нужные переменные
    public boolean isNext(int[] mas){
        if (x1 > mas[0] && y1 > mas[1] && x1 < mas[2] && y1 < mas[3]){
            return true;
        }
        return false;
    }
}
