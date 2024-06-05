package fr.univtours.polytech.bookshop.business;

import fr.univtours.polytech.bookshop.model.details.WsDetailsResult;

public interface DetailsBusiness {
    WsDetailsResult getBookDetails(String titleAndAuthor);
}
