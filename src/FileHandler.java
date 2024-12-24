import java.io.*;

public class FileHandler {

    public static void readFilesCreateFolders(){
        File directoryForCTPdata = new File("C:\\CTPdata");
        directoryForCTPdata.mkdir();
        directoryForCTPdata = new File("C:\\CTPdata\\Users");

        //directoryForCTPdata.mkdir();
        System.out.println(directoryForCTPdata.mkdir() + " mkdir for users");
        //

        directoryForCTPdata = new File("C:\\CTPdata\\Cargos.txt");
        if (!directoryForCTPdata.exists()){
            writeFile("", directoryForCTPdata);
        } else {
            int ID;
            String product;
            String date;
            String cargoState;
            int howManyDays;
            String userName;
            String location;
            for (int lineIndex = 0; readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt") != null; lineIndex++){
                if (lineIndex == 0){
                    try {
                        ID = Integer.parseInt(readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[0]);
                    } catch (NumberFormatException e){
                        ID = -1;
                        System.out.println("error cuz id cant be read2222222222");
                    }
                    product = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[1];
                    date = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[2];
                    cargoState = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[3];
                    try {
                        howManyDays = Integer.parseInt(readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[4]);
                    } catch (NumberFormatException e){
                        howManyDays = -1;
                        System.out.println("error cuz id cant be read333333333333333333333333333333");
                    }
                    userName = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[5];
                    location = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[6];

                    App.cargos = new CargoLinkedListNode(product, ID, date, cargoState, howManyDays, userName, location);
                    App.cargosInitialized = true;

                    //
                    System.out.println("here is a location from node0 : " + App.cargos.getNode(0).cargo.location);
                    //
                } else {
                    try {
                        ID = Integer.parseInt(readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[0]);
                    } catch (NumberFormatException e){
                        ID = -1;
                        System.out.println("error cuz id cant be read2222222222");
                    }
                    product = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[1];
                    date = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[2];
                    cargoState = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[3];
                    try {
                        howManyDays = Integer.parseInt(readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[4]);
                    } catch (NumberFormatException e){
                        howManyDays = -1;
                        System.out.println("error cuz id cant be read333333333333333333333333333333");
                    }
                    userName = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[5];
                    location = readLineFromFile(lineIndex, "C:\\CTPdata\\Cargos.txt").split("[,]")[6];

                    App.cargos.newNode(product, ID, date, cargoState, howManyDays, userName, location);

                    //
                    System.out.println("here is a locaton from node 1 : " + App.cargos.getNode(1).cargo.location);
                    //
                }
            }
        }

        //directoryForCTPdata.mkdir();
        System.out.println(directoryForCTPdata.mkdir() + " mkdir for cargos");
        //

        directoryForCTPdata = new File("C:\\CTPdata\\Date.txt");
        if (!directoryForCTPdata.exists()){
            writeFile("01.01.2000", directoryForCTPdata);
            App.date = "01.01.2000";
        } else {    
            App.date = readLineFromFile(0, directoryForCTPdata);
        }
        System.out.println(directoryForCTPdata.mkdir() + " mkdir for date");
        

        readUserFiles();
    }

    public static void readUserFiles(){
        File userFile;
        String name, password, surname, cargoHistory;
        int userID;

        //System.out.println("stuff: " + (new File("C:\\CTPdata\\Users\\User0.txt")).exists());

        if ((userFile = new File("C:\\CTPdata\\Users\\User0.txt")).exists()){

            /* //
            System.out.println("\ninitial existing id: 0");
            // */
            try {
                userID = Integer.parseInt(FileHandler.readLineFromFile(0, userFile));
            } catch (NumberFormatException e){
                userID = -1;
                System.out.println("error cuz id cant be read");
            }
            name = FileHandler.readLineFromFile(1, userFile);
            surname = FileHandler.readLineFromFile(2, userFile);
            password = FileHandler.readLineFromFile(3, userFile);
            cargoHistory = FileHandler.readLineFromFile(4, userFile);

            //System.out.println(name);
            //System.out.println(password);

            App.users = new UserLinkedListNode(userID, name, surname, password, cargoHistory);
            App.usersInitialized = true;

            //System.out.println(App.users.getNode(0).user.name + ": is no1");
        }
        
        for (int id = 1;  (userFile = new File("C:\\CTPdata\\Users\\User" + id + ".txt")).exists(); id++){

            //
            //System.out.println("\nexisting id: " + id);
            //
            try {
                userID = Integer.parseInt(FileHandler.readLineFromFile(0, userFile));
            } catch (NumberFormatException e){
                userID = -1;
                System.out.println("error cuz id cant be read");
            }
            name = FileHandler.readLineFromFile(1, userFile);
            surname = FileHandler.readLineFromFile(2, userFile);
            password = FileHandler.readLineFromFile(3, userFile);
            cargoHistory = FileHandler.readLineFromFile(4, userFile);
            App.users.newNode(userID, name, surname, password, cargoHistory);
        }
    }

    public static void writeFile(String content, String directory){
        try{
            FileWriter wr = new FileWriter(directory);
            wr.write(content);
            wr.close();
        } catch (IOException e) {
            System.out.println("io exception");
            e.printStackTrace();
        }
        
    }

    public static void writeFile(String content, File file){
        try{
            FileWriter wr = new FileWriter(file);
            wr.write(content);
            wr.close();
        } catch (IOException e) {
            System.out.println("io exception");
            e.printStackTrace();
        }
        
    }

    public static void addLineToFile(String content, String directory){
        //PROBLEMS HERE PROBOBLY
        String fileContent = "";

        System.out.println("fileContent1:_" + fileContent);

        boolean more = false;
        for (int lineIndex = 0; readLineFromFile(lineIndex, directory) != null; lineIndex++){
            more = true;
            if (lineIndex == 0){
                fileContent += (readLineFromFile(lineIndex, directory));
                System.out.println("fileContent2:_" + fileContent);
            } else {
                System.out.println("fileContent3:_" + fileContent);
                fileContent += ("\n" + readLineFromFile(lineIndex, directory));
            }
        }

        System.out.println("fileContent:_" + fileContent);

        if (!more){
            System.out.println("content(!more):_" + content);
            writeFile((content), directory);
        } else {
            System.out.println("filecontent(more):_" + fileContent + "_ and \\n content:_" + "\n" + content);
            writeFile((fileContent + "\n" + content), directory);
        }
    }

    public static String readLineFromFile(int lineIndex, String directory){
        String out = "error";
        try {

            /* //
            System.out.println("test11");
            // */

            FileReader fR = new FileReader(directory);
            BufferedReader bR = new BufferedReader(fR);
            try {

                /* //
                System.out.println("test12");
                // */
    
                while (lineIndex != -1){

                    /* //
                    System.out.println("test13 " + lineIndex);
                    // */
        
                    out = bR.readLine();
                    lineIndex--;
                }
                bR.close();

                /* //
                System.out.println("test14 " + out);
                // */
    
                return out;
            } catch (IOException f){
                System.out.println("io exception");
                f.printStackTrace();
            }
        } catch (FileNotFoundException e){
            System.out.println("file not found exception");
            e.printStackTrace();
        }
        return out;
    }

    public static String readLineFromFile(int lineIndex, File directory){
        String out = "error";
        try {

            /* //
            System.out.println("test11");
            // */

            FileReader fR = new FileReader(directory);
            BufferedReader bR = new BufferedReader(fR);
            try {

                /* //
                System.out.println("test12");
                // */
    
                while (lineIndex != -1){

                    /* //
                    System.out.println("test13 " + lineIndex);
                    // */
        
                    out = bR.readLine();
                    lineIndex--;
                }
                bR.close();

                /* //
                System.out.println("test14 " + out);
                // */
    
                return out;
            } catch (IOException f){
                System.out.println("io exception");
                f.printStackTrace();
            }
        } catch (FileNotFoundException e){
            System.out.println("file not found exception");
            e.printStackTrace();
        }
        return out;
    }

    public static void editFileLine(String directory, int lineIndex, String content){
        try {

            FileReader fR;
            BufferedReader bR;
            FileWriter fW;
            BufferedWriter bW;

            String currentLine;
            String fileContents = "";
            fR = new FileReader(directory);
            bR = new BufferedReader(fR);

            try {

                for (int currentLineIndex = 0; (currentLine = bR.readLine()) != null; currentLineIndex++){
                    if (currentLineIndex == lineIndex){
                        fileContents += content;
                    } else {
                        fileContents += currentLine;
                    }

                    fileContents += "\n";
                }

                fW = new FileWriter(directory);
                bW = new BufferedWriter(fW);
                bW.write(fileContents);

                bR.close();
                fR.close();
                bW.close();
                fW.close();

            } catch (IOException f) {
                System.out.println("io exception");
                f.printStackTrace();
            }
            
        } catch (FileNotFoundException e){
            System.out.println("file not found exception");
            e.printStackTrace();
        }
    }

    public static void editFileLine(String directory, int lineIndex, File content){
        try {

            FileReader fR;
            BufferedReader bR;
            FileWriter fW;
            BufferedWriter bW;

            String currentLine;
            String fileContents = "";
            fR = new FileReader(directory);
            bR = new BufferedReader(fR);

            try {

                for (int currentLineIndex = 0; (currentLine = bR.readLine()) != null; currentLineIndex++){
                    if (currentLineIndex == lineIndex){
                        fileContents += content;
                    } else {
                        fileContents += currentLine;
                    }

                    fileContents += "\n";
                }

                fW = new FileWriter(directory);
                bW = new BufferedWriter(fW);
                bW.write(fileContents);

                bR.close();
                fR.close();
                bW.close();
                fW.close();

            } catch (IOException f) {
                System.out.println("io exception");
                f.printStackTrace();
            }
            
        } catch (FileNotFoundException e){
            System.out.println("file not found exception");
            e.printStackTrace();
        }
    }

    public static void editUserFileLine(String userName, int lineIndex, String content){
        try {

            FileReader fR;
            BufferedReader bR;
            FileWriter fW;
            BufferedWriter bW;

            String currentLine;
            String fileContents = "";

            String directory = findUserFileDirectory(userName);

            fR = new FileReader(directory);
            bR = new BufferedReader(fR);

            try {

                for (int currentLineIndex = 0; (currentLine = bR.readLine()) != null; currentLineIndex++){
                    if (currentLineIndex == lineIndex){
                        fileContents += content;
                    } else {
                        fileContents += currentLine;
                    }

                    fileContents += "\n";
                }

                fW = new FileWriter(directory);
                bW = new BufferedWriter(fW);
                bW.write(fileContents);

                bR.close();
                fR.close();
                bW.close();
                fW.close();

            } catch (IOException f) {
                System.out.println("io exception");
                f.printStackTrace();
            }
            
        } catch (FileNotFoundException e){
            System.out.println("file not found exception");
            e.printStackTrace();
        }
    }

    public static boolean fileExists(String directory){
        return (new File(directory)).exists();
    }

    public static boolean userFileExists(String name){
        boolean foundUser = false;

        for (int userID = 0; userID < App.users.count(); userID++){
            if (fileExists(("C:\\CTPdata\\Users\\User" + userID + ".txt"))){
                if (readLineFromFile(1, ("C:\\CTPdata\\Users\\User" + userID + ".txt")).equals(name)){
                    foundUser = true;
                }
            }
        }

        return foundUser;
    }

    public static String findUserFileDirectory(String name){
        for (int userID = 0; userID < App.users.count(); userID++){
            if (readLineFromFile(1, ("C:\\CTPdata\\Users\\User" + userID + ".txt")).equals(name)){
                return ("C:\\CTPdata\\Users\\User" + userID + ".txt");
            }
        }
        return "no such user file found";
    }
}
