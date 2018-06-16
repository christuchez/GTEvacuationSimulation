import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Creates an Image Panel that subclasses JPanel to add in our personal images and drawings
 *
 */
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int INTERSECTION_SIZE = 14;
	private final int EXIT_SIZE 		= 10;
	
	private Image map;
	private LinkedList<Intersection> intersectionList;
	private LinkedList<Exit> exitList;

	/**
	 * Create the image panel.
	 */
	public ImagePanel(LinkedList<Intersection> intersectionList, LinkedList<Exit> exitList) {
		this.intersectionList = intersectionList;
		this.exitList = exitList;
		try {
			map = ImageIO.read(new File("img/GTMap.jpg"));
		}
		catch(IOException e) {
			System.out.println("Error in loading image. Please load image again.");
			e.printStackTrace();
		}
	}
	/**
	 * Repaints the GUI
	 */
	public void doAgain(){
		repaint();
	}
	
	
	/**
	 * Overrides the JPanel paint component method. 
	 * Lights up an intersection/exit whenever it needs to flash. 
	 * Intersection: 
	 * 		Green Flash - Car Passed From One Road to Another
	 * 		Blue  Flash - Police Officer Aided Car Pass from One Road to Another
	 * Exit:
	 * 		Green Flash - Car Has Exited Campus!!
	 */
	@Override
	protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
	        g.drawImage(map, 0, 0, this.getWidth(), this.getHeight(), null);
	        g.setColor(Color.RED);
	        for(Intersection intersection : intersectionList) {
	        	g.fillOval(intersection.getXPosition(), intersection.getYPosition(), INTERSECTION_SIZE, INTERSECTION_SIZE);
	        	if(intersection.shouldFlash() && !intersection.hasPoliceOfficer()) {
		        	g.setColor(Color.GREEN);
		        	g.fillOval(intersection.getXPosition(), intersection.getYPosition(), INTERSECTION_SIZE, INTERSECTION_SIZE);
	    	        repaint();
	    	        validate();
	        	}
	        	else if(intersection.shouldFlash() && intersection.hasPoliceOfficer()){
	        		g.setColor(Color.BLUE);
		        	g.fillOval(intersection.getXPosition(), intersection.getYPosition(), INTERSECTION_SIZE, INTERSECTION_SIZE);
	    	        repaint();
	    	        validate();
	        	}
	        	g.setColor(Color.RED);
	        	repaint();
    	        validate();
	        }
	        for(Exit exit : exitList) {
	        	g.fillRect(exit.getXPosition(), exit.getYPosition(), EXIT_SIZE, EXIT_SIZE);
	        	if(exit.shouldFlash()) {
		        	g.setColor(Color.GREEN);
		        	g.fillRect(exit.getXPosition(), exit.getYPosition(), EXIT_SIZE, EXIT_SIZE);
	    	        repaint();
	    	        validate();
	        	}
	        	g.setColor(Color.RED);
	        	repaint();
    	        validate();
	        }
	    }
}