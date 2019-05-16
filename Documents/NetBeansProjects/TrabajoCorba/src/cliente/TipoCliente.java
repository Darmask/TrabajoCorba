package cliente;

/**
 *
 * @author Felipe Gutierrez
 */

public class TipoCliente {
    private int id_tipo;
    private String tipo;
    
    //constructor
    public TipoCliente(int id_tipo,String tipo){
        this.setId_tipo(id_tipo);
        this.setTipo(tipo);
        
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    //METODO PARA MOSTRAR EL CAMPO NOMBRE EN COMBO
    public String toString(){
        return tipo;
    }
}
