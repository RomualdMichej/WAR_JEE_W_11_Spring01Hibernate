<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>DODAWANIE PUBLISHERA</h1>

<form:form method="post" modelAttribute="publisher">

    <form:hidden path="id"/> <br />
    Nazwa: <form:input path="name" /> <br />
    <form:errors path="name"/> <br />
    NIP: <form:input path="nip"/> <br />
    <form:errors path="nip"/> <br />
    REGON: <form:input path="regon"/> <br />
    <form:errors path="regon"/> <br />
    <br />
    <input type="submit" value="Zapisz">

</form:form>