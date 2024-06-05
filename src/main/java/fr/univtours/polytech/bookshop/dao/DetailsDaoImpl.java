package fr.univtours.polytech.bookshop.dao;

import fr.univtours.polytech.bookshop.model.details.Doc;
import fr.univtours.polytech.bookshop.model.details.WsDetailsResult;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class DetailsDaoImpl implements DetailsDao {

    private static final String OPEN_LIBRARY_API_URL = "https://openlibrary.org/search.json?q=";

    @Override
    public WsDetailsResult searchBookDetails(String titleAndAuthor) {
        try {
            // URL de l'API Open Library
            String apiUrl = OPEN_LIBRARY_API_URL + titleAndAuthor;

            // Instanciation du client
            Client client = ClientBuilder.newClient();

            // Appeler l'API Open Library
            WebTarget target = client.target(apiUrl);
            WsDetailsResult result = target.request(MediaType.APPLICATION_JSON).get(WsDetailsResult.class);

            // Vérifier s'il y a des résultats
            if (result != null && result.getDocs() != null && !result.getDocs().isEmpty()) {
                // recup le 1er doc
                Doc firstDoc = result.getDocs().get(0);

                // nouvel objet WsDetailsResult pour stocker les infos
                WsDetailsResult detailsResult = new WsDetailsResult();

                // Ajout des indos nécessaires
                detailsResult.setRatingsCount(firstDoc.getRatings_average());
                detailsResult.setRatingsAverage(firstDoc.getRatings_average());

                // Ajouter l'URL de la photo de l'auteur s'il existe
                if (firstDoc.getAuthor_key() != null && !firstDoc.getAuthor_key().isEmpty()) {
                    String authorImageUrl = "https://covers.openlibrary.org/a/olid/" + firstDoc.getAuthor_key()
                            + ".jpg";
                    detailsResult.setAuthorImageUrl(authorImageUrl);
                }
                return detailsResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Si aucun résultat ou s'il y a eu une erreur, return null
        return null;
    }
}
