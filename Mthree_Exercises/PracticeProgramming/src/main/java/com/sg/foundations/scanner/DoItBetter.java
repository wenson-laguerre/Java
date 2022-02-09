package com.sg.foundations.scanner;

import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many miles can you run ?");
        int userAnswer= input.nextInt();

        System.out.print("Hhahahaha I can run "+((userAnswer*2)+1)+" miles");

        System.out.print("\nHow many hotdogs can you eat ?");
        userAnswer= input.nextInt();

        System.out.print("Hhahahaha I can eat "+((userAnswer*2)+1)+" hotdogs");

        System.out.print("\nHow many languages can you speak ?");
         userAnswer= input.nextInt();

        System.out.print("Hhahahaha I can speak "+((userAnswer*2)+1)+" languages");

    }
}
