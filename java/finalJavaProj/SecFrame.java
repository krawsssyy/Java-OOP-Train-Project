package finalJavaProj;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
@SuppressWarnings("serial")
public class SecFrame extends JFrame {
    private JLabel title,depTime,arrTime;
    private JButton goBack,calculate;
    @SuppressWarnings("unused")
	private TrainScheduler ts;
    @SuppressWarnings("unused")
	private List<Train> foundTrains;
    GridBagConstraints gbc = new GridBagConstraints();
    SecFrame(TrainScheduler ts,List<Train> foundTrains,int trainClass,int redType,String depStation,String arrStation, String trainType, int trainID, String CNP){
        super("RESULTS");
        this.ts = ts;
        this.foundTrains = foundTrains;
        LocalDateTime dep = null, arr = null;
        for(Train t : foundTrains) {
        	if(t.getTrainID() == trainID)
        		{
        		dep = t.getDeparture().getTime();
        		arr = t.getArrival().getTime();
        		}
        	}
        JPanel p1 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(0,0,0,30);
        title = new JLabel("TRAIN SCHEDULES");
        title.setFont(new Font("Verdana", Font.PLAIN, 30));
        p1.add(title,gbc);
        this.add(p1,BorderLayout.NORTH);
        JPanel p2 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy=1;
        gbc.insets = new Insets(5,100,4,50);
        depTime = new JLabel("DEPARTURE OF CHOSEN TRAIN");
        p2.add(depTime,gbc);
        gbc.gridx = 0;
        gbc.gridy=2;
        gbc.insets = new Insets(5,100,4,50);
        JLabel depTime2 = new JLabel(dep.toString());
        p2.add(depTime2,gbc);
        gbc.gridx = 2;
        gbc.gridy=1;
        gbc.insets = new Insets(5,50,4,50);
        arrTime = new JLabel("ARRIVAL OF CHOSEN TRAIN");
        p2.add(arrTime,gbc);
        gbc.gridx = 2;
        gbc.gridy=2;
        gbc.insets = new Insets(5,50,4,50);
        JLabel arrTime2 = new JLabel(arr.toString());
        p2.add(arrTime2,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(50,0,0,0);
        JLabel reduction = new JLabel("REDUCTION TYPE: ");
        p2.add(reduction,gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.insets = new Insets(50,0,0,0);
        JLabel redText = null;
        if(redType == 0) {
        	redText = new JLabel("Normal");
        }
        else if(redType == 1) {
        	redText = new JLabel("Elderly");
        }
        else if(redType == 2) {
        	redText = new JLabel("Student");
        }
        else if(redType == 3) { 
        	redText = new JLabel("Veteran");
        }
        p2.add(redText, gbc);
        
        this.add(p2,BorderLayout.CENTER);
        JPanel p3 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        goBack = new JButton("Back");
        goBack.addActionListener(e -> {
            TrainsResultTable TrainsTable = new TrainsResultTable(ts,foundTrains,trainClass,redType,depStation,arrStation,trainType, CNP);
            TrainsTable.pack();
            TrainsTable.setVisible(true);
            TrainsTable.setLocationRelativeTo(null);
            TrainsTable.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.dispose();
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(25,10,10,5);
        p3.add(goBack,gbc);
        calculate = new JButton("CALCULATE PRICE");
        calculate.addActionListener(e -> {
        	ThirdFrame Frame3 = new ThirdFrame(ts,foundTrains,trainClass,redType,depStation,arrStation,trainType, trainID, CNP);
            Frame3.pack();
            Frame3.setVisible(true);
            Frame3.setLocationRelativeTo(null);
            Frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.dispose();
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(25,5,10,10);
        p3.add(calculate,gbc);
        JLabel clock = new JLabel();
        @SuppressWarnings("unused")
		Clock c = new Clock(clock);
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.insets = new Insets(10,100,10,100);
        p3.add(clock,gbc);
        this.add(p3,BorderLayout.SOUTH);
    }
}
