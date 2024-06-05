package fr.univtours.polytech.bookshop.dao;

import java.io.IOException;

import fr.univtours.polytech.bookshop.model.details.WsDetailsResult;

public interface DetailsDao {
    WsDetailsResult searchBookDetails(String query) throws IOException, InterruptedException;
}