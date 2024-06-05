package fr.univtours.polytech.bookshop.business;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bookshop.dao.DetailsDao;
import fr.univtours.polytech.bookshop.model.details.Doc;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DetailsBusinessImpl implements DetailsBusiness {

    @Inject
    private DetailsDao detailsDao;

    /***
     * retourner les détails du livre avec le title et Author correspondant
     */
    @Override
    public Doc getBookDetails(String titleAndAuthor) {
        try {
            List<Doc> liste = detailsDao.searchBookDetails(titleAndAuthor);
            for (Doc doc : liste) {
                String concatenatedTitleAndAuthor = doc.getTitle() + doc.getAuthor_name();
                if (concatenatedTitleAndAuthor.equals(titleAndAuthor)) {
                    return doc;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }

}
