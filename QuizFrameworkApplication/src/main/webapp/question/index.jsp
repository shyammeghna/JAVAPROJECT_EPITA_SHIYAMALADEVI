<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Quiz</h3>
<from method="post" action="${pageContext.request.contextPath }/question">
<ol type="1">
   <c:forEach var="question" items="${questions}">
    <li>
    ${question.content}
    <input type="hidden" name="questionId" value="${question_id }">
    <ol type="a">
    <c:forEach var="answer" items="${question.answers}">
    <li>
       <input type="radio" name="question_${question.id }" values="${answer.id }">
    ${answer.content }</li>
    </c:forEach>
    </ol>
    </li>

  </c:forEach>
</ol>
<input type="submit" value="submit">
</from>

</body>
</html>