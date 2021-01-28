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

    public void paintb(Graphics g, int x1,int y1, int x, int y){
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
        player.move(mouse.getx(), mouse.gety());
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
