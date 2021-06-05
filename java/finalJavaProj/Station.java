package finalJavaProj;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Station {
    private static int stationId=0;
    private String city;
    private LocalDateTime time;
    private double km;
    private double price;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public Station(String city, LocalDateTime time, float km) {
        this.city = city;
        this.time = time;
        this.km = km;
        stationId++;
        price = km/5;
    }
    Station(String str, int i) throws Exception {
        throw new Exception("Unsupported operation made!");
    }
    public static int getStationId() {
        return stationId;
    }
    public String getCity() {
        return city;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public double getKm() {
        return km;
    }
    public double getFirstClassPrice() {
        return price+(price*4/10);
    }
    public double getSecondClassPrice() {
        return price;
    }
    public static void setStationId(int stationID) {
        Station.stationId = stationID;
    }  
    public void setCity(String city) {
        this.city = city;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public void setKm(float km) {
        this.km = km;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return " City = '" + city + '\'' +
                "/ Date & Time = " + time.format(formatter) +
                "/ km = " + km;
    }
}

