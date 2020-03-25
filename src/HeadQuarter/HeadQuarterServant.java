package HeadQuarter;

import ClientAndServer.HeadQuarterPOA;
import ClientAndServer.NoxReading;
import ClientAndServer.SensorData;
import org.omg.CORBA.ORB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class HeadQuarterServant extends HeadQuarterPOA {

    public HeadQuarterUI parent;
    public ORB orb;
    public ClientAndServer.LocalMonitoringStation server;

    HeadQuarterServant(HeadQuarterUI parentGUI, ORB orb_val) {
        // store reference to parent GUI
        parent = parentGUI;
        // store reference to ORB
        orb = orb_val;
    }
    @Override
    public void connectLMS(String lms_name){
        // look up the server
        try {
            // read in the 'stringified IOR'
            BufferedReader in = new BufferedReader(new FileReader(lms_name + "relay.ref"));
            String stringified_ior = in.readLine();

            // get object reference from stringified IOR
            org.omg.CORBA.Object relay =
                    orb.string_to_object(stringified_ior);
            server = ClientAndServer.LocalMonitoringStationHelper.narrow(relay);
        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }

    @Override
    public String getNox(String lms_name, String sensor_name){
        connectLMS(lms_name);
        return server.fetch_NoxReading(sensor_name);
    }

    @Override
    public void raise_alarm(NoxReading alarm_reading) {
        System.out.println(noxReading_ToString(alarm_reading));
        parent.noxReadingAlarmList.addElement(noxReading_ToString(alarm_reading));
    }

    @Override
    public void register_agency(String who, String contact_details, String area_of_interest) {

    }

    @Override
    public void register_local_monitoring_station(String server_name) {
        parent.lmsList.addElement(server_name);
    }

    @Override
    public String noxReading_ToString(NoxReading reading){
        return "LMS: " + reading.station_name + "\n" + "Area Name: " + reading.sensor_name +"\n" + "Reading Value: " + reading.reading_value + "\n"
                + "Date: " + reading.date + "\n" + "Time: " + reading.time;
    }

    @Override
    public void return_all_logs(String lms_name) {
        connectLMS(lms_name);
        NoxReading[] logs = server.log();
        parent.lms_logs_model.clear();
        for (NoxReading obj : logs){
            parent.lms_logs_model.addElement(noxReading_ToString(obj));
        }
    }

    @Override
    public void return_connected_sensors(String lms_name){
        connectLMS(lms_name);
        SensorData[] sensor = server.sensor_data();
        for (SensorData s : sensor){
            System.out.println(s.sensor_name);
        }
    }
}
