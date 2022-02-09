package com.sg.foundations.scanner;

import java.util.*;

public class MiniMadLibs {
    public static void main(String[] args) {
        List<String>madLibs = new ArrayList<>();
        Scanner input = new Scanner(System.in);

   System.out.println("Let's play MAD LIBS!\n");

        System.out.println("I need a noun:");
        madLibs.add(input.next());

        System.out.println("Now an adjective: ");
        madLibs.add(input.next());

        System.out.println("Another noun: ");
        madLibs.add(input.next());

        System.out.println("And a number: ");
        madLibs.add(input.next());

        System.out.println("Another adjective: ");
        madLibs.add(input.next());

        System.out.println("A plural noun: ");
        madLibs.add(input.next());

        System.out.println("Another one: ");
        madLibs.add(input.next());

        System.out.println("One more: ");
        madLibs.add(input.next());

        System.out.println("A verb (infinitive form): ");
        madLibs.add(input.next());

        System.out.println("Same verb (past participle): ");
        madLibs.add(input.next());

        System.out.println("*** NOW LETS GET MAD (libs) ***");
        System.out.println(
                          madLibs.get(0)+": the "+ madLibs.get(1)+" frontier. These are the voyages of the starship "
                        + madLibs.get(2)+". Its "+ madLibs.get(3)+"-year mission: to explore strange "+ madLibs.get(4)+" "+ madLibs.get(5)+
                ", to seek out "+ madLibs.get(5)+" "+ madLibs.get(6)+" and "+ madLibs.get(4)+" "+ madLibs.get(7)+", to boldly "+ madLibs.get(8)+" where no one has "+ madLibs.get(9)+" before.\n");


    }
}
