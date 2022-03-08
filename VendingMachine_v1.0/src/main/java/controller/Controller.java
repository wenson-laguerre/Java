package controller;

import dao.PersistenceException;
import dto.Item;
import service.InsufficientFundsException;
import service.NoItemInventoryException;
import service.ServiceLayer;
import view.AppView;

import java.math.BigDecimal;

import java.util.Map;

public class Controller {
    private final AppView view;
    private final ServiceLayer serviceLayer;

    public Controller(AppView view, ServiceLayer serviceLayer) {
        this.view = view;
        this.serviceLayer = serviceLayer;//Dao accessed through service layer
    }

    /*                       CORE Methode                                 */
    public void run() {
        boolean keepGoing= true;
        BigDecimal userBalance= BigDecimal.valueOf(0.00);
        String itemSelection;
        Item selectedItem;
        try{
            displayMenu();// Menu banner and items
            view.displayBalance(userBalance);
        }
        catch(PersistenceException e ){
            view.displayErrorMessage(e.getMessage());
        }
        userBalance = getFunds();

        while(keepGoing){
            try{

                itemSelection = getItemSelection();
                if(itemSelection.equals("quit")){//Feature: Option to Exit
                    keepGoing= false;
                    break;
                }
                selectedItem =runTransaction(itemSelection,userBalance);
                //Update balance
                userBalance= getUpdatedBalance(selectedItem,userBalance);
                view.displayBalance(userBalance);


               keepGoing= continueOption();
            }catch(InsufficientFundsException | NoItemInventoryException |PersistenceException e){

                view.displayErrorMessage(e.getMessage());
                System.exit(0);
            }
        }


    }
    /*                        Methods                                  */
    public void displayMenu() throws PersistenceException {
        Map<String, BigDecimal> itemsInStockWithCosts = serviceLayer.listItemsAndPriceInInventory();
        view.displayMainMenuTitle();
        view.displayMenu(itemsInStockWithCosts);

    }

    private BigDecimal getFunds() {

        return view.getFunds();
    }

    public String getItemSelection(){

        return view.getItemSelection() ;
    }

    public Item runTransaction(String indexInString,BigDecimal funds) throws PersistenceException, NoItemInventoryException, InsufficientFundsException {
        //retrive Item information
        int index =( Integer.parseInt(indexInString) ) - 1 ;
        Item itemDesired = serviceLayer.getItemByIndex(index);//ITEM FOUND

        view.displayItemInfo(itemDesired);//Item before transaction

        return itemDesired;
    }

    public BigDecimal getUpdatedBalance(Item itemBought,BigDecimal balance) throws InsufficientFundsException, NoItemInventoryException,PersistenceException {
        // (Fund check,inventory check)
        serviceLayer.updateItemInInventory(itemBought,balance); // -1 from stock
        balance= view.getChange(itemBought.getPrice(),balance);// balance- price of Item

        return balance;

    }

    public boolean continueOption(){
        String continueBuying= view.displayContinueOption();
        if(continueBuying.equalsIgnoreCase("no")){
            return false;
        }else if (continueBuying.equalsIgnoreCase("yes")) {
            return true;
        }else
            return false;

    }
}

