package ClientAndServer;


/**
 * Generated from IDL interface "HeadQuarter".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 04-Mar-2020 19:25:35
 */

public interface HeadQuarterOperations
{
	/* constants */
	/* operations  */
	void raise_alarm(ClientAndServer.NoxReading alarm_reading);
	void register_agency(java.lang.String who, java.lang.String contact_details, java.lang.String area_of_interest);
	void register_local_server(java.lang.String server_name);
	java.lang.String getNox();
}
