<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap.css' />"> --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul  class="navbar-nav mr-auto">
      <li style="width: auto;" class="nav-item dropdown">
         <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <Strong><fmt:message key="For_Admin"/></Strong>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/admin/change_doctor"><fmt:message key="Change_doctor"/></a>
          <a class="dropdown-item" href="/admin/discharge"><fmt:message key="Discharge_patient"/></a>
          <a class="dropdown-item" href="/admin/create"><fmt:message key="Create_worker"/></a>
        </div>
      </li>
      <li style="width: auto;" class="nav-item dropdown">
         <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <Strong><fmt:message key="For_Doctor"/></Strong>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/doctor/diagnosis"><fmt:message key="Make/edit_diagnosis"/></a>
          <a class="dropdown-item" href="/doctor/operations"><fmt:message key="Operations"/></a>
        </div>
      </li>
      <li style="width: auto;" class="nav-item">
        <a class="nav-link" href="/procedures_medicines"><fmt:message key="Procedures_and_medicines"/></a>
      </li>
      <li style="width: auto;" class="nav-item">
        <a class="nav-link" href="/journal"><fmt:message key="Show_journal"/></a>
      </li>
       
       <form style="margin-top: 8px; margin-left:1350px; background-color: #f8f9fa; position: absolute;" id="language">
        <select  name="language" onchange="submit()">
       		<option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>  
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>            	                              
            </select>
      </form>
      <p style=" position: absolute; margin-left: 1430px; margin-bottom: 0px;">
        <a class="nav-link" href="/logout"><fmt:message key="Logout"/></a>
      </p>
    </ul>
  </div>
</nav>
</body>
</html>