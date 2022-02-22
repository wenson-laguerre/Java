package dao;

import dto.DVD;

import java.util.List;

public interface LibraryDao {

    DVD addDvd(String title, DVD dvd)throws LibraryDaoException;
    DVD updateDvd(String title,DVD dvd)throws LibraryDaoException;
    DVD deleteDvd(String title)throws LibraryDaoException;
    DVD getDvd(String title)throws LibraryDaoException;
    List<DVD> getAllDvds()throws LibraryDaoException;


}
//throws DvdLibraryDaoException