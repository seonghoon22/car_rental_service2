<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>차량 등록</title>
</head>

<body>
    <nav class="navbar navbar-expand  navbar-dark bg-dark">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="./home">Home</a>
            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">
            	<spring:message code="addCar.form.title.label" /> 
            </h1>
        </div>
    </div>

    <div class="container">
      <div class="float-right">
        <form:form action="${pageContext.request.contextPath}/logout" method="POST"> 
            <input type="submit" class="btn btn-sm btn-success" value="Logout" />
        </form:form>  
    </div>
    <div class="float-right" style="padding-right:30px">  
            <a href="?language=ko" >Korean</a>|<a href="?language=en">English</a>
    </div>  
        
    <br><br>
       <form:form modelAttribute = "NewCar" 
       action="./add?${_csrf.parameterName}=${_csrf.token}"
       class="form-horizontal" 
       enctype="multipart/form-data">
        <fieldset>
        <legend><spring:message code="addCar.form.subtitle.label" /></legend>
        <div class="form-group row">
            <label class="col-sm-2 control-label">
            	<spring:message code="addCar.form.carId.label" />
            </label>
            <div class="col-sm-3">
                <form:input  path="car_no"  class="form-control"/>  
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label" >
            	<spring:message code="addCar.form.name.label" />
            </label>
            <div class="col-sm-3">
                <form:input  path="model"  class="form-control"/>  
            </div>
        </div>
        <div class="form-group row">
           <label class="col-sm-2 control-label" >
           		<spring:message code="addCar.form.unitPrice.label" /> 
           </label>
           <div class="col-sm-3">
               <form:input  path="model_year" class="form-control"/>  
           </div>
        </div>
        <div class="form-group row">
           <label class="col-sm-2 control-label" >
				<spring:message code="addCar.form.author.label" />
			</label>
           <div class="col-sm-3">
               <form:input  path="price" class="form-control"/>  
           </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label" >
            	<spring:message code="addBook.form.description.label" />
            </label>
            <div class="col-sm-5">    
                <form:textarea  path="imgpath" cols="50" rows="2" class="form-control"/>  
            </div>
        </div>
        
        <div class="form-group row">
            <label class="col-sm-2 control-label" >
            	<spring:message code="addCar.form.condition.label" />
            </label>

        </div>
        
        <div class="form-group row"> 
        	<label class="col-sm-2 control-label" >
        		<spring:message code="addCar.form.bookImage.label" /> 
        	</label>
        	<div class="col-sm-7">
            	<form:input path="imgpath" type="file" class="form-control" />
        	</div>
     	</div> 
     
        <div class="form-group row">
            <div class="col-sm-offset-2 col-sm-10" >
            <input type="submit" class="btn btn-primary" value ="<spring:message code="addCar.form.button.label" /> "/>
            </div>
        </div>
        </fieldset>
        </form:form>  
        <hr>
    <footer>
        <p>&copy; addCar</p>
    </footer>
    </div>
</body>
</html>