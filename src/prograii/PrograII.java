
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
    
}
class Boleta extends DocTributario{
    
}
class Factura extends DocTributario{
    
}

class Cliente{
    
}
class Direccion{
    
}

class Articulo{
    
}

class DetalleOrden{

}

class OrdenCompra{
    
}



public class PrograII {

    public static void main(String[] args) {
       
    }
    
}
