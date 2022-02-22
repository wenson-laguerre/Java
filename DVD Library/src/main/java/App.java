import controller.LibraryController;
import dao.LibraryDao;
import dao.LibraryDaoException;
import dao.LibraryDaoImpl;
import dao.LibraryFileImpl;
import ui.LibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws LibraryDaoException {
        // Test without file
        // Tested all functions all work fine and saved correctly with hashmap
        UserIO myIO = new UserIOConsoleImpl();
        LibraryView myView = new LibraryView(myIO);
       // LibraryDao myDao = new LibraryDaoImpl();
        LibraryDao myDao = new LibraryFileImpl();

        LibraryController dvdSystem = new LibraryController(myView,myDao);
        dvdSystem.run();

    }
}
