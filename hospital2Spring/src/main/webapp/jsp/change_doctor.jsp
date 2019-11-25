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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
		<form style="padding-left: 30px; width: 300px;" method="POST" action="/admin/change_doctor/change">
		<h3><fmt:message key="Change_doctor"/></h3>
			  <div class="form-group"> 
			    <label for="exampleFormControlInput1"><fmt:message key="Room"/></label>
			    <input name="room" required pattern="^[ 0-9]+$" type="text" class="form-control" value="${room}" id="exampleFormControlInput1" >
			  	<label for="exampleFormControlInput1"><fmt:message key="Name"/></label>
			    <input name="name" required type="text" class="form-control" value="${name}" id="exampleFormControlInput1" >
			  	<label for="exampleFormControlInput1"><fmt:message key="Surname"/></label>
			    <input name="surname" required type="text" class="form-control" value="${surname}" id="exampleFormControlInput1" >
			  	<label><fmt:message key="Select_doctor"/></label> <br>
			  	<select  name ="doctor_id" required>
					<c:forEach var="listOfDoctors" items="${listOfDoctors}">
						<option value="${listOfDoctors.id}">${listOfDoctors.surname} ${listOfDoctors.name}, id = ${listOfDoctors.id}</option>
					</c:forEach> 
				</select> <br> <br>
				<input type="submit" value=<fmt:message key="change"/>> <c:out value="${msg }"/>
			  </div>
	 	 </form>
</body>
</html>