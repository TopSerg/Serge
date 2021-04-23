package com.company;

import javax.swing.*;
import java.awt.*;

public class Player {

    int x, y, high, width;
    Image player, playerl;
    Move move;

    public Player(String s, String s2, int x, int y, int high, int width, Move move){
        player = new ImageIcon(s).getImage();
        playerl = new ImageIcon(s2).getImage();
        this.x = x;
        this.y = y;
        this.high = high;
        this.width = width;
        this.move = move;
    }

    public void paint(Graphics g){
        int[] a;
        if (move.getDx() > 0) {
            g.drawImage(player, x, y, width, high, null);
        }
        else{
            g.drawImage(playerl, x, y, width, high, null);
        }
//        System.out.println(x + " " + y);
        a = move.getXY();
        x = a[0];
        y = a[1];
    }

    public boolean isNext(int[] mas){
        return move.isNext(mas);
    }

    public void move (int dx, int dy, int mas[][]){
        move.moves(this, mas, dx, dy);
    }

    public void setXY(int x, int y){
//        this.x = x;
//        this.y = y;
        move.setXY(x,y);
    }

}
