package ClientAndServer;


/**
 * Generated from IDL interface "HeadQuarter".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 08-Mar-2020 16:46:37
 */

public abstract class HeadQuarterHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(HeadQuarterHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:ClientAndServer/HeadQuarter:1.0", "HeadQuarter");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final ClientAndServer.HeadQuarter s)
	{
			any.insert_Object(s);
	}
	public static ClientAndServer.HeadQuarter extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:ClientAndServer/HeadQuarter:1.0";
	}
	public static HeadQuarter read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(ClientAndServer._HeadQuarterStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final ClientAndServer.HeadQuarter s)
	{
		_out.write_Object(s);
	}
	public static ClientAndServer.HeadQuarter narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.HeadQuarter)
		{
			return (ClientAndServer.HeadQuarter)obj;
		}
		else if (obj._is_a("IDL:ClientAndServer/HeadQuarter:1.0"))
		{
			ClientAndServer._HeadQuarterStub stub;
			stub = new ClientAndServer._HeadQuarterStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static ClientAndServer.HeadQuarter unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof ClientAndServer.HeadQuarter)
		{
			return (ClientAndServer.HeadQuarter)obj;
		}
		else
		{
			ClientAndServer._HeadQuarterStub stub;
			stub = new ClientAndServer._HeadQuarterStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
