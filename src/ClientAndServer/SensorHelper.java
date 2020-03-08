package ClientAndServer;


/**
 * Generated from IDL interface "Sensor".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 08-Mar-2020 16:46:37
 */

public abstract class SensorHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(SensorHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:ClientAndServer/Sensor:1.0", "Sensor");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final ClientAndServer.Sensor s)
	{
			any.insert_Object(s);
	}
	public static ClientAndServer.Sensor extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:ClientAndServer/Sensor:1.0";
	}
	public static Sensor read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(ClientAndServer._SensorStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final ClientAndServer.Sensor s)
	{
		_out.write_Object(s);
	}
	public static ClientAndServer.Sensor narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.Sensor)
		{
			return (ClientAndServer.Sensor)obj;
		}
		else if (obj._is_a("IDL:ClientAndServer/Sensor:1.0"))
		{
			ClientAndServer._SensorStub stub;
			stub = new ClientAndServer._SensorStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static ClientAndServer.Sensor unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.Sensor)
		{
			return (ClientAndServer.Sensor)obj;
		}
		else
		{
			ClientAndServer._SensorStub stub;
			stub = new ClientAndServer._SensorStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
