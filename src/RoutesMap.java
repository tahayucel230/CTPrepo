public class RoutesMap {
    public static TreeNode mapTree;
    public static void prepareMapTree(){

        mapTree = new TreeNode("Ankara");
        mapTree.newNode("Ankara", "Istanbul");
        mapTree.newNode("Ankara", "Bursa");
        mapTree.newNode("Ankara", "Denizli");
        mapTree.newNode("Ankara", "Sivas");
        mapTree.newNode("Bursa", "Izmir");
        mapTree.newNode("Denizli", "Antalya");
        mapTree.newNode("Sivas", "Kahramanmaras");
        mapTree.newNode("Sivas", "Bingol");
        mapTree.newNode("Sivas", "Erzurum");
        mapTree.newNode("Kahramanmaras", "Mersin");
        mapTree.newNode("Bingol", "Mardin");
        mapTree.newNode("Bingol", "Van");

    }

    public static int getDistance(String name){
        return mapTree.findNodeWithName(name).depth;
    }
}
