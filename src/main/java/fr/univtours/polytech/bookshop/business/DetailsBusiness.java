package fr.univtours.polytech.bookshop.business;

import fr.univtours.polytech.bookshop.model.details.Doc;

public interface DetailsBusiness {
    // WsDetailsResult getBookDetails(String titleAndAuthor);
    public Doc getBookDetails(String titleAndAuthor);
}
