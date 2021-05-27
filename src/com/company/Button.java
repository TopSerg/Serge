package com.company;

import javax.swing.*;
import java.awt.*;
//малоиспользуемый класс кнопки
public class Button {
    //задание необходимых переменных
    int x, y, hight, width;
    boolean clik = false;
    Image image;
    Mouse mouse;

    //конструктор
    public Button(int x,int y,int hight,int width, String str, Mouse mouse){
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.width = width;
        this.mouse = mouse;
        image = new ImageIcon(str).getImage();
    }

    //метод нажатия на кнопку
    public void Clicked(){
        if (mouse.getx(1) > x && mouse.getx(1) < x+width && mouse.gety(1) > y && mouse.gety(1) < y+hight){
            clik = true;
        }
        else{
            clik = false;
        }
    }

    //метод отрисовки
    public void paint(Graphics g){
        Clicked();
        g.drawImage(image, x, y, width, hight, null);
    }

    //переход на другой уровень
    public boolean Restart(){
        if (clik){
            return true;
        }
        else{
            return false;
        }
    }
}
