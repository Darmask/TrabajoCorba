package InformacionApp;


/**
* InformacionApp/InformacionOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from informacion.idl
* s�bado 18 de mayo de 2019 17H33' COT
*/

public interface InformacionOperations 
{
  boolean insertarInformacion (String nombre, String apellido, String estado, int id_usuario);
  boolean actualizarInformacion (String nombre, String apellido, String estado, int id_usuario);
  boolean eliminarInformacion (int id);
  void shutdown ();
} // interface InformacionOperations
