A CORBA-based client-server system.  The requirements of the system can be broken down into a number of separate systems which will need to communicate in a client-server manner to solve the overall requirements:

_1.  The Monitoring Station:_
    
The Monitoring Station is a stand-alone monitoring system, to be prototyped as a CORBA server, that supports the following functionality at least:
- Register itself with a Regional Centre upon initial activation
- Can be remotely activated
- Can be remotely deactivated
- Can be remotely reset
- Can return, upon request, the current value of the nitrogen oxides sensor
- Can identify anomalous or potentially dangerous readings of nitrogen oxides and alert the Local Server immediately.

_2.  Precompile the IDL.  To do this open a (IntelliJ) Terminal and type:_

The Local Server is to be prototyped as a CORBA server that supports the following functionality at least:
- Receives requests to register Monitoring Stations and maintains a list of connected devices
- Receives alerts from connected Monitoring Stations, and maintains a log of these alerts
- Triggers an alarm at the Environmental Centre when two alarms happen within a specified time frame
- Returns the log upon request
- Polls all connected Monitoring Stations when requested to do so, and returns a set of readings

_3.  The  Monitoring Centre_
    
The Monitoring Centre is to be prototyped as a CORBA server that supports the following functionality at least:
- Receives confirmed alarms from Local Servers
- Alerts the operator when a confirmed alarm is received
- Allows agencies (e.g. the Environment Agency, local councils, local pressure groups, etc.) to register for notifications in particular areas in case of alarms
- Maintains a list of connected Local Servers
- Polls all Local Servers upon request and displays the results of readings returned, highlighting readings of concern

To run the demo from IntelliJ:

1.  Add all the libraries from the Jacorb lib folder to the **module** (NOTE - add them to the module, not the project.  They are not all required, but I don't know the minmum set) **AND** add the jboss library too.

2.  Precompile the IDL.  To do this open a (IntelliJ) Terminal and type:


    cd RelayWithGUIsDemo/src
    <path_to_jacorb_dir>/bin/idl LocalMonitoringStation.LocalMonitoringStationUI.idl

e.g. I would type:

    cd RelayWithGUIsDemo/src
    /spare/jacorb-3.9/bin/idl LocalMonitoringStation.LocalMonitoringStationUI.idl

3.  You can then run the different components of the system.  You need to start them in the following order:


    Sensor.SensorServer
    LocalMonitoringStation.LocalMonitoringStationUI
    HeadQuarter.HeadQuarterUI


