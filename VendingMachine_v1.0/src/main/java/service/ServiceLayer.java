package service;

import dao.PersistenceException;
import dto.Item;

import java.math.BigDecimal;
import java.util.Map;

public interface ServiceLayer {

    void addItemToInventory(Item item) throws PersistenceException;

    void removeItemFromInventory(String itemName) throws PersistenceException;

    void updateItemInInventory(Item updatedItem,BigDecimal userBalance) throws PersistenceException, InsufficientFundsException,NoItemInventoryException;

    Map<String, BigDecimal> listItemsAndPriceInInventory() throws PersistenceException;

    Item getItemByIndex( int index) throws PersistenceException;
}
