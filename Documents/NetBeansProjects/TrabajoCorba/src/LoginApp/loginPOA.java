package LoginApp;


/**
* LoginApp/loginPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from login.idl
* lunes 20 de mayo de 2019 07:02:15 PM COT
*/

public abstract class loginPOA extends org.omg.PortableServer.Servant
 implements LoginApp.loginOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarLogin", new java.lang.Integer (0));
    _methods.put ("actualizarLogin", new java.lang.Integer (1));
    _methods.put ("eliminarLogin", new java.lang.Integer (2));
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
       case 0:  // LoginApp/login/insertarLogin
       {
         String usuario = in.read_wstring ();
         String contrasena = in.read_wstring ();
         boolean $result = false;
         $result = this.insertarLogin (usuario, contrasena);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // LoginApp/login/actualizarLogin
       {
         String usuario = in.read_wstring ();
         String contrasena = in.read_wstring ();
         boolean $result = false;
         $result = this.actualizarLogin (usuario, contrasena);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // LoginApp/login/eliminarLogin
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.eliminarLogin (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // LoginApp/login/shutdown
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
    "IDL:LoginApp/login:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public login _this() 
  {
    return loginHelper.narrow(
    super._this_object());
  }

  public login _this(org.omg.CORBA.ORB orb) 
  {
    return loginHelper.narrow(
    super._this_object(orb));
  }


} // class loginPOA
