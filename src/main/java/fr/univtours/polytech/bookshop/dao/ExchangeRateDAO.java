package fr.univtours.polytech.bookshop.dao;

import fr.univtours.polytech.bookshop.model.exchangerate.WsExchangeResult;

public interface ExchangeRateDAO {
    public WsExchangeResult getPriceByExchange(String code,float price);
}
