package ui;

import dto.DVD;

import java.util.List;

public class LibraryView {

    private final UserIO io;

    public LibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(){
        io.print("Welcome to the DVD Management System");
        io.print("( Chose the operation by entering the number.)\n" +
                "1.Add a DVD to the collection\n" +
                "2.Remove a DVD from the collection\n" +
                "3.Edit the information for a DVD in the collection\n" +
                "4.View list the DVDs in the collection\n" +
                "5.Search for a DVD\n" +
                "6.Quit Application\n\n");
        return io.readInt( "Choice (1-6):",1,6);
    }
    public int printUpdateMenuAndGetSelection(){
        io.print("Welcome to the Update Dvd section");
        io.print("( Chose the operation you wish to update by entering the number.)\n" +
                "1.Title\n" +
                "2.Release Date\n" +
                "3.MPAA\n" +
                "4.Director Name\n" +
                "5.Studio\n" +
                "6. User Rating\n" +
                "7.End update\n\n");
        return io.readInt( "Choice (1-7):",1,7);
    }
    public DVD getNewDvdInfo(){
        io.print("Enter corresponding information for the DVD Input");
        String title = io.readString("Title : ");
        String release=io.readString("Release Date :");
        String mpa = io.readString("MPAA : ");
        String director = io.readString("Director Name: ");
        String studio = io.readString("Studio : ");
        String userRating =io.readString("User Rating: ");
        DVD currentDvd = new DVD(title);
        currentDvd.setReleaseDate(release);
        currentDvd.setMPAA(mpa);
        currentDvd.setDirectorName(director);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        return currentDvd;

    }
    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD title you are looking for.");
    }

    public void displayDvdList(List<DVD> dvdList){
        for (DVD currentDvd:dvdList){
            String dvdInfo = String.format("#%s : %s %s %s %s %s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMPAA(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayDvdInfo(DVD dvd) {
        if (dvd != null) {
            io.print("1.Title: "+dvd.getTitle()+" 2.Release day:"+dvd.getReleaseDate()+
                    "\n 3.MPAA: "+dvd.getMPAA()+" 4.Director: "+ dvd.getDirectorName()+
                    "\n 5.Studio: "+dvd.getStudio()+" 6.User Ratings: "+dvd.getUserRating());
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayAddDVDBanner() {
        io.print("=== Add DVD ===");
    }
    public void displayAllBanner() {
        io.print("=== Display All DVD ===");
    }
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD info ===");
    }
    public void displayRemoveDvdBanner () {
        io.print("=== Remove DVD from library ===");
    }
    public void displayUpdateDvdBanner () {
        io.print("=== Update DVD from library ===");
    }

    public void displayAddSuccessBanner() {
        io.readString("DVD successfully added to library.  Please hit enter to continue");
    }
    public void displayUpdateSuccessBanner() {
        io.readString("DVD successfully updated to library.  Please hit enter to continue");
    }
    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD in this library.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
