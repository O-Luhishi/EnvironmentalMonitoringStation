package Sensor;

import ClientAndServer.NoxReading;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


public class SensorServer extends JFrame {
    private JTextArea textarea;

    public static String stationName;
    public static String lms_name, sensor_name;
    public static int readingValue;
    public static int time;
    public static int date;

    public static JTextField txtTime;
    public static JTextField txtStationName;
    public static JTextField txtReadingValue;
    public static JTextField txtDate;

    public ORB orb;

    public SensorServant sensorRef;

    public SensorServer(String[] args) {
        try {
            sensor_name = JOptionPane.showInputDialog("Please Register Your Sensor Name");
            lms_name = JOptionPane.showInputDialog("Please Connect To A Local Monitoring Station");
            // create and initialize the ORB
            orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            sensorRef = new SensorServant(this, orb);
            // get the 'stringified IOR'
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(sensorRef);
            String stringified_ior = orb.object_to_string(ref);

            // Save IOR to file
            BufferedWriter out = new BufferedWriter(new FileWriter(sensor_name + "server.ref"));
            out.write(stringified_ior);
            out.close();


            // set up the GUI
            textarea = new JTextArea(20, 25);
            JScrollPane scrollpane = new JScrollPane(textarea);
            JPanel panel = new JPanel();
            JPanel panell = new JPanel();


            panel.add(scrollpane);
            getContentPane().add(panel, "Center");

            txtReadingValue = new JTextField(14);
            panel.add(txtReadingValue);

            JLabel lblReadingValue = new JLabel("Reading Value");
            panel.add(lblReadingValue);

            txtStationName = new JTextField(14);
            txtStationName.setText(lms_name);
            txtStationName.setEditable(false);
            panel.add(txtStationName);

            JLabel lblStationName = new JLabel("Station Name");
            panel.add(lblStationName);

            // remove the "orb.run()" command,
            // or the server will run but the GUI will not be visible
            // orb.run();

            txtTime = new JTextField(14);
            panel.add(txtTime);

            JLabel lblTime = new JLabel("Time");
            panel.add(lblTime);

            txtDate = new JTextField(14);
            panel.add(txtDate);

            JLabel lblDate = new JLabel("Date");
            panel.add(lblDate);
            getContentPane().add(panell, "South");

            JButton btnSaveReadings = new JButton("Save Readings");
            btnSaveReadings.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    get_Reading();
                }
            });
            panell.add(btnSaveReadings);

            setSize(400, 524);
            setTitle("Sensor.SensorServer");

            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    System.exit(0);
                }
            });


            // wait for invocations from clients
            textarea.append("Server started.  Waiting for clients...\n\n");
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }

    void addMessage(String message) {
        textarea.append(message);
    }

    private void get_Reading() {
        stationName = txtStationName.getText();
        readingValue = Integer.parseInt(txtReadingValue.getText());
        date = Integer.parseInt(txtDate.getText());
        time = Integer.parseInt(txtTime.getText());
        if (readingValue >= 50){
            sensorRef.connectLMS(lms_name);
            sensorRef.raise_alarm(sensorRef.get_reading());
        }
    }


    public static void main(String[] args) {
        final String[] arguments = args;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SensorServer(arguments).setVisible(true);
            }
        });
    }
}


