package informacion;

/**
 *
 * @author Felipe Gutierrez
 */
public class Login {
    private int id;
    private String usuario;
    
    //constructor
    public Login(int id,String usuario){
        this.setId(id);
        this.setUsuario(usuario);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    //METODO PARA MOSTRAR EL CAMPO NOMBRE EN COMBO
    public String toString(){
        return usuario;
    }
}
