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
<body style="height: 1000px;">
	<jsp:include page="header.jsp" />
	<div style="display: inline-flex; padding-left: 120px;">
		<form style="padding-left: 30px; width: 400px;" method="POST" action="/doctor/diagnosis/make">
			<h1><fmt:message key="Make_Diagnosis"/></h1>
			<label for="exampleFormControlInput1"><fmt:message key="Room"/></label>
			<input name="room" required pattern="^[ 0-9]+$" type="text" class="form-control" value="${room}" id="exampleFormControlInput1" >
			<label for="exampleFormControlInput1"><fmt:message key="Name"/></label>
			<input name="name" required type="text" class="form-control" value="${name}" id="exampleFormControlInput1" >
			<label for="exampleFormControlInput1"><fmt:message key="Surname"/></label>
			<input name="surname" required type="text" class="form-control" value="${surname}" id="exampleFormControlInput1" >
			<label for="exampleFormControlTextarea1"><fmt:message key="Description"/></label>
    		<textarea name="description" required class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Conclusion"/></label>
    		<textarea name="conclusion" required class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Procedures"/></label>
    		<textarea name="procedures" required class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Medicines"/></label>
    		<textarea name="medicines" required class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Operation"/></label>
    		<textarea name="operation" required class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea> 
	        <br>
	        <input type="submit" value=<fmt:message key="make"/>> <c:out value="${msg1 }"/>       
	    </form>
    
	    <form style="padding-left: 30px; width: 400px;" method="POST" action="/doctor/diagnosis/find">	
			<h1><fmt:message key="Find_Diagnosis"/></h1>
			<label for="exampleFormControlInput1"><fmt:message key="Room"/></label>
			<input name="room" required pattern="^[ 0-9]+$" type="text" class="form-control" value="${patient.room}" id="exampleFormControlInput1" >
			<label for="exampleFormControlInput1"><fmt:message key="Name"/></label>
			<input name="name" required type="text" class="form-control" value="${patient.name}" id="exampleFormControlInput1" >
			<label for="exampleFormControlInput1"><fmt:message key="Surname"/></label>
			<input name="surname" required type="text" class="form-control" value="${patient.surname}" id="exampleFormControlInput1" >
			<br>
			<input type="submit" value="<fmt:message key="find"/>">   <c:out value="${msg }"/>
	    </form>
	   
	    <form style="padding-left: 30px; width: 476px;" method="POST" action="/doctor/diagnosis/edit">
	    	<h1><fmt:message key="Edit_Diagnosis"/></h1>
			<p><textarea style="display:none;" name="room" cols="40" rows="3" style="resize: none; height: 15px;">${patient.room}</textarea></p>
	        <input style="display:none;" type="text" value="${patient.name}" name="name">
	        <input style="display:none;" type="text" value="${patient.surname}" name="surname">	
			<label for="exampleFormControlTextarea1"><fmt:message key="Description"/></label>
    		<textarea  name="description" required class="form-control" id="exampleFormControlTextarea1" rows="3">${diagnosis.description }</textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Conclusion"/></label>
    		<textarea  name="conclusion" required class="form-control" id="exampleFormControlTextarea1" rows="3">${diagnosis.conclusion }</textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Procedures"/></label>
    		<textarea  name="procedures" required class="form-control" id="exampleFormControlTextarea1" rows="3">${diagnosis.procedures }</textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Medicines"/></label>
    		<textarea  name="medicines" required class="form-control" id="exampleFormControlTextarea1" rows="3">${diagnosis.medicines }</textarea>  	
			<label for="exampleFormControlTextarea1"><fmt:message key="Operation"/></label>
    		<textarea  name="operation" required class="form-control" id="exampleFormControlTextarea1" rows="3">${diagnosis.operations }</textarea> 
	        <br>
	        <input type="submit" value=<fmt:message key="edit"/>> <c:out value="${msg2 }"/>
	    </form>
    </div>
</body>
</html>