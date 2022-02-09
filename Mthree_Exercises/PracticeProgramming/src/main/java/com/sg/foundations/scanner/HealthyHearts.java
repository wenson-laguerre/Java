package com.sg.foundations.scanner;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
     System.out.println("What is your age?");
     int age = input.nextInt();

     double maxRate = 220-age;
     double minTarget= maxRate * 0.5;
     double maxTarget= maxRate * 0.85;

     System.out.println("Your maximum heart rate should be "+maxRate+" beats per minute.\n");
     System.out.println("Your target HR Zone is "+minTarget+" - "+maxTarget+" beats per minute.");


    }
}
