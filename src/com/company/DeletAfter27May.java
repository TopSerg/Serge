package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeletAfter27May {

    int x,y,wight,high, iterator = 0;
    boolean talk = false;
    File file;
    Image image;
    Player player;

    public DeletAfter27May(int x,int y,int wight,int high,String txt, String img, Player player){
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
        this.player = player;
        image = new ImageIcon(img).getImage();
        file = new File(txt);
//        try{
//            file = new File(txt);
//            sc = new Scanner(file);
//        }catch (FileNotFoundException e){
//            System.out.println("ПАШЕЛ НАХУЙ");
//        }
    }

    public void paint(Graphics g){
        g.drawImage(image,x,y,wight,high,null);
        if (player.Go(x,y,wight,high)){
            talk = true;
        }
        if (talk){
            animation(g);
            iterator++;
        }
        if (iterator == 100){
            talk = false;
            iterator = 0;
        }
//        while (sc.hasNext()){
//            System.out.println(sc.next());
//        }
    }

    public void animation(Graphics g){
        Scanner sc = null;
        try{
            sc = new Scanner(file);
        }catch (FileNotFoundException e){
            System.out.println("ПАШЕЛ НАХУЙ");
        }
        int x = this.x - 300,y = this.y - 300,wight = 300,high = 300;
        g.setColor(new Color(255,255,255));
        g.fillRect(x,y,wight,high);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Century", Font.PLAIN, 20));
//        if (sc.hasNext()) {
//            g.drawString(sc.nextLine(), x, y+30);
//        }
        int q = 0, w = 0;
        String sosiska = "";
        while (sc.hasNext()){
            sosiska = sc.next();
            g.drawString(sosiska,x+10*q,y + 10*w);
            q++;
            q += sosiska.length();
            System.out.println(q);
            if (q > 30){
                w++;
                q = 0;
            }
            //System.out.println(sc.next());
        }
        sc.close();
    }
}
