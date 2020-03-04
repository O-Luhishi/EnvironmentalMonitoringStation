package ClientAndServer;

/**
 * Generated from IDL alias "Log_of_alarm_readings".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 04-Mar-2020 19:25:35
 */

public final class Log_of_alarm_readingsHolder
	implements org.omg.CORBA.portable.Streamable
{
	public ClientAndServer.NoxReading[] value;

	public Log_of_alarm_readingsHolder ()
	{
	}
	public Log_of_alarm_readingsHolder (final ClientAndServer.NoxReading[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return Log_of_alarm_readingsHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = Log_of_alarm_readingsHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		Log_of_alarm_readingsHelper.write (out,value);
	}
}
