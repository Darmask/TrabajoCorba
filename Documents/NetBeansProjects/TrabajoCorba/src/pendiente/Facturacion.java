package pendiente;

/**
 *
 * @author Felipe Gutierrez
 */
public class Facturacion {
    private int id;
    private String fecha_venta;
    
    //constructor
    public Facturacion(int id,String fecha_venta){
        this.setId(id);
        this.setFecha_venta(fecha_venta);
        
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    //METODO PARA MOSTRAR EL CAMPO NOMBRE EN COMBO
    public String toString(){
        return fecha_venta;
    }
    
}
