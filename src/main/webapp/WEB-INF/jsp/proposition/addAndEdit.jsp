<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>


<h2>DODAWANIE NOWEJ PROPOZYCJI</h2>


<form:form method="post"
           modelAttribute="proposition">

    <form:hidden path="id"/> <br />
    Title: <form:input path="title"/> <br />
    <form:errors path="title"/> <br />

    Rating: <form:input path="rating"/> <br />
    <form:errors path="rating"/> <br />

    Description: <form:input path="description"/> <br />
    <form:errors path="description"/> <br />

    Publisher:
    <form:select path="publisher.id" items="${allPublishers}"
                 itemLabel="name" itemValue="id"/>
    <br />
    <form:errors path="publisher"/> <br />

    Authors:
    <form:select path="authorList" items="${allAuthors}"
                 itemLabel="fullName" itemValue="id" multiple="true"/>
    <br />
    <form:errors path="authorList"/> <br />

    Pages: <form:input path="pages"/> <br />
    <form:errors path="pages"/> <br />
    <br />

    <form:hidden path="proposition"/> <br />

    <input type="submit" value="Zapisz!"/>

</form:form>