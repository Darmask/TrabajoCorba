package LoginApp;


/**
* LoginApp/loginOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from login.idl
* viernes 17 de mayo de 2019 09:53:45 PM COT
*/

public interface loginOperations 
{
  boolean insertarLogin (String usuario, String contrasena);
  boolean actualizarLogin (String usuario, String contrasena);
  boolean eliminarLogin (int id);
  void shutdown ();
} // interface loginOperations
