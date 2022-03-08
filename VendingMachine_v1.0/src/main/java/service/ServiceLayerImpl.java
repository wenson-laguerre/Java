package service;

import dao.AuditDAO;
import dao.InventoryDAO;
import dao.PersistenceException;
import dto.Item;

import java.math.BigDecimal;

import java.util.Map;

public class ServiceLayerImpl implements ServiceLayer {
    private InventoryDAO inventoryDao;
    private AuditDAO auditDAO;

    public ServiceLayerImpl(InventoryDAO inventoryDao,AuditDAO auditDAO) {
        this.inventoryDao = inventoryDao;
        this.auditDAO =auditDAO;
    }

    @Override
    public void addItemToInventory(Item item) throws PersistenceException {
        inventoryDao.addItemToInventory(item); //no exception to add for now
    }

    @Override
    public void removeItemFromInventory(String itemName) throws PersistenceException {
        inventoryDao.removeItemFromInventory(itemName);
    }

    @Override
    public void updateItemInInventory(Item updatedItem,BigDecimal userBalance) throws PersistenceException, InsufficientFundsException, NoItemInventoryException {
    BigDecimal itemPrice=updatedItem.getPrice();
    int itemStock = updatedItem.getQuantityInStock();

        if(itemPrice.compareTo(userBalance)==1){// itemPrice > userBalance
            throw new InsufficientFundsException("You currently do not have enough for this item.\n\n" +
                    "Your Balance is: "+userBalance+"$");


        }else if (itemStock == 0){
            throw new NoItemInventoryException("This item is currently out of stock.");
        }else
             inventoryDao.updateItemInInventory(updatedItem);
        auditDAO.writeAuditEntry("Item: "+updatedItem.getName()+" was bought by a user.");


    }

    @Override
    public Map<String, BigDecimal> listItemsAndPriceInInventory() throws PersistenceException {
        return inventoryDao.listItemsAndPriceInInventory();
    }

    @Override
    public Item getItemByIndex(int index) throws PersistenceException {

     return inventoryDao.getItemByIndex(index);

    }
}
