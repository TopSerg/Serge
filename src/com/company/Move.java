package com.company;

import java.awt.*;

public class Move {
    int level = 1, x1 = 0, y1 = 0, dx, dy, divx, divy, speed, px, py;
    int stena[][];
    double k, xdiv = 0, ydiv = 0;
    boolean a = true;
    Mouse mouse;


    public Move(Mouse mouse, int speed, int x1, int y1){
        this.mouse = mouse;
        this.speed = speed;
        this.x1 = x1;
        this.y1 = y1;
    }

//    public void set(){
//        dx = mouse.getx() - x1;
//        dy = mouse.gety() - y1;
//    }

    public void moves(Player player, int[][] mas, int qx, int qy){
        stena = mas;
        player.x = x1;
        player.y = y1;
        int mx = qx, my = qy, x = x1, y = y1,  b1, b2, xp, yp, nx = 0, ny = 0, dx = 0, dy = 0;
        double k1 = 1, k2 = 1;
        boolean a = false;
        for (int i = 0; i < stena.length; i++){
            //g.drawLine(stena[i][0],stena[i][2],stena[i][1],stena[i][3]);
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
                //g.drawLine(stena[i][0], b2, stena[i][1], (int)(b2+stena[i][1]*k2));
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
                    //nx = mx+dx;
                    //ny = dy+my;
                    a = true;
                }
                else{
                    nx = mx;
                    ny = my;
                    a = true;
                }
                //System.out.println(dx +" "+ dy+" "+Math.abs(my - mx*k1- b1)+" " + Math.sqrt(1+k1*k1));
            }
            if (!a){
                nx = mx;
                ny = my;
                a = true;
            }
            //System.out.println(i);
        }
        div(nx, ny);
    }

    public void moves(Item item){
        item.x = x1;
        item.y = y1;
    }

    public void mov(int x, int y){
//        int mx = mouse.getx(1), my = mouse.gety(1), x = x1, y = y1,  b1, b2, xp, yp, nx = 0, ny = 0, dx = 0, dy = 0;
//        double k1 = 1, k2 = 1;
//        boolean a = false;
//        for (int i = 0; i < stena.length; i++){
//            //g.drawLine(stena[i][0],stena[i][2],stena[i][1],stena[i][3]);
//            if (mx > stena[i][0] && mx < stena[i][1]){
//                if (mx != x){
//                    k2 = (double)(my-y)/(double)(mx-x);
//                }
//                if (stena[i][1]-stena[i][0] != 0){
//                    k1 = (double)(stena[i][3]-stena[i][2])/(double)(stena[i][1]-stena[i][0]);
//                }
//
//                b1 = stena[i][2];
//                b2 = (int)((double)(y*mx-my*x)/(double)(mx-x)) ;
//                xp = (int)((b2-b1)/(k1-k2));
//                //g.drawLine(stena[i][0], b2, stena[i][1], (int)(b2+stena[i][1]*k2));
//                yp = (int)(k1*xp) + b1;
//                if ((mx-xp)*(x-xp) < 0){
//                    dx = (int)((Math.abs(my - mx*k1- b1))/Math.sqrt(1+k1*k1));
//                    dy = (int)(-dx/k2);
//                    if (x < mx){
//                        nx = mx+dx;
//                    }
//                    else{
//                        nx = mx-dx;
//                    }
//                    if (y < my){
//                        ny = my-dy;
//                    }
//                    else{
//                        ny = my+dy;
//                    }
//                    //nx = mx+dx;
//                    //ny = dy+my;
//                    a = true;
//                }
//                else{
//                    nx = mx;
//                    ny = my;
//                    a = true;
//                }
//                System.out.println(dx +" "+ dy+" "+Math.abs(my - mx*k1- b1)+" " + Math.sqrt(1+k1*k1));
//            }
//            if (!a){
//                nx = mx;
//                ny = my;
//                a = true;
//            }
//            //System.out.println(i);
//        }
        move1(x,y);
    }

    public void div(int x, int y){
        dx = x - x1;
        dy = y - y1;
        if (dx != 0 && dy != 0){
            divx = dx;
            divy = dy;
//            k = divy/divx;
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
            //System.out.print(speed*divx/Math.abs(divx) + "   ___x__    ");
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
            //System.out.print(speed*divy/Math.abs(divy) + "   ___y___   ");
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
//                ydiv = k*xdiv;
//                divy -= k*divx;
            }
        }
        move1((int)xdiv, (int)ydiv);
    }

    public void move1(int x, int y) {
        int b1 = 0, b2, xp, yp, nx = 0, ny = 0, dx = 0, dy = 0;
        double k1 = 1, k2 = 1;
        for (int i = 0; i < stena.length; i++) {
            //System.out.println(x1 + " " + y1);
            if (x1 + x > stena[i][0] && x1 + x < stena[i][1]) {
                if (stena[i][1] - stena[i][0] != 0) {
                    k1 = (double) (stena[i][3] - stena[i][2]) / (double) (stena[i][1] - stena[i][0]);
                }
                b1 = stena[i][2];
                //System.out.println(k1 + " " + b1 + " " + (y1 + y) +" "+ (k1 * (x1-stena[i][0]) + b1));
                if (y1 + y < k1 * (x1-stena[i][0]) + b1) {
                    y1 -= y;
                    System.out.println(1);
                }
                if (y1 < k1 * ((x1-stena[i][0]) + x) + b1) {
                    x1 -= x;
                }
            }
//                y1 += y;
//                x1 = 704;
//            } else if (y1 < 30) {
//                level = 2;
//                x1 = 760;
//                y1 = 540;
//                mouse.xm = 760;
//                mouse.ym = 540;
//            }
                //else{

            }
            x1 += x;
            y1 += y;
        }

        public int[] getXY() {
            int[] ans = new int[2];
            ans[0] = x1;
            ans[1] = y1;
            return ans;
        }
    }
