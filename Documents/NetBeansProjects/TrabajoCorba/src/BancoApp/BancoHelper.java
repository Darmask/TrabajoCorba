package BancoApp;


/**
* BancoApp/BancoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banco.idl
* martes 7 de mayo de 2019 11:06:32 AM COT
*/

abstract public class BancoHelper
{
  private static String  _id = "IDL:BancoApp/Banco:1.0";

  public static void insert (org.omg.CORBA.Any a, BancoApp.Banco that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static BancoApp.Banco extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (BancoApp.BancoHelper.id (), "Banco");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static BancoApp.Banco read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BancoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, BancoApp.Banco value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static BancoApp.Banco narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BancoApp.Banco)
      return (BancoApp.Banco)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BancoApp._BancoStub stub = new BancoApp._BancoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static BancoApp.Banco unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BancoApp.Banco)
      return (BancoApp.Banco)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BancoApp._BancoStub stub = new BancoApp._BancoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
