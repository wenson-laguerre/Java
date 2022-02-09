package com.sg.foundations.flowcontrol.random;
import java.util.Random;
public class ALittleChaos {
    public static void main(String[] args) {

        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(100);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");

        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));
        System.out.println("**********************************************************************");
        System.out.println("randomizer.Next(101) to randomizer.Next(51) + 50 :");
        System.out.print((randomizer.nextInt(51)+50) + ", ");//73
        System.out.print((randomizer.nextInt(51)+50) + ", ");//53
        System.out.print((randomizer.nextInt(51)+50) + ", ");//90
        System.out.print((randomizer.nextInt(51)+50)+ ", ");//75
        System.out.print((randomizer.nextInt(51)+50) + ", ");//63
        System.out.println((randomizer.nextInt(51)+50));//74
        int x =5;
        System.out.println(randomizer.nextInt(51)*x);//100
        double y =9;
        System.out.println(randomizer.nextInt(51)*7);//259
/*        - What happens if you change randomizer.Next(101) to randomizer.Next(51) + 50? (Answer in a comment.)
            ANSWER: What end happen is you shorten the rang of  the random number
                    from 0-100 to 50-100. Because every time you get a number it will
                    have a +50 making 50 the smallest value possible at output
          - Can you include random numbers in a math statement? (Answer in a comment.)
            ANSWER: Yes an instance of a random value can be used
 */

    }
}
