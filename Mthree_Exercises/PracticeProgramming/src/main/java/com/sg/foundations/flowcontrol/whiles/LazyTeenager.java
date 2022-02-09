package com.sg.foundations.flowcontrol.whiles;
import java.util.Random;
public class LazyTeenager {
    public static void main(String[] args) {
       int x= 1;
       int chance= 0;
       Random  rand = new Random();
        do {
            System.out.println("Clean your room!! " +" (x"+x+")");
            chance= rand.nextInt(10)+1;

            if(x==chance){
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if(x==7){
                System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
            x++;
        }while(x<8);
    }
}
