package dao;

import dto.Item;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryDaoImpl implements InventoryDAO {

    private Map<String, Item> inventory = new HashMap<>();

    private final String INVENTORY_FILE ;
    public static final String DELIMITER="::";

    public InventoryDaoImpl() {//Production data
        this.INVENTORY_FILE = "Inventory.txt";
    }
    public InventoryDaoImpl(String TextFile) {//Test data
        this.INVENTORY_FILE = TextFile;
    }

    @Override
    public void addItemToInventory(Item item) throws PersistenceException {
        loadFromFile();
        inventory.put(item.getName(), item);
        writeToFile();
    }

    @Override
    public void removeItemFromInventory(String itemName) throws PersistenceException {
        loadFromFile();
        inventory.remove(itemName);
        writeToFile();
    }

    @Override
    public void updateItemInInventory(Item updatedItem) throws PersistenceException {
        loadFromFile();
        updatedItem.setQuantityInStock((updatedItem.getQuantityInStock())-1);
        inventory.replace(updatedItem.getName(),updatedItem);
        writeToFile();
    }

    @Override
    public Map<String, BigDecimal> listItemsAndPriceInInventory() throws PersistenceException {//only collect items with available stock
        loadFromFile();
        //Use of Lambdas and Streams to collect here
        /* Lambdas is an anonymous function since this will be used this one time so no need making a whole method and allow parralell processing
         * we are trying to return a map(itemInStockWithCosts) with only the name and cost per item
         *Entryset() allows me to return set view of all entries
         * stream() is used to expose a sequence of items in map(inventory)
         * filter() as the name dictates it allows me to stream only the items of map that respects a certain condition
         * collect(Collectors.toMap(value1,value2)) collect value1 and value2 of the items after the filter */
        Map<String, BigDecimal> itemsInStockWithCosts = inventory.entrySet()
                .stream()
                //.filter(map -> map.getValue().getQuantityInStock() > 0) removed filter otherwise user wont be able to view item
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue().getPrice()));

        return itemsInStockWithCosts ;
    }

    @Override
    public List<Item> getInventoryList() throws PersistenceException {
        loadFromFile();
        return new ArrayList<>(inventory.values());

    }

    @Override
    public Item getItemByIndex(int index) throws PersistenceException {
        List<Item> listOfInventory = getInventoryList();


        return listOfInventory.get(index);
    }

    /***********************************************************************
     *                  File Consistency Methods
     * **********************************************************************/
    // Split a String variable and create an Item object from the parts
    private Item unmarshallItem(String itemInTextFormat){
        Item itemFromFile;//item object to instantiated and filled

        String[]itemTokens= itemInTextFormat.split(DELIMITER);//String split into array of strings separated by "::"

        String itemName= itemTokens[0];
        BigDecimal itemPrice =new BigDecimal(itemTokens[1]) ;
        int itemStock = Integer.parseInt(itemTokens[2]);

        itemFromFile = new Item(itemName,itemPrice,itemStock);// Instance of item created and added the properties collected

        return itemFromFile;
    }

    //Read, Interpret File and fill Map
    private void loadFromFile() throws PersistenceException {
        Scanner scanner;

        try{
            scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(INVENTORY_FILE)));
        }catch(FileNotFoundException e){
            throw new PersistenceException("Could not load file",e);
        }
        String currentLine;// Line being read
        Item currentItem;// Item created from line read

        while(scanner.hasNextLine()){// run loop as long that there is content to read on the next line

            currentLine = scanner.nextLine();// Collect line save to String variable
            currentItem = unmarshallItem(currentLine);// Transform collected line into Item object and save to Instance of Item

            inventory.put(currentItem.getName(),currentItem);// Add item to Inventory Map
        }
        scanner.close();
    }

    //Taking an item object and turning it into a String
    private String marshallItem(Item aItem){

        String itemAsText = aItem.getName() + DELIMITER;//Item as a String= itemName + ::

        itemAsText += aItem.getPrice() + DELIMITER;//Item as a String: itemName+ :: + itemPrice + ::

        itemAsText += aItem.getQuantityInStock(); // //Item as a String: itemName+ :: + itemPrice + :: + ItemStock

        return itemAsText;
    }

    //Taking the changes done in the Inventory Map and altering the text file in consequence
    private void writeToFile() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new PersistenceException("Could not save Item data.", e);
        }
        String itemAsText;
        List<Item> itemList =new ArrayList<>(inventory.values()) ;
        for (Item currentItem : itemList) {
            itemAsText = marshallItem(currentItem);
            out.println(itemAsText);
            out.flush();
        }
        out.close();
    }
}
