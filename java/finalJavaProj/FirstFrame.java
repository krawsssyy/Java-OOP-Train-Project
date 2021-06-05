package finalJavaProj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@SuppressWarnings("serial")
public class FirstFrame extends JFrame {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private JLabel title,departure, arrival, depTime, arrTime, depDate, arrDate, maxPrice, trainClass,intermStation,trainType,CNP;
    @SuppressWarnings("rawtypes")
	private JComboBox secDep, secArr, depTime2, arrTime2, secClass,secIntermStation,secTrainType;
    private JTextField secMaxPrice,depDate2, arrDate2,CNP2;
    private JButton show;
    private JRadioButton student,elderly,veteran,normal;
    @SuppressWarnings("unused")
	private TrainScheduler ts;
    private int redType=0;
    private GridBagConstraints gbc;
    private String[] hours={"Choose...","00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"},
            classes={"Choose...","First Class","Second Class"},
            types={"Choose...","Personal","Intercity","Accelerated","Fast"},
            stations={"Choose...","Alba Iulia","Alexandria","Arad","Bacau","Baia Mare","Barlad","Bistrita","Botosani","Braila","Brasov","Bucuresti Nord","Buzau","Calarasi","Cernavoda","Cluj Napoca","Constanta","Craiova","Deva","Drobeta-Turnu Severin","Focsani","Galati","Giurgiu","Hunedoara","Iasi","Lugoj","Medgidia","Medias","Oradea","Piatra Neamt","Pitesti","Ploiesti","Ramnicu Valcea","Resita","Roman","Satu Mare","Sfantu Gheorge","Sibiu","Slatina","Slobozia","Suceava","Targoviste","Targu Jiu","Targu Mures","Timisoara","Tulcea","Turda","Vaslui","Voluntari","Zalau"};
    @SuppressWarnings({ "unchecked", "rawtypes" })
	FirstFrame(TrainScheduler ts){
        super("TRAIN SCHEDULER");
        this.ts = ts;
        JPanel p1 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(0,0,0,30);
        title = new JLabel("TRAIN SCHEDULER");
        title.setFont(new Font("Verdana", Font.PLAIN, 30));
        p1.add(title,gbc);
        this.add(p1,BorderLayout.NORTH);
        JPanel p2 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,100,4,50);
        departure = new JLabel("DEPARTURE STATION");
        p2.add(departure,gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,150,4,100);
        arrival = new JLabel("ARRIVAL STATION");
        p2.add(arrival,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,100,10,50);
        secDep = new JComboBox(stations);
        p2.add(secDep,gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(0,150,10,100);
        secArr = new JComboBox(stations);
        p2.add(secArr,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,50,4,80);
        intermStation = new JLabel("INTERMEDIARY STATION");
        p2.add(intermStation,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0,50,10,80);
        secIntermStation = new JComboBox(stations);
        p2.add(secIntermStation,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(35,100,30,130);
        depTime = new JLabel("DEPARTURE TIME");
        p2.add(depTime,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(35,70,30,100);
        arrTime = new JLabel("ARRIVAL TIME");
        p2.add(arrTime,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,100,20,130);
        depTime2 = new JComboBox(hours);
        p2.add(depTime2,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(10,70,20,100);
        arrTime2 = new JComboBox(hours);
        p2.add(arrTime2,gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(35,100,20,150);
        depDate = new JLabel("DEPARTURE DATE");
        p2.add(depDate,gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(35,50,20,100);
        arrDate = new JLabel("ARRIVAL DATE");
        p2.add(arrDate,gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,100,20,150);
        depDate2 = new JTextField(10);
        p2.add(depDate2,gbc);
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.insets = new Insets(10,50,20,100);
        arrDate2 = new JTextField(10);
        p2.add(arrDate2,gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(10,0,4,35);
        maxPrice = new JLabel("MAX PRICE(RON)");
        p2.add(maxPrice,gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(0,0,35,35);
        secMaxPrice = new JTextField(10);
        p2.add(secMaxPrice,gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10,100,4,50);
        trainType = new JLabel("TRAIN TYPE");
        p2.add(trainType,gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(10,100,4,50);
        trainClass = new JLabel("TRAIN CLASS");
        p2.add(trainClass,gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.insets = new Insets(0,100,10,50);
        secTrainType = new JComboBox(types);
        p2.add(secTrainType,gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.insets = new Insets(0,150,10,100);
        secClass = new JComboBox(classes);
        p2.add(secClass,gbc);
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.insets = new Insets(50,0,0,50);
        JLabel reducere = new JLabel("REDUCTION TYPE: ");
        p2.add(reducere,gbc);
        ButtonGroup bg = new ButtonGroup();
        student = new JRadioButton("Student");
        elderly = new JRadioButton("Elderly");
        veteran = new JRadioButton("Veteran");
        normal = new JRadioButton("No reduction");
        bg.add(student);
        bg.add(elderly);
        bg.add(veteran);
        bg.add(normal);
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CNP2.setEditable(true);
                redType=2;
            }
        });
        elderly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CNP2.setEditable(true);
                redType=1;
            }
        });
        veteran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CNP2.setEditable(true);
                redType=3;
            }
        });
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CNP2.setEditable(false);
                redType=0;
            }
        });
        
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.insets = new Insets(10,10,10,60);
        p2.add(student,gbc);
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10,5,10,60);
        p2.add(elderly,gbc);
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.insets = new Insets(10,5,10,55);
        p2.add(veteran,gbc);
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.insets = new Insets(10,5,10,30);
        p2.add(normal,gbc);
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.insets = new Insets(50,100,4,50);
        CNP = new JLabel("CNP");
        p2.add(CNP,gbc);
        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.insets = new Insets(50,100,4,50);
        CNP2 = new JTextField(13);
        CNP2.setEditable(false);
        p2.add(CNP2,gbc);
        this.add(p2,BorderLayout.CENTER);
        JPanel p3 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        show = new JButton("SHOW RESULTS");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(10,100,10,100);
        p3.add(show,gbc);
        show.addActionListener(e -> {
            String date = depDate2.getText()+" "+depTime2.getSelectedItem().toString();
            if(secIntermStation.getSelectedIndex()==0){
                var foundTrains = ts.trainsLookup(secDep.getSelectedItem().toString(), secArr.getSelectedItem().toString(),null,redType,secTrainType.getSelectedItem().toString(),Double.parseDouble(secMaxPrice.getText()),secClass.getSelectedIndex(),LocalDateTime.parse(date,formatter));
                TrainsResultTable t1 = new TrainsResultTable(ts,foundTrains,secClass.getSelectedIndex(),redType,secDep.getSelectedItem().toString(),secArr.getSelectedItem().toString(),secTrainType.getSelectedItem().toString(), CNP2.getText());
                t1.pack();
                t1.setVisible(true);
                t1.setLocationRelativeTo(null);
                t1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.dispose();
            }
            else {
                        var foundTrains = ts.trainsLookup(secDep.getSelectedItem().toString(),secArr.getSelectedItem().toString(),secIntermStation.getSelectedItem().toString(),redType,secTrainType.getSelectedItem().toString(),Double.parseDouble(secMaxPrice.getText()),secClass.getSelectedIndex(),LocalDateTime.parse(date,formatter));
                        TrainsResultTable tt = new TrainsResultTable(ts,foundTrains,secClass.getSelectedIndex(),redType,secDep.getSelectedItem().toString(),secArr.getSelectedItem().toString(), secTrainType.getSelectedItem().toString(),CNP2.getText());
                        tt.pack();
                        tt.setVisible(true);
                        tt.setLocationRelativeTo(null);
                        tt.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        this.dispose();
                }
        });
        JLabel ceas = new JLabel();
        @SuppressWarnings("unused")
		Clock c = new Clock(ceas);
        gbc.gridx=1;gbc.gridy=0;gbc.insets = new Insets(10,100,10,100);
        p3.add(ceas,gbc);
        this.add(p3,BorderLayout.SOUTH);    
    }
    @SuppressWarnings("rawtypes")
	public JComboBox getTrainClass(){
        return this.secClass;
    }
    @SuppressWarnings("rawtypes")
	public JComboBox getDeparture(){
        return this.secDep;
    }
    @SuppressWarnings("rawtypes")
	public JComboBox getArrival(){
        return this.secArr;
    }
    public void setRedType(int type){
        this.redType = type;
    } 
    
}
