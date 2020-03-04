package ClientAndServer;

/**
 * Generated from IDL interface "LocalMonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 04-Mar-2020 19:25:35
 */

public final class LocalMonitoringStationHolder	implements org.omg.CORBA.portable.Streamable{
	 public LocalMonitoringStation value;
	public LocalMonitoringStationHolder()
	{
	}
	public LocalMonitoringStationHolder (final LocalMonitoringStation initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return LocalMonitoringStationHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = LocalMonitoringStationHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		LocalMonitoringStationHelper.write (_out,value);
	}
}
