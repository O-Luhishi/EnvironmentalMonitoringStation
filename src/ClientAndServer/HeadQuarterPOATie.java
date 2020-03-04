package ClientAndServer;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "HeadQuarter".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 04-Mar-2020 19:25:35
 */

public class HeadQuarterPOATie
	extends HeadQuarterPOA
{
	private HeadQuarterOperations _delegate;

	private POA _poa;
	public HeadQuarterPOATie(HeadQuarterOperations delegate)
	{
		_delegate = delegate;
	}
	public HeadQuarterPOATie(HeadQuarterOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public HeadQuarterOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(HeadQuarterOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public java.lang.String getNox()
	{
		return _delegate.getNox();
	}

	public void raise_alarm(ClientAndServer.NoxReading alarm_reading)
	{
_delegate.raise_alarm(alarm_reading);
	}

	public void register_local_server(java.lang.String server_name)
	{
_delegate.register_local_server(server_name);
	}

	public void register_agency(java.lang.String who, java.lang.String contact_details, java.lang.String area_of_interest)
	{
_delegate.register_agency(who,contact_details,area_of_interest);
	}

}
