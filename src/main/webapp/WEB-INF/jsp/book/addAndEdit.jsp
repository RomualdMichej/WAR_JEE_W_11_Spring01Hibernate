<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>


<h2>DODAWANIE NOWEJ KSIAZKI</h2>


<form:form method="post"
           modelAttribute="book">

    <form:hidden path="id"/> <br />
    Title: <form:input path="title"/> <br />
    Rating: <form:input path="rating"/> <br />
    Description: <form:input path="description"/> <br />
    Publisher:
    <form:select path="publisher.id" items="${allPublishers}"
                 itemLabel="name" itemValue="id"/>
    <br />
    Authors:
    <form:select path="authorList" items="${allAuthors}"
                 itemLabel="fullName" itemValue="id" multiple="true"/>
    <br />

    <input type="submit" value="Zapisz!"/>

</form:form>