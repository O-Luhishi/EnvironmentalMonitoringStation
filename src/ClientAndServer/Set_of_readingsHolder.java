package ClientAndServer;

/**
 * Generated from IDL alias "Set_of_readings".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 04-Mar-2020 17:25:02
 */

public final class Set_of_readingsHolder
	implements org.omg.CORBA.portable.Streamable
{
	public ClientAndServer.NoxReading[] value;

	public Set_of_readingsHolder ()
	{
	}
	public Set_of_readingsHolder (final ClientAndServer.NoxReading[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return Set_of_readingsHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = Set_of_readingsHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		Set_of_readingsHelper.write (out,value);
	}
}
