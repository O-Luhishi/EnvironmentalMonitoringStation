package ClientAndServer;


/**
 * Generated from IDL interface "HeadQuarter".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 19-Mar-2020 20:12:14
 */

public interface HeadQuarterOperations
{
	/* constants */
	/* operations  */
	void raise_alarm(ClientAndServer.NoxReading alarm_reading);
	void register_agency(java.lang.String who, java.lang.String contact_details, java.lang.String area_of_interest);
	void register_local_monitoring_station(java.lang.String server_name);
	java.lang.String getNox();
	void connectLMS();
	java.lang.String noxReading_ToString(ClientAndServer.NoxReading reading);
}
