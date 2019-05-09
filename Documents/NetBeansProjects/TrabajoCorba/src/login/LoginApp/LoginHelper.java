package LoginApp;


/**
* LoginApp/LoginHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Login.idl
* lunes 6 de mayo de 2019 08:02:56 PM COT
*/

abstract public class LoginHelper
{
  private static String  _id = "IDL:LoginApp/Login:1.0";

  public static void insert (org.omg.CORBA.Any a, LoginApp.Login that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static LoginApp.Login extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (LoginApp.LoginHelper.id (), "Login");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static LoginApp.Login read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_LoginStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, LoginApp.Login value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static LoginApp.Login narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof LoginApp.Login)
      return (LoginApp.Login)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      LoginApp._LoginStub stub = new LoginApp._LoginStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static LoginApp.Login unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof LoginApp.Login)
      return (LoginApp.Login)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      LoginApp._LoginStub stub = new LoginApp._LoginStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
