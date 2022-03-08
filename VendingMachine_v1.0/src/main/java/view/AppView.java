package view;

import dto.Coins;
import dto.Item;
import view.ui.UserIO;
import view.ui.UserIOConsoleImpl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

import static dto.Coins.*;

public class AppView {

    UserIO io = new UserIOConsoleImpl();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public int i = 0;

    public void displayMainMenuTitle() {
        String star = "*";
        String border = star.repeat(45);

        io.print(border);
        io.print("Welcome to the Vending Machine Simulator");
        io.print(border);
    }

    public void displayMenu(Map<String, BigDecimal> itemsInStockWithCosts) {
        final int[] no = {1};
        String leftAlignFormat = "| %-3s | %-15s | %-5s |%n";

        System.out.format("+-----+-----------------+-------+%n");
        System.out.format("| No. | Item Name       | Price |%n");
        System.out.format("+-----+-----------------+-------+%n");
        itemsInStockWithCosts.entrySet().forEach(entry -> {

            String formattedPrice = df.format(entry.getValue());
            System.out.format(leftAlignFormat, no[0], entry.getKey(), formattedPrice);
            no[0]++;
            i = no[0];
        });
        System.out.format("+-----------------------+-------+%n\n");

    }

    public void displayItemInfo(Item item) {
        io.print("---------------------------------------\n" +
                "Item: " + item.getName()  +
                "        | Current Quantity: " + item.getQuantityInStock() + "\n" +
                "---------------------------------------");
    }
    public void displayBalance(BigDecimal balance){
        io.print("---------------------------------------\n" +
                "Current Balance : "+df.format(balance) +" $\n" +
                "---------------------------------------\n");
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }

    public String displayContinueOption() {
        return io.readString("Would you like to buy something else?\n" +
                "(yes/no) : ");
    }

    public String getItemSelection() {

        return io.readString("\nWhat would you like to buy(choices: 1-" + (i - 1) + ")\n" +
                "(To exit Vending Machine type 'quit')\n" +
                "Choice:");
    }

    public BigDecimal getFunds() {
        return io.readBigDecimal("Please type the amount money in dollars before making selection (format ex.'5.30')\n" +
                "Add to balance:$ ");

    }


    public BigDecimal getChange(BigDecimal price, BigDecimal balance) {

        balance = balance.subtract(price);

        generateChange(balance);
        io.print("\tYour change is:  " + balance +"$");

        return balance;
    }

    public void generateChange(BigDecimal userBalance) {
        Coins []eachCoin= {QUARTER,DIME,NICKEL,PENNY};
        double nbOfCoin;

        for( int i = 0; i < eachCoin.length; i++ ){
            String coinName =eachCoin[i].getName(eachCoin[i]);
            BigDecimal coinValue = eachCoin[i].getValue();

            nbOfCoin= nbOfEachCoin(coinValue,userBalance);

            BigDecimal coinsToSubtract =BigDecimal.valueOf(nbOfCoin).multiply(coinValue);

            userBalance =userBalance.subtract(coinsToSubtract);
            io.print("\t"+(int)nbOfCoin+" x "+coinName);

        }

    }

    public double nbOfEachCoin(BigDecimal coin, BigDecimal balance) {

        double nb = 0;
        for (BigDecimal i = coin; i.compareTo(balance) <= 0; i = i.add(coin)) {
            nb++;
        }

        return nb;
    }


}