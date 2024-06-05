package fr.univtours.polytech.bookshop.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bookshop.business.BookBusiness;
import fr.univtours.polytech.bookshop.business.DetailsBusiness;
import fr.univtours.polytech.bookshop.model.BookBean;
import fr.univtours.polytech.bookshop.model.details.Doc;
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
        for (BookBean book : books) {
            Doc docs = this.detailsBusiness.getBookDetails(book.getTitle()+" "+book.getAuthor());
            if(null != docs && docs.getAuthor_name()!=null && docs.getTitle()!=null){
                book.setRatingsAverage(docs.getRatings_average());
                book.setRatingsCount(docs.getRatings_count());
                //book.setAuthorImageUrl();
                System.err.println("Ratings" +book.getRatingsAverage());

            }
        }
        request.setAttribute("BOOKS", books);

        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
