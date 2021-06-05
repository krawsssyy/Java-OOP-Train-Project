package finalJavaProj;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class TrainScheduler {
    private List<Train> trains = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();
    public TrainScheduler(List<Train> trains, List<Sale> sales) {
        this.trains = trains;
        this.sales = sales;
    }
    public List<Train> trainsLookup(String leavingStation, String arrivalStation, String intermediaryStation,int reductionType, String trainType, double maxPrice, int trainClass, LocalDateTime departureTime){
       List<Train> foundTrains = new ArrayList<>();
       for(Train t : this.trains) {
        	if(t.getType().equals(trainType) && t.stationExists(leavingStation) == true && t.stationExists(arrivalStation) == true && t.stationLookup(arrivalStation).getTime().isAfter(LocalDateTime.from(departureTime)))
        		foundTrains.add(t);
        }
        
        if(intermediaryStation != null){
            foundTrains = foundTrains.stream().filter(t -> t.stationExists(intermediaryStation) == true).collect(Collectors.toList());
        }
        if(!foundTrains.isEmpty()){
            if(trainClass==2){
                foundTrains = foundTrains.stream().filter(t -> t.calcPrice(2,leavingStation,arrivalStation,reductionType) < maxPrice).collect(Collectors.toList());
                return foundTrains;
            }
            if(trainClass==1){
                foundTrains = foundTrains.stream().filter(t -> t.calcPrice(1,leavingStation,arrivalStation,reductionType) < maxPrice).collect(Collectors.toList());
                return foundTrains;
            }
        }
        return null;

    }
    public List<Train> getTrains() {
        return this.trains;
    }
    public List<Sale> getSales() {
        return this.sales;
    }
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
    public void setSales(List<Sale> vanzari) {
        this.sales = vanzari;
    }
}
