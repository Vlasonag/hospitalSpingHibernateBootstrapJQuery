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
		<form style="padding-left: 30px; width: 300px;" method="POST" action="/admin/create/worker">
		<h3><fmt:message key="Registration"/></h3>
			  <div class="form-group">
			    <label for="exampleFormControlInput1"><fmt:message key="Login"/></label>
			    <input pattern = "[A-Za-z0-9]{6,}" name="login" required type="text" class="form-control" id="exampleFormControlInput1" >
			  	<label  for="exampleFormControlInput1"><fmt:message key="Password"/></label>
			    <input pattern = "[A-Za-z0-9]{6,}" name="password" required type="text" class="form-control" id="exampleFormControlInput1" >
			  	<label for="exampleFormControlInput1"><fmt:message key="Name"/></label>
			    <input name="name" required type="text" class="form-control" id="exampleFormControlInput1">
			  	<label for="exampleFormControlInput1"><fmt:message key="Surname"/></label> 
			    <input name="surname" required type="text" class="form-control" id="exampleFormControlInput1" ><br>
			    <label for="exampleFormControlInput1"><fmt:message key="Role"/></label> 
			  	<select  name ="ROLE" required>
					<option value="ROLE_DOCTOR"><fmt:message key="Doctor"/></option>
					<option value="ROLE_NURSE"><fmt:message key="Nurse"/></option>
				</select> <br> <br>
				<input type="submit" value="<fmt:message key="register"/>"> 
				<h3>${msg}</h3>
			  </div>
	 	 </form>
</body>
</html>