<%-- 
    Document   : modificarEmpleado
    Created on : 25 jun. 2024, 08:55:25
    Author     : USER 17
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <script src="https://kit.fontawesome.com/be423ee65b.js" crossorigin="anonymous"></script>
        <title>MODIFICAR EMPLEADO</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                margin: 0;
                padding: 20px; /* Espacio alrededor del contenido */
                background-color: #f0f0f0; /* Fondo gris claro */
            }

            .container {
                max-width: 600px;
                margin: auto;
                background-color: #fff; /* Fondo blanco para el contenedor */
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Sombra ligera */
            }

            form {
                margin-bottom: 20px;
            }

            label {
                display: block;
                margin-bottom: 8px;
                color: #555; /* Color de texto gris */
            }

            input[type="text"],
            input[type="date"],
            button[type="submit"] {
                width: calc(100% - 20px);
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
            }

            .button-container {
                display: flex;
                justify-content: space-between;
            }

            button[type="submit"] {
                background-color: #4a4a4a; /* Fondo gris oscuro */
                color: #fff; /* Color de texto blanco */
                border: none;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.2s ease;
                width: calc(15% - 10px); /* Ajuste de ancho para dos botones en una fila */
            }

            button[type="submit"]:hover {
                background-color: #dc3545; /* Cambio de color al pasar el mouse */
                transform: scale(1.05); /* Efecto de escala al pasar el mouse */
            }

            .back-button {
                background-color: #dc3545; /* Color rojo para el botón de regreso */
                border-color: #dc3545;
                position: relative; /* Posicionamiento relativo para permitir desplazamiento */
               left: 100px; /* Mueve el botón 20px a la derecha */
                bottom: 73px;
            }

            .back-button:hover {
                background-color: #c82333; /* Cambio de color al pasar el mouse */
                border-color: #c82333;
                transform: translateY(-5px); /* Mueve el botón 5px hacia arriba al pasar el mouse */
            }
        </style>
    </head>
    <body>

        <div class="container">
            <h1>MODIFIQUE EL CAMPO QUE DESEA</h1>
            <form action="Servlet?action=update" method="post">
                <label>CODIGO:</label>
                <input type="text" name="codigo" value="${empleado.codigo}" required /><br/>
                <label>NOMBRE:</label>
                <input type="text" name="nombre" value="${empleado.nombre}" required /><br/>
                <label>APELLIDO:</label>
                <input type="text" name="apellido" value="${empleado.apellido}" required /><br/>
                <label>FECHA DE NACIMIENTO:</label>
                <input type="date" name="fechaNacimiento" value="${empleado.fechaNacimiento}" required /><br/>
                <label>FECHA CONTRATACION:</label>
                <input type="date" name="fechaContratacion" value="${empleado.fechaContratacion}" required /><br/>
                <button type="submit"><i class="fa-solid fa-rotate" style="color: #ffffff;"></i></button>
            </form>
            <form action="Servlet?action=list" method="get">
                <button type="submit" class="back-button"><i class="fa-solid fa-angles-left" style="color: #ffffff;"></i></button>
            </form>
        </div>
    </body>
</html>