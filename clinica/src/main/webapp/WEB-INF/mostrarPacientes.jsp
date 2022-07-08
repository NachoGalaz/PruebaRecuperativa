<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Pacientes</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
            </head>

            <body>
                <h1 style="text-align: center"> Los datos han sido guardados </h1>
                <div class="container">

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Rut</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Fecha de Nacimiento</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="paciente" items="${pacientesCapturados}">
                                <tr>
                                    <th scope="row">${paciente.id}</th>
                                    <td>${paciente.rut}</td>
                                    <td>${paciente.nombre}</td>
                                    <td>${paciente.fecha_nacimiento}</td>
                                    <td><a class="btn btn-warning" href="/paciente/editar/${paciente.id}" role="button">Editar</a></td>
                                    <td><a class="btn btn-danger" href="eliminar/${paciente.id}" role="button">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>