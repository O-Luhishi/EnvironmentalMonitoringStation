package ClientAndServer;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 20:05:26
 */

public abstract class MonitoringStationPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ClientAndServer.MonitoringStationOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "_get_station_name", Integer.valueOf(0));
		m_opsHash.put ( "activate", Integer.valueOf(1));
		m_opsHash.put ( "deactivate", Integer.valueOf(2));
		m_opsHash.put ( "get_reading", Integer.valueOf(3));
		m_opsHash.put ( "reset", Integer.valueOf(4));
		m_opsHash.put ( "_get_location", Integer.valueOf(5));
	}
	private String[] ids = {"IDL:ClientAndServer/MonitoringStation:1.0"};
	public ClientAndServer.MonitoringStation _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ClientAndServer.MonitoringStation __r = ClientAndServer.MonitoringStationHelper.narrow(__o);
		return __r;
	}
	public ClientAndServer.MonitoringStation _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ClientAndServer.MonitoringStation __r = ClientAndServer.MonitoringStationHelper.narrow(__o);
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
			case 0: // _get_station_name
			{
			_out = handler.createReply();
			java.lang.String tmpResult2 = station_name();
_out.write_string( tmpResult2 );
				break;
			}
			case 1: // activate
			{
				_out = handler.createReply();
				activate();
				break;
			}
			case 2: // deactivate
			{
				_out = handler.createReply();
				deactivate();
				break;
			}
			case 3: // get_reading
			{
				_out = handler.createReply();
				ClientAndServer.NoxReadingHelper.write(_out,get_reading());
				break;
			}
			case 4: // reset
			{
				_out = handler.createReply();
				reset();
				break;
			}
			case 5: // _get_location
			{
			_out = handler.createReply();
			java.lang.String tmpResult3 = location();
_out.write_string( tmpResult3 );
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
