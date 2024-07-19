/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FABIAN
 */
@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM producto");
            ResultSet resultSet = statement.executeQuery();

            List<Producto> productos = new ArrayList<>();
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getString("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getString("precio"));
                productos.add(producto);
            }

            request.setAttribute("productos", productos);
            request.getRequestDispatcher("/productos.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener productos");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO producto (id, nombre, precio) VALUES (?, ?, ?)");
            statement.setString(1, id);
            statement.setString(2, nombre);
            statement.setString(3, precio);
            statement.executeUpdate();
            response.sendRedirect("producto");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar producto");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE producto SET nombre=?, precio=? WHERE id=?");
            statement.setString(1, nombre);
            statement.setString(2, precio);
            statement.setString(3, id);
            statement.executeUpdate();
            response.sendRedirect("producto");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar producto");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM producto WHERE id=?");
            statement.setString(1, id);
            statement.executeUpdate();
            response.sendRedirect("producto");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar producto");
        }
    }
}
