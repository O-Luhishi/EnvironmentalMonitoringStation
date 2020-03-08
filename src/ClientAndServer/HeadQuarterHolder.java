package ClientAndServer;

/**
 * Generated from IDL interface "HeadQuarter".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 08-Mar-2020 16:46:37
 */

public final class HeadQuarterHolder	implements org.omg.CORBA.portable.Streamable{
	 public HeadQuarter value;
	public HeadQuarterHolder()
	{
	}
	public HeadQuarterHolder (final HeadQuarter initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return HeadQuarterHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = HeadQuarterHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		HeadQuarterHelper.write (_out,value);
	}
}
