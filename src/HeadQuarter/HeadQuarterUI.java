package HeadQuarter;

import LocalMonitoringStation.LocalMonitoringStationUI;
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
	public DefaultListModel<String> noxReadingAlarmList;
	public DefaultListModel<String> lmsList;
	public DefaultListModel<String> lms_logs_model;
	public JList lms_list;
	public JList alarm_list;
	public JList lms_logs_list;
	public JTextArea sensor_reading;
	public JLabel lblNoxReading;
	public JScrollPane lms_logs_ScrollPane, alarm_list_ScrollPane, lms_ScrollPane;

	public String lms_name, sensor_name;
	public static String[] arguments;

	public ClientAndServer.HeadQuarter headQuarter;

	public HeadQuarterUI(String[] args) {
		try {
			arguments = args;
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
			lmsList = new DefaultListModel<String>();
			lms_logs_model = new DefaultListModel<>();

			frame = new JFrame();
			frame.setBounds(100, 100, 600, 672);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JLabel lblHeadQuaters = new JLabel("HeadQuarter Server ");
			lblHeadQuaters.setBounds(235, 6, 125, 16);
			frame.getContentPane().add(lblHeadQuaters);

			alarm_list = new JList();
			alarm_list.setModel(noxReadingAlarmList);
			//list.setBounds(26, 59, 898, 213);
			//frame.getContentPane().add(list);

			JLabel lblAlarmList = new JLabel("Alarm List From All Local Monitoring Stations:");
			lblAlarmList.setBounds(22, 46, 380, 16);
			frame.getContentPane().add(lblAlarmList);
			
			alarm_list_ScrollPane = new JScrollPane(alarm_list);
			alarm_list_ScrollPane.setBounds(22, 76, 550, 161);
			frame.getContentPane().add(alarm_list_ScrollPane);
			
			JLabel lblLocalMonitoringSystem = new JLabel("Connected Local Monitoring System:");
			lblLocalMonitoringSystem.setBounds(22, 428, 241, 16);
			frame.getContentPane().add(lblLocalMonitoringSystem);
			
			lms_list = new JList();
			lms_list.setModel(lmsList);
			
			lms_ScrollPane = new JScrollPane(lms_list);
			lms_ScrollPane.setBounds(26, 465, 200, 120);
			frame.getContentPane().add(lms_ScrollPane);


			sensor_reading = new JTextArea();
			sensor_reading.setEditable(false);
			sensor_reading.setBounds(376, 467, 196, 116);
			frame.getContentPane().add(sensor_reading);
			
			lblNoxReading = new JLabel("Latest Nox Reading Sensor: ");
			lblNoxReading.setBounds(360, 428, 212, 16);
			frame.getContentPane().add(lblNoxReading);
			
			JButton btnGetNoxReading = new JButton("Get Nox Reading");
			btnGetNoxReading.setBounds(399, 595, 153, 29);
			frame.getContentPane().add(btnGetNoxReading);
			btnGetNoxReading.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					lms_name = JOptionPane.showInputDialog("Please Select Which Local Monitoring Station");
					sensor_name = JOptionPane.showInputDialog("Please Select Which Sensor");
					setNoxReadingList(headQuarter.getNox(lms_name, sensor_name));
				}
			});
			
			JLabel lblLocalMonitoringStation = new JLabel("Local Monitoring Station Logs:");
			lblLocalMonitoringStation.setBounds(22, 251, 380, 16);
			frame.getContentPane().add(lblLocalMonitoringStation);

			lms_logs_list = new JList();
			lms_logs_list.setModel(lms_logs_model);
			
			lms_logs_ScrollPane = new JScrollPane(lms_logs_list);
			lms_logs_ScrollPane.setBounds(22, 279, 550, 132);
			frame.getContentPane().add(lms_logs_ScrollPane);
			
			JButton btnActivateLms = new JButton("Activate LMS");
			btnActivateLms.setBounds(22, 595, 117, 29);
			frame.getContentPane().add(btnActivateLms);
			btnActivateLms.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					lms_name = JOptionPane.showInputDialog("Please Select Which Local Monitoring Station");
					headQuarter.return_all_logs(lms_name);
				}
			});
			
			JButton btnDeactivateLms = new JButton("Deactivate LMS");
			btnDeactivateLms.setBounds(213, 595, 139, 29);
			frame.getContentPane().add(btnDeactivateLms);
			btnDeactivateLms.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					lms_name = JOptionPane.showInputDialog("Please Select Which Local Monitoring Station");
					get_connected_sensors(lms_name);
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

	private void get_connected_sensors(String lms_name){
		headQuarter.return_connected_sensors(lms_name);
	}

	private void deactivateLMS(){
		String lms_name = JOptionPane.showInputDialog("Please Register Local Monitoring Station");
		lmsList.removeElement(lms_name);
	}

	private void activateLMS(){
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LocalMonitoringStationUI(arguments).setVisible(true);
			}
		});
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
