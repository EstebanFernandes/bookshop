package fr.univtours.polytech.bookshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.bookshop.business.BookBusiness;
import fr.univtours.polytech.bookshop.business.DetailsBusiness;
import fr.univtours.polytech.bookshop.business.ExchangeRateBusiness;
import fr.univtours.polytech.bookshop.model.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("books")
public class BooksServlet extends HttpServlet {

    @Inject
    private BookBusiness bookBusiness;
    @Inject
    private DetailsBusiness detailsBusiness;
    @Inject
    private ExchangeRateBusiness exchangeRateBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                System.out.println("Bookservlet");
        List<BookBean> books = this.bookBusiness.getBooks();
        List<Float> newPrices = new ArrayList<Float>();
        //List<WsDetailsResult> details = this.detailsBusiness.getBookDetails(books.);
        for (BookBean bookBean : books) {
            if(bookBean.getPrice()!=null)
                newPrices.add(exchangeRateBusiness.getPriceByCode(bookBean.getCurrency(), bookBean.getPrice()));
                else
                newPrices.add(0f);
            //bookBean.setDetails(this.detailsBusiness.getBookDetails(bookBean.getId()));
        }
        System.out.println(newPrices);
        request.setAttribute("BOOKS", books);
        request.setAttribute("prices", newPrices);
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
