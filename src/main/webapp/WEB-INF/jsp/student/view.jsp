<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form method="post" modelAttribute="student">

    First name: ${student.firstName}
    <br />

    Last name: ${student.lastName}
    <br />

    Gender: ${student.gender}
    <br />

    Country: ${student.country}
    <br />

    Notes:
    <form:textarea path="notes" rows="3" cols="20" disabled="true" />
    <br />

    Mailing list: ${student.mailingList}
    <br />

    Programming skills: <br />
    <c:forEach items="${student.programmingSkills}" var="skill">
        ${skill} <br />
    </c:forEach>

    Hobbies: <br />
    <c:forEach items="${student.hobbies}" var="hobby">
        ${hobby} <br />
    </c:forEach>

</form:form>