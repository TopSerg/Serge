package com.company.vzlomzopy;

import com.company.Mouse;

import javax.swing.*;
import java.awt.*;

public class Buttonvz {
    int x, y, hight, width, number;
    char puck;
    int q = 0;
    boolean clik = false, isopen = false, flagok = false;
    Image image, image1, image2;
    Mouse mouse;

    public Buttonvz(int x,int y,int hight,int width, String str1, String str2, String str3, Mouse mouse){
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.width = width;
        this.mouse = mouse;
        number = (int) (str3.toCharArray()[0])-48;
        puck = str3.toCharArray()[0];
        //System.out.println(str3.toCharArray()[0]);
        image = new ImageIcon(str1).getImage();
        image1 = new ImageIcon(str2).getImage();
        image2 = new ImageIcon(str3).getImage();
    }

    public void Clicked(){
        if (mouse.getx(3) > x && mouse.getx(3) < x+width && mouse.gety(3) > y && mouse.gety(3) < y+hight){
            if (mouse.getBut() == 3){
                flagok = true;
            }
            clik = true;
        }
        else{
            clik = false;
        }
    }

    public void paint(Graphics g){
        Clicked();
        Pukpiska();
        if (!isopen){
            g.drawImage(image1, x, y, width, hight, null);
        }
        else{
            if (flagok){
                g.drawImage(image, x, y, width, hight, null);
            }
            else{
                if (q < 5){
                    g.drawImage(image, x, y, width, hight, null);
                    //q+=5;
                    //System.out.println(q);
                    q++;
                }
                else{
                    g.drawImage(image2, x, y, width, hight, null);
                }
            }

            //g.drawImage(image, x, y, width, hight, null);
        }
    }

    public void Pukpiska(){
        if (clik){
            isopen = true;
        }
    }

    public char getNumber(){
        //System.out.println(number);
        return puck;
    }


    public boolean IsOpen(){
        return isopen;
    }
}
