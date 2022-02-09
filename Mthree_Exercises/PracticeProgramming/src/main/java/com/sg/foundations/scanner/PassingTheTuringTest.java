package com.sg.foundations.scanner;

import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Hello There!\nWhat's your name?");
        String name = input.next();

        System.out.print("\nHi, "+name+"! I'm Alice.\nWhat's your favorite color?");
        String favColor =input.next();

        System.out.print("\nHuh, "+favColor+"? Mine's Electric Lime.\n\n" +
                           "I really like limes. They're favourite fruit, too.\n" +
                           "What's YOUR favorite, "+name+"? ");
        String favFruit = input.next();

        System.out.print("\nReally? "+favFruit+"? That's wild! \n" +
                            "Speaking of favorites, what's your favorite number? ");
        int favNum = input.nextInt();

        System.out.print("\n"+favNum+" is a cool number. Mine's -7. \n" +
                            "Did you know "+favNum+" * -7 is "+(favNum * -7 )+"? " +
                            "That's a cool number too!\n\n" +
                "Well, thanks for talking to me, "+name);

    }
}
