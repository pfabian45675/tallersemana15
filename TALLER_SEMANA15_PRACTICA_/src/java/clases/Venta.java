/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author FABIAN
 */
public class Venta {
    private String id;
    private String clienteId;
    private String productoId;
    private String cantidad;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    // Métodos para convertir a CSV y desde CSV
    public String toCSV() {
        return String.join(",", id, clienteId, productoId, cantidad);
    }

    public static Venta fromCSV(String csv) {
        String[] parts = csv.split(",");
        Venta venta = new Venta();
        venta.setId(parts[0]);
        venta.setClienteId(parts[1]);
        venta.setProductoId(parts[2]);
        venta.setCantidad(parts[3]);
        return venta;
    }
}
