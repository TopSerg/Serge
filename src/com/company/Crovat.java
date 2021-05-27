package com.company;

import javax.swing.*;
import java.awt.*;

//класс предмета, с которым можно взаимодействовать
public class Crovat {

    //задание необходимых переменных
    Image img1, img2;
    int x,y,height,width;
    double xq,yq,widthq, heightq;
    boolean comleted = false;
    String needItem;
    Mouse mouse;
    JFrame frame;

    //конструктор
    public Crovat(String str1, String str2, String needItem, double x, double y, double width, double height, Mouse mouse, JFrame frame){
        img1 = new ImageIcon(str1).getImage();
        img2 = new ImageIcon(str2).getImage();
        this.frame = frame;
        this.xq = x;
        this.yq = y;
        this.widthq = width;
        this.heightq = height;
        this.needItem = needItem;
        this.mouse = mouse;
    }

    //отрисовка
    public void paint(Graphics g){
        x = (int) (xq*frame.getWidth());
        y = (int) (yq*frame.getHeight());
        width = (int) (widthq*frame.getWidth());
        height = (int) (heightq*frame.getHeight());
        if (!comleted){
            g.drawImage(img1, x,y,width,height,null);
        }
        else{
            g.drawImage(img2, x,y,width,height,null);
        }
        Complet();
    }

    //проверка выполнено ли условие данного предмета
    public void Complet(){
        if (mouse.getx(3) > x && mouse.gety(3) > y && mouse.getx(3) < x+width && mouse.gety(3) < y+height && mouse.HasItem()){
            if (mouse.getItem().getName().equals(needItem)){
                comleted = true;
                mouse.Delete();
            }
        }
    }
}
