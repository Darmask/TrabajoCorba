package Tipo_pagoApp;

/**
* Tipo_pagoApp/Tipo_pagoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from tipo_pago.idl
* martes 7 de mayo de 2019 12:19:12 PM COT
*/

public final class Tipo_pagoHolder implements org.omg.CORBA.portable.Streamable
{
  public Tipo_pagoApp.Tipo_pago value = null;

  public Tipo_pagoHolder ()
  {
  }

  public Tipo_pagoHolder (Tipo_pagoApp.Tipo_pago initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Tipo_pagoApp.Tipo_pagoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Tipo_pagoApp.Tipo_pagoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Tipo_pagoApp.Tipo_pagoHelper.type ();
  }

}