package BancoApp;


/**
* BancoApp/BancoOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banco.idl
* martes 7 de mayo de 2019 11:06:32 AM COT
*/

public interface BancoOperations 
{
  boolean insertarBanco (String nombre, String estado);
  boolean actualizarBanco (String nombre, String estado);
  boolean eliminarBanco (int id);
  void shutdown ();
} // interface BancoOperations