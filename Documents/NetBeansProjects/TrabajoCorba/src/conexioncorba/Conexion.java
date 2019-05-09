
package conexioncorba;


import java.sql.*;
/**
 *
 * @author Tamayo
 */
public class Conexion {
    public Connection conex;
    
    public Connection conectar(){
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7291210","sql7291210","Yk8GiM2xwf");
            System.out.println("La conexion se realizo con exito");
        } catch (Exception e) {
            System.out.println("No fue posible la conexion." + e.getMessage());
        }
        return conex;
        
    }
    
    
}
