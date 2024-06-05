package fr.univtours.polytech.bookshop.business;

import java.io.IOException;

import fr.univtours.polytech.bookshop.dao.DetailsDao;
import fr.univtours.polytech.bookshop.model.details.WsDetailsResult;
import jakarta.ejb.EJB;

public class DetailsBusinessImpl implements DetailsBusiness {

    @EJB
    private DetailsDao detailsDao;

    /***
     * getBookDetails qui prend en paramètre le titre et l'auteur du livre 
     * et retourne les détails enrichis du livre sous forme d'objet WsDetailsResult.
     */
    @Override
    public WsDetailsResult getBookDetails(String titleAndAuthor) {
        try {
            return (this.detailsDao.searchBookDetails(titleAndAuthor));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
