package ClientAndServer;


/**
 * Generated from IDL interface "Relay".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 20:05:26
 */

public abstract class RelayHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(RelayHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:ClientAndServer/Relay:1.0", "Relay");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final ClientAndServer.Relay s)
	{
			any.insert_Object(s);
	}
	public static ClientAndServer.Relay extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:ClientAndServer/Relay:1.0";
	}
	public static Relay read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(ClientAndServer._RelayStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final ClientAndServer.Relay s)
	{
		_out.write_Object(s);
	}
	public static ClientAndServer.Relay narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.Relay)
		{
			return (ClientAndServer.Relay)obj;
		}
		else if (obj._is_a("IDL:ClientAndServer/Relay:1.0"))
		{
			ClientAndServer._RelayStub stub;
			stub = new ClientAndServer._RelayStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static ClientAndServer.Relay unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.Relay)
		{
			return (ClientAndServer.Relay)obj;
		}
		else
		{
			ClientAndServer._RelayStub stub;
			stub = new ClientAndServer._RelayStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
