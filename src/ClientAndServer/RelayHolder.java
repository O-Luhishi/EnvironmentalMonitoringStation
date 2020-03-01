package ClientAndServer;

/**
 * Generated from IDL interface "Relay".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 18:30:36
 */

public final class RelayHolder	implements org.omg.CORBA.portable.Streamable{
	 public Relay value;
	public RelayHolder()
	{
	}
	public RelayHolder (final Relay initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return RelayHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = RelayHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		RelayHelper.write (_out,value);
	}
}
