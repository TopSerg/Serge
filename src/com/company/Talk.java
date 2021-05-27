package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Talk {

    int x,y,wight,high, iterator = 0;
    int f = 0;
    int q = 0, w =0, r = 0;
    boolean talk = false;
    boolean a = true, b = false, asdf = true, asdf1 = false;
    File file;
    Image image, ba, de;
    Player player;
    JFrame frame;
    Mouse mouse;
    String ka = "";
    String vivod = "";
    Scanner sc = null;
    int lsgnserljgn = 0;

    public Talk(int x, int y, int wight, int high, String txt, String img, Player player, String img2, String img3, JFrame frame, Mouse mouse){
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
        this.player = player;
        this.frame = frame;
        this.mouse = mouse;
        image = new ImageIcon(img).getImage();
        ba = new ImageIcon(img2).getImage();
        de = new ImageIcon(img3).getImage();
        file = new File(txt);
//        try{
//            file = new File(txt);
//            sc = new Scanner(file);
//        }catch (FileNotFoundException e){
//            System.out.println("бе");
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
        System.out.println(vivod);
        if (a) {
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("Пппп");
            }
        }
        int x = 20,y = 900,wight = 1900,high = 100;
        g.setColor(new Color(255,255,255));
        g.fillRect(x,y,wight,high);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Century", Font.PLAIN, 20));
//        if (sc.hasNext()) {
//            g.drawString(sc.nextLine(), x, y+30);
//        }
        boolean z = mouse.isClik(1);
        if (z){
            b = true;
        }
        //while (!a){
        if (!a) {
            if (b) {
                if (f == 0){
                    vivod = "";
                    f++;
                }
                //System.out.println("kslrgseuhguhsepruighsepr");
                try {
                    //if (sc.hasNext()){
                    ka = sc.next();
                    //}
                } catch (NoSuchElementException e) {
                    System.out.println("S");
                } catch (NullPointerException e) {
                    System.out.println("T");
                }
                //System.out.println(sosiska);
            }

//            r++;
            if (ka.equals("/1/")) {
                asdf = true;
//                g.drawImage(baba, 0, 0, frame.getWidth(), frame.getHeight(), null);
//                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
                b = false;
                f = 0;
            } else if (ka.equals("/2/")) {
                asdf = false;
//                g.drawImage(deda, 0, 0, frame.getWidth(), frame.getHeight(), null);
//                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
//                g.drawString(vivod, 100, 100);
                //System.out.println(vivod);
                b = false;
                f = 0;
            }
            else if (ka.equals("/1")){
                asdf1 = true;
            }
            else if (ka.equals("/2")){
                asdf1 = true;
            }
                else {
                if (q + ka.length() > 52) {
                    q = 0;
                    g.drawString(vivod, x + 2, y + 26 + 26 * (w));
                    w++;
                    vivod = "";
                }
                vivod += ka + " ";
                q++;
                q += ka.length();
            }
            if (asdf){
                g.drawImage(ba, 0, 0, frame.getWidth(), frame.getHeight(), null);
//                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
            }
            else{
                g.drawImage(de, 0, 0, frame.getWidth(), frame.getHeight(), null);
//                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
//                g.drawString(vivod, 100, 100);
            }
            //System.out.println(z + " " + sosiska);
//            while (!z){
//                z = mouse.isClik(1);
//                if (z){
//                    System.out.println("s;lejrng;srgjns;krngsd;,fmgn;s,dmnrj;gsenrg;mfn;skjren");
//                }
////                System.out.println(!z);
//                long mil = 100000;
//                try {
//                    g.wait(mil);
//                }catch (InterruptedException e){
//                    System.out.println(6);
//                }catch (IllegalMonitorStateException e){
//                    int u = 0;
//                }
//            }
            //System.out.println(q);
            //System.out.println(sc.next());
        }
        if (ka.equals("иду")) {
            lsgnserljgn++;
            if (lsgnserljgn == 100) {
                a = true;
            }
        }
        else {
            a = false;
        }
        g.drawString(vivod, 60, 670);
        //System.out.println(vivod);
        if (a) {
            //g.drawString(vivod, 100, 100);
            sc.close();
        }
    }
}
