package LoginApp;

/**
* LoginApp/loginHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from login.idl
* lunes 20 de mayo de 2019 07:02:15 PM COT
*/

public final class loginHolder implements org.omg.CORBA.portable.Streamable
{
  public LoginApp.login value = null;

  public loginHolder ()
  {
  }

  public loginHolder (LoginApp.login initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = LoginApp.loginHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    LoginApp.loginHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return LoginApp.loginHelper.type ();
  }

}
