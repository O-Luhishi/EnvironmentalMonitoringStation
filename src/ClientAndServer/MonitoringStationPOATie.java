package ClientAndServer;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 20:05:26
 */

public class MonitoringStationPOATie
	extends MonitoringStationPOA
{
	private MonitoringStationOperations _delegate;

	private POA _poa;
	public MonitoringStationPOATie(MonitoringStationOperations delegate)
	{
		_delegate = delegate;
	}
	public MonitoringStationPOATie(MonitoringStationOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public MonitoringStationOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(MonitoringStationOperations delegate)
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
	public java.lang.String station_name()
	{
		return _delegate.station_name();
	}

	public void activate()
	{
_delegate.activate();
	}

	public void deactivate()
	{
_delegate.deactivate();
	}

	public ClientAndServer.NoxReading get_reading()
	{
		return _delegate.get_reading();
	}

	public void reset()
	{
_delegate.reset();
	}

	public java.lang.String location()
	{
		return _delegate.location();
	}

}
