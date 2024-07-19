/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Cliente {
    private String id;
    private String dni;
    private String apellido;
    private String nombre;

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public String toCSV() {
        return String.join(",", id,dni, nombre, apellido);
    }

    public static Cliente fromCSV(String csv) {
        String[] parts = csv.split(",");
        Cliente cliente = new Cliente();
        cliente.setId(parts[0]);
        cliente.setDni(parts[1]);
        cliente.setNombre(parts[2]);
        cliente.setApellido(parts[3]);
        return cliente;
    }
}