package facturacion;

/**
 *
 * @author Felipe Gutierrez
 */
public class TipoPago {
    private int id;
    private String descripcion;
    
    //constructor
    public TipoPago(int id,String descripcion){
        this.setId(id);
        this.setDescripcion(descripcion);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //METODO PARA MOSTRAR EL CAMPO NOMBRE EN COMBO
    public String toString(){
        return descripcion;
    }
    
}
