<%-- 
    Document   : nuevoEmpleado
    Created on : 25 jun. 2024, 08:40:20
    Author     : USER 17
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Nuevo Empleado</title>
        <!-- comment <link type="image/png" sizes="96x96" rel="icon" href=".../icons8-añadir-usuario-masculino-96.png">-->
        <script src="https://kit.fontawesome.com/be423ee65b.js" crossorigin="anonymous"></script>
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            margin-bottom: 20px;
            color: #333333;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 14px;
            transition: background-color 0.3s ease;
            margin: 5px 0; /* Espacio entre botones cuando están apilados verticalmente */
            text-align: center;
            box-sizing: border-box;
        }

        .button:hover {
            background-color: #45a049;
        }

        .cancel-button {
            background-color: #f44336;
        }

        .cancel-button:hover {
            background-color: #e53935;
        }

        .regresar-button {
            background-color: #2196F3;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            transition: background-color 0.3s ease;
            margin-top: 20px;
        }

        .regresar-button:hover {
            background-color: #1976D2;
        }

        table {
            width: 100%;
            max-width: 800px;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #dddddd;
            box-sizing: border-box;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        /* Estilo para la celda de acciones */
        td.actions {
            text-align: center; /* Centra los botones en la celda */
        }

        td.actions .button {
            display: block; /* Cambia a block para apilar verticalmente */
            width: 100px; /* Ajusta el ancho de los botones */
            margin: 5px auto; /* Espacio entre botones y centrado horizontal */
            box-sizing: border-box;
        }

        /* Ajuste de ancho de columnas */
        th, td {
            min-width: 100px; /* Ancho mínimo para columnas */
        }

        th:nth-child(1), td:nth-child(1) {
            width: 50px; /* Ancho específico para la columna ID */
        }

        th:nth-child(2), td:nth-child(2) {
            width: 150px; /* Ancho específico para la columna Nombre */
        }

        th:nth-child(3), td:nth-child(3) {
            width: 150px; /* Ancho específico para la columna Apellido */
        }

        th:nth-child(4), td:nth-child(4) {
            width: 80px; /* Ancho específico para la columna DNI */
        }

        th:nth-child(5), td:nth-child(5) {
            width: 150px; /* Ancho específico para la columna Acciones */
        }
    </style>
</head>
<body>
   <h1>Clientes</h1>
    <form action="cliente" method="post">
        ID: <input type="text" name="id">
        DNI: <input type="text" name="dni">
        Nombre: <input type="text" name="nombre">
        Apellido: <input type="text" name="apellido">
        <input type="submit" value="Agregar Cliente">
    </form>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="cliente" items="${clientes}">
            <tr>
                <td>${cliente.id}</td>
                <td>${cliente.dni}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.apellido}</td>
                <td>
                    <form action="cliente" method="post">
                        <input type="hidden" name="_method" value="put">
                        <input type="hidden" name="id" value="${cliente.id}">
                        DNI: <input type="text" name="dni" value="${cliente.dni}">
                        Nombre: <input type="text" name="nombre" value="${cliente.nombre}">
                        Apellido: <input type="text" name="apellido" value="${cliente.apellido}">
                        <input type="submit" value="Actualizar">
                    </form>
                    <form action="cliente" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="hidden" name="id" value="${cliente.id}">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>