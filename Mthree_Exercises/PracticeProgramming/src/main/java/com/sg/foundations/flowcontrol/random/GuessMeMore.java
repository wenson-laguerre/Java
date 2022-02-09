package com.sg.foundations.flowcontrol.random;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessMeMore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!" +
                "\nYour guess: ");
        int guess = input.nextInt();
        int randomValue= ThreadLocalRandom.current().nextInt(-100,100);

        if(guess == randomValue){
            System.out.println("Wow, nice guess! That was it!");
        }else{
            System.out.println("Ha, nice try -! Try again!\n" +
                    "My guess:"+randomValue);
        }
    }
}
