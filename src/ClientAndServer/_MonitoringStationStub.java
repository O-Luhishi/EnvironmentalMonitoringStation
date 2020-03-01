package ClientAndServer;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 18:30:36
 */

public class _MonitoringStationStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements ClientAndServer.MonitoringStation
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	private String[] ids = {"IDL:ClientAndServer/MonitoringStation:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = ClientAndServer.MonitoringStationOperations.class;
	public void x(java.lang.String a)
	{
		while(true)
		{
			if(! this._is_local())
			{
				org.omg.CORBA.portable.InputStream _is = null;
				org.omg.CORBA.portable.OutputStream _os = null;
				try
				{
					_os = _request("_set_x",true);
					java.lang.String tmpResult1 = a;
_os.write_string( tmpResult1 );
					_is = _invoke(_os);
					return;
				}
				catch( org.omg.CORBA.portable.RemarshalException _rx )
					{
						continue;
					}
				catch( org.omg.CORBA.portable.ApplicationException _ax )
				{
					String _id = _ax.getId();
						try
						{
								_ax.getInputStream().close();
						}
						catch (java.io.IOException e)
						{
							throw new RuntimeException("Unexpected exception " + e.toString() );
						}
							throw new RuntimeException("Unexpected exception " + _id );
				}
				finally
				{
					if (_os != null)
					{
						try
						{
							_os.close();
						}
						catch (java.io.IOException e)
						{
							throw new RuntimeException("Unexpected exception " + e.toString() );
						}
					}
					this._releaseReply(_is);
				}
			}

			else
			{
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_set_x", _opsClass);
				if( _so == null )
					continue;
				MonitoringStationOperations _localServant = (MonitoringStationOperations)_so.servant;
				try
				{
					_localServant.x(a);
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
					return;
				}
				catch (RuntimeException re) 
				{
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(re);
					throw re;
				}
				catch (java.lang.Error err) 
				{
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(err);
					throw err;
				}
				finally
				{
					_servant_postinvoke(_so);
				}
			}

		}

	}

	public java.lang.String NoxReading()
	{
		while(true)
		{
			if(! this._is_local())
			{
				org.omg.CORBA.portable.InputStream _is = null;
				org.omg.CORBA.portable.OutputStream _os = null;
				try
				{
					_os = _request( "NoxReading", true);
					_is = _invoke(_os);
					java.lang.String _result = _is.read_string();
					return _result;
				}
				catch( org.omg.CORBA.portable.RemarshalException _rx )
					{
						continue;
					}
				catch( org.omg.CORBA.portable.ApplicationException _ax )
				{
					String _id = _ax.getId();
					try
					{
							_ax.getInputStream().close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
					throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				if (_os != null)
				{
					try
					{
						_os.close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
				}
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "NoxReading", _opsClass );
			if( _so == null )
				continue;
			MonitoringStationOperations _localServant = (MonitoringStationOperations)_so.servant;
			java.lang.String _result;
			try
			{
				_result = _localServant.NoxReading();
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
				return _result;
			}
			catch (RuntimeException re) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(re);
				throw re;
			}
			catch (java.lang.Error err) 
			{
				if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
					((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(err);
				throw err;
			}
			finally
			{
				_servant_postinvoke(_so);
			}
		}

		}

	}

	public java.lang.String x()
	{
		while(true)
		{
			if(! this._is_local())
			{
				org.omg.CORBA.portable.InputStream _is = null;
				org.omg.CORBA.portable.OutputStream _os = null;
				try
				{
					_os = _request("_get_x",true);
					_is = _invoke(_os);
					return _is.read_string();
				}
				catch( org.omg.CORBA.portable.RemarshalException _rx )
					{
						continue;
					}
				catch( org.omg.CORBA.portable.ApplicationException _ax )
				{
					String _id = _ax.getId();
					try
					{
						_ax.getInputStream().close();
					}
					catch (java.io.IOException e)
					{
						throw new RuntimeException("Unexpected exception " + e.toString() );
					}
						throw new RuntimeException("Unexpected exception " + _id );
				}
				finally
				{
					if (_os != null)
					{
						try
						{
							_os.close();
						}
						catch (java.io.IOException e)
						{
							throw new RuntimeException("Unexpected exception " + e.toString() );
						}
					}
					this._releaseReply(_is);
				}
			}

			else
			{
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_get_x", _opsClass);
				if( _so == null )
					continue;
				MonitoringStationOperations _localServant = (MonitoringStationOperations)_so.servant;
				java.lang.String _result;
				try
				{
					_result = _localServant.x();
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
						return _result;
				}
				catch (RuntimeException re) 
				{
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(re);
					throw re;
				}
				catch (java.lang.Error err) 
				{
					if ( _so instanceof org.omg.CORBA.portable.ServantObjectExt) 
						((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion(err);
					throw err;
				}
				finally
				{
					_servant_postinvoke(_so);
				}
			}

		}

	}

}
