package dao;

import dto.DVD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryDaoImpl implements LibraryDao{

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDvd(String title, DVD dvd)throws LibraryDaoException {
        return dvds.put(title,dvd);
    }

    @Override
    public DVD updateDvd(String title, DVD dvd)throws LibraryDaoException {

        return dvds.replace(title,dvd);
    }

    @Override
    public DVD deleteDvd(String title)throws LibraryDaoException {
        DVD deleteDvd = dvds.remove(title);
        return deleteDvd;
    }

    @Override
    public DVD getDvd(String title)throws LibraryDaoException {
        return dvds.get(title);
    }

    @Override
    public List<DVD> getAllDvds()throws LibraryDaoException {
        return new ArrayList<>(dvds.values());
    }
}
