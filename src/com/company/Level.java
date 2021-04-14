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

    double[][] stena;
    int[][] mas;
    int level;
    boolean a = true;

    public Level(String sback, String sfront, JFrame f, Bakpack b, int lvl, Player player, Mouse mouse, double[][] stena){
        this.stena = stena;
        mas = new int[stena.length][stena[0].length];
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
        int mx = mouse.getx(1), my = mouse.gety(1), x = player.x, y = player.y,  b1, b2, xp, yp, nx = 0, ny = 0, dx = 0, dy = 0;
        nx = mx;
        ny = my;
        for (int i = 0; i < mas.length;i++){
            for (int j = 0; j < mas.length;j++){
                if (j == 0 || j == 1){
                    mas[i][j] = (int)(stena[i][j]*frame.getWidth());
                }
                else{
                    mas[i][j] = (int)(stena[i][j]*frame.getHeight());
                }
            }
        }
        player.move(nx, ny, mas);
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
