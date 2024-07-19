<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script src="https://kit.fontawesome.com/be423ee65b.js" crossorigin="anonymous"></script>
        <title>LISTA DE EMPLEADOS</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                margin: 0;
                padding: 20px; /* Agregar espacio alrededor del contenido */
                background-color: #f0f0f0; /* Fondo gris claro */
            }

            .container {
                max-width: 800px;
                margin: auto;
                background-color: #fff; /* Fondo blanco para el contenedor */
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Sombra ligera */
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            table th,
            table td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd; /* Borde inferior delgado */
            }

            table th {
                background-color: #f2f2f2; /* Fondo gris claro para las cabeceras */
                color: #333; /* Color de texto gris oscuro */
            }

            table td {
                color: #555; /* Color de texto gris */
            }

            button[type="submit"] {
                background-color:#4a4a4a; 
                padding: 8px 20px;
                margin-right: 8px;
                margin-top: 5px;
                font-size: 14px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            button[type="submit"]:hover {
                background-color: #dc3545; /* Cambio de color al pasar el mouse */
                color: #fff; /* Color de texto blanco */
                transform: scale(1.05); /* Efecto de escala al pasar el mouse */
            }

            .new-employee-button {
                background-color: #dc3545; /* Color verde para el botón 'Nuevo Empleado' */
                color: #fff; /* Color de texto blanco */
                border: none;
                padding: 10px 20px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            .new-employee-button:hover {
                background-color: #dc3545; /* Cambio de color al pasar el mouse */
                transform: scale(1.05); /* Efecto de escala al pasar el mouse */
            }
            .fa-solid{
                top: px;
            }

        </style>
    </head>
    <body>

        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>CODIGO</th>
                        <th>NOMBRES</th>
                        <th>APELLIDOS</th>
                        <th>FECHA NACIMIENTO</th>
                        <th>FECHA CONTARTACION</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Asumiendo que 'empleados' es una lista o colección -->
                    <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <td>${empleado.codigo}</td>
                            <td>${empleado.nombre}</td>
                            <td>${empleado.apellido}</td>
                            <td>${empleado.fechaNacimiento}</td>
                            <td>${empleado.fechaContratacion}</td>
                            <td>
                                <form action="Servlet" method="get">
                                    <input type="hidden" name="action" value="modify" />
                                    <input type="hidden" name="codigo" value="${empleado.codigo}" />
                                    <button type="submit"><i class="fa-regular fa-pen-to-square" style="color: #ffffff;"></i></button>
                                </form>
                                <form action="Servlet" method="get">
                                    <input type="hidden" name="action" value="delete" />
                                    <input type="hidden" name="codigo" value="${empleado.codigo}" />
                                    <button type="submit" ><i class="fa-solid fa-user-xmark" style="color: #ffffff;"></i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="index.jsp" method="get">
                <button class="new-employee-button" type="submit"><i class="fa-solid fa-user-plus" style="color: #ffffff;"></i></button>
            </form>


        </div>
    </body>
</html>