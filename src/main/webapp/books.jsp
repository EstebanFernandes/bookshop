<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="fr.univtours.polytech.bookshop.model.details.WsDetailsResult" %> 
<html>

<head>
    <title>Résultats</title>
    <meta charset="UTF-8" />

    <style>
        table,
        th,
        td {
            border: 1px solid;
        }
    </style>
</head>

<body>
    <h1>Liste des livres</h1>
    <fieldset>
        <legend>Livres</legend>
        <table>
            <tr>
                <th>Titre</th>
                <th>Auteur</th>
                <th>Nombre de notes</th>
                <th>Moyenne des notes</th>
                <th>Image de l'auteur</th>
            </tr>
            <c:forEach items="${requestScope.BOOKS}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.ratingsCount}</td>
                    <td>${book.ratingsAverage}</td>
                    <td><img src="${book.authorImageUrl}" alt="Image de l'auteur" width="100"></td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</body>

</html>
