/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author FABIAN
 */
public class Producto {
    private String id;
    private String nombre;
    private String precio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

   public String toCSV(){
       return String.join(",", id, nombre, precio);
   }
   
   public static Producto fromCSV(String csv) {
        String[] parts = csv.split(",");
        Producto producto = new Producto();
        producto.setId(parts[0]);
        producto.setNombre(parts[1]);
        producto.setPrecio(parts[2]);
        return producto;
    }

}
