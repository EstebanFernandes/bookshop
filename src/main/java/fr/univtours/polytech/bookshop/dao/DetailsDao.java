package fr.univtours.polytech.bookshop.dao;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bookshop.model.details.Doc;

public interface DetailsDao {
    List<Doc> searchBookDetails(String query) throws IOException, InterruptedException;
}