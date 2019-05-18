package proveedores;

/**
 *
 * @author Tamayo
 */
public class productoCombo {
    int id;
    String nombre_producto;
    
    public productoCombo(int id , String nombre_producto){
    this.setId(id);
    this.setNombre_producto(nombre_producto);
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    //METODO PARA MOSTRAR EL CAMPO NOMBRE EN COMBO
    public String toString(){
        return nombre_producto;
    }
    
}
