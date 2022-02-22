package controller;

import dao.LibraryDao;
import dao.LibraryDaoException;
import dto.DVD;
import ui.*;

import java.util.List;


public class LibraryController {

    private UserIO io = new UserIOConsoleImpl();

    private LibraryView view;
    private LibraryDao dao;

    public LibraryController(LibraryView view,LibraryDao dao) {
        this.dao =dao;
        this.view = view;
    }

    public void run() throws LibraryDaoException {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        updateDvd();
                        break;

                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        io.print("Program will now close.");
                        keepGoing = false;
                        break;
                    default:
                        io.print("UNKNOWN COMMAND");

                }

            }
        }catch(LibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }
    private DVD runUpdate(DVD dvd){
        boolean keepGoing = true;
        int updateSelection;
        while(keepGoing){

            updateSelection= getUpdateSelection();
            switch (updateSelection)
            {
                case 1:// while coding I saw that to change title would mean to change my class accessors
                    io.print("Sorry title cannot be updated," +
                            "if this title is wrong delete this " +
                            "dvd and make a new one with correct title.");
                    keepGoing =false;
                    break;
                case 2:
                    String release=io.readString("New Release Date :");
                    dvd.setReleaseDate(release);
                    break;
                case 3:
                    String mpa = io.readString("New MPAA : ");
                    dvd.setMPAA(mpa);
                    break;

                case 4:
                    String director = io.readString(" New Director Name: ");
                    dvd.setDirectorName(director);
                    break;
                case 5:
                    String studio = io.readString("New Studio : ");
                    dvd.setStudio(studio);
                    break;
                case 6:
                    String userRating =io.readString("User Rating: ");
                    dvd.setUserRating(userRating);
                    break;
                case 7:
                    io.print("Update section will now end");
                    keepGoing =false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");

            }

        }
        return dvd;
    }
    /**********************************************
     *          From LibraryView
     * **********************************************/

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private int getUpdateSelection(){
        return view.printUpdateMenuAndGetSelection();
    }

    /******************************************************
     *              Menu actions
     ******************************************************/
    private void addDvd() throws LibraryDaoException {
        view.displayAddDVDBanner();
        DVD newDVD=view.getNewDvdInfo();
        dao.addDvd(newDVD.getTitle(),newDVD);
        view.displayAddSuccessBanner();
    }
    private void removeDvd() throws LibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        DVD removeDvd = dao.deleteDvd(title);
        view.displayRemoveResult(removeDvd);
    }
    private void updateDvd() throws LibraryDaoException {

        view.displayUpdateDvdBanner();
        String title= view.getDvdTitleChoice(); //   Step 1: Search for DVD
        DVD currentDvd= dao.getDvd(title);      //   Step 2. pull up current data
        view.displayDvdInfo(currentDvd);        //   Step 3. Print current dvd info
       DVD updatedDvd= runUpdate(currentDvd);   //   Step 4. create updated dvd
       dao.updateDvd(title,updatedDvd);         //   Step 5. replace prev DVD in map
       view.displayUpdateSuccessBanner();
    }
    private void listDvds() throws LibraryDaoException {
        view.displayAllBanner();
        List<DVD> dvdList =dao.getAllDvds();
        view.displayDvdList(dvdList);

    }
    private  void viewDvd() throws LibraryDaoException {
        view.displayDisplayDVDBanner();
        String title =view.getDvdTitleChoice();
        DVD dvd = dao.getDvd(title);
        view.displayDvdInfo(dvd);
    }
}
