package ClientAndServer;


/**
 * Generated from IDL interface "LocalMonitoringStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 19-Mar-2020 20:12:14
 */

public interface LocalMonitoringStationOperations
{
	/* constants */
	/* operations  */
	java.lang.String fetch_NoxReading();
	java.lang.String name();
	java.lang.String location_name();
	ClientAndServer.NoxReading[] log();
	void raise_alarm(ClientAndServer.NoxReading alarmReading);
	ClientAndServer.NoxReading[] take_readings();
	void add_monitoring_station(java.lang.String station_name, java.lang.String station_location, java.lang.String station_ior);
	void connectSensor();
	void connectHQ();
}
