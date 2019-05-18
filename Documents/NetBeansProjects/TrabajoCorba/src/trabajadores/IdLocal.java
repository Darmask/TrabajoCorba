package trabajadores;

/**
 *
 * @author Tamayo
 */
public class IdLocal {
    int id;
    String nombre;
    
    public IdLocal(int id , String nombre){
        this.setId(id);
        this.setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //METODO PARA MOSTRAR EL CAMPO NOMBRE EN COMBO
    public String toString(){
        return nombre;
    }
    
    
}
