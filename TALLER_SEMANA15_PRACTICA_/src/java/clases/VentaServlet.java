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

@WebServlet("/venta")
public class VentaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM venta");
            ResultSet resultSet = statement.executeQuery();

            List<Venta> ventas = new ArrayList<>();
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setId(resultSet.getString("id"));
                venta.setClienteId(resultSet.getString("cliente_id"));
                venta.setProductoId(resultSet.getString("producto_id"));
                venta.setCantidad(resultSet.getString("cantidad"));
                ventas.add(venta);
            }

            request.setAttribute("ventas", ventas);
            request.getRequestDispatcher("/ventas.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener ventas");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String clienteId = request.getParameter("clienteId");
        String productoId = request.getParameter("productoId");
        String cantidad = request.getParameter("cantidad");

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO venta (id, cliente_id, producto_id, cantidad) VALUES (?, ?, ?, ?)");
            statement.setString(1, id);
            statement.setString(2, clienteId);
            statement.setString(3, productoId);
            statement.setString(4, cantidad);
            statement.executeUpdate();
            response.sendRedirect("venta");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar venta");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String clienteId = request.getParameter("clienteId");
        String productoId = request.getParameter("productoId");
        String cantidad = request.getParameter("cantidad");

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE venta SET cliente_id=?, producto_id=?, cantidad=? WHERE id=?");
            statement.setString(1, clienteId);
            statement.setString(2, productoId);
            statement.setString(3, cantidad);
            statement.setString(4, id);
            statement.executeUpdate();
            response.sendRedirect("venta");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar venta");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM venta WHERE id=?");
            statement.setString(1, id);
            statement.executeUpdate();
            response.sendRedirect("venta");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar venta");
        }
    }
}