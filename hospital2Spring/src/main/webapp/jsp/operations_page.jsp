<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
	<jsp:include page="header.jsp" />
	
	<form style="padding-left: 30px; width: 400px;" method="POST" action="/doctor/operations/find">	
		<h1><fmt:message key="Operations"/></h1>
		<label for="exampleFormControlInput1"><fmt:message key="Room"/></label>
		<input name="room" required pattern="^[ 0-9]+$" type="text" class="form-control" value="${patient.room}" id="exampleFormControlInput1" >
		<label for="exampleFormControlInput1"><fmt:message key="Name"/></label>
		<input name="name" required type="text" class="form-control" value="${patient.name}" id="exampleFormControlInput1" >
		<label for="exampleFormControlInput1"><fmt:message key="Surname"/></label>
		<input name="surname" required type="text" class="form-control" value="${patient.surname}" id="exampleFormControlInput1" >
		<br> 
        <input type="submit" value="<fmt:message key="find"/>"> ${msg }
    </form><br>
				<form style="padding-left: 30px; width: 400px;" method="POST" action="/doctor/operations/find/note">
				<fmt:message key="Operation"/>: <c:out value="${diagnosis.operations}"/> <br> <br>
				<label for="exampleFormControlInput1"><fmt:message key="Commentary"/></label>
	    		<textarea name="commentary" required class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea> 
		        <br>
		        <input type="submit" value="<fmt:message key="operate"/>">
					<p style="display: none;"><textarea name="room" cols="40" rows="3" style="resize: none; height: 15px;">${patient.room}</textarea></p>
			        <input style="display: none;"type="text" value="${patient.name}" name="name">
			        <input style="display: none;"type="text" value="${patient.surname}" name="surname">
	    	  	</form>
   
</body>
</html>