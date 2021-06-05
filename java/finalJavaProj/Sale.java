package finalJavaProj;
public class Sale {
    private static int saleID = 0;
    private Train train;
    private int trainClass;
    private float finPrice;
    private String CNP;
    private static boolean[][] seats = new boolean[100][50];
    public Sale(Train train, int trainClass, float finPrice, String CNP, int seat) {
        this.train = train;
        this.trainClass = trainClass;
        this.finPrice = finPrice;
        this.CNP = CNP;
        seats[train.getTrainID()][seat] = true;
        saleID++;
    }
    public static int getAvailableSeats(int trainID) {
    	for(int j = 0; j < 50; j++)
    		if(seats[trainID][j] == false)
    			return j;
    	return -1;
    }
    public static int getSaleID() {
        return saleID;
    }
    public Train getTrain() {
        return this.train;
    } 
    public int getTrainClass() {
        return this.trainClass;
    }
    public float getFinalPrice() {
        return this.finPrice;
    }
    public String getCNP() {
        return CNP;
    }
    public static void setSaleID(int saleID) {
        Sale.saleID = saleID;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    public void setTrainClass(int trainClass) {
        this.trainClass = trainClass;
    }
    public void setFinalPrice(float finPrice) {
        this.finPrice = finPrice;
    }
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}
