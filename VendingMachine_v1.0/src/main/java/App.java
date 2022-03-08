import controller.Controller;
import dao.AuditDAO;
import dao.AuditDaoImpl;
import dao.InventoryDAO;
import dao.InventoryDaoImpl;

import service.ServiceLayer;
import service.ServiceLayerImpl;

import view.AppView;

public class App {
    public static void main(String[] args) {
        AppView myView = new AppView();//View class for what appears to clients
        InventoryDAO vendingMachineInventoryDao = new InventoryDaoImpl("Inventory.txt");// main functions and read/writes to file and map
        AuditDAO auditVendingMachine = new AuditDaoImpl();

        ServiceLayer serviceLayer =new ServiceLayerImpl(vendingMachineInventoryDao,auditVendingMachine);//implamentation of business logic
        Controller vendingMachineSimulation = new Controller(myView,serviceLayer);

        vendingMachineSimulation.run();

    }
}
