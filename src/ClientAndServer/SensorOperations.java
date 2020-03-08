package ClientAndServer;


/**
 * Generated from IDL interface "Sensor".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 08-Mar-2020 16:46:37
 */

public interface SensorOperations
{
	/* constants */
	/* operations  */
	java.lang.String station_name();
	java.lang.String location();
	ClientAndServer.NoxReading get_reading();
	void activate();
	void deactivate();
	void reset();
	void raise_alarm(ClientAndServer.NoxReading reading);
	void connectLMS();
}
