<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Paciente</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            </head>

            <body>
                <h1 style="text-align: center"> Por favor ingrese sus datos de Paciente </h1>

                <div class="container">
                    <c:if test="${msgError!= null}">
                        <c:out value="${msgError}"></c:out>
                    </c:if>
                    <form:form action="/paciente/guardar" method="post" modelAttribute="paciente">
                        <form:label path="rut" class="form-label">Rut:</form:label>
                        <form:input path="rut" class="form-control" placeholder="1111111-1"/>
                        <br>
                        <form:label path="nombre" class="form-label">Nombre:</form:label>
                        <form:input path="nombre" class="form-control" />
                        <br>
                        <form:label path="fecha_nacimiento" class="form-label">Fecha de nacimiento:</form:label>
                        <form:input type="date" path="fecha_nacimiento" class="form-control" />
                        <br>
                        <input type="submit" value="Guardar Datos">
                    </form:form>
                </div>
            </body>

            </html>