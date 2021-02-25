package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Level {
    Image background;
    Image frontground;
    JFrame frame;
    Item [] items = new Item[5];
    Bakpack bakpack;
    Player player;
    Mouse mouse;

    int[][] stena;
    int level;
    boolean a = true;

    public Level(String sback, String sfront, JFrame f, Bakpack b, int lvl, Player player, Mouse mouse, int[][] stena){
        this.stena = stena;
        this.mouse = mouse;
        level = lvl;
        frame = f;
        background = new ImageIcon(sback).getImage();
        if (sfront != "no"){
            frontground = new ImageIcon(sfront).getImage();
        }
        else{
            frontground = null;
        }
        bakpack = b;
        this.player = player;
    }

    public void plusitem(Item item){
        for (int i = 0; i < 5; i++){
            if (items[i] == null && a){
                items[i] = item;
                break;
            }
        }

    }

    public void script(){

    }

    public void paintb(Graphics g, int x1,int y1){
        g.drawImage(background, 0, 0, frame.getWidth(), frame.getHeight(), null);
        for (int i = 0; i < 5; i++){
            if (items[i] != null) {
                items[i].paint(g);
                items[i].find(x1, y1);
                if (items[i].getfind()) {
                    bakpack.plus(items[i]);
                    items[i] = null;
                }
            }
        }
        //g.drawImage(player.getPlayer(), x, y, player.getHigh(), player.getWidth(), null);
        int mx = mouse.getx(1), my = mouse.gety(1), x = player.x, y = player.y,  b1, b2, xp, yp, nx = 0, ny = 0, dx, dy;
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
                b2 = my-(int)(k2*(mx-stena[i][2]));
                xp = (int)((b2-b1)/(k1-k2));
                g.drawLine(stena[i][0], b2, stena[i][1], (int)(b2+stena[i][1]*k2));
                yp = (int)(k1*xp) + b1;
                if ((mx-xp)*(x-xp) < 0){
                    dx = (int)((k1*Math.abs(my - mx*k1- b1))/Math.sqrt(1+k1*k1));
                    dy = (int)(-dx/k1);
                    nx = mx+dx;
                    ny = dy+my;
                    a = true;
                }
                else{
                    nx = mx;
                    ny = my;
                    a = true;
                }
                System.out.println(k1 + " " + k2 + " " + i + " " +b1 + " " + b2);
            }
            if (!a){
                nx = mx;
                ny = my;
                a = true;
            }
            //System.out.println(i);
        }
        //if (a){
        player.move(nx, ny);
        //System.out.println(nx + " " + ny);
        //}
        player.paint(g);
        paintf(g);
    }

    public void paintf(Graphics g){
        if (frontground != null){
            g.drawImage(frontground, 0, 0, frame.getWidth(), frame.getHeight(), null);
        }
    }

    public int getLevel(){
        return level;
    }

}
