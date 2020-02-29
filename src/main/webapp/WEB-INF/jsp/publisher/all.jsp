<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="add" method="get">
    <input type="submit" value="Dodaj nowego wydawce">
</form>

<c:forEach items="${publishers}" var="publisher">
    Id: ${publisher.id} Nazwa: ${publisher.name} <br />
    <form method="get" action="edit">
        <input type="hidden" name="toEditId" value="${publisher.id}">
        <input type="submit" value="Edytuj">
    </form>
    <form method="get" action="remove">
        <input type="hidden" name="toRemoveId" value="${publisher.id}">
        <input type="submit" value="Usun">
    </form>
</c:forEach>