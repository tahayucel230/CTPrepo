public class User {
    public String name, password, surname, cargoHistory;
    public int ID;

    public User(int ID, String name, String surname, String password, String cargoHistory){
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.cargoHistory = cargoHistory;
    }
}
