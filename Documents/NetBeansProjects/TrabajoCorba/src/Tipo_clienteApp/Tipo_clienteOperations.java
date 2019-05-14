package Tipo_clienteApp;


public interface Tipo_clienteOperations 
{
  boolean insertarTipo_cliente (String tipo);
  boolean actualizarTipo_cliente (String tipo);
  boolean eliminarTipo_cliente (int id_tipo);
  void shutdown ();
} // interface Tipo_clienteOperations
