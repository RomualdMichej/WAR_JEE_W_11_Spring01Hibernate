<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="student">

    First name:
    <form:input path="firstName" />
    <br />

    Last name:
    <form:input path="lastName" />
    <br />

    Gender:
    M: <form:radiobutton path="gender" value="M" />
    K: <form:radiobutton path="gender" value="K" />
    <br />

    Country:
    <form:select path="country" items="${countries}" />
    <br />

    Notes:
    <form:textarea path="notes" rows="3" cols="20" />
    <br />

    Mailing list:
    <form:checkbox path="mailingList" />
    <br />

    ProgrammingSkills:
    <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/>
    <br />

    Hobbies:
    <form:checkboxes path="hobbies" items="${hobbies}" />

    <input type="submit" value="Wyslij">


</form:form>