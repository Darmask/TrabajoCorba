package proveedores;

/**
 *
 * @author Tamayo
 */
public class marca {

    int id ;
    String marca;
    
    //constructor
    public marca(int id,String marca){
       this.setId(id);
        this.setMarca(marca);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    //METODO PARA MOSTRAR EL CAMPO NOMBRE EN COMBO
    public String toString(){
        return marca;
    }
    
}
