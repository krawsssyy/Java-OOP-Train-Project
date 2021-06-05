package finalJavaProj;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ThirdFrame extends JFrame{
	private JLabel price, price2, depStat, depStat2, arrStat, arrStat2, trainCls, trainCls2, trainid, trainid2, cnp, cnp2,red, red2;
	private JButton buy, back;
	@SuppressWarnings("unused")
	private TrainScheduler ts;
	@SuppressWarnings("unused")
	private List<Train> foundTrains;
	private Train givenTrain = null;
	GridBagConstraints gbc = new GridBagConstraints();
	ThirdFrame(TrainScheduler ts,List<Train> foundTrains,int trainClass,int redType,String depStation,String arrStation, String trainType, int trainID, String CNP){
		super("BUYING MENU");
		this.ts = ts;
		this.foundTrains = foundTrains;
		for(Train t : foundTrains) {
        	if(t.getTrainID() == trainID)
        		givenTrain = t;
        	}
		 JPanel p1 = new JPanel(new GridBagLayout());
		 gbc = new GridBagConstraints();
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     gbc.insets = new Insets(5,100,4,50);
	     price = new JLabel("Final price : ");
	     p1.add(price,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 0;
	     gbc.insets = new Insets(5,100,4,50);
	     price2 = new JLabel(String.valueOf(givenTrain.calcPrice(trainClass, depStation, arrStation, redType)).substring(0, 5));
	     p1.add(price2, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 1;
	     gbc.insets = new Insets(5,100,4,50);
	     depStat = new JLabel("Departure: ");
	     p1.add(depStat,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 1;
	     gbc.insets = new Insets(5,100,4,50);
	     depStat2 = new JLabel(depStation);
	     p1.add(depStat2, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 2;
	     gbc.insets = new Insets(5,100,4,50);
	     arrStat = new JLabel("Arrival: ");
	     p1.add(arrStat,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 2;
	     gbc.insets = new Insets(5,100,4,50);
	     arrStat2 = new JLabel(arrStation);
	     p1.add(arrStat2, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 3;
	     gbc.insets = new Insets(5,100,4,50);
	     trainCls = new JLabel("Train Class: ");
	     p1.add(trainCls,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 3;
	     gbc.insets = new Insets(5,100,4,50);
	     trainCls2 = new JLabel(String.valueOf(trainClass));
	     p1.add(trainCls2, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 4;
	     gbc.insets = new Insets(5,100,4,50);
	     trainid = new JLabel("Train ID: ");
	     p1.add(trainid,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 4;
	     gbc.insets = new Insets(5,100,4,50);
	     trainid2 = new JLabel(String.valueOf(trainID));
	     p1.add(trainid2, gbc);
	     gbc.gridx = 0;
	     gbc.gridy = 5;
	     gbc.insets = new Insets(5,100,4,50);
	     red = new JLabel("Reduction type: ");
	     p1.add(red,gbc);
	     gbc.gridx = 1;
	     gbc.gridy = 5;
	     gbc.insets = new Insets(5,100,4,50);
	     red2 = new JLabel(String.valueOf(redType));
	     p1.add(red2, gbc);
	     if(redType != 0 ) {
	    	 gbc.gridx = 0;
		     gbc.gridy = 6;
		     gbc.insets = new Insets(5,100,4,50);
		     cnp = new JLabel("CNP: ");
		     p1.add(cnp,gbc);
		     gbc.gridx = 1;
		     gbc.gridy = 6;
		     gbc.insets = new Insets(5,100,4,50);
		     cnp2 = new JLabel(CNP);
		     p1.add(cnp2, gbc);
	     }
	     this.add(p1,BorderLayout.CENTER);
	     JPanel p2 = new JPanel(new GridBagLayout());
		 gbc = new GridBagConstraints();
		 back = new JButton("Back");
	     back.addActionListener(e -> {
	    	 SecFrame Frame1 = new SecFrame(ts,foundTrains,trainClass,redType,depStation,arrStation,trainType, trainID, CNP);
	         Frame1.pack();
	         Frame1.setVisible(true);
	         Frame1.setLocationRelativeTo(null);
	         Frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	         this.dispose();
	     });
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     gbc.insets = new Insets(25,10,10,5);
	     p2.add(back,gbc);
	     buy = new JButton("Buy this ticket");
	     buy.addActionListener(e -> {
	    	 List<Sale> vanzari = new ArrayList<>();
	    	 vanzari = ts.getSales();
	    	 int seat = Sale.getAvailableSeats(trainID);
	    	 if(seat == -1) {
	    		JOptionPane.showMessageDialog(this, "No more places left for this train!");
	        	return;
	    	 }
	    	 Sale s = new Sale(givenTrain, trainClass, (float)givenTrain.calcPrice(trainClass, depStation, arrStation, redType), CNP, seat);
	    	 vanzari.add(s);
	    	 ts.setSales(vanzari);
	    	 System.out.println("RECEIPT: ");
	    	 System.out.println("+-------+----------------+-------------------+------------------+---------+---------------+--------------+-----------+");
 	 		 System.out.println("|  Id   |     Type       |     Departure     |     Arrival      |  Price  |   Reduction   |      CNP     |    Seat   |");
 	 		 System.out.println("+-------+----------------+-------------------+------------------+---------+---------------+--------------+-----------+");
 	 		 String alignment = "| %-5d | %-14s | %-17s | %-16s | %-7s | %-13d | %-12s | %-9d | \n";
	 		 DecimalFormat twoDForm = new DecimalFormat("#.##");
	 		 String price = twoDForm.format(givenTrain.calcPrice(trainClass, depStation, arrStation, redType));
	 		 System.out.format(alignment, trainID, trainType, depStation, arrStation, price, redType, CNP, seat);
	 		 System.out.println("+-------+----------------+-------------------+------------------+---------+---------------+--------------+-----------+");
	 		 System.out.println("");
	    	 JOptionPane.showMessageDialog(this, "Transaction successful! Your receipt will be printed shortly!");
	    	 this.dispose();
	    	 System.exit(0);
	     });
	     gbc.gridx = 1;
	     gbc.gridy = 0;
	     gbc.insets = new Insets(25,5,10,10);
	     p2.add(buy,gbc);
	     JLabel clock = new JLabel();
	     @SuppressWarnings("unused")
	     Clock c = new Clock(clock);
	     gbc.gridx=2;
	     gbc.gridy=0;
	     gbc.insets = new Insets(10,100,10,100);
	     p2.add(clock,gbc);
	     this.add(p2,BorderLayout.SOUTH);
	     
	}

}
