<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>


<form:form method="post"
           modelAttribute="person">

    Login: <br />
    <form:input path="login"/> <br />

    Password: <br />
    <form:password path="password"/> <br />

    Email: <br >
    <form:input path="email"/> <br />

    <input type="submit" value="Wyslij">

</form:form>