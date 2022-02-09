package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("How many units of fizzing and buzzing do you need in your life? ");
        int units = input.nextInt();
        int tradition= 0;
        for(int i =0;i<100;i++)
        {
            if((i % 3 == 0) &&( i % 5==0)){
                System.out.println("fizz buzz");
                tradition++;
            }else if(i % 5 == 0){
                System.out.println("buzz");
                tradition++;
            }else if (i%3 == 0){
                System.out.println("fizz");
                tradition++;
            }else if(tradition ==units){
                System.out.println("TRADITION!!!!!");
                break;
            }else {
                System.out.println(i);
            }
        }




    }
}
