
package prograii;


import java.util.*;


class Pago{
    private float monto;
    private Date fecha;
    private float deuda;
    public Pago(float mon, Date fec, float deud){
        monto = mon;
        fecha = fec;
        deuda = deud;
    }
    public float getMonto(){
        return monto;
    }
    public float getDeuda(){
        return deuda;
    }
    public Date getFecha(){
        return fecha;
    }
    public float pagar(){
        if(deuda<monto) deuda = 0;
        if(deuda>=monto) deuda = deuda - monto;
        return deuda;
    }
}
class Efectivo extends Pago{
     public Efectivo(float monto, Date fecha, float deuda){
         super(monto, fecha, deuda);
     }
     
    public float calcDevolucion(){
        if(super.getMonto()<=super.getDeuda()) return 0;
        float dev = super.getMonto()-super.getDeuda();
        return dev;
    }
    
    public float pagar(){
        return super.pagar();
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    public Transferencia(float monto, Date fecha, float deuda, String banc,
            String num){
         super(monto, fecha, deuda);
         banco = banc;
         numCuenta = num;
     }
    public float pagar(){
        return super.pagar();
    }
    
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(float monto, Date fecha, float deuda, String tip, String num){
         super(monto, fecha, deuda);
         numTransaccion = num;
         tipo = tip;
     }
    public float pagar(){
        return super.pagar();
    }
    
    
}

class DocTributario {
    private String numero;
    private String rut;
    private Date fecha;
    private Direccion direccion;
    public DocTributario(String num, String r, Date fec, Direccion dir){
        numero = num;
        rut = r;
        fecha = fec;
        direccion = dir;
    }
        
}
class Boleta extends DocTributario{
    public Boleta(String numero, String rut, Date fecha, Direccion direccion){
        super(numero, rut, fecha, direccion);
    }
    
    
}
class Factura extends DocTributario{
    public Factura(String numero, String rut, Date fecha, Direccion direccion){
        super(numero, rut, fecha, direccion);
    }
    
}

class Cliente{
    private String nombre;
    private String rut;
    private Direccion direccion;
    public Cliente(String nom, String r, String dir){
        nombre = nom;
        rut = r;
        direccion = new Direccion(dir);
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public Direccion getDireccion(){
        return direccion;
    }
    
    
}
class Direccion{
    private String direccion;
    public Direccion(String dir){
        direccion = dir;
    }
    public String getDireccion(){
        return direccion;
    }
}

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    public Articulo(float pes, String nombr, String descr, float prec){
       peso = pes;
       nombre = nombr;
       descripcion = descr;
       precio = prec;
    }
    public float getPeso(){
        return peso;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public float getPrecio(){
        return precio;
    }
    
}

class DetalleOrden{
    private float deuda;
    private ArrayList<Articulo> lista;
    private int cantidad;
    public DetalleOrden(){
        cantidad = 0;
        lista = new ArrayList<Articulo>();
    }
    public void addArticulo(Articulo art){
        lista.add(art);
        cantidad = lista.size();
    }
    public float calcPrecio(){
        float precio = 0;
        for(int i=0; i<cantidad-1; ++i){
             precio = precio + lista.get(i).getPrecio();
        }
        deuda = precio;
        return precio;
    }
    
    public float calcIVA(){
        float precio = calcPrecio();
        float IVA = (float) ((precio * 0.19)/1.19);
        return IVA;
    }
    public float calcPrecioSinIVA(){
        float precio = calcPrecio();
        float IVA = calcIVA();
        float siniva = (float) ((precio - IVA));
        return siniva;
    }
    
    public float calcPeso(){
        float peso = 0;
        for(int i=0; i<cantidad-1; ++i){
             peso = peso + lista.get(i).getPeso();
        }
        return peso;
    }

}

class OrdenCompra{
    private Date fecha;
    private String estado;
    private ArrayList<String> estados;
    private DetalleOrden detalle;
    private Cliente cliente;
    public OrdenCompra(){
        fecha = new Date();
        estados = new ArrayList<String>();
        estados.add("Creando/editando pedido");
        estados.add("Pedido creado, obteniendo información del cliente");
        estados.add("Esperando pago");
        estados.add("Pago realizado, compra exitosa");
        estado = estados.get(0);
    }
    
    public void add(Articulo art){
        estado = estados.get(0);
        detalle.addArticulo(art);
    }
    
    public float calcPrecioSinIVA(){
        return detalle.calcPrecioSinIVA();
    }
    
    public float calcIVA(){
        return detalle.calcIVA();
    }
    
    public float calcPrecio(){
        return detalle.calcPrecio();
    }
    
    public float calcPeso(){
        return detalle.calcPeso();
    }
    
    public void infCliente(String nombre, String rut, String direccion){
        estado = estados.get(1);
        cliente = new Cliente(nombre, rut, direccion);
    }
    
    int numPago = 0;
    
    public Boleta crearBoleta(){
        String num = String.valueOf(numPago);
        Boleta boleta = new Boleta(num, cliente.getNombre(), fecha,
        cliente.getDireccion());
        return boleta;
    }
   
    public Factura crearFactura(){
        Factura factura = new Factura(String.valueOf(numPago), cliente.getNombre(), fecha
        ,cliente.getDireccion());
        return factura;
    }
    
    
}



public class PrograII {

    public static void main(String[] args) {
      
    }
    
}
