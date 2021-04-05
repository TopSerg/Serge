package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



/*class mMouse1 extends Frame implements MouseMotionListener{
    int xm1 = 0, ym1 = 0;
    public mMouse1(){

    }
    public void mouseDragged (MouseEvent e){
        xm1 = e.getX();
        ym1 = e.getY();
    }
    public void mouseMoved (MouseEvent e){
        xm1 = e.getX();
        ym1 = e.getY();
    }
    public int getx1(){
        return xm1;
    }
    public int gety1(){
        return ym1;
    }
}


class mMouse extends Frame implements MouseListener{

    boolean clik;
    int xm = 100, ym = 550;

    public mMouse(){
        clik = false;
    }
    public void mousePressed(MouseEvent e)
    {
        //System.out.println("mouse pressed");
        this.xm = e.getX();
        this.ym = e.getY();
        //System.out.println(xm + " " + ym);
    }
    public void mouseReleased(MouseEvent e)
    {
        //System.out.println("mouse Released");
    }
    public void mouseClicked(MouseEvent e)
    {
        //System.out.println("mouse Clicked");
    }
    public void mouseExited(MouseEvent e)
    {
        //System.out.println("mouse Exited");
    }
    public void mouseEntered(MouseEvent e)
    {
        //System.out.println("mouse Entered");
    }
    public int getx(){
        return xm;
    }
    public int gety(){
        return ym;
    }
}



 class Display1 extends JPanel implements ActionListener{

    Image fon = new ImageIcon("C:\\Users\\Serge\\Pictures\\fon.png").getImage();
    Image bigdick = new ImageIcon("C:\\Users\\Serge\\Pictures\\gnom.png").getImage();

    Timer timer = new Timer(20, this);

    JFrame frame;
    int xm = 0, ym = 0, xd, yd, i =0;
    int y1 = 550, ym1 = 0;
    int x1 = 100, xm1 = 0;
    boolean find = false;
    mMouse1 mouse1;
    mMouse mouse;
    String str = "";


    public Display1(JFrame frame, mMouse mouse, mMouse1 mouse1) {
        this.mouse1 = mouse1;
        this.mouse = mouse;
        xd = (int)(Math.random()*1300);
        yd = (int)(Math.random()*650);
        this.frame = frame;
        timer.start();
    }

    //Поиск пасхалки
    public boolean find(int x, int y, int xd, int yd){
        if (x > xd && x < xd+100 && y > yd && yd < yd+100){
            return true;
        }
        return false;
    }

     //Пасхалка
     public void bigdick(Graphics g){
         if (find){
             g.drawImage(bigdick, xd, yd, 100, 100, null);
             i++;
             if (i == 20){
                 find = false;
                 i = 0;
                 xd = (int)(Math.random()*1300);
                 yd = (int)(Math.random()*730);
             }
         }
     }


    // Метод отрисовки
    public void paint(Graphics g) {
        g.drawImage(fon, 0, 0, frame.getWidth(), frame.getHeight(), null);
        g.drawString(str,frame.getWidth()-200,10);
        bigdick(g);
    }

    // Метод таймера
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        str = (xm1-xd) + " " + (ym1-yd);
        find = find(xm, ym, xd, yd);
        xm = mouse.getx();
        ym = mouse.gety();
        xm1 = mouse1.getx1();
        ym1 = mouse1.gety1();
        repaint();
    }

}*/

public class Makaka {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JustGame");
        Mouse m = new Mouse();
        Mouse1 m1 = new Mouse1();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.addMouseListener(m);
        frame.addMouseMotionListener(m1);
        Display v = new Display(frame,m,m1);
        frame.add(v);
        frame.setVisible(true);
    }

}