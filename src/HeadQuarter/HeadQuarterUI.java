package HeadQuarter;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class HeadQuarterUI extends JFrame {
	public JFrame frame;
	public DefaultListModel<String> noxReadingAlarmList, LMSAndIORList;
	public JList list_lms, list;

	public JTextArea sensor_reading;
	public JLabel lblNoxReading;

	public ClientAndServer.HeadQuarter headQuarter;

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

			headQuarter = ClientAndServer.HeadQuarterHelper.narrow(ref);


			noxReadingAlarmList = new DefaultListModel<>();
			LMSAndIORList = new DefaultListModel<>();


			frame = new JFrame();
			frame.setBounds(100, 100, 600, 513);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JLabel lblHeadQuaters = new JLabel("HeadQuarter Server ");
			lblHeadQuaters.setBounds(235, 6, 125, 16);
			frame.getContentPane().add(lblHeadQuaters);

			list = new JList();
			list.setModel(noxReadingAlarmList);
			//list.setBounds(26, 59, 898, 213);
			//frame.getContentPane().add(list);

			JLabel lblAlarmList = new JLabel("Alarm List From Local Monitoring Station: Leeds ");
			lblAlarmList.setBounds(22, 46, 380, 16);
			frame.getContentPane().add(lblAlarmList);
			
			JScrollPane scrollPane = new JScrollPane(list);
			scrollPane.setBounds(22, 76, 550, 161);
			frame.getContentPane().add(scrollPane);
			
			JLabel lblLocalMonitoringSystem = new JLabel("Connected Local Monitoring System:");
			lblLocalMonitoringSystem.setBounds(22, 258, 241, 16);
			frame.getContentPane().add(lblLocalMonitoringSystem);
			
			list_lms = new JList();
			list_lms.setModel(LMSAndIORList);
			
			JScrollPane scrollPane_LMS_IOR = new JScrollPane(list_lms);
			scrollPane_LMS_IOR.setBounds(26, 295, 200, 120);
			frame.getContentPane().add(scrollPane_LMS_IOR);


			sensor_reading = new JTextArea();
			sensor_reading.setEditable(false);
			sensor_reading.setBounds(376, 297, 196, 116);
			frame.getContentPane().add(sensor_reading);
			
			lblNoxReading = new JLabel("Latest Nox Reading Sensor: ");
			lblNoxReading.setBounds(360, 258, 212, 16);
			frame.getContentPane().add(lblNoxReading);
			
			JButton btnGetNoxReading = new JButton("Get Nox Reading");
			btnGetNoxReading.setBounds(399, 425, 153, 29);
			frame.getContentPane().add(btnGetNoxReading);
			btnGetNoxReading.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO: Create Function To Return Station Name In HQ Servant
					set_Label_Name_To_Sensor("Leeds");
					setNoxReadingList(headQuarter.getNox());
				}
			});

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}

	private void setNoxReadingList(String reading){
		sensor_reading.setText(reading);
	}

	private void set_Label_Name_To_Sensor(String sensorName){
		lblNoxReading.setText("Latest Nox Reading Sensor: "+ sensorName);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeadQuarterUI window = new HeadQuarterUI(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
