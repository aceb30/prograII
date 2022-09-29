
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
    private String nombre;
    private String rut;
    
}
class Direccion{
    private String direccion;
}

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    
}

class DetalleOrden{

}

class OrdenCompra{
    private Date fecha;
    private String estado;
}



public class PrograII {

    public static void main(String[] args) {
       
    }
    
}
