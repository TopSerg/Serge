package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Level {
    Image background;
    Image frontground;
    Image dick = new ImageIcon("kebok.png").getImage();
    JFrame frame;
    Item [] items = new Item[5];
    Chel[] chels = new Chel[5];
    Crovat[] crovats = new Crovat[5];
    Bakpack bakpack;
    Player player;
    Mouse mouse;

    double[][] stena;
    int[][] mas, masas;
    double[][] next;
    int level;
    public static int nlvl = 1;
    boolean a = true;
    static boolean nextlvl = false;

    public Level(String sback, String sfront, JFrame f, Bakpack b, int lvl, Player player, Mouse mouse, double[][] stena, double[][] next){
        this.stena = stena;
        this.next = next;
        mas = new int[stena.length][stena[0].length];
        masas = new int[next.length][next[0].length];
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
    public void pluscrovat(Crovat crovat){
        for (int i = 0; i < 5; i++){
            if (crovats[i] == null && a){
                crovats[i] = crovat;
                break;
            }
        }

    }

    public void pluschel(Chel chel){
        for (int i = 0; i < 5; i++){
            if (chels[i] == null && a){
                chels[i] = chel;
                break;
            }
        }

    }

    public void script(){

    }

    public int getNext(){
        for (int i = 0 ; i < 5; i++){
            if (chels[i] != null) {
                if (chels[i].begin()) {
                    return chels[i].getRetur();
                }
            }
        }
        return 0;
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
            if (chels[i] != null){
                chels[i].paint(g);
            }
            if (crovats[i] != null){
                crovats[i].paint(g);
            }
        }
        int mx = mouse.getx(1), my = mouse.gety(1), x = player.x, y = player.y,  b1, b2, xp, yp, nx = 0, ny = 0, dx = 0, dy = 0;
        nx = mx;
        ny = my;
        for (int i = 0; i < mas.length;i++){
            for (int j = 0; j < mas[i].length;j++){
                if (j == 0 || j == 1){
                    mas[i][j] = (int)(stena[i][j]*frame.getWidth());
                }
                else{
                    mas[i][j] = (int)(stena[i][j]*frame.getHeight());
                }
            }
        }
        for (int i = 0; i < masas.length;i++){
            for (int j = 0; j < masas[i].length;j++){
                if (j == 0 || j == 2 || j == 5){
                    masas[i][j] = (int)(next[i][j]*frame.getWidth());
                }
                else if (j == 1 || j == 3 || j == 6){
                    masas[i][j] = (int)(next[i][j]*frame.getHeight());
                }
                else{
                    masas[i][j] = (int) next[i][j];
                }
            }
            if(player.isNext(masas[i])){
                nextlvl = true;
                nlvl = masas[i][4];
                player.setXY(masas[i][5], masas[i][6]);
            }
            g.setColor(new Color(209, 0, 255, 149));
            g.fillRect(masas[i][0], masas[i][1], masas[i][2]-masas[i][0],masas[i][3]-masas[i][1]);
            g.setColor(new Color(255, 0, 0));
        }
        player.move(nx, ny, mas);
        player.paint(g);
        paintf(g);
        if(level == 3){
            if (mouse.getx(3) > frame.getWidth()*1162.0/1920 && mouse.getx(3) < frame.getWidth()*1226.0/1920 && mouse.gety(3) > frame.getHeight()*134.0/1080 && mouse.gety(3) < frame.getHeight()*203.0/1080){
                for (int i = 0; i < 100; i++){
                    g.drawImage(dick,0,0,frame.getWidth(), frame.getHeight(), null);
                }
            }
            //1920 1080
        }
    }

    public void paintf(Graphics g){
        for (int i = 0; i < mas.length; i++){
            g.drawLine(mas[i][0], mas[i][2], mas[i][1], mas[i][3]);
        }
        if (frontground != null){
            g.drawImage(frontground, 0, 0, frame.getWidth(), frame.getHeight(), null);
        }
    }

    public static int Nextlvl(){
        return nlvl;
    }

    public int getLevel(){
        return level;
    }

}
