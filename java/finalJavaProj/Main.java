package finalJavaProj;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
	private static boolean inList(int val, int[] list) {
		for(int i = 0; i < list.length; i++)
			if(val == list[i])
				return true;
		return false;
	}
    public static void main(String[] args) {
        class Initialize implements Runnable{
            @Override
            public void run() {
                List<Station> statii = new ArrayList<>();
                List<Sale> vanzari = new ArrayList<>();
                List<Train> trenuri = new ArrayList<>();
                String[] stations = {"Alba Iulia","Alexandria","Arad","Bacau","Baia Mare","Barlad","Bistrita","Botosani","Braila","Brasov","Bucuresti Nord","Buzau","Calarasi","Cernavoda","Cluj Napoca","Constanta","Craiova","Deva","Drobeta-Turnu Severin","Focsani","Galati","Giurgiu","Hunedoara","Iasi","Lugoj","Medgidia","Medias","Oradea","Piatra Neamt","Pitesti","Ploiesti","Ramnicu Valcea","Resita","Roman","Satu Mare","Sfantu Gheorge","Sibiu","Slatina","Slobozia","Suceava","Targoviste","Targu Jiu","Targu Mures","Timisoara","Tulcea","Turda","Vaslui","Voluntari","Zalau"};
                String[]  types = {"Personal","Intercity","Accelerated","Fast"};
                for(int i = 0; i < 100; i++) {
                	int randomNum = ThreadLocalRandom.current().nextInt(0, stations.length);
                	int[] indexes = new int[8];
                	indexes[0] = randomNum;
                	int count = 1;
                	Station begin = new Station(stations[randomNum],LocalDateTime.of(2021, i % 12 + 1, i % 30 + 1, i % 15, 00, 00),(float)(300 + Math.pow(-1,  i)*(i % 201)));
                	statii.add(begin);
                	Station aux;
                	int stats = i % 4;
                	for(int j = 0; j < stats; j++) {
                		int rand = ThreadLocalRandom.current().nextInt(0, stations.length);
                		while(inList(rand, indexes)) {
                			rand = ThreadLocalRandom.current().nextInt(0, stations.length);
                		}
                		indexes[count++] = rand;
                		aux = new Station(stations[rand],LocalDateTime.of(2021, i % 12 + 1, i % 30 + 1, i % 15 + j, 00, 00),(float)(300 + Math.pow(-1,  i)*(i % 201)));
                		statii.add(aux);
                		
                	}
                	int rand2 = ThreadLocalRandom.current().nextInt(0, stations.length);
                	while(inList(rand2, indexes)) {
                		rand2 = ThreadLocalRandom.current().nextInt(0, stations.length);
                	}
                	Station end = new Station(stations[rand2],LocalDateTime.of(2021, i % 12 + 1, i % 30 + 1 , i % 15 + 7, 00, 00),(float)(600 + Math.pow(-1,  i)*(i % 201)));
                	statii.add(end);
                	Train t = new Train(i,begin,end,statii,types[i % 4]);
                	System.out.println(t.toString());
                    trenuri.add(t);
                    statii.clear();
                }
                TrainScheduler mt = new TrainScheduler(trenuri,vanzari);
                FirstFrame initialize = new FirstFrame(mt);
                initialize.pack();
                initialize.setVisible(true);
                initialize.setLocationRelativeTo(null);
                initialize.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            
        }
        Thread t1 = new Thread(new Initialize());
        t1.start();
    }
    
}
