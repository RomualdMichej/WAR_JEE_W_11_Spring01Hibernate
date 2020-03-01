<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Lista wszystkich propozycji</h2>

<h5><a href="/">Powrot na strone glowna</a></h5>

<form action="add" method="get">
    <input type="submit" value="Dodaj nowa propozycje">
</form>

<c:forEach items="${allPropositions}" var="proposition">
    <br />
    ------------------------------------------------
    <br />

    <h3>${proposition.title}</h3>
    <h5>${proposition.description}</h5>
    <form method="get"
          action="edit">
        <input type="hidden" name="toEditId" value="${proposition.id}">
        <input type="submit" value="Edytuj">
    </form>
    <form method="get"
          action="remove">
        <input type="hidden" name="toRemoveId" value="${proposition.id}">
        <input type="submit" value="Usun">
    </form>
    <br />
    ------------------------------------------------
    <br />
</c:forEach>