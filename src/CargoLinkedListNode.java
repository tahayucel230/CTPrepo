public class CargoLinkedListNode {
    public Cargo cargo;
    CargoLinkedListNode next;

    public CargoLinkedListNode(String productName, int ID, String date, String cargoState, int howManyDays, String userName, String location){
        this.cargo = new Cargo(productName, ID, date, cargoState, howManyDays, userName, location);
    }

    public int count(int count){

        //
        System.out.println("cargo count:" + count);
        //

        if (next == null){
            return count;
        } else {
            return next.count(count+1);
        }
    }
    public int count(){
        if (next == null){
            return 1;
        } else {
            return next.count(2);
        }
    }

    public void newNode(String productName, int ID, String date, String cargoState, int howManyDays, String userName, String location){
        if (next == null){
            next = new CargoLinkedListNode(productName, ID, date, cargoState, howManyDays, userName, location);
        } else {
            next.newNode(productName, ID, date, cargoState, howManyDays, userName, location);
        }
    }

    public CargoLinkedListNode getNode(int nodeID){
        if (nodeID == 0){
            return this;
        } else {
            if (next != null){
                return next.getNode(nodeID-1);
            } else {
                return this;
            }
        }
    }
}
