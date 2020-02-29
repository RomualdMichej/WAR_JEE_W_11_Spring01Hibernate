<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Lista wszystkich ksiazek</h2>

<form action="add" method="get">
    <input type="submit" value="Dodaj nowa ksiazke">
</form>

<c:forEach items="${allBooks}" var="book">
    <br />
    ------------------------------------------------
    <br />

    <h3>${book.title}</h3>
    <h5>${book.description}</h5>
    <form method="get"
          action="edit">
        <input type="hidden" name="toEditId" value="${book.id}">
        <input type="submit" value="Edytuj">
    </form>
    <form method="get"
          action="remove">
        <input type="hidden" name="toRemoveId" value="${book.id}">
        <input type="submit" value="Usun">
    </form>
    <br />
    ------------------------------------------------
    <br />
</c:forEach>