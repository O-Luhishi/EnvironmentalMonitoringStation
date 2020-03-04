package ClientAndServer;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Sensor".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 04-Mar-2020 17:25:02
 */

public class SensorPOATie
	extends SensorPOA
{
	private SensorOperations _delegate;

	private POA _poa;
	public SensorPOATie(SensorOperations delegate)
	{
		_delegate = delegate;
	}
	public SensorPOATie(SensorOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public ClientAndServer.Sensor _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ClientAndServer.Sensor __r = ClientAndServer.SensorHelper.narrow(__o);
		return __r;
	}
	public ClientAndServer.Sensor _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ClientAndServer.Sensor __r = ClientAndServer.SensorHelper.narrow(__o);
		return __r;
	}
	public SensorOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(SensorOperations delegate)
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
