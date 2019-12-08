<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div style="padding-left: 30px; width: 430px;">
	<br>
		<button onclick="findAll()"><fmt:message key="All_notes"/></button>
		<button onclick="findMy()"><fmt:message key="My_notes"/></button>
		<button onclick="myFunctionSearch()"><fmt:message key="Find_notes"/></button><br><br>
		
			<label for="exampleFormControlInput1"><fmt:message key="Room"/></label>
			<input id="room" name="room" required pattern="^[ 0-9]+$" type="text" class="form-control" value="${room}" id="exampleFormControlInput1" >
			<label for="exampleFormControlInput1"><fmt:message key="Name"/></label>
			<input id="name" name="name" required type="text" class="form-control" value="${name}" id="exampleFormControlInput1" >
			<label for="exampleFormControlInput1"><fmt:message key="Surname"/></label>   
			<input id="surname" name="surname" required type="text" class="form-control" value="${surname}" id="exampleFormControlInput1" >
			<br>
		<button onclick="get()"><fmt:message key="sort"/> ↓/↑</button> <br><br>
		<p id="demo"></p>
	</div>
	
	<script type="text/javascript">
function findAll() {
    //function which send ajax request to the server
    $.ajax({
        url : '/journal/all',
        datatype : 'json',
        type : "post",
        contentType : "application/json",
        data : JSON.stringify({
        }),
        success : function(data) {
        	console.log(data);
        	var str = "";
        	for(var i=0; i < data.length; i++) {
        		str += "<div  style=\"width: 400px;\" class=\"alert alert-danger\" role=\"alert\">";
        		str += "Note id = " + data[i].note_id + "<br/>"; 
        		str += "Worker: " + data[i].worker_surname + " " + data[i].worker_name + ", id = " + data[i].worker_id + "<br/>";
        		str += "Patient: " + data[i].patient_surname + " " + data[i].patient_name + ", room = " + data[i].room + "<br/>";
        		str += "Procedures: " + data[i].procedures + "<br/>";
        		str += "Medicines: " + data[i].medicines + "<br/>";
        		str += "Operation: " + data[i].operation + "<br/>";
        		str += "Date/Time: " + data[i].date + "<br/>";
        		str += "Commentary: " + data[i].commentary + "<br/>";
        		str += "</div>";
        	}
        	document.getElementById("demo").innerHTML = str;
        	return data;
        }
    });
    
}
</script>

<script type="text/javascript">
function findMy() {
    //function which send ajax request to the server
    $.ajax({
        url : '/journal/my',
        datatype : 'json',
        type : "post",
        contentType : "application/json",
        data : JSON.stringify({
        }),
        success : function(data) {
        	console.log(data);
        	var str = "";
        	for(var i=0; i < data.length; i++) {
        		str += "<div  style=\"width: 400px;\" class=\"alert alert-danger\" role=\"alert\">";
        		str += "Note id = " + data[i].note_id + "<br/>"; 
        		str += "Worker: " + data[i].worker_surname + " " + data[i].worker_name + ", id = " + data[i].worker_id + "<br/>";
        		str += "Patient: " + data[i].patient_surname + " " + data[i].patient_name + ", room = " + data[i].room + "<br/>";
        		str += "Procedures: " + data[i].procedures + "<br/>";
        		str += "Medicines: " + data[i].medicines + "<br/>";
        		str += "Operation: " + data[i].operation + "<br/>";
        		str += "Date/Time: " + data[i].date + "<br/>";
        		str += "Commentary: " + data[i].commentary + "<br/>";
        		str += "</div>";
        	}
        	document.getElementById("demo").innerHTML = str;
			return data;
        	
        	
        }
    });
    
}
</script>
<script type="text/javascript">
function myFunctionSearch() {
    //function which send ajax request to the server
    $.ajax({
        url : '/journal/find/patient',
        datatype : 'json',
        type : "post", 
        contentType : "application/json; charset=UTF-8",
        data : JSON.stringify({
            room : document.getElementById("room").value,
            worker_name : document.getElementById("name").value,
            worker_surname : document.getElementById("surname").value,
            page : 1
        }),
        success : function(data) {
        	console.log(data);
        	var str = "";
        	for(var i=0; i < data.length; i++) {
        		str += "<div  style=\"width: 400px;\" class=\"alert alert-danger\" role=\"alert\">";
        		str += "Note id = " + data[i].note_id + "<br/>"; 
        		str += "Worker: " + data[i].worker_surname + " " + data[i].worker_name + ", id = " + data[i].worker_id + "<br/>";
        		str += "Patient: " + data[i].patient_surname + " " + data[i].patient_name + ", room = " + data[i].room + "<br/>";
        		str += "Procedures: " + data[i].procedures + "<br/>";
        		str += "Medicines: " + data[i].medicines + "<br/>";
        		str += "Operation: " + data[i].operation + "<br/>";
        		str += "Date/Time: " + data[i].date + "<br/>";
        		str += "Commentary: " + data[i].commentary + "<br/>";
        		str += "</div>";
        	}
        	document.getElementById("demo").innerHTML = str;
			return data;
        	
        	
        }
    });
    
}
</script>
<script type="text/javascript">
function get() {
    //function which send ajax request to the server
    $.ajax({
        url : '/journal/sort',
        datatype : 'json',
        type : "post", 
        contentType : "application/json",
        data :  JSON.stringify({
        }),
        success : function(data) {
        	console.log(data);
        	var str = "";
        	for(var i=0; i < data.length; i++) {
        		str += "<div  style=\"width: 400px;\" class=\"alert alert-danger\" role=\"alert\">";
        		str += "Note id = " + data[i].note_id + "<br/>"; 
        		str += "Worker: " + data[i].worker_surname + " " + data[i].worker_name + ", id = " + data[i].worker_id + "<br/>";
        		str += "Patient: " + data[i].patient_surname + " " + data[i].patient_name + ", room = " + data[i].room + "<br/>";
        		str += "Procedures: " + data[i].procedures + "<br/>";
        		str += "Medicines: " + data[i].medicines + "<br/>";
        		str += "Operation: " + data[i].operation + "<br/>";
        		str += "Date/Time: " + data[i].date + "<br/>";
        		str += "Commentary: " + data[i].commentary + "<br/>";
        		str += "</div>";
        	}
        	document.getElementById("demo").innerHTML = str;
			return data;
        	
        	
        }
    });
    
}
</script>
</body>
</html>