package HeadQuarter;

import ClientAndServer.HeadQuarterPOA;
import ClientAndServer.NoxReading;
import org.omg.CORBA.ORB;

import java.io.BufferedReader;
import java.io.FileReader;

public class HeadQuarterServant extends HeadQuarterPOA {

    private HeadQuarterUI parent;
    private ORB orb;
    private ClientAndServer.LocalMonitoringStation server;

    HeadQuarterServant(HeadQuarterUI parentGUI, ORB orb_val) {
        // store reference to parent GUI
        parent = parentGUI;

        // store reference to ORB
        orb = orb_val;


        // look up the server
        try {
            // read in the 'stringified IOR'
            BufferedReader in = new BufferedReader(new FileReader("relay.ref"));
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
    public String getNox(){
        return server.fetch_NoxReading();
    }

    @Override
    public void raise_alarm(NoxReading alarm_reading) {

    }

    @Override
    public void register_agency(String who, String contact_details, String area_of_interest) {

    }

    @Override
    public void register_local_server(String server_name) {

    }
}
