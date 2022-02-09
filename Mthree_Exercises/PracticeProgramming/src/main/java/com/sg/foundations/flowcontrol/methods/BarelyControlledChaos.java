package com.sg.foundations.flowcontrol.methods;

import java.util.Random;

public class BarelyControlledChaos {
    public static Random rand= new Random();
    public static void main(String[] args) {

        String color = colors(); // call color method here
        String animal = animals(); // call animal method again here
        String colorAgain = colors(); // call color method again here
        int weight = ranNumber(5,200); // call number method,
        // with a range between 5 - 200
        int  distance =ranNumber(10,20); // call number method,
        // with a range between 10 - 20
        int number = ranNumber(1000,2000); // call number method,
        // with a range between 10000 - 20000
        int time = ranNumber(2,6); // call number method,
        // with a range between 2 - 6

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + " lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    public static String colors(){
        int choix = rand.nextInt(5);
        String []arrColors= {"Red","Blue","White","Grey","Green"};
        String randomColor= arrColors[choix];
        return randomColor;
    }
    public static String animals(){
        int choix = rand.nextInt(5);
        String []arrAnimal= {"dog","cat","hamster","snake","gorilla"};
        String randomAnimal= arrAnimal[choix];
        return randomAnimal;
    }

    public static int ranNumber(int min,int max){
        return rand.nextInt((max-min)+1)+min;
    }


}



