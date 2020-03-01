<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${empty validationResult}">
        Encja poprawna!
    </c:when>
    <c:otherwise>
        Encja nie poprawna!
    </c:otherwise>
</c:choose>

<br />
<br />

<c:forEach items="${validationResult}" var="validation">
    ${validation.propertyPath} : ${validation.message} <br />
</c:forEach>