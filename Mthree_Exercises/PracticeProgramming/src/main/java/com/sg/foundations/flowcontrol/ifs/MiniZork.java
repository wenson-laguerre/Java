package com.sg.foundations.flowcontrol.ifs;
import java.util.*;
public class MiniZork {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("You feel something soft");
                System.out.println("it hairy and sticky but can't figure out what it is...");
                System.out.print("Do you pull it out or you give up because things are getting creepy ?");
                action = userInput.nextLine();
                if(action.equals("pull it out")){
                    System.out.println("AHHHHHHHHHHHHHH !!!!!!!");
                    System.out.println("You pulled  a possessed rat and now you are Possessed!");

                }else if(action.equals("give up ")){
                    System.out.println("You made the right call you had no business touching someone else's property never know what could have happen");

                }
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You hear strange deranged laughs from upstairs");
            System.out.print("Do you walk towards the stairs or you leave the house?");
            action = userInput.nextLine();
            if(action.equals("walk towards the stairs")){
                System.out.println("That was the last time anyone ever heard from you ");
            }else if(action.equals("leave the house")){
                System.out.println("You know its a bad idea smart move make your way home");

            }
        }
    }
}
