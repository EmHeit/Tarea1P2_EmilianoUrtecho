package tarea1p2_emilianourtecho;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarea1P2_EmilianoUrtecho {
    
    static Scanner escan = new Scanner (System.in);
    static ArrayList <Producto> productos = new ArrayList<>();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");    
    
    
    public static void main(String[] args) {
        String eleccionSt;
        eleccionSt = JOptionPane.showInputDialog(null, 
                "       ~MENU~\n "
                + " 1. Agregar Producto\n"
                + " 2. Listar Producto\n"
                + " 3. Buscar Producto\n"
                + " 4. Modificar Producto\n"
                + " 5. Elimminar Producto\n"
                + " 6. SALIR\n"
                + "Usted elija: ");
        
        int eleccionInt = Integer.parseInt(eleccionSt);
        
        do {
            switch(eleccionInt){
                case 1://Agregar Producto
                    AgregarProducto();
                    break;
                case 2://Listar Producto
                    ListarProducto();
                    break;
                case 3://Buscar Producto
                    BuscarProducto();
                    break;
                case 4://Modificar Productoo
                    ModificarProducto();
                    break;
                case 5:// ELiminar Producto
                    EliminarProducto();
                    break;
                case 6://SALIR
                    JOptionPane.showMessageDialog(null, "Esta seguro que quiere salir? Si sale sin guardar se perderan todos sus datos.");
                    JOptionPane.showMessageDialog(null, "Tendra que presionar la tecla 6 otra vez.");
                    break;
                default://Sepa
                    JOptionPane.showMessageDialog(null, "Lo lamento, no puede hacer nada si no presiona las teclas adecuadas.");
                    break;
            }
            
            eleccionSt = JOptionPane.showInputDialog(null, 
                    "       ~MENU~\n "
                    + " 1. Agregar Producto\n"
                    + " 2. Listar Producto\n"
                    + " 3. Buscar Producto\n"
                    + " 4. Modificar Producto\n"
                    + " 5. Elimminar Producto\n"
                    + " 6. SALIR\n"
                    + "Usted elija: ");
            eleccionInt = Integer.parseInt(eleccionSt);
            
        } while (eleccionInt != 6);
        
    }
    
    //Agregar productos
    public static void AgregarProducto() {
    if (productos.size() >= 500) {
        JOptionPane.showMessageDialog(null, "Mis disculpas, pero ya ha alcanzado el máximo de 500 productos agregados");
    } else {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto: ");
        String cantidadSt = JOptionPane.showInputDialog(null, "Ingrese la cantidad que hay en el almacén: ");
        int cantidadInt = Integer.parseInt(cantidadSt);
        String precioSt = JOptionPane.showInputDialog(null, "Ingrese el precio del '" + nombre + "': ");
        int precio = Integer.parseInt(precioSt);
        String fechaVencimiento = JOptionPane.showInputDialog(null, "Ingrese la fecha de vencimiento (dd/MM/yyyy) para el producto '" + nombre + "': ");
        String color = JOptionPane.showInputDialog(null, "Ingrese el color del producto '" + nombre + "': ");
        String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción del producto '" + nombre + "': ");

        Producto producto = new Producto(cantidadInt, nombre, precio, fechaVencimiento, color, descripcion);
        productos.add(producto);

        JOptionPane.showMessageDialog(null, "ID del producto: " + producto.ProductoID());

        JOptionPane.showMessageDialog(null, "El producto se ha ingresado con éxito");
    }
}

    //Listar productos
    public static void ListarProducto(){
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos para enlistar");
        }else{
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                JOptionPane.showMessageDialog(null, "- "+producto);
            }            
        }
    }
    
    //Buscar Productos
    public static void BuscarProducto() {
        String opcion2 = "";
        opcion2 = JOptionPane.showInputDialog(null, "   ~~MENU BUSQUEDA~~\n\n"
                + "1. Buscar Producto por Nombre\n"
                + "2. Buscar Producto por ID\n"
                + "3. Buscar Producto por Color\n"
                + "4. Buscar Producto por Fecha de Vencimiento\n"
                + "5. SALIR\n"
                + "Que desea?:");
        int opcion2Int = Integer.parseInt(opcion2);
        do {
            switch (opcion2Int) {
                case 1:
                    BuscarNombre();
                    break;
                case 2:
                    BuscarID();
                    break;
                case 3:
                    BuscarColor();
                    break;
                case 4:
                    BuscarFechaVencimiento();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Si quiere salir, presione la misma tecla.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Lo siento, no puedo leer eso, presione una tecla válida.");
                    break;
            }

            opcion2 = JOptionPane.showInputDialog(null, "   ~~MENU BUSQUEDA~~\n\n"
                    + "1. Buscar Producto por Nombre\n"
                    + "2. Buscar Producto por ID\n"
                    + "3. Buscar Producto por Color\n"
                    + "4. Buscar Producto por Fecha de Vencimiento\n"
                    + "5. SALIR\n"
                    + "Que desea?:");
            opcion2Int = Integer.parseInt(opcion2);
        } while (opcion2Int != 5);
    }
    public static void BuscarNombre(){
        String nombre = "";
        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto: ");
        boolean estado = false;
        
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado el producto "+ nombre+" !!");
                estado = true;
                break;
            }
        }
        if (!estado) {
            JOptionPane.showMessageDialog(null, "Lo siento, pero no se ha encontrado el producto ("+nombre+")");
        }
        
    }
    public static void BuscarID(){
        
        String IDSt = "";
        IDSt = JOptionPane.showInputDialog(null, "Ingrese el ID del producto: ");
        
        boolean estado = false;
        
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.ProductoID() == IDSt) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado el producto!!");
                estado = true;
                break;
            }
        }
        if (!estado) {
            JOptionPane.showMessageDialog(null, "Lo siento, pero no se ha encontrado el producto");
        }        
    }
    public static void BuscarColor() {
        String color = JOptionPane.showInputDialog(null, "Ingrese el color del producto a buscar: ");
        boolean encontrado = false;

        for (Producto producto : productos) {
            if (producto.getColor().equalsIgnoreCase(color)) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado el producto con el color " + color + ": \n" + producto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningún producto con el color " + color);
        }
    }
    public static void BuscarFechaVencimiento() {
        String fechaVencimiento = JOptionPane.showInputDialog(null, "Ingrese la fecha de vencimiento (dd/MM/yyyy) del producto a buscar: ");
        boolean encontrado = false;

        for (Producto producto : productos) {
            if (producto.getFechaVencimiento().equalsIgnoreCase(fechaVencimiento)) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado el producto con fecha de vencimiento " + fechaVencimiento + ": \n" + producto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningún producto con la fecha de vencimiento " + fechaVencimiento);
        }
    }
    
    //Modificar Productos
    public static void ModificarProducto() {
    if (productos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay productos que modificar");
    } else {
        String opcion3 = JOptionPane.showInputDialog(null, " ~~MENU MODIFICAR~~\n\n"
                + "1. Modificar Nombre\n"
                + "2. Modificar Cantidad de productos\n"
                + "3. Modificar Fecha de Vencimiento\n"
                + "4. Modificar Descripción\n"
                + "5. Modificar Color\n"
                + "6. Modificar Todo\n"
                + "7. NADA\n"
                + "Qué desea hacer: ");
        int opcion3Int = Integer.parseInt(opcion3);
        do {
            switch (opcion3Int) {
                case 1: // Modificar Nombre
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto para modificar: ");
                    ModificarNombre(nombre);
                    break;
                case 2: // Modificar Cantidad de productos
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto para modificar su cantidad: ");
                    ModificarCantidad(nombre);
                    break;
                case 3: // Modificar Fecha de Vencimiento
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto para modificar la fecha de vencimiento (dd/MM/yyyy): ");
                    ModificarFechaVencimiento(nombre);
                    break;
                case 4: // Modificar Descripción
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto para modificar la descripción: ");
                    ModificarDescripcion(nombre);
                    break;
                case 5: // Modificar Color
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto para modificar el color: ");
                    ModificarColor(nombre);
                    break;
                case 6: // Modificar Todo
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto para modificar todo (nombre, cantidad, fecha de vencimiento, descripción y color): ");
                    ModificarTodo(nombre);
                    break;
                case 7: // NADA
                    JOptionPane.showMessageDialog(null, "Si quiere salir, vuelva a presionar la misma tecla.");
                    break;
                default: // SEPA
                    JOptionPane.showMessageDialog(null, "Lo siento, tecla incorrecta. Intente de nuevo...");
                    break;
            }
            opcion3 = JOptionPane.showInputDialog(null, " ~~MENU MODIFICAR~~\n\n"
                    + "1. Modificar Nombre\n"
                    + "2. Modificar Cantidad de productos\n"
                    + "3. Modificar Fecha de Vencimiento\n"
                    + "4. Modificar Descripción\n"
                    + "5. Modificar Color\n"
                    + "6. Modificar Todo\n"
                    + "7. NADA\n"
                    + "Qué desea hacer: ");
            opcion3Int = Integer.parseInt(opcion3);
        } while (opcion3Int != 7);
    }
}    
    public static void ModificarNombre(String nombre){
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos almacenados todavia.");
        }else{
            boolean buscar = false;
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    String nuevoNombre = "";
                    nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto "+ producto.getNombre() +": ");
                    producto.setNombre(nuevoNombre);
                    
                    buscar = true;
                    
                    JOptionPane.showMessageDialog(null, "Se ha cambiado el nombre del producto con exito!!!");
                    break;
                }
            }
            if (!buscar) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado un producto con el nombre de " + nombre);
            }
        }
    }
    public static void ModificarCantidad(String nombre){
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningun producto que modificar");
        }else{
            boolean buscar = false;
            
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    String nuevaCantidad = "";
                    nuevaCantidad = JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad disponible actualmente del procuto"+ producto.getNombre()+": ");
                    int nuevaCantInt = Integer.parseInt(nuevaCantidad);
                    
                    producto.setCantidad(nuevaCantInt);
                    
                    JOptionPane.showMessageDialog(null, "Se ha modificado la cantidad del producto "+ producto.getNombre()+" con exito!!!");
                    buscar = true;
                    break;
                }
            }
            if (!buscar) {
                JOptionPane.showMessageDialog(null, "No se ha ecnontrado ningun producto con el nombre de "+nombre);
            }
        }
    }
    public static void ModificarFechaVencimiento(String nombre) {
    if (productos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay productos almacenados todavía.");
    } else {
        boolean buscar = false;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                String nuevaFechaVencimiento = JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de vencimiento (dd/MM/yyyy) para el producto " + producto.getNombre() + ": ");
                producto.setFechaVencimiento(nuevaFechaVencimiento);
                buscar = true;
                JOptionPane.showMessageDialog(null, "Se ha cambiado la fecha de vencimiento del producto con éxito!!!");
                break;
            }
        }
        if (!buscar) {
            JOptionPane.showMessageDialog(null, "No se ha podido cambiar la fecha de vencimiento, disculpe");
        }
    }
}    
    public static void ModificarDescripcion(String nombre) {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos almacenados todavía.");
        } else {
            boolean buscar = false;
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    String nuevaDescripcion = JOptionPane.showInputDialog(null, "Ingrese la nueva descripción para el producto " + producto.getNombre() + ": ");
                    producto.setDescripcion(nuevaDescripcion);
                    buscar = true;
                    JOptionPane.showMessageDialog(null, "Se ha cambiado la descripción del producto con éxito!!!");
                    break;
                }
            }
                if (!buscar) {
                    JOptionPane.showMessageDialog(null, "No se ha podido cambiar la descripcion del producto, lo siento");
                }
        }
    }
    public static void ModificarColor(String nombre) {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos almacenados todavía.");
        } else {
            boolean buscar = false;
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    String nuevoColor = JOptionPane.showInputDialog(null, "Ingrese el nuevo color para el producto " + producto.getNombre() + ": ");
                    producto.setColor(nuevoColor);
                    buscar = true;
                    JOptionPane.showMessageDialog(null, "Se ha cambiado el color del producto con éxito!!!");
                    break;
                }
            }
            if (!buscar) {
                JOptionPane.showMessageDialog(null, "No se ha podido modificar el color del producto");
            }
        }
    }
    public static void ModificarTodo(String nombre) {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos almacenados todavía.");
        } else {
            boolean buscar = false;
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto " + producto.getNombre() + ": ");
                    String nuevaCantidad = JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad disponible actualmente del producto " + producto.getNombre() + ": ");
                    int nuevaCantidadInt = Integer.parseInt(nuevaCantidad);
                    String nuevaFechaVencimiento = JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de vencimiento (dd/MM/yyyy) para el producto " + producto.getNombre() + ": ");
                    String nuevaDescripcion = JOptionPane.showInputDialog(null, "Ingrese la nueva descripción para el producto " + producto.getNombre() + ": ");
                    String nuevoColor = JOptionPane.showInputDialog(null, "Ingrese el nuevo color para el producto " + producto.getNombre() + ": ");

                    producto.setNombre(nuevoNombre);
                    producto.setCantidad(nuevaCantidadInt);
                    producto.setFechaVencimiento(nuevaFechaVencimiento);
                    producto.setDescripcion(nuevaDescripcion);
                    producto.setColor(nuevoColor);

                    JOptionPane.showMessageDialog(null, "El nombre, cantidad, fecha de vencimiento, descripción y color del producto se han modificado con éxito!!!");
                    buscar = true;
                    break;
                }
            }
            if (!buscar) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado un producto con el nombre de " + nombre);
            }
        }
    }
    
    //Eliminar Productos
    public static void EliminarProducto(){
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos agregados aun");
        }else{
            String nombreElim = "";
            nombreElim =JOptionPane.showInputDialog(null, "Ingrese el nombre del producto que desea eliminar");
            
            boolean buscar = false;
            
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                if (producto.getNombre().equalsIgnoreCase(nombreElim)) {
                    productos.remove(i);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el producto "+ producto.getNombre() +" con exito");
                    buscar = true;
                    break;
                }
            }
            if (!buscar) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado un producto con el nombre de "+nombreElim);
            }
        }
    }
    
}
