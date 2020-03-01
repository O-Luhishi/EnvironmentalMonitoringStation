package ClientAndServer;


/**
 * Generated from IDL interface "MonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 01-Mar-2020 20:05:26
 */

public interface MonitoringStationOperations
{
	/* constants */
	/* operations  */
	java.lang.String station_name();
	java.lang.String location();
	ClientAndServer.NoxReading get_reading();
	void activate();
	void deactivate();
	void reset();
}
