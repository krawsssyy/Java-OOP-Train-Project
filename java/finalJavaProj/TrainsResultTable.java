package finalJavaProj;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.LinkedHashSet;
import javax.swing.table.DefaultTableModel;
@SuppressWarnings("serial")
public class TrainsResultTable extends JFrame {
    private JTable tabel;
    @SuppressWarnings("unused")
	private TrainScheduler ts;
    @SuppressWarnings("unused")
	private List<Train> foundTrains;
    private JButton frame1,frame2;
    TrainsResultTable(TrainScheduler ts,List<Train> foundTrains,int trainClass,int redType,String depStation, String arrStation,String type, String CNP){
        super("RESULTS");
        this.ts=ts;
        this.foundTrains = foundTrains;
        JPanel p1 = new JPanel();
        tabel = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String header[] = new String[] {"ID Tren",
        "Departure Station",
        "Time of departure",
        "Date of departure",
        "Arrival station",
        "Time of arrival",
        "Date of arrival",
        "Train Type", 
        "Class",
        "Price"};
        dtm.setColumnIdentifiers(header);
        tabel.setModel(dtm);
        JScrollPane scrollPane = new JScrollPane(tabel);
        tabel.setFillsViewportHeight(true);
        LinkedHashSet<String[]> trains = new LinkedHashSet<String[]>();
       // String intermStation = null;
        if(foundTrains != null) {
            for (int count = 0; count < foundTrains.size(); count++) {
	            if(foundTrains.get(count).stationLookup(depStation)!=null && foundTrains.get(count).stationLookup(arrStation)!=null){
	                    String[] train = {
	                    String.valueOf(foundTrains.get(count).getTrainID()), 
	                    depStation, 
	                    String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getHour())+":"+String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getMinute()),
	                    String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getDayOfMonth())+"."+foundTrains.get(count).stationLookup(depStation).getTime().getMonth().name()+"."+String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getYear()),
	                    arrStation,
	                    String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getHour())+":"+String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getMinute()),
	                    String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getDayOfMonth())+"."+foundTrains.get(count).stationLookup(arrStation).getTime().getMonth().name()+"."+String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getYear()),
	                    foundTrains.get(count).getType(),
	                    String.valueOf(trainClass),
	                    String.valueOf(foundTrains.get(count).calcPrice(trainClass,depStation,arrStation,redType)).substring(0, 5)
	                    };
	                    trains.add(train);
	            }
	          /*  else if(foundTrains.get(count).stationLookup(depStation) != null && foundTrains.get(count).stationLookup(arrStation)==null ){
	                intermStation=foundTrains.get(count).getArrival().getCity();
	                String[] train = {
	                    String.valueOf(foundTrains.get(count).getTrainID()), 
	                    depStation, 
	                    String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getHour())+":"+String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getMinute()),
	                    String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getDayOfMonth())+"."+foundTrains.get(count).stationLookup(depStation).getTime().getMonth().name()+"."+String.valueOf(foundTrains.get(count).stationLookup(depStation).getTime().getYear()),
	                    intermStation,
	                    String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getHour())+":"+String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getMinute()),
	                    String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getDayOfMonth())+"."+foundTrains.get(count).stationLookup(intermStation).getTime().getMonth().name()+"."+String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getYear()),
	                    foundTrains.get(count).getType(),
	                    String.valueOf(trainClass),
	                    String.valueOf(foundTrains.get(count).calcPrice(trainClass,depStation,intermStation,redType)).substring(0, 5)
	                    };
	                    trains.add(train);
	            }
	            else if(foundTrains.get(count).stationLookup(depStation) == null && foundTrains.get(count).stationLookup(arrStation)!=null ){
	                String[] train = {
	                    String.valueOf(foundTrains.get(count).getTrainID()), 
	                    intermStation, 
	                    String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getHour())+":"+String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getMinute()),
	                    String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getDayOfMonth())+"."+foundTrains.get(count).stationLookup(intermStation).getTime().getMonth().name()+"."+String.valueOf(foundTrains.get(count).stationLookup(intermStation).getTime().getYear()),
	                    arrStation,
	                    String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getHour())+":"+String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getMinute()),
	                    String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getDayOfMonth())+"."+foundTrains.get(count).stationLookup(arrStation).getTime().getMonth().name()+"."+String.valueOf(foundTrains.get(count).stationLookup(arrStation).getTime().getYear()),
	                    foundTrains.get(count).getType(),
	                    String.valueOf(trainClass),
	                    String.valueOf(foundTrains.get(count).calcPrice(trainClass,intermStation,arrStation,redType)).substring(0, 5)
	                    };
	                    trains.add(train);
	                    intermStation = null;
	            }     */
 }
        }
        for(String[] el: trains)
        {
            dtm.addRow(el);
        }
        tabel.setPreferredScrollableViewportSize(tabel.getPreferredSize());
        p1.add(scrollPane);
        JPanel p2 = new JPanel();
        JTextField tf = new JTextField(10);
        tf.setToolTipText("Enter the id of the train you want");
        p2.add(tf);
        frame1 = new JButton("Back");
        frame2 = new JButton("Next");
        frame1.addActionListener(e -> {
            FirstFrame Frame1 = new FirstFrame(ts);
            Frame1.pack();
            Frame1.setVisible(true);
            Frame1.setLocationRelativeTo(null);
            Frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            Frame1.getDeparture().setSelectedItem(depStation);
            Frame1.getArrival().setSelectedItem(arrStation);
            Frame1.getTrainClass().setSelectedIndex(trainClass);
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
            this.dispose();
        });
        frame2.addActionListener(e -> {
        	if(tf.getText().equals("")) {
        		JOptionPane.showMessageDialog(this, "Please input a train ID!");
        		return;
        	}
        	boolean ok = false;
        	for(Train t : foundTrains) {
        		if(String.valueOf(t.getTrainID()).equals(tf.getText()))
        			ok = true;
        	}
        	if(!ok) {
        		JOptionPane.showMessageDialog(this, "Please input a correct train ID!");
        		return;
        	}
            SecFrame Frame1 = new SecFrame(ts,foundTrains,trainClass,redType,depStation,arrStation,type, Integer.parseInt(tf.getText()), CNP);
            Frame1.pack();
            Frame1.setVisible(true);
            Frame1.setLocationRelativeTo(null);
            Frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.dispose();
        });
        p2.add(frame1);
        p2.add(frame2);
        JLabel clock = new JLabel();
        @SuppressWarnings("unused")
		Clock c = new Clock(clock);
        p2.add(clock);
        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.SOUTH);
    }
}
    
