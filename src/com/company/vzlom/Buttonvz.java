package com.company.vzlom;

import com.company.Mouse;

import javax.swing.*;
import java.awt.*;
//класс кнопки для сапера
public class Buttonvz {
    //задание необходимых переменных
    int x, y, hight, width, number;
    char pur;
    int q = 0;
    boolean clik = false, isopen = false, flagok = false;
    Image image, image1, image2;
    Mouse mouse;

    //конструктор класса
    public Buttonvz(int x,int y,int hight,int width, String str1, String str2, String str3, Mouse mouse){
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.width = width;
        this.mouse = mouse;
        number = (int) (str3.toCharArray()[0])-48;
        pur = str3.toCharArray()[0];
        image = new ImageIcon(str1).getImage();
        image1 = new ImageIcon(str2).getImage();
        image2 = new ImageIcon(str3).getImage();
    }

    //метод отработки нажатия на кнопку
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

    //метод отрисовки
    public void paint(Graphics g){
        Clicked();
        Puf();
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
                    q++;
                }
                else{
                    g.drawImage(image2, x, y, width, hight, null);
                }
            }
        }
    }

    //открытие клетки
    public void Puf(){
        if (clik){
            isopen = true;
        }
    }

    //возвращает номер клетки
    public char getNumber(){
        return pur;
    }

    //возвращает открыта ли клетка
    public boolean IsOpen(){
        return isopen;
    }
}
