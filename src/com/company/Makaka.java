package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Makaka {

    //Основной запускаемый класс программы
    public static void main(String[] args) {
        //создание объекта класса JFrame, являющегося рамкой нашего изображения
        JFrame frame = new JFrame("JustGame");
        //создание объекта класса Mouse, являющегося слушателем нажатий мышки
        Mouse m = new Mouse();
        //создание объекта класса Mouse1, являющегося слушателем движений мышки
        Mouse1 m1 = new Mouse1();
        //задание выхода из приложения по нажатию х
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //растягивание рамки на весь экран
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //убираем декорации
        frame.setUndecorated(true);
        //добавляем слушанье мышки в рамку
        frame.addMouseListener(m);
        //добавляем слушанье мышки в рамку
        frame.addMouseMotionListener(m1);
        //создание объекта класса Display, являющегося наполнением рамки
        Display v = new Display(frame,m,m1);
        //наполняем рамку
        frame.add(v);
        //делаем все это видимым
        frame.setVisible(true);
    }

}