package InformacionApp;


/**
* InformacionApp/InformacionOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from informacion.idl
* martes 7 de mayo de 2019 11:37:59 AM COT
*/

public interface InformacionOperations 
{
  boolean insertarInformacion (String nombre, String apellido, String estado, String id_estado);
  boolean actualizarBanco (String nombre, String apellido, String estado, String id_estado);
  boolean eliminarBanco (int id);
  void shutdown ();
} // interface InformacionOperations
