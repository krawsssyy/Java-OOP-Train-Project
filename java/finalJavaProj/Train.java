package finalJavaProj;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class Train {
    private int trainID = 0;
    private Station departure,arrival;
    private List<Station> stations;
    private String type;
    private Reduction red = null;
    public Train(int trainID, Station departure, Station arrival, List<Station> stations, String type) {
        this.trainID = trainID;
        this.departure = departure;
        this.arrival = arrival;
        this.stations = stations;
        this.type = type;
    }
    private static class Reduction {
        private double specialPrice;
        @SuppressWarnings("unused")
		private LocalDateTime beginDate;
        @SuppressWarnings("unused")
		private LocalDateTime endDate;

        public Reduction(double reduction, LocalDateTime beginDate, LocalDateTime endDate){
            this.specialPrice = reduction;
            this.beginDate = beginDate;
            this.endDate = endDate;
        }
    }
    public void setReduction(double reduction, LocalDateTime beginDate, LocalDateTime endDate){
        Reduction s = new Reduction(reduction,beginDate,endDate);
        this.red = s;
    }
    public double calcPrice(int trainClass, String depStation, String arrStation, int reductionType) {
        Station foundArrival = null;
        Station foundDeparture = null;
        double price;
        foundArrival = this.stationLookup(depStation);
        foundDeparture = this.stationLookup(arrStation);
        if (trainClass == 1) {
            price = foundDeparture.getFirstClassPrice() - foundArrival.getFirstClassPrice();
        } else price = foundDeparture.getSecondClassPrice() - foundArrival.getSecondClassPrice();
        switch (reductionType) {
            case 0:
                if(red != null){
                    return price - red.specialPrice;
                }
                else return price;
            case 1:
                if(red != null){
                    return price - (price * 20 / 100) - red.specialPrice;
                }
                else return price - (price * 20 / 100);
            case 2:
                if(red != null){
                    return price - (price * 40 / 100) - red.specialPrice;
                }
                else return price - (price * 40 / 100);
            case 3:
                if(red != null){
                    return price - (price * 60 / 100) - red.specialPrice;
                }
                else return price - (price * 60 / 100);
        }
        return 0;
    }
    public int getTrainID() {
        return this.trainID;
    }
    public Station getDeparture() {
        return this.departure;
    }
    public Station getArrival() {
        return this.arrival;
    }
    public List<Station> getStations() {
        return this.stations;
    }
    public String getType() {
        return this.type;
    }
    public Reduction getSpecial() {
        return this.red;
    }
    public void setDeparture(Station departure) {
        this.departure = departure;
    }
    public void setArrival(Station arrival) {
        this.arrival = arrival;
    }
    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setSpecial(Reduction special) {
        this.red = special;
    }
    public boolean stationExists(String Station) {
        if(Station.equals(departure.getCity()))
            return true;
        for (Station s : stations) {
            if (s.getCity().equals(Station)) return true;
        }
        if(Station.equals(arrival.getCity()))
            return true;
        return false;
    }
    public Station stationLookup(String Station){
        if(Station.equals(departure.getCity()))
            return departure;
        for (Station s : stations) {
            if (s.getCity().equals(Station)) return s;
        }
        if(Station.equals(arrival.getCity()))
            return arrival;
        return null;
    }
    @Override
    public String toString() {
        return "Tren : " +
                "Train ID = " + trainID +
                "/ Departure = " + departure +
                "/ Arrival =" + arrival +
                "/ Stations = " + stations +
                "/ Type = '" + type + ';' +
                " Special = " + red +
                '.';
    }
}