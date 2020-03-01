<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Czy na pewno chcesz usunac autora ${author.fullName}?</h2>
<input type="hidden" name="toRemoveId" value="${author.id}">
<form:form method="post"
           modelAttribute="viewHelper">
    <form:hidden path="option" value="confirmed"/>
    <input type="submit" value="Tak!">
</form:form>
<form:form method="post"
           modelAttribute="viewHelper">
    <form:hidden path="option" value="non-confirmed"/>
    <input type="submit" value="Nie!">
</form:form>