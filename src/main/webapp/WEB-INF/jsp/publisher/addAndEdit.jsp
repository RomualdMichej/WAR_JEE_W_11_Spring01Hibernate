<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>DODAWANIE PUBLISHERA</h1>

<form:form method="post" modelAttribute="publisher">

    <form:hidden path="id"/> <br />
    Nazwa: <form:input path="name" />
    <br />
    <input type="submit" value="Zapisz">

</form:form>