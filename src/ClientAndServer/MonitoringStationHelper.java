package ClientAndServer;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 20:05:26
 */

public abstract class MonitoringStationHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(MonitoringStationHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:ClientAndServer/MonitoringStation:1.0", "MonitoringStation");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final ClientAndServer.MonitoringStation s)
	{
			any.insert_Object(s);
	}
	public static ClientAndServer.MonitoringStation extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:ClientAndServer/MonitoringStation:1.0";
	}
	public static MonitoringStation read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(ClientAndServer._MonitoringStationStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final ClientAndServer.MonitoringStation s)
	{
		_out.write_Object(s);
	}
	public static ClientAndServer.MonitoringStation narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.MonitoringStation)
		{
			return (ClientAndServer.MonitoringStation)obj;
		}
		else if (obj._is_a("IDL:ClientAndServer/MonitoringStation:1.0"))
		{
			ClientAndServer._MonitoringStationStub stub;
			stub = new ClientAndServer._MonitoringStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static ClientAndServer.MonitoringStation unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.MonitoringStation)
		{
			return (ClientAndServer.MonitoringStation)obj;
		}
		else
		{
			ClientAndServer._MonitoringStationStub stub;
			stub = new ClientAndServer._MonitoringStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
