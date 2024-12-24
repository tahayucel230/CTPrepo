public class UserLinkedListNode {
    public User user;
    UserLinkedListNode next;

    public UserLinkedListNode(int ID, String name, String surname, String password, String cargoHistory){
        this.user = new User(ID, name, surname, password, cargoHistory);
    }

    private int count(int count){
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

    public void newNode(int ID, String name, String surname, String password, String cargoHistory){
        if (next == null){
            next = new UserLinkedListNode(ID, name, surname, password, cargoHistory);
        } else {
            next.newNode(ID, name, surname, password, cargoHistory);
        }
    }

    public void newUser(String name, String surname, String password){
        // THIS vvvvvvvvvv MAKES IT SO THAT THIS WHOLE THING ONLY WORKS FOR APP.USERS AND NO OTHER USER LINKED LIST FOR NOW
        int ID = App.users.count();
        // THIS ^^^^^^^^^^ MAKES IT SO THAT THIS WHOLE THING ONLY WORKS FOR APP.USERS AND NO OTHER USER LINKED LIST FOR NOW
        
        newNode(ID, name, surname, password, "-,-,-,-,-");
    }

    public UserLinkedListNode getNode(int nodeID){
        
        //
        //System.out.println("1- i am " + this.user.name + " and getNode: " + nodeID);
        //
        
        if (nodeID == 0){
        
            //
            //System.out.println("2- i am " + this.user.name + " and getNode: " + nodeID);
            //
            
            return this;
        } else {
            if (next != null){

                //
                //System.out.println("3- i am " + this.user.name + " and getNode: " + nodeID);
                //

                return next.getNode(nodeID-1);
            } else {
                //System.out.println("there werent that many nodes and i am the last one");
                return this;
            }
        }
    }
}
