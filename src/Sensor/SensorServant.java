package Sensor;

import ClientAndServer.NoxReading;
import ClientAndServer.SensorPOA;


class SensorServant extends SensorPOA {
    private SensorServer parent;

    SensorServant(SensorServer parentGUI) {
        // store reference to parent GUI
        parent = parentGUI;
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
}


