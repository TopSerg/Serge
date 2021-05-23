package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DeletAfter27May {

    int x,y,wight,high;
    boolean talk = false;
    String txt, img;
    File file;
    Image image;
    Player player;

    public DeletAfter27May(int x,int y,int wight,int high,String txt, String img, Player player){
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
        this.player = player;
        file = new File(txt);
        image = new ImageIcon(img).getImage();
    }

    public void paint(Graphics g){
        g.drawImage(image,x,y,wight,high,null);
        if (player.Go(x,y,wight,high)){
            talk = true;
        }
    }
}
