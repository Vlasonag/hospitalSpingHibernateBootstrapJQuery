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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap.css' />"> --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
    <div style="padding-top: 150px;padding-left: 550px;" class="col-md-6 login-form-1">
    	<h1 style="width: 500px; padding-left: 138px;"><fmt:message key="login_in"/></h1> 
    	<c:url value="j_spring_security_check" var="loginUrl" />
    		<form style="padding-top: 20px;"  action="${loginUrl}" method="POST">
            	 <div class="form-group">
                 	<input style="width: 400px;" required name="login" type="text" class="form-control" placeholder="Your login" value="" />
            	</div>
            	<div class="form-group">
                	<input style="width: 400px;" required name="password" type="password" class="form-control" placeholder="Your password" value="" />
            	</div>
            	<div class="form-group">
                    <input style="width: 400px;" type="submit" class="btnSubmit" value="<fmt:message key="login"/>" />
                </div>
            </form>
     </div>
</body>
</html>