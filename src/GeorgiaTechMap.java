import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * Georgia Tech Map based on personal map. Creates a GUI for visual display of the simulation
 *
 */
public class GeorgiaTechMap {

	private JFrame frame;
	private static LinkedList<Intersection> intersectionList;
	private static LinkedList<Exit> exitList;

	private ImagePanel mapPanel;
	private boolean begin;
	private static int numIterations;
	
	/**
	 * Create the application
	 * @wbp.parser.entryPoint
	 */
	public GeorgiaTechMap(int numIterations, LinkedList<Intersection> intersectionList, LinkedList<Exit> exitList) {
		GeorgiaTechMap.intersectionList = intersectionList;
		GeorgiaTechMap.exitList 		= exitList;
		GeorgiaTechMap.numIterations 	= numIterations;
		initialize(numIterations);
	}
	
	/**
	 * Runs the application
	 */
	public static void start() {
		EventQueue.invokeLater(() -> {
			try {
				GeorgiaTechMap map = new GeorgiaTechMap(numIterations, intersectionList, exitList);
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				map.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Gets the frame being used
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Repaints the GUI
	 */
	public void paintAgain(){
		mapPanel.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int numIterations) {
		
		/* Main application color */
		Color aliceBlue = new Color(240, 248, 255); 
		
		/* Sets up the main JFrame */
		frame = new JFrame();
		frame.getContentPane().setBackground(aliceBlue);
		frame.setBounds(100, 100, 815, 475);
		
		if(numIterations == 1) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		/* Sets up the left settings panel */
		JPanel directionsPanel = new JPanel();
		directionsPanel.setBackground(aliceBlue);
		
		/* Sets up the title panel */
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(aliceBlue);
		
		/* Sets up the map panel */
		mapPanel = new ImagePanel(intersectionList, exitList);
		mapPanel.setBackground(aliceBlue);
		
		/* Layout of all components configured here */
		GroupLayout layout_mapPanel = new GroupLayout(mapPanel);
		layout_mapPanel.setHorizontalGroup(
			layout_mapPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 578, Short.MAX_VALUE)
		);
		layout_mapPanel.setVerticalGroup(
			layout_mapPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 396, Short.MAX_VALUE)
		);		
		
		GroupLayout layout_frame = new GroupLayout(frame.getContentPane());
		layout_frame.setHorizontalGroup(
			layout_frame.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout_frame.createSequentialGroup()
					.addGroup(layout_frame.createParallelGroup(Alignment.LEADING)
						.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
						.addGroup(layout_frame.createSequentialGroup()
							.addComponent(directionsPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout_frame.setVerticalGroup(
			layout_frame.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout_frame.createSequentialGroup()
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout_frame.createParallelGroup(Alignment.LEADING, false)
						.addComponent(mapPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(directionsPanel, GroupLayout.PREFERRED_SIZE, 396, Short.MAX_VALUE))
					.addGap(5))
		);
		
		/* Creates the GTENS SYSTEM ALERT label */
		JLabel lblWelcome = new JLabel("GTENS SYSTEM ALERT!");
		lblWelcome.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		
		/* Creates the simulation information label */
		JLabel lblThisSimulationAttempts = new JLabel("<html>To all GaTech Personnel: A chemical hazard has been released into Georgia Tech "
				+ "and all are advised to evacuate immediately! Watch the simulation to the right "
				+ "to see how vehicles leave GaTech during this crisis. The simulation will automatically start in <b>T-Minus 25</b> seconds." 
				+ "<br><br>Note that vehicles will arrive at intersections and move forward by whoever arrived first, but "
				+ "some intersections have policemen who'll help the cars move out a little bit faster! " 
				+ "The lights flash green anytime a car moves between a normal intersection and blue anytime a "
				+ "car moves between a police officer intersection. <html> ");
		lblThisSimulationAttempts.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 12));
		
		GroupLayout layout_settingsPanel = new GroupLayout(directionsPanel);
		layout_settingsPanel.setHorizontalGroup(
			layout_settingsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(layout_settingsPanel.createSequentialGroup()
					.addGroup(layout_settingsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(layout_settingsPanel.createSequentialGroup()
							.addGap(39)
							.addComponent(lblWelcome))
						.addGroup(layout_settingsPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblThisSimulationAttempts)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout_settingsPanel.setVerticalGroup(
			layout_settingsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(layout_settingsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcome)
					.addGap(18)
					.addComponent(lblThisSimulationAttempts, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		mapPanel.setLayout(layout_mapPanel);
		
		JLabel label_Title = new JLabel("GT Evacuation Simulation");
		label_Title.setBackground(new Color(135, 206, 235));
		label_Title.setHorizontalAlignment(SwingConstants.CENTER);
		label_Title.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		GroupLayout layout_titlePanel = new GroupLayout(titlePanel);
		layout_titlePanel.setHorizontalGroup(
			layout_titlePanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(label_Title, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
		);
		layout_titlePanel.setVerticalGroup(
			layout_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(layout_titlePanel.createSequentialGroup()
					.addComponent(label_Title, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		titlePanel.setLayout(layout_titlePanel);
		directionsPanel.setLayout(layout_settingsPanel);
		frame.getContentPane().setLayout(layout_frame);
	}
	
	/**
	 * Checks if begin button has been pressed
	 * @return
	 */
	public boolean checkIfBegin() {
		return begin;
	}
}

