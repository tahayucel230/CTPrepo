public class App {

    static String currentUser;
    public static UserLinkedListNode users;
    public static boolean usersInitialized;
    public static CargoLinkedListNode cargos;
    public static boolean cargosInitialized;
    public static String date;

    public static void main(String[] args) throws Exception {

        RoutesMap.prepareMapTree();

        usersInitialized = false;
        cargosInitialized = false;
        FileHandler.readFilesCreateFolders();

        SwingMain.startSwing();

        boolean exit = false;

        while (!exit){
            currentUser = IntroPage.runIntroPage();

            System.out.println(currentUser);

            if (currentUser.equals("worker")){
                WorkerPage.workerPageRun();
            }
            else if (currentUser.equals("customer")){
                CustomerPage.customerPageRun();
            }
            else {
                System.out.println("user type not acquired\n");
            }

            exit = EndPage.runEndPage();
        }

        SwingMain.stopSwing();
    }

    public static void wait(int delay){
        try{ 
            Thread.sleep(delay); 
        }catch(InterruptedException e){}
    }

    public static int getDateInteger (String date){
        int returnInt = -1;
        try{
            returnInt = Integer.parseInt(date.split("[.]")[0]) + Integer.parseInt(date.split("[.]")[1])*30;
        } catch (NumberFormatException e){
            System.out.println("number format exception");
            e.printStackTrace();
        }

        return returnInt;
    }

    public static String getIntegerDate (int input){
        if (input%30 == 0){
            return ("30." + ((input/30)-1) + ".2000");
        }
        return ((input%30) + "." + input/30 + ".2000");
    }
}
