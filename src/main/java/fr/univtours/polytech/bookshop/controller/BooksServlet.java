package fr.univtours.polytech.bookshop.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bookshop.business.BookBusiness;
import fr.univtours.polytech.bookshop.business.DetailsBusiness;
import fr.univtours.polytech.bookshop.model.BookBean;
import fr.univtours.polytech.bookshop.model.details.WsDetailsResult;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<BookBean> books = this.bookBusiness.getBooks();
        //List<WsDetailsResult> details = this.detailsBusiness.getBookDetails(books.);
        for (BookBean bookBean : books) {
            
            //bookBean.setDetails(this.detailsBusiness.getBookDetails(bookBean.getId()));
        }

        request.setAttribute("BOOKS", books);

        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
