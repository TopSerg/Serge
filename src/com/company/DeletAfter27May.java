package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeletAfter27May {

    int x,y,wight,high, iterator = 0;
    boolean talk = false;
    boolean a = true, b = false, asdf = false, asdf1 = false;
    File file;
    Image image, baba, deda;
    Player player;
    JFrame frame;
    Mouse mouse;
    String sosiska = "";
    String vivod = "";
    Scanner sc = null;

    public DeletAfter27May(int x,int y,int wight,int high,String txt, String img, Player player, String img2, String img3, JFrame frame, Mouse mouse){
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.high = high;
        this.player = player;
        this.frame = frame;
        this.mouse = mouse;
        image = new ImageIcon(img).getImage();
        baba = new ImageIcon(img2).getImage();
        deda = new ImageIcon(img3).getImage();
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
        if (a) {
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("ПАШЕЛ НАХУЙ");
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
        int q = 0, w =0, r = 0;
        boolean z = mouse.isClik(1);
        if (z){
            b = true;
        }
        //while (!a){
        if (!a) {
            if (b) {
                System.out.println("kslrgseuhguhsepruighsepr");
                try {
                    //if (sc.hasNext()){
                    sosiska = sc.next();
                    //}
                } catch (NoSuchElementException e) {
                    System.out.println("SOSI");
                } catch (NullPointerException e) {
                    System.out.println("TRASI");
                }
                System.out.println(sosiska);
            }

//            r++;
            if (sosiska.equals("/1/")) {
                asdf = true;
                asdf1 = false;
//                g.drawImage(baba, 0, 0, frame.getWidth(), frame.getHeight(), null);
//                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
                vivod = "";
                b = false;
            } else if (sosiska.equals("/2/")) {
                asdf1 = true;
                asdf = false;
//                g.drawImage(deda, 0, 0, frame.getWidth(), frame.getHeight(), null);
//                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
//                g.drawString(vivod, 100, 100);
                //System.out.println(vivod);
                vivod = "";
                b = false;
            } else {
                if (q + sosiska.length() > 29) {
                    q = 0;
                    g.drawString(vivod, x + 2, y + 15 + 15 * (w));
                    w++;
                    vivod = "";
                }
                vivod += sosiska + " ";
                q++;
                q += sosiska.length();
            }
            if (asdf){
                g.drawImage(baba, 0, 0, frame.getWidth(), frame.getHeight(), null);
                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
            }
            else if(asdf1){
                g.drawImage(deda, 0, 0, frame.getWidth(), frame.getHeight(), null);
                g.drawString(vivod, x + 2, y + 15 + 15 * (w));
                g.drawString(vivod, 100, 100);
            }
            System.out.println(z + " " + sosiska);
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
        if (sosiska.equals("нахуй")) {
            a = true;
        }
        else {
            a = false;
        }
        g.drawString(vivod, 100, 100);
        //System.out.println(vivod);
        if (a) {
            g.drawString(vivod, 100, 100);
            sc.close();
        }
    }
}
