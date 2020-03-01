<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>DODAWANIE AUTORA</h1>

<form:form method="post" modelAttribute="author">

    <form:hidden path="id"/> <br />
    FirstName: <form:input path="firstName"/> <br />
    <form:errors path="firstName"/> <br />

    LastName: <form:input path="lastName"/> <br />
    <form:errors path="lastName"/> <br />

    PESEL: <form:input path="pesel"/> <br />
    <form:errors path="pesel"/> <br />

    Email: <form:input path="email"/> <br />
    <form:errors path="email"/> <br />

    Rok urodzenia: <form:input path="yearOfBirth"/> <br />
    <form:errors path="yearOfBirth"/> <br />

    <br />
    <input type="submit" value="Zapisz">

</form:form>