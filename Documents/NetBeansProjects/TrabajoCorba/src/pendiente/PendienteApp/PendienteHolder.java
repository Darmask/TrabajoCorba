package PendienteApp;

/**
* PendienteApp/PendienteHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from pendiente.idl
* martes 7 de mayo de 2019 11:54:20 AM COT
*/

public final class PendienteHolder implements org.omg.CORBA.portable.Streamable
{
  public PendienteApp.Pendiente value = null;

  public PendienteHolder ()
  {
  }

  public PendienteHolder (PendienteApp.Pendiente initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PendienteApp.PendienteHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PendienteApp.PendienteHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PendienteApp.PendienteHelper.type ();
  }

}
