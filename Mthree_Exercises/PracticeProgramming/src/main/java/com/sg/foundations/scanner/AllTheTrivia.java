package com.sg.foundations.scanner;
import java.util.*;


public class AllTheTrivia {
    public static void main(String[] args) {
        List<String>Answers= new ArrayList<>();
       //String []  Answers = new String[4];
        Scanner input = new Scanner(System.in);

        System.out.print("What unit is equivalent to 1,024 Gigabytes?");
        Answers.add(input.next());

        System.out.print("Which planet is the only one that rotates clockwise in our Solar System?");
        Answers.add(input.next());

        System.out.print("The largest volcano ever discovered in our Solar System is located on which planet?");
        Answers.add(input.next());

        System.out.print("What is the most abundant element in the earth's atmosphere?");
        Answers.add(input.next());



        System.out.println("****************************************************************");
        System.out.println("Initial order:");
        int count=1;
        for(String i:Answers){

            System.out.print(count+": "+i+" ");
            count++;
        }
        Collections.shuffle(Answers);// values are mix at random
        System.out.println("\nAfter Shuffle order:");
        count=1;
        for(String i:Answers){

            System.out.print(count+": "+i+" ");
            count++;
        }
        System.out.println("\nWow, 1,024 Gigabytes is a "+Answers.get(0)+"!");
        System.out.println("I didn't know that the largest ever volcano was discovered on "+Answers.get(1)+"!");
        System.out.println("That's amazing that "+Answers.get(2)+" is the most abundant element in the atmosphere...");
        System.out.println(Answers.get(3) +" is the only planet that rotates clockwise, neat!");

    }
}
