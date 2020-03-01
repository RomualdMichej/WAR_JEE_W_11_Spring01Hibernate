<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>DODAWANIE AUTORA</h1>

<form:form method="post" modelAttribute="author">

    <form:hidden path="id"/> <br />
    FirstName: <form:input path="firstName"/> <br />
    LastName: <form:input path="lastName"/> <br />
    <input type="submit" value="Zapisz">

</form:form>