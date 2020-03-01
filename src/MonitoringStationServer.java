import ClientAndServer.*;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.io.*;
import javax.swing.*;


class MonitoringStationServant extends MonitoringStationPOA {
	private MonitoringStationServer parent;

	String noxReading;

	MonitoringStationServant(MonitoringStationServer parentGUI) {
		// store reference to parent GUI
		parent = parentGUI;
	}

	public String NoxReading() {
		parent.addMessage("hello_world called by relay.\n    Replying with message...\n\n");
		return get_NoxReading();
	}

	private String get_NoxReading() {
		noxReading = MonitoringStationServer.get_Reading();
		return noxReading;
	}

	@Override
	public String x() {
		return null;
	}

	@Override
	public void x(String arg) {

	}
}

public class MonitoringStationServer extends JFrame {
	private JTextArea textarea;
	public static JTextField txtField;

	public MonitoringStationServer(String[] args){
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB
			MonitoringStationServant helloRef = new MonitoringStationServant(this);

			// get the 'stringified IOR'
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloRef);
			String stringified_ior = orb.object_to_string(ref);

			// Save IOR to file
			BufferedWriter out = new BufferedWriter(new FileWriter("server.ref"));
			out.write(stringified_ior);
			out.close();


			// set up the GUI
			textarea = new JTextArea(20,25);
			JScrollPane scrollpane = new JScrollPane(textarea);
			JPanel panel = new JPanel();
			JPanel panell = new JPanel();


			panel.add(scrollpane);
			getContentPane().add(panel, "Center");
			getContentPane().add(panell, "South");

			setSize(400, 500);
			setTitle("LocalMonitoringStationUI Demo Server");

			addWindowListener (new java.awt.event.WindowAdapter () {
				public void windowClosing (java.awt.event.WindowEvent evt) {
					System.exit(0);
				}
			} );


			// wait for invocations from clients
			textarea.append("Server started.  Waiting for clients...\n\n");

			// remove the "orb.run()" command,
			// or the server will run but the GUI will not be visible
			// orb.run();

			txtField = new JTextField(14);
			panell.add(txtField);
		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}


	void addMessage(String message){
		textarea.append(message);
	}

	static String get_Reading(){
		return txtField.getText();
	}


	public static void main(String[] args) {
		final String[] arguments = args;
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MonitoringStationServer(arguments).setVisible(true);
			}
		});
	}
}


