package ClientAndServer;

/**
 * Generated from IDL struct "NoxReading".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 08-Mar-2020 16:46:37
 */

public final class NoxReadingHolder
	implements org.omg.CORBA.portable.Streamable
{
	public ClientAndServer.NoxReading value;

	public NoxReadingHolder ()
	{
	}
	public NoxReadingHolder(final ClientAndServer.NoxReading initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return ClientAndServer.NoxReadingHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = ClientAndServer.NoxReadingHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		ClientAndServer.NoxReadingHelper.write(_out, value);
	}
}
