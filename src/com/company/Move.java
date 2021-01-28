package com.company;

import java.awt.*;

public class Move {
    int level = 1, x1 = 0, y1 = 0, dx, dy, divx, divy, speed;
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

    public void moves(Player player){
        player.x = x1;
        player.y = y1;
    }

    public void moves(Item item){
        item.x = x1;
        item.y = y1;
    }

    public void mov(int x, int y){
        switch (level){
            case (1):
                move1(x,y);
                break;
//            case (2):
//                move2(x,y);
//                break;
        }
    }

    public void div(int x, int y){
        dx = x - x1;
        dy = y - y1;
        if (dx != 0 && dy != 0){
            divx = dx;
            divy = dy;
        }
        if (divx != 0){
            mov(speed*divx/Math.abs(divx),0);

            if ((divx-speed*divx/Math.abs(divx))*divx/Math.abs(divx) < 0){
                divx = 0;
            }
            else {
                divx -= speed*divx/Math.abs(divx);
            }
        }
        if (divy != 0){
            mov(0,speed*divy/Math.abs(divy));
            if ((divy-speed*divy/Math.abs(divy))*divy/Math.abs(divy) < 0){
                divy = 0;
            }
            else {
                divy -= speed*divy/Math.abs(divy);
            }
        }
    }

    public void move1(int x, int y){
        if (y1 < 390 && (x1 < 333 || x1 > 745)){
            x1 += x;
            y1 = 390;
        }
        else if ((y1 < (-197*x1/65 + 89909/65)+40+y1/15*40/100)&&x1>330&&x1<457){
            x1 += x+40+y1/15*40/100;
            y1 = -197*x1/65 + 89909/65+y1/15+100;
        }
        else if (x1 > 705 && y1 < 380){
            y1 += y;
            x1 = 704;
        }
        else if (y1 < 30){
            level = 2;
            x1 = 760;
            y1 = 540;
            mouse.xm = 760;
            mouse.ym = 540;
        }
        else{
            x1 += x;
            y1 += y;
        }
    }

    public  int[] getXY(){
        int[] ans = new int[2];
        ans[0] = x1;
        ans[1] = y1;
        return ans;
    }
}
