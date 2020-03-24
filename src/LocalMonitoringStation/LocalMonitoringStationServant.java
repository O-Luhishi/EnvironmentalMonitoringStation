package LocalMonitoringStation;

import ClientAndServer.LocalMonitoringStationPOA;
import ClientAndServer.NoxReading;
import ClientAndServer.Log_of_alarm_readingsHolder;
import org.omg.CORBA.ORB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class LocalMonitoringStationServant extends LocalMonitoringStationPOA {

	private ORB orb;
	private ClientAndServer.Sensor server;
	private ClientAndServer.HeadQuarter hqServer;
	private LocalMonitoringStationUI parent;
	private ArrayList<NoxReading> noxReadingArrayList;
	private Log_of_alarm_readingsHolder noxReadingHolder = new Log_of_alarm_readingsHolder();

	public int log_count = 2;

	LocalMonitoringStationServant(LocalMonitoringStationUI parentGUI, ORB orb_val) {
		// store reference to parent GUI
		parent = parentGUI;
		// store reference to ORB
		orb = orb_val;
		noxReadingArrayList = new ArrayList<>();
	}

	@Override
	public String fetch_NoxReading(String sensor_name) {
		connectSensor(sensor_name);
		parent.addMessage("Fetch_NoxReading called by client.  Calling server..\n");
		NoxReading messageFromServer = server.get_reading();
		parent.addMessage("message from server = " + messageFromServer + "\n"
				+ "   Now forwarding to client..\n\n");
		System.out.println("RESULT: "+noxReading_ToString(messageFromServer));
		return noxReading_ToString(messageFromServer);
	}

	@Override
	public String name() {
		return null;
	}

	@Override
	public String location_name() {
		return null;
	}

	@Override
	public NoxReading[] take_readings() {
		return new NoxReading[0];
	}

	@Override
	public NoxReading[] log() {
		NoxReading[] noxReadingArray = new NoxReading[noxReadingArrayList.size()];
		return noxReadingArrayList.toArray(noxReadingArray);
	}

	@Override
	public void appendReadingToNoxReadingList(NoxReading reading) {
		noxReadingArrayList.add(reading);
	}

	@Override
	public void raise_alarm(NoxReading alarmReading) {
		// TODO: Add function to only alert on 2 alarms above 50
		System.out.println(noxReading_ToString(alarmReading));
		connectHQ();
		hqServer.raise_alarm(alarmReading);
	}

	@Override
	public void add_monitoring_station(String station_name, String station_location, String station_ior) {

	}

	@Override
	public void add_local_monitoring_station(String lms_name, String lms_ior) {
		connectHQ();
		hqServer.register_local_monitoring_station(lms_name);
	}

	public String noxReading_ToString(NoxReading object){
		return "Station Name: " + object.station_name + "\n" + "Reading Value: " + object.reading_value + "\n"
				+ "Date: " + object.date + "\n" + "Time: " + object.time;
	}

	@Override
	public void connectSensor(String sensor_name){
		// look up the server
		try {
			// read in the 'stringified IOR'
			BufferedReader in = new BufferedReader(new FileReader(sensor_name + "server.ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref =
					orb.string_to_object(stringified_ior);
			server = ClientAndServer.SensorHelper.narrow(server_ref);
		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void connectHQ(){
		try {
			// read in the 'stringified IOR'
			BufferedReader input = new BufferedReader(new FileReader("HeadQuarterServer.ref"));
			String stringified_ior1 = input.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref1 =
					orb.string_to_object(stringified_ior1);
			hqServer = ClientAndServer.HeadQuarterHelper.narrow(server_ref1);
		}catch(Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}
}
