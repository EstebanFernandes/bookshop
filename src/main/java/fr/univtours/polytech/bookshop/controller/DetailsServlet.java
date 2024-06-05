package fr.univtours.polytech.bookshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.bookshop.business.DetailsBusiness;
import fr.univtours.polytech.bookshop.model.details.Doc;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {

    @Inject
    private DetailsBusiness detailsBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // On place une liste vide dans la requête.
        request.setAttribute("DOCS", new ArrayList<Doc>());
        // On redirige vers la JSP.
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // On récupère ce que l'utilisateur à saisi.
        String search = request.getParameter("search");
        // On exécute la requête correspondante.
        List<Doc> docs = this.detailsBusiness.getBookDetails(search);
        // On place le résultat de la recherche dans la requête.
        request.setAttribute("DOCS", docs);
        // On redirige vers la JSP.
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
