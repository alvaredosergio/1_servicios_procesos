// Objeto Producto
public class Producto {
    // Cantidad de productos que tenemos, precio del producto
    private int cantidad;
    private float precio;
    // Constructor estableciendo Cantidad a 100, y Precio inicial a 10
    public Producto() {
        this.cantidad = 100;
        this.precio = 10;
    }
    // Get Cantidad
    public int getCantidad() {
        return cantidad;
    }
    // Creamos un setCantidad nuevo, aumentando 1 cada vez, cantidad++
    public void aumentarCantidad(){
        cantidad++;
    }
    // Creamos un setCantidad nuevo, disminuyendo 1 cada vez, cantidad--
    public void disminuirCantidad(){
        cantidad--;
    }
    // getPrecio será en función a la cantidad de existencias que tenemos
    public float getPrecio() {
        if(cantidad >= 50){
            precio = 10;
        } else if(cantidad < 50){
            precio = 12;
        }else if (cantidad <= 10){
            precio = 15;
        }
        return precio;
    }

    // setPrecio estandar
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
