package tarea1p2_emilianourtecho;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto {
    private static int contadorID = 1;
    private String Codigo;
    private int cant;
    private String nombre;
    private int Precio;
    private boolean Estado;
    private String descripcion;
    private String fechaVencimiento;
    private String color;

    public Producto(int cant, String nombre, int Precio, String fechaVencimiento, String Color, String descripcion) {
        SimpleDateFormat fecha = new SimpleDateFormat("yyyyMMdd");
        String fechaActual = fecha.format(new Date());
        this.Codigo = fechaActual + contadorID;
        this.cant = cant;
        this.nombre = nombre;
        this.Precio = Precio;
        this.Estado = true;
        this.color = color;
        this.descripcion = "";
        this.fechaVencimiento = fechaVencimiento;
        contadorID++;
    }

    // GET
    public String ProductoID() {
        return Codigo;
    }

    public int cantidad() {
        return cant;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return Precio;
    }
    
    public String getColor(){
        return color;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getFechaVencimiento(){
        return fechaVencimiento;
    }
    
    public boolean Estados() {
        return Estado;
    }

    public void agotado() {
        Estado = false;
    }

    public void disponible() {
        Estado = true;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void setColor (String color){
        this.color = color;   
    }
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setCantidad(int cantidad) {
        this.cant = cantidad;
    }
}
