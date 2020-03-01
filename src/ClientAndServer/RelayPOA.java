package ClientAndServer;


/**
 * Generated from IDL interface "Relay".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 20:05:26
 */

public abstract class RelayPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ClientAndServer.RelayOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "fetch_NoxReading", Integer.valueOf(0));
	}
	private String[] ids = {"IDL:ClientAndServer/Relay:1.0"};
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
			case 0: // fetch_NoxReading
			{
				_out = handler.createReply();
				java.lang.String tmpResult0 = fetch_NoxReading();
_out.write_string( tmpResult0 );
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
