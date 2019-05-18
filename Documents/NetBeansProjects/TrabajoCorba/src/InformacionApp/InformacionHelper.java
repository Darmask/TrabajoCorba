package InformacionApp;


/**
* InformacionApp/InformacionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from informacion.idl
* s�bado 18 de mayo de 2019 17H33' COT
*/

abstract public class InformacionHelper
{
  private static String  _id = "IDL:InformacionApp/Informacion:1.0";

  public static void insert (org.omg.CORBA.Any a, InformacionApp.Informacion that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static InformacionApp.Informacion extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (InformacionApp.InformacionHelper.id (), "Informacion");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static InformacionApp.Informacion read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_InformacionStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, InformacionApp.Informacion value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static InformacionApp.Informacion narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof InformacionApp.Informacion)
      return (InformacionApp.Informacion)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      InformacionApp._InformacionStub stub = new InformacionApp._InformacionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static InformacionApp.Informacion unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof InformacionApp.Informacion)
      return (InformacionApp.Informacion)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      InformacionApp._InformacionStub stub = new InformacionApp._InformacionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
