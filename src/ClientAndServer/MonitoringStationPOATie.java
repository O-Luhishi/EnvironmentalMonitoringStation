package ClientAndServer;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 18:30:36
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
	public void x(java.lang.String a)
	{
		_delegate.x(a);
	}

	public java.lang.String NoxReading()
	{
		return _delegate.NoxReading();
	}

	public java.lang.String x()
	{
		return _delegate.x();
	}

}
