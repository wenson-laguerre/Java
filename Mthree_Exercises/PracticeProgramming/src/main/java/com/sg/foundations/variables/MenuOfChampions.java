package com.sg.foundations.variables;

public class MenuOfChampions {
    public static void main(String[] args) {
        String  deco= ".oOo",
                Welcome="WELCOME TO RESTAURANT NIGHT VALE!",
                Today ="Today's Menu Is...",
                item1=" *** Slice of Big Rico Pizza",
                item2=" ***** Invisible Strawberry Pie",
                item3=" ***** Denver Omelet";
        double  pizza = 500.00,
                pie = 2.00,
                omelet =1.50;

        String MenuOfChamps=deco.repeat(15)+".\n\n\t\t\t"+
                            Welcome+"\n\t\t\t"+
                            Today+"\n\n"+
                            deco.repeat(15)+"\n\n\t\t\t\t"+
                            "$ "+String.format("%.2f",pizza)+item1+"\n\t\t\t\t"+
                            "$ "+String.format("%.2f",pie)+item2+"\n\t\t\t\t"+
                            "$ "+String.format("%.2f",omelet)+item3;                                                ;

        System.out.print(MenuOfChamps);

    }
}
