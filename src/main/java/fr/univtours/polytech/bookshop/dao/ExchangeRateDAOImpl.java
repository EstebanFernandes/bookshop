package fr.univtours.polytech.bookshop.dao;

import fr.univtours.polytech.bookshop.model.exchangerate.WsExchangeResult;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ExchangeRateDAOImpl implements ExchangeRateDAO{

    private static String URI = " https://v6.exchangerate-api.com/v6/";
    private static String API_KEY = "312c88d24f63dd19676e159b";
    @Override
    public WsExchangeResult getPriceByExchange(String code, float price) {
         // Instanciation du client.
        Client client = ClientBuilder.newClient();

        // On indique l'URL du Web Service.
        WebTarget target = client.target(URI+API_KEY+"/");

        // On indique le "end point" (on aurait aussi pu directement le mettre dans
        // l'URL).
        // C'est également avec cette méthode qu'on pourrait ajouter des "path
        // parameters" si besoin.
        Float f = price;
        target = target.path("EUR/"+code+"/"+ f.toString());
        // On précise (lorsqu'il y en a) les "query parameters".


        // On appelle le WS en précisant le type de l'objet renvoyé, ici un
        // WsAddressResult.
        System.out.println(target.getUri());
        return target.request(MediaType.APPLICATION_JSON).get(WsExchangeResult.class);

    }

}
