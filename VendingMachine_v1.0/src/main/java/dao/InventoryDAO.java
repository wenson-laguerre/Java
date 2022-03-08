package dao;

import dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface InventoryDAO {
    void addItemToInventory(Item item) throws PersistenceException;
    void removeItemFromInventory(String itemName) throws PersistenceException;
    void updateItemInInventory(Item updatedItem) throws PersistenceException;

    Map<String, BigDecimal> listItemsAndPriceInInventory() throws PersistenceException;
    List<Item> getInventoryList() throws PersistenceException;
    Item getItemByIndex(int index) throws PersistenceException;

}
