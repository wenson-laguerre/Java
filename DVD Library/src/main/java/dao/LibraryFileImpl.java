package dao;

import dto.DVD;

import java.io.*;
import java.util.*;

public  class LibraryFileImpl implements LibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();

    public static final String DVD_FILE= "DVD_collection.txt";
    public static final String DELIMITER="::";

    @Override
    public DVD addDvd(String title, DVD dvd) throws LibraryDaoException{
        loadDvdLibrary();
        DVD preDvd = dvds.put(title,dvd);
        writeDVD();
        return preDvd;
    }

    @Override
    public DVD updateDvd(String title, DVD dvd) throws LibraryDaoException {
        loadDvdLibrary();
        DVD updatedDVDS= dvds.replace(title,dvd);
        writeDVD();
        return updatedDVDS;
    }

    @Override
    public DVD deleteDvd(String title) throws LibraryDaoException {
        loadDvdLibrary();
        DVD deleteDvd = dvds.remove(title);
        writeDVD();
        return deleteDvd;
    }

    @Override
    public DVD getDvd(String title) throws LibraryDaoException {
        loadDvdLibrary();
        return dvds.get(title);
    }

    @Override
    public List<DVD> getAllDvds() throws LibraryDaoException {
        loadDvdLibrary();
        return new ArrayList<>(dvds.values());

    }
    /********************************
     * File Persistent methodes
     *******************************/
    private  DVD unmarshallDvd(String dvdAsText){//collect string from text file turn into object
        String[] dvdTokens= dvdAsText.split(DELIMITER);

        String dvdTitle = dvdTokens[0];

        //instance made and DVD title already set to index 0
        DVD dvdFromFile = new DVD(dvdTitle);
        // Index 1 - ReleaseDate
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        // Index 2 - MPAA
        dvdFromFile.setMPAA(dvdTokens[2]);

        // Index 3 - Director Name
        dvdFromFile.setDirectorName(dvdTokens[3]);
        // Index 4 - Studio
        dvdFromFile.setStudio(dvdTokens[4]);
        // Index 5 - user Rating
        dvdFromFile.setUserRating(dvdTokens[5]);

        return dvdFromFile;

    }
    private void loadDvdLibrary() throws LibraryDaoException{
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new LibraryDaoException(
                    "-_- Could not load Library data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent dvd unmarshalled
        DVD currentDvd;
        // Go through LIBRARY_FILE line by line, decoding each line into a
        // Student object by calling the unmarshallDVD method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DVD
            currentDvd = unmarshallDvd(currentLine); //turn txt line to object



            dvds.put(currentDvd.getTitle(), currentDvd);// add to program library
        }
        // close scanner
        scanner.close();
    }
    private String marshallDvd(DVD aDvd){

        String dvdAsText = aDvd.getTitle() + DELIMITER;


        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        dvdAsText += aDvd.getMPAA() + DELIMITER;

        dvdAsText += aDvd.getDirectorName()+ DELIMITER;
        dvdAsText += aDvd.getStudio()+ DELIMITER;
        dvdAsText += aDvd.getUserRating();

        // We have now turned a DVD to text! Return it!
        return dvdAsText;
    }
    private void writeDVD() throws LibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new LibraryDaoException(
                    "Could not save dvd data.", e);
        }
        String dvdAsText;
        List<DVD> dvdList = this.getAllDvds();
        for (DVD currentDvd :dvdList) {
            // turn a DVD into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the DVD object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
