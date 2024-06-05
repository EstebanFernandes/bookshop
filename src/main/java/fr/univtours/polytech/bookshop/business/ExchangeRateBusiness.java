package fr.univtours.polytech.bookshop.business;

public interface ExchangeRateBusiness {
    //Renvoie le prix en euro selon le code passé en paramètre
public float getPriceByCode(String code,float price);
}
