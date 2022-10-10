package prograii;

import java.util.*;

class Pago {

    private float monto;
    private Date fecha;
    private float deuda;

    public Pago(float mon, Date fec, float deud) {
        monto = mon;
        fecha = fec;
        deuda = deud;
    }

    public float getMonto() {
        return monto;
    }

    public float getDeuda() {
        return deuda;
    }

    public Date getFecha() {
        return fecha;
    }

    public float pagar() {
        if (deuda < monto) {
            deuda = 0;
        }
        if (deuda >= monto) {
            deuda = deuda - monto;
        }
        return deuda;
    }
}

class Efectivo extends Pago {

    public Efectivo(float monto, Date fecha, float deuda) {
        super(monto, fecha, deuda);
    }

    public float calcDevolucion() {
        if (super.getMonto() <= super.getDeuda()) {
            return 0;
        }
        float dev = super.getMonto() - super.getDeuda();
        return dev;
    }

    @Override
    public float pagar() {
        return super.pagar();

    }

}

class Transferencia extends Pago {

    private String banco;
    private String numCuenta;

    public Transferencia(float monto, Date fecha, float deuda, String banc,
            String num) {
        super(monto, fecha, deuda);
        banco = banc;
        numCuenta = num;
    }

    @Override
    public float pagar() {
        return super.pagar();

    }

}

class Tarjeta extends Pago {

    private String tipo;
    private String numTransaccion;

    public Tarjeta(float monto, Date fecha, float deuda, String tip, String num) {
        super(monto, fecha, deuda);
        numTransaccion = num;
        tipo = tip;
    }

    @Override
    public float pagar() {
        return super.pagar();

    }

}

class DocTributario {

    private String numero;
    private String rut;
    private Date fecha;
    private Direccion direccion;

    public DocTributario(String num, String r, Date fec, Direccion dir) {
        numero = num;
        rut = r;
        fecha = fec;
        direccion = dir;

    }

}

class Boleta extends DocTributario {

    public Boleta(String numero, String rut, Date fecha, Direccion direccion) {
        super(numero, rut, fecha, direccion);
    }

}

class Factura extends DocTributario {

    public Factura(String numero, String rut, Date fecha, Direccion direccion) {
        super(numero, rut, fecha, direccion);
    }

}

class Cliente {

    private String nombre;
    private String rut;
    private Direccion direccion;

    public Cliente(String nom, String r, String dir) {
        nombre = nom;
        rut = r;
        direccion = new Direccion(dir);
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
    public void addNombre(String nome){
        nombre = nome;
    }
    public void addDireccion(Direccion d){
        direccion  = d;
    }
    public void addRut(String ru){
        rut = ru;
    }

}

class Direccion {

    private String direccion;

    public Direccion(String dir) {
        direccion = dir;
    }

    public String getDireccion() {
        return direccion;
    }
}

class Articulo {

    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;

    public Articulo(float pes, String nombr, String descr, float prec) {
        peso = pes;
        nombre = nombr;
        descripcion = descr;
        precio = prec;
    }

    public float getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

}

class DetalleOrden {

    private float deuda;
    private ArrayList<Articulo> lista;
    private int cantidad;

    public DetalleOrden() {
        cantidad = 0;
        lista = new ArrayList<Articulo>();
    }

    public void addArticulo(Articulo art) {
        lista.add(art);
        cantidad = lista.size();
    }

    public float calcPrecio() {
        float precio = 0;
        for (int i = 0; i < cantidad - 1; ++i) {
            precio = precio + lista.get(i).getPrecio();
        }
        deuda = precio;
        return precio;
    }

    public float calcIVA() {
        float precio = calcPrecio();
        float IVA = (float) ((precio * 0.19) / 1.19);
        return IVA;
    }

    public float calcPrecioSinIVA() {
        float precio = calcPrecio();
        float IVA = calcIVA();
        float siniva = (float) ((precio - IVA));
        return siniva;
    }

    public float calcPeso() {
        float peso = 0;
        for (int i = 0; i < cantidad - 1; ++i) {
            peso = peso + lista.get(i).getPeso();
        }
        return peso;
    }
}

class OrdenCompra {

    private Date fecha;
    private String estado;
    private ArrayList<String> estados;
    private DetalleOrden detalle = new DetalleOrden();
    private Cliente cliente = new Cliente(null, null, null);

    public OrdenCompra() {
        fecha = new Date();
        estados = new ArrayList<>();
        estados.add("Creando/editando pedido");
        estados.add("Pedido creado, obteniendo informacion del cliente");
        estados.add("Esperando pago");
        estados.add("Pago realizado, compra exitosa");
        estado = estados.get(0);
    }

    public void add(Articulo art) {
        estado = estados.get(0);
        detalle.addArticulo(art);
    }

    public float calcPrecioSinIVA() {
        return detalle.calcPrecioSinIVA();
    }

    public float calcIVA() {
        return detalle.calcIVA();
    }

    public float calcPrecio() {
        return detalle.calcPrecio();
    }

    public float calcPeso() {
        return detalle.calcPeso();
    }

    public void infCliente(String nombre, String rut, Direccion direccion) {
        estado = estados.get(1);
        cliente.addDireccion(direccion);
        cliente.addNombre(nombre);
        cliente.addRut(rut);
       
    }

    int numPago = 0;

    public Boleta crearBoleta() {
        String num = String.valueOf(numPago);
        Boleta boleta = new Boleta(num, cliente.getNombre(), fecha,
                cliente.getDireccion());
        return boleta;
    }

    public Factura crearFactura() {
        Factura factura = new Factura(String.valueOf(numPago), cliente.getNombre(), fecha,
                 cliente.getDireccion());
        return factura;
    }

}

public class PrograII {

    public static void main(String[] args) {
       Articulo manzana = new Articulo(1.f, "Manzana", "Roja", 1000.f);
        Articulo cafe = new Articulo(1.f, "Cafe", "Descafeinado", 0.5f);
        Articulo jugo = new Articulo(0.5f, "Jugo", "Naranja", 1700.f);
        Articulo bebida = new Articulo(1.5f, "Bebida", "Sprite", 2000.f);
        Articulo pan = new Articulo(1.f, "Pan", "Marraqueta", 1300.f);
        Articulo arroz = new Articulo(2.f, "Arroz", "Linea 2", 2200.f);

        OrdenCompra orden1 = new OrdenCompra();
        Direccion d1 = new Direccion("Chiguayante");
        Direccion d2 = new Direccion("Chillan");
        orden1.infCliente("Bastian", "21.086.950-6", d1);
        OrdenCompra orden2 = new OrdenCompra();
        orden2.infCliente("Bastian", "21.282.686-3", d2);
        OrdenCompra orden3 = new OrdenCompra();
        orden2.infCliente("Alex", "21.282.686-3", d2);

        orden1.add(bebida);
        orden1.add(manzana);
        orden1.add(arroz);

        orden1.add(bebida);
        orden1.add(jugo);
        orden1.add(pan);

        orden3.add(bebida);
        orden3.add(manzana);
        orden3.add(arroz);
        orden3.add(pan);
        orden3.add(jugo);
        orden3.add(cafe);

        orden1.crearBoleta();
        orden2.crearFactura();

        orden2.crearFactura();

        orden3.crearBoleta();
        orden3.crearBoleta();

        System.out.println(orden1.calcPrecio());
        System.out.println("Orden1 Sin iva " + orden1.calcPrecioSinIVA());
    }
    
}

