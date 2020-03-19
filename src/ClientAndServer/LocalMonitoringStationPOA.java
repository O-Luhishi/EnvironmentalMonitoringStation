package ClientAndServer;


/**
 * Generated from IDL interface "LocalMonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 19-Mar-2020 20:12:14
 */

public abstract class LocalMonitoringStationPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ClientAndServer.LocalMonitoringStationOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "_get_name", Integer.valueOf(0));
		m_opsHash.put ( "_get_log", Integer.valueOf(1));
		m_opsHash.put ( "raise_alarm", Integer.valueOf(2));
		m_opsHash.put ( "add_monitoring_station", Integer.valueOf(3));
		m_opsHash.put ( "fetch_NoxReading", Integer.valueOf(4));
		m_opsHash.put ( "connectHQ", Integer.valueOf(5));
		m_opsHash.put ( "connectSensor", Integer.valueOf(6));
		m_opsHash.put ( "take_readings", Integer.valueOf(7));
		m_opsHash.put ( "_get_location_name", Integer.valueOf(8));
	}
	private String[] ids = {"IDL:ClientAndServer/LocalMonitoringStation:1.0"};
	public ClientAndServer.LocalMonitoringStation _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ClientAndServer.LocalMonitoringStation __r = ClientAndServer.LocalMonitoringStationHelper.narrow(__o);
		return __r;
	}
	public ClientAndServer.LocalMonitoringStation _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ClientAndServer.LocalMonitoringStation __r = ClientAndServer.LocalMonitoringStationHelper.narrow(__o);
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
			case 0: // _get_name
			{
			_out = handler.createReply();
			java.lang.String tmpResult6 = name();
_out.write_string( tmpResult6 );
				break;
			}
			case 1: // _get_log
			{
			_out = handler.createReply();
			ClientAndServer.Log_of_alarm_readingsHelper.write(_out,log());
				break;
			}
			case 2: // raise_alarm
			{
				ClientAndServer.NoxReading _arg0=ClientAndServer.NoxReadingHelper.read(_input);
				_out = handler.createReply();
				raise_alarm(_arg0);
				break;
			}
			case 3: // add_monitoring_station
			{
				java.lang.String _arg0=_input.read_string();
				java.lang.String _arg1=_input.read_string();
				java.lang.String _arg2=_input.read_string();
				_out = handler.createReply();
				add_monitoring_station(_arg0,_arg1,_arg2);
				break;
			}
			case 4: // fetch_NoxReading
			{
				_out = handler.createReply();
				java.lang.String tmpResult7 = fetch_NoxReading();
_out.write_string( tmpResult7 );
				break;
			}
			case 5: // connectHQ
			{
				_out = handler.createReply();
				connectHQ();
				break;
			}
			case 6: // connectSensor
			{
				_out = handler.createReply();
				connectSensor();
				break;
			}
			case 7: // take_readings
			{
				_out = handler.createReply();
				ClientAndServer.Set_of_readingsHelper.write(_out,take_readings());
				break;
			}
			case 8: // _get_location_name
			{
			_out = handler.createReply();
			java.lang.String tmpResult8 = location_name();
_out.write_string( tmpResult8 );
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
