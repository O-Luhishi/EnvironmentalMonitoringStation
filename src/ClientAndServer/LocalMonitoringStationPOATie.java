package ClientAndServer;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "LocalMonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 08-Mar-2020 16:46:37
 */

public class LocalMonitoringStationPOATie
	extends LocalMonitoringStationPOA
{
	private LocalMonitoringStationOperations _delegate;

	private POA _poa;
	public LocalMonitoringStationPOATie(LocalMonitoringStationOperations delegate)
	{
		_delegate = delegate;
	}
	public LocalMonitoringStationPOATie(LocalMonitoringStationOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public LocalMonitoringStationOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(LocalMonitoringStationOperations delegate)
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
	public java.lang.String name()
	{
		return _delegate.name();
	}

	public ClientAndServer.NoxReading[] log()
	{
		return _delegate.log();
	}

	public void raise_alarm(ClientAndServer.NoxReading alarmReading)
	{
_delegate.raise_alarm(alarmReading);
	}

	public void add_monitoring_station(java.lang.String station_name, java.lang.String station_location, java.lang.String station_ior)
	{
_delegate.add_monitoring_station(station_name,station_location,station_ior);
	}

	public java.lang.String fetch_NoxReading()
	{
		return _delegate.fetch_NoxReading();
	}

	public void connectHQ()
	{
_delegate.connectHQ();
	}

	public void connectSensor()
	{
_delegate.connectSensor();
	}

	public ClientAndServer.NoxReading[] take_readings()
	{
		return _delegate.take_readings();
	}

	public java.lang.String location_name()
	{
		return _delegate.location_name();
	}

}
