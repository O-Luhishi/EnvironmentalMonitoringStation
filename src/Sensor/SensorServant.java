package Sensor;

import ClientAndServer.NoxReading;
import ClientAndServer.SensorPOA;
import org.omg.CORBA.ORB;

import java.io.BufferedReader;
import java.io.FileReader;


class SensorServant extends SensorPOA {
    private SensorServer parent;
    public ORB orb;
    public ClientAndServer.LocalMonitoringStation lms_server;

    SensorServant(SensorServer parentGUI, ORB orb_val) {
        // store reference to parent GUI
        parent = parentGUI;
        orb = orb_val;
    }

    @Override
    public String station_name() {
        return null;
    }

    @Override
    public String location() {
        return null;
    }

    @Override
    public NoxReading get_reading() {
        parent.addMessage("Get_NoxReading called by HQ.\n    Replying with STRUCT message...\n\n");
        NoxReading NoxReadings = new NoxReading();
        NoxReadings.time = SensorServer.time;
        NoxReadings.date = SensorServer.date;
        NoxReadings.station_name = SensorServer.stationName;
        NoxReadings.reading_value = SensorServer.readingValue;
        return NoxReadings;
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void raise_alarm(NoxReading reading){
        lms_server.raise_alarm(reading);
    }

    @Override
    public void connectLMS(String lms_name) {
        try {
            // read in the 'stringified IOR'
            BufferedReader in = new BufferedReader(new FileReader(lms_name+ "relay.ref"));
            String stringified_ior_LMS = in.readLine();

            // get object reference from stringified IOR
            org.omg.CORBA.Object lms_ref =
                    orb.string_to_object(stringified_ior_LMS);
            lms_server = ClientAndServer.LocalMonitoringStationHelper.narrow(lms_ref);
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}


