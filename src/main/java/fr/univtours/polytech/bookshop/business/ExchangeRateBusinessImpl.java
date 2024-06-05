package fr.univtours.polytech.bookshop.business;

import fr.univtours.polytech.bookshop.dao.ExchangeRateDAO;
import fr.univtours.polytech.bookshop.model.exchangerate.WsExchangeResult;
import jakarta.inject.Inject;

public class ExchangeRateBusinessImpl implements ExchangeRateBusiness{

@Inject
    private ExchangeRateDAO exchangeRateDAO;
    
    @Override
    public float getPriceByCode(String code, float price) {
        WsExchangeResult excR= exchangeRateDAO.getPriceByExchange(code, price);
        return Float.parseFloat(excR.getResult());
    }

}
