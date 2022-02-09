package com.sg.foundations.flowcontrol.whiles;

public class WaitAWhile {
    public static void main(String[] args) {
        int timeNow = 11;
        int bedTime = 10;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}
/*What happens if you change bedTime's value to 11?  Code run's one more time since u extended the bedtime
What about using bedTime's original value, but changing timeNow to 11? code runs once since you passed the bedtime to begin with
If you comment out timeNow++ at the end of the loop, what happens?infinite loop since current time never changes you never leave the loop
* */