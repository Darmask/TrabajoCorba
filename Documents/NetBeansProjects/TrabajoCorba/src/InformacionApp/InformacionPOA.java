package InformacionApp;


/**
* InformacionApp/InformacionPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from informacion.idl
* s�bado 18 de mayo de 2019 17H33' COT
*/

public abstract class InformacionPOA extends org.omg.PortableServer.Servant
 implements InformacionApp.InformacionOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarInformacion", new java.lang.Integer (0));
    _methods.put ("actualizarInformacion", new java.lang.Integer (1));
    _methods.put ("eliminarInformacion", new java.lang.Integer (2));
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
       case 0:  // InformacionApp/Informacion/insertarInformacion
       {
         String nombre = in.read_wstring ();
         String apellido = in.read_wstring ();
         String estado = in.read_wstring ();
         int id_usuario = in.read_long ();
         boolean $result = false;
         $result = this.insertarInformacion (nombre, apellido, estado, id_usuario);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // InformacionApp/Informacion/actualizarInformacion
       {
         String nombre = in.read_wstring ();
         String apellido = in.read_wstring ();
         String estado = in.read_wstring ();
         int id_usuario = in.read_long ();
         boolean $result = false;
         $result = this.actualizarInformacion (nombre, apellido, estado, id_usuario);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // InformacionApp/Informacion/eliminarInformacion
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.eliminarInformacion (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // InformacionApp/Informacion/shutdown
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
    "IDL:InformacionApp/Informacion:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Informacion _this() 
  {
    return InformacionHelper.narrow(
    super._this_object());
  }

  public Informacion _this(org.omg.CORBA.ORB orb) 
  {
    return InformacionHelper.narrow(
    super._this_object(orb));
  }


} // class InformacionPOA
