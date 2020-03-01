package ClientAndServer;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Relay".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 18:30:36
 */

public class RelayPOATie
	extends RelayPOA
{
	private RelayOperations _delegate;

	private POA _poa;
	public RelayPOATie(RelayOperations delegate)
	{
		_delegate = delegate;
	}
	public RelayPOATie(RelayOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public ClientAndServer.Relay _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ClientAndServer.Relay __r = ClientAndServer.RelayHelper.narrow(__o);
		return __r;
	}
	public ClientAndServer.Relay _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ClientAndServer.Relay __r = ClientAndServer.RelayHelper.narrow(__o);
		return __r;
	}
	public RelayOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(RelayOperations delegate)
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
	public java.lang.String fetch_message()
	{
		return _delegate.fetch_message();
	}

}
