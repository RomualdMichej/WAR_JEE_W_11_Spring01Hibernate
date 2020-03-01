<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h5><a href="/">Powrot na strone glowna</a></h5>
<form action="add" method="get">
    <input type="submit" value="Dodaj nowego autora">
</form>

<c:forEach items="${authors}" var="author">
    Id: ${author.id} Nazwa: ${author.fullName} <br />
    <form method="get" action="edit">
        <input type="hidden" name="toEditId" value="${author.id}">
        <input type="submit" value="Edytuj">
    </form>
    <form method="get" action="remove">
        <input type="hidden" name="toRemoveId" value="${author.id}">
        <input type="submit" value="Usun">
    </form>
</c:forEach>