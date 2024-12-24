public class Cargo {
    public int ID, howManyDays;
    public String productName, date, cargoState, userName, location;
    //Location receiverLocation, senderLocation;
    public Cargo(String productName, int ID, String date, String cargoState, int howManyDays, String userName, String location){
        this.productName = productName;
        this.ID = ID;
        this.date = date;
        this.cargoState = cargoState;
        this.howManyDays = howManyDays;
        this.userName = userName;
        this.location = location;
    }
}
