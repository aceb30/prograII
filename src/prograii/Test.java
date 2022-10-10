
package prograii;


import java.util.*;


class Pago{
    
    private float monto;
    private Date fecha;
    
    public Pago(int monto){
        
        this.monto = monto;
        fecha = new Date();
    }
}
class Efectivo extends Pago{     
    
    public float calcDevolucion(){
        float dev = 0;
        return dev;
    }    
}

class Transferencia extends Pago{
    
    public Transferencia(float mon , String banco,String numCuenta){
        //No se como arreglar esto de super :(
        //super(float monto);
        //monto = mon;
        this.banco = banco;
        this.numCuenta = numCuenta;
    }
    private String banco;
    private String numCuenta;
    
}

class Tarjeta extends Pago{
    
    private String tipo;
    private String numTransaccion;
    
}

class DocTributario {
    
    OrdenCompra orden;
    private String direccion;
    private String rut;
    private Date fecha;
    
    public DocTributario(String rut,String Direccion,Date fecha){
        
        this.rut = rut;
        this.direccion = direccion;
        this.fecha = fecha;        
    }       
        
}

class Boleta extends DocTributario{
    
}

class Factura extends DocTributario{
    
}

class Cliente{
    
    private OrdenCompra orden;
    private DocTributario documento;
    
    public Cliente(OrdenCompra orden,String nombre,String rut,String direccion){
        
        this.orden = orden;
        this.nombre = nombre;
        this.rut = rut;
        Direccion dir = new Direccion(direccion);
        documento = new DocTributario(rut, direccion, orden.getFecha());
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
    
    private DetalleOrden detalle;
    private Date fecha;
    private String estado;
    
    public OrdenCompra(int cantidad , Articulo articulos){
        
        this.detalle = new DetalleOrden(cantidad, articulos);
        fecha = new Date();
        
    }
    
    public Date getFecha(){
        return this.fecha;
    }
}

public class PrograII {

    public static void main(String[] args) {                      
        
        Articulo jugo = new Articulo(1,"Jugo","sabor naranja", 250);
        Articulo fruta = new Articulo(20,"Manzana","fuji", 1500);           
        
        OrdenCompra orden1= new OrdenCompra(5,jugo);
        
        Cliente cliente1= new Cliente(orden1,"Bastian","21.086.950-6","Chiguayante");
        
        Transferencia t = new Transferencia(100f,"BancoEstado","1312312");
    }
    
}