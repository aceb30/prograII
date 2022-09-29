
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
    public Cliente(String n,String r,String d){
        nombre = n;
        rut = r;
        Direccion dir = new Direccion(d);
    }
    
    private String nombre;
    private String rut;
    
    
}
class Direccion{
    
    public Direccion(String d){
        direccion=d;
    }
    private String direccion;
}

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    
}

class DetalleOrden{
    
    private int cantidad;
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
    }
    
}