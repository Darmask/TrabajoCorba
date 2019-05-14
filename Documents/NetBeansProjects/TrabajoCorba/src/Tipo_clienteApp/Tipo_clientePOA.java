package Tipo_clienteApp;



public abstract class Tipo_clientePOA extends org.omg.PortableServer.Servant
 implements Tipo_clienteApp.Tipo_clienteOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarTipo_cliente", new java.lang.Integer (0));
    _methods.put ("actualizarTipo_cliente", new java.lang.Integer (1));
    _methods.put ("eliminarTipo_cliente", new java.lang.Integer (2));
    _methods.put ("shutdown", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Tipo_clienteApp/Tipo_cliente/insertarTipo_cliente
       {
         String tipo = in.read_wstring ();
         boolean $result = false;
         $result = this.insertarTipo_cliente (tipo);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // Tipo_clienteApp/Tipo_cliente/actualizarTipo_cliente
       {
         String tipo = in.read_wstring ();
         boolean $result = false;
         $result = this.actualizarTipo_cliente (tipo);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // Tipo_clienteApp/Tipo_cliente/eliminarTipo_cliente
       {
         int id_tipo = in.read_long ();
         boolean $result = false;
         $result = this.eliminarTipo_cliente (id_tipo);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // Tipo_clienteApp/Tipo_cliente/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Tipo_clienteApp/Tipo_cliente:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Tipo_cliente _this() 
  {
    return Tipo_clienteHelper.narrow(
    super._this_object());
  }

  public Tipo_cliente _this(org.omg.CORBA.ORB orb) 
  {
    return Tipo_clienteHelper.narrow(
    super._this_object(orb));
  }


} // class Tipo_clientePOA
