package ProveedoresApp;

/**
* ProveedoresApp/ProveedoresHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from proveedores.idl
*/

public final class ProveedoresHolder implements org.omg.CORBA.portable.Streamable
{
  public ProveedoresApp.Proveedores value = null;

  public ProveedoresHolder ()
  {
  }

  public ProveedoresHolder (ProveedoresApp.Proveedores initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ProveedoresApp.ProveedoresHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ProveedoresApp.ProveedoresHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ProveedoresApp.ProveedoresHelper.type ();
  }

}
