package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        char[] mas = n.toCharArray();
        System.out.println((int)mas[0]);
        for (int i = mas[0]; i < mas[0]+mas[1]-48;i++){
            System.out.print((char)i);
        }
    }
}
