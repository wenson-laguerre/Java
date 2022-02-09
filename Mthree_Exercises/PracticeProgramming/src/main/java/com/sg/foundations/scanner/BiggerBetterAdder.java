package com.sg.foundations.scanner;

import java.util.Scanner;

public class BiggerBetterAdder {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int     x,
                y,
                z;
       System.out.println( "What is value 1: ");
       x = input.nextInt();

        System.out.println( "What is value 2: ");
        y  = input.nextInt();

        System.out.println( "What is value 3: ");
        z = input.nextInt();

        int sum = x+y+z;

        System.out.println("x + y + z = sum: \n"+x+" + "+y+" + "+z+" = "+ sum);

    }
}
