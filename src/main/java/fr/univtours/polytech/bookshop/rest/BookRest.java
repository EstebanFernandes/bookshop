package fr.univtours.polytech.bookshop.rest;

import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.bookshop.business.BookBusiness;
import fr.univtours.polytech.bookshop.model.BookBean;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("v1")
public class BookRest {
    @EJB
    private BookBusiness bookBusiness;

    @Path("books")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<BookBean> getBooks(@QueryParam("auteur") String auteur, @QueryParam("titre") String titre) {
        List<BookBean> books = this.bookBusiness.getBooks();
        List<BookBean> results = new ArrayList<>();
    
        // Vérification correcte des chaînes nulles ou vides
        boolean isTitreValid = titre != null && !titre.trim().isEmpty();
        boolean isAuteurValid = auteur != null && !auteur.trim().isEmpty();
    
        if (isTitreValid || isAuteurValid) {
            // On a un titre ou un auteur
            for (BookBean bookBean : books) {
                boolean matchesTitre = isTitreValid && bookBean.getTitle().toUpperCase().contains(titre.toUpperCase());
                boolean matchesAuteur = isAuteurValid && bookBean.getAuthor().toUpperCase().contains(auteur.toUpperCase());
    
                if (matchesTitre || matchesAuteur) {
                    results.add(bookBean);
                }
            }
        } else {
            // Si ni titre ni auteur ne sont fournis, retourner tous les livres
            results = books;
        }
        return results;
    }

    @GET
    @Path("books/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public BookBean getBook(@PathParam("id") Integer idBook) {
        BookBean bookBean = bookBusiness.getBook(idBook);
        return bookBean;
    }

    @DELETE
    @Path("books/{id}")
    public Response deleteBook(@PathParam("id") Integer idBook,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        System.out.println(auth);
        if (!"42".equals(auth)) {
            // Le client n'a pas le droit de faire cette action.
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            // Le client à la droit de faire cette action.
            // On vérifie que le livre existe dans la base de données.
            List<BookBean> books = this.bookBusiness.getBooks();
            BookBean bookBean = bookBusiness.getBook(idBook);
            if (null == bookBean) {
                // Le livre n'existe pas. On renvoie un 404.
                return Response.status(Status.NOT_FOUND).build();
            } else {
                // Le livre existe. On le supprime ...
                this.bookBusiness.removeBook(idBook);
                // ... et on renvoie un 204 par exemple.
                return Response.status(Status.NO_CONTENT).build();
            }
        }
    }

    // Méthode appelée lorsqu'on ajoute toutes les informations dans le corps de la
    // requête.
    @POST
    @Path("books")
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response createBook(BookBean bookBean,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        System.out.println(auth);
        if (!"42".equals(auth)) {
            // Le client n'a pas le droit de faire cette action.
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            this.bookBusiness.createBook(bookBean);
            return Response.status(Status.ACCEPTED).build();
        }
    }

    @PUT
    @Path("books/{id}")
    public Response fullUpdateBook(@PathParam("id") Integer idBook, BookBean bookBean,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        System.out.println(auth);
        if (!"42".equals(auth)) {
            // Le client n'a pas le droit de faire cette action.
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            BookBean oldBookBean = bookBusiness.getBook(idBook);
            
            if (null == oldBookBean) {
                return Response.status(Status.NOT_FOUND).build();
            } else {
                // On met à jour tous les champs :
                oldBookBean.setAuthor(bookBean.getAuthor());
                oldBookBean.setCurrency(bookBean.getCurrency());
                oldBookBean.setPrice(bookBean.getPrice());
                oldBookBean.setTitle(bookBean.getTitle());

                bookBusiness.updateBook(oldBookBean);
                return Response.status(Status.ACCEPTED).build();
            }
        }
    }

    @PATCH
    @Path("books/{id}")
    public Response partialUpdateBook(@PathParam("id") Integer idBook, BookBean bookBean,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        System.out.println(auth);
        if (!"42".equals(auth)) {
            // Le client n'a pas le droit de faire cette action.
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            BookBean oldBookBean = bookBusiness.getBook(idBook);
            if (null == oldBookBean) {
                return Response.status(Status.NOT_FOUND).build();
            }

            // Seul les champs renseignés dans le bean envoyé sont mis à jour en base de
            // données.
            if (null != bookBean.getAuthor() && !"".equals(bookBean.getAuthor())) {
                oldBookBean.setAuthor(bookBean.getAuthor());
            }
            if (null != bookBean.getCurrency() && !"".equals(bookBean.getCurrency())) {
                oldBookBean.setCurrency(bookBean.getCurrency());
            }
            if (null != bookBean.getPrice() && !"".equals(bookBean.getPrice().toString())) {
                oldBookBean.setPrice(bookBean.getPrice());
            }
            if (null != bookBean.getTitle()) {
                oldBookBean.setTitle(bookBean.getTitle());
            }

            this.bookBusiness.updateBook(oldBookBean);
            return Response.status(Status.ACCEPTED).build();
        }
    }

}
