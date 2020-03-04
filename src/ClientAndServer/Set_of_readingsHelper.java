package ClientAndServer;

/**
 * Generated from IDL alias "Set_of_readings".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 04-Mar-2020 19:25:35
 */

public abstract class Set_of_readingsHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, ClientAndServer.NoxReading[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static ClientAndServer.NoxReading[] extract (final org.omg.CORBA.Any any)
	{
		if ( any.type().kind() == org.omg.CORBA.TCKind.tk_null)
		{
			throw new org.omg.CORBA.BAD_OPERATION ("Can't extract from Any with null type.");
		}
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(Set_of_readingsHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(ClientAndServer.Set_of_readingsHelper.id(), "Set_of_readings",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_struct_tc(ClientAndServer.NoxReadingHelper.id(),"NoxReading",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("time", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null),new org.omg.CORBA.StructMember("date", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null),new org.omg.CORBA.StructMember("station_name", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("reading_value", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null)})));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:ClientAndServer/Set_of_readings:1.0";
	}
	public static ClientAndServer.NoxReading[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		ClientAndServer.NoxReading[] _result;
		int _l_result1 = _in.read_long();
		try
		{
			 int x = _in.available();
			 if ( x > 0 && _l_result1 > x )
				{
					throw new org.omg.CORBA.MARSHAL("Sequence length too large. Only " + x + " available and trying to assign " + _l_result1);
				}
		}
		catch (java.io.IOException e)
		{
		}
		_result = new ClientAndServer.NoxReading[_l_result1];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=ClientAndServer.NoxReadingHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, ClientAndServer.NoxReading[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			ClientAndServer.NoxReadingHelper.write(_out,_s[i]);
		}

	}
}
