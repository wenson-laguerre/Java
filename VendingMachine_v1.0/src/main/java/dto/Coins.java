package dto;

import java.math.BigDecimal;

public enum Coins {
    QUARTER(0.25),DIME(0.10),NICKEL(0.05),PENNY(0.01);

    private final double pre;
    private final BigDecimal value;
    Coins(double pre) {
        this.pre =pre;
        this.value=BigDecimal.valueOf(pre);

    }

    public double getPre() {
        return pre;
    }

    public BigDecimal getValue() {
        return value;
    }
    public String getName(Coins type){
        String coinToString="";
        switch (type){
            case QUARTER:
                coinToString= "Quarters";
                break;
            case DIME:
                coinToString= "Dimes";
                break;
            case NICKEL:
                coinToString="Nickels";
                break;
            case PENNY:
                coinToString="Pennies";
        }
        return coinToString;
    }
}
