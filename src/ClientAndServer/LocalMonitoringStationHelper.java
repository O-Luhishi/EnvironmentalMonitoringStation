package ClientAndServer;


/**
 * Generated from IDL interface "LocalMonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 08-Mar-2020 16:46:37
 */

public abstract class LocalMonitoringStationHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(LocalMonitoringStationHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:ClientAndServer/LocalMonitoringStation:1.0", "LocalMonitoringStation");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final ClientAndServer.LocalMonitoringStation s)
	{
			any.insert_Object(s);
	}
	public static ClientAndServer.LocalMonitoringStation extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:ClientAndServer/LocalMonitoringStation:1.0";
	}
	public static LocalMonitoringStation read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(ClientAndServer._LocalMonitoringStationStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final ClientAndServer.LocalMonitoringStation s)
	{
		_out.write_Object(s);
	}
	public static ClientAndServer.LocalMonitoringStation narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.LocalMonitoringStation)
		{
			return (ClientAndServer.LocalMonitoringStation)obj;
		}
		else if (obj._is_a("IDL:ClientAndServer/LocalMonitoringStation:1.0"))
		{
			ClientAndServer._LocalMonitoringStationStub stub;
			stub = new ClientAndServer._LocalMonitoringStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static ClientAndServer.LocalMonitoringStation unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.LocalMonitoringStation)
		{
			return (ClientAndServer.LocalMonitoringStation)obj;
		}
		else
		{
			ClientAndServer._LocalMonitoringStationStub stub;
			stub = new ClientAndServer._LocalMonitoringStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
