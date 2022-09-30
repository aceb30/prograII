
package prograii;


import java.util.*;


class Pago{
    private float monto;
    private Date fecha;
    
    public Pago(){
        
    }
}
class Efectivo extends Pago{
     
    
    public float calcDevolucion(){
        float dev = 0;
        return dev;
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
}

class DocTributario {
    
    private String numero;
    private String rut;
    private Date fecha;
        
}
class Boleta extends DocTributario{
    
}
class Factura extends DocTributario{
    
}

class Cliente{
    
    private OrdenCompra orden;//Sin uso todavia 
    
    public Cliente(String nombre,String rut,String direccion){
        
        this.nombre = nombre;
        this.rut = rut;
        Direccion dir = new Direccion(direccion);
    }
    
    private String nombre;
    private String rut;
    
    
}
class Direccion{
    
    public Direccion(String direccion){
        this.direccion = direccion;
    }
    private String direccion;
}

class Articulo{
    
    public Articulo(float peso,String nombre,String descripcion,float precio){
        
        this.peso = peso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;    
    }
    
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    
}

class DetalleOrden{
    
    private Articulo articulos;
    private int cantidad;
    
    public DetalleOrden(int cantidad,Articulo articulos){
        this.articulos =articulos;
        this.cantidad = cantidad;
    }
    
    public float calcPrecio(){
        return null;
    }
    
    public float calcPrecioSinIVA(){
        return null;
    }
    
    public float calcIVA(){
        return null;
    }
    
    public float calcPeso(){
        return null;
    }

}

class OrdenCompra{
     
    private Date fecha;
    private String estado;
    public OrdenCompra(){
        fecha = new Date();
        
    }
}



public class PrograII {

    public static void main(String[] args) {
       
        OrdenCompra orden1= new OrdenCompra();
        Cliente cliente1= new Cliente("Bastian","21.086.950-6","Chiguayante");     
        Articulo jugo = new Articulo(1,"Jugo","sabor naranja", 250);
        Articulo fruta = new Articulo(20,"Manzana","fuji", 1500);
    
        DetalleOrden det1= new DetalleOrden(5,jugo);
        
    }
    
}