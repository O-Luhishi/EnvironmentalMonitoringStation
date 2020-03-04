package HeadQuarter;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class HeadQuarterUI extends JFrame {
	private JTextArea textarea;

	public HeadQuarterUI(String[] args) {
		try {
		// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB
			HeadQuarterServant headquarterRef = new HeadQuarterServant(this, orb);

			// get the 'stringified IOR'
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(headquarterRef);
			String stringified_ior = orb.object_to_string(ref);

			// Save IOR to file
			BufferedWriter out = new BufferedWriter(new FileWriter("HeadQuarterServer.ref"));
			out.write(stringified_ior);
			out.close();

			// wait for invocations from clients
			System.out.println("Server started.  Waiting for clients...");
			//orb.run();

			final ClientAndServer.HeadQuarter lms =
					ClientAndServer.HeadQuarterHelper.narrow(ref);


			// set up the GUI
			textarea = new JTextArea(20,25);
			JScrollPane scrollpane = new JScrollPane(textarea);
			JPanel textpanel = new JPanel();

			JPanel buttonpanel = new JPanel();
			JButton getItButton = new JButton("Get Nox Reading");
			getItButton.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent evt) {
//					textarea.append("Calling relay...\n");
//					String result = lms.fetch_NoxReading();
//					textarea.append("   Result = \n" + result + "\n\n");
					String result = lms.getNox();
					System.out.println("Result: "+ result);
					textarea.append("Result: "+ result);
				}
			});


			textpanel.add(scrollpane);
			buttonpanel.add(getItButton);

			getContentPane().add(textpanel, "Center");
			getContentPane().add(buttonpanel, "South");

			setSize(400, 500);
			setTitle("LocalMonitoringStation.LocalMonitoringStationUI Demo Client");

			addWindowListener (new WindowAdapter () {
				public void windowClosing (WindowEvent evt) {
					System.exit(0);
				}
			} );

			textarea.append("Client started.  Click the button to contact relay...\n\n");

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}



	public static void main(String[] args) {
		final String[] arguments = args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HeadQuarterUI(arguments).setVisible(true);
			}
		});
	}
}
