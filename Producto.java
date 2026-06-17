public class Producto {
    private String codigo;
    private String nombreProducto;
    private double precio;
    private int stock;

    public void setNombreProducto(String nombre){
        this.nombreProducto = nombre;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException{
        if(precio < 0){
            throw new PrecioInvalidoException("El precio NO puede ser menor que cero(0)");
        } else {
            this.precio = precio;
        } 
    }

    public void setStock(int stock) throws StockInvalidoException{
        if(precio < 0){
            throw new StockInvalidoException("El stock NO puede ser menor que cero(0)");
        } else {
            this.stock = stock;
        }
    }

    public String getNombreProducto(){
        return nombreProducto;
    }

    public String getCodigo(){
        return codigo;
    }

    public double getPrecio(){
        return precio;
    }

    public int getStock(){
        return stock;
    }

    public static void buscarCodigo(Producto [] arreglo, String codigoBuscado){
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i].codigo.equals(codigoBuscado)){
                System.out.printf("Codigo: %s\t\tNombre: %s\t\tPrecio: %f", arreglo[i].codigo, arreglo[i].nombreProducto, arreglo[i].precio);
            }
        }
    }

    public static void imprimirProductos(Producto [] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            System.out.printf("Codigo: %s\t\tNombre: %s\t\tPrecio: %f\t\tStocks: %d\n", arreglo[i].codigo, arreglo[i].nombreProducto, arreglo[i].precio, arreglo[i].stock);
        }
    }

    
}
