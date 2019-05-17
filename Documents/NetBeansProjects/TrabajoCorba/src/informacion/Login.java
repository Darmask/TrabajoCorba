package informacion;

/**
 *
 * @author Felipe Gutierrez
 */
public class Login {
    private String usuario;
    
    //constructor
    public Login(String usuario){
        this.setUsuario(usuario);
        
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
