package ClientAndServer;


/**
 * Generated from IDL interface "HeadQuarter".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 19-Mar-2020 20:12:14
 */

public abstract class HeadQuarterPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ClientAndServer.HeadQuarterOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "getNox", Integer.valueOf(0));
		m_opsHash.put ( "connectLMS", Integer.valueOf(1));
		m_opsHash.put ( "raise_alarm", Integer.valueOf(2));
		m_opsHash.put ( "noxReading_ToString", Integer.valueOf(3));
		m_opsHash.put ( "register_local_monitoring_station", Integer.valueOf(4));
		m_opsHash.put ( "register_agency", Integer.valueOf(5));
	}
	private String[] ids = {"IDL:ClientAndServer/HeadQuarter:1.0"};
	public ClientAndServer.HeadQuarter _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ClientAndServer.HeadQuarter __r = ClientAndServer.HeadQuarterHelper.narrow(__o);
		return __r;
	}
	public ClientAndServer.HeadQuarter _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ClientAndServer.HeadQuarter __r = ClientAndServer.HeadQuarterHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // getNox
			{
				_out = handler.createReply();
				java.lang.String tmpResult13 = getNox();
_out.write_string( tmpResult13 );
				break;
			}
			case 1: // connectLMS
			{
				_out = handler.createReply();
				connectLMS();
				break;
			}
			case 2: // raise_alarm
			{
				ClientAndServer.NoxReading _arg0=ClientAndServer.NoxReadingHelper.read(_input);
				_out = handler.createReply();
				raise_alarm(_arg0);
				break;
			}
			case 3: // noxReading_ToString
			{
				ClientAndServer.NoxReading _arg0=ClientAndServer.NoxReadingHelper.read(_input);
				_out = handler.createReply();
				java.lang.String tmpResult14 = noxReading_ToString(_arg0);
_out.write_string( tmpResult14 );
				break;
			}
			case 4: // register_local_monitoring_station
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				register_local_monitoring_station(_arg0);
				break;
			}
			case 5: // register_agency
			{
				java.lang.String _arg0=_input.read_string();
				java.lang.String _arg1=_input.read_string();
				java.lang.String _arg2=_input.read_string();
				_out = handler.createReply();
				register_agency(_arg0,_arg1,_arg2);
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
