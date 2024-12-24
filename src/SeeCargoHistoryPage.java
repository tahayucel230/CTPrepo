import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SeeCargoHistoryPage {
    static boolean pressed;
    public static void seeCargoHistoryPageRun(User currentUser){

        SwingMain.mainFrame.setVisible(false);

        String[] cargoIDSs = currentUser.cargoHistory.split("[,]");
        int[] cargoIDs = new int[cargoIDSs.length];

        for (int cargoIndex = 0; cargoIndex < cargoIDSs.length; cargoIndex++){
            if (cargoIDSs[cargoIndex].equals("-")){
                cargoIDs[cargoIndex] = -1;
            } else {
                try {
                    cargoIDs[cargoIndex] = Integer.parseInt(cargoIDSs[cargoIndex]);
                } catch (NumberFormatException e){
                    cargoIDs[cargoIndex] = -1;
                    System.out.println("error cuz id cant be read9");
                }
            }
        }
        

        for (int idid : cargoIDs){
            System.out.println(" an id: " + idid + " / howManyDays: " + App.cargos.getNode(idid).cargo.howManyDays + " / days remaining: " + getDaysLeftString(App.getDateInteger(App.cargos.getNode(idid).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(idid).cargo.howManyDays));
        }

        System.out.println("\n");
        cargoIDs = mergeSort(cargoIDs, 0, cargoIDs.length-1);
        cargoIDs = sendEmptiesToTheEnd(cargoIDs);

        for (int cargoIndex = 0; cargoIndex < cargoIDSs.length; cargoIndex++){
            cargoIDSs[cargoIndex] = Integer.toString(cargoIDs[cargoIndex]);
        }

        String[] products = new String[cargoIDs.length];
        for (int arrayIndex = 0; arrayIndex < 5; arrayIndex++){
            if (cargoIDs[arrayIndex] == -1){
                products[arrayIndex] = "-";
            } else {
                products[arrayIndex] = App.cargos.getNode(cargoIDs[arrayIndex]).cargo.productName;
            }
        }

        JButton confirmButton = new JButton("kargo detaylarini goster");
        JTextField cargoIDTextField = new JTextField();

        //              DO IT HERE IF EVER GOING TO SET CARGO "CARGOSTATE"S TO BE ACCURATE

        JLabel cargoLabel1;
        JLabel cargoLabel2;
        JLabel cargoLabel3;
        JLabel cargoLabel4;
        JLabel cargoLabel5;
        if (cargoIDs[0] != -1){
            cargoLabel1 = new JLabel("Urun: " + products[0] + " / Teslime kalan gun: " + getDaysLeftString(App.getDateInteger(App.cargos.getNode(cargoIDs[0]).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(cargoIDs[0]).cargo.howManyDays) + " / Kargo ID'si: " + cargoIDSs[0]);
        } else {
            cargoLabel1 = new JLabel("-");
        }

        if (cargoIDs[1] != -1){
            cargoLabel2 = new JLabel("Urun: " + products[1] + " / Teslime kalan gun: " + getDaysLeftString(App.getDateInteger(App.cargos.getNode(cargoIDs[1]).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(cargoIDs[1]).cargo.howManyDays) + " / Kargo ID'si: " + cargoIDSs[1]);
        } else {
            cargoLabel2 = new JLabel("-");
        }

        if (cargoIDs[2] != -1){
            cargoLabel3 = new JLabel("Urun: " + products[2] + " / Teslime kalan gun: " + getDaysLeftString(App.getDateInteger(App.cargos.getNode(cargoIDs[2]).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(cargoIDs[2]).cargo.howManyDays) + " / Kargo ID'si: " + cargoIDSs[2]);
        } else {
            cargoLabel3 = new JLabel("-");
        }

        if (cargoIDs[3] != -1){
            cargoLabel4 = new JLabel("Urun: " + products[3] + " / Teslime kalan gun: " + getDaysLeftString(App.getDateInteger(App.cargos.getNode(cargoIDs[3]).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(cargoIDs[3]).cargo.howManyDays) + " / Kargo ID'si: " + cargoIDSs[3]);
        } else {
            cargoLabel4 = new JLabel("-");
        }

        if (cargoIDs[4] != -1){
            cargoLabel5 = new JLabel("Urun: " + products[4] + " / Teslime kalan gun: " + getDaysLeftString(App.getDateInteger(App.cargos.getNode(cargoIDs[4]).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(cargoIDs[4]).cargo.howManyDays) + " / Kargo ID'si: " + cargoIDSs[4]);
        } else {
            cargoLabel5 = new JLabel("-");
        }

        JLabel dialogueLabel = new JLabel("ID numarasi ile aratiniz: ");

        cargoLabel1.setBounds(20,20,500, 40);
        cargoLabel2.setBounds(20,70,500, 40);
        cargoLabel3.setBounds(20,120,500, 40);
        cargoLabel4.setBounds(20,170,500, 40);
        cargoLabel5.setBounds(20,210,500, 40);
        dialogueLabel.setBounds(20, 400, 500, 40);
        cargoIDTextField.setBounds(400,250,300, 40);
        confirmButton.setBounds(400,300,300, 40);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                pressed = true;
            }
        });
        
        SwingMain.mainFrame.add(confirmButton);
        SwingMain.mainFrame.add(cargoIDTextField);
        SwingMain.mainFrame.add(cargoLabel1);
        SwingMain.mainFrame.add(cargoLabel2);
        SwingMain.mainFrame.add(cargoLabel3);
        SwingMain.mainFrame.add(cargoLabel4);
        SwingMain.mainFrame.add(cargoLabel5);
        SwingMain.mainFrame.add(dialogueLabel);

        pressed = false;

        SwingMain.mainFrame.setVisible(true);

        while (!pressed){
            App.wait(100);

            cargoLabel1.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*7/40,SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()/20);
            cargoLabel2.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*10/40,SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()/20);
            cargoLabel3.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*13/40,SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()/20);
            cargoLabel4.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*16/40,SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()/20);
            cargoLabel5.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*19/40,SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()/20);
            dialogueLabel.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*22/40,SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()/20);
            cargoIDTextField.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*25/40,SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()/20);
            confirmButton.setBounds(SwingMain.mainFrame.getWidth()*7/24,SwingMain.mainFrame.getHeight()*28/40,SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()/20);

            cargoLabel1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            cargoLabel2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            cargoLabel3.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            cargoLabel4.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            cargoLabel5.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            dialogueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
        }

        String requestedID = cargoIDTextField.getText();
        SwingMain.mainFrame.remove(confirmButton);
        SwingMain.mainFrame.remove(cargoIDTextField);
        SwingMain.mainFrame.remove(cargoLabel1);
        SwingMain.mainFrame.remove(cargoLabel2);
        SwingMain.mainFrame.remove(cargoLabel3);
        SwingMain.mainFrame.remove(cargoLabel4);
        SwingMain.mainFrame.remove(cargoLabel5);
        SwingMain.mainFrame.remove(dialogueLabel);

        SeeCargoDetailsPage.seeCargoDetailsPageRun(requestedID, currentUser);
    }

    public static int[] sendEmptiesToTheEnd(int[] array){
        // -1 idlileri sona at
        boolean fixedYet = false;
        int holdIndex;
        while (!fixedYet){
            fixedYet = true;
            holdIndex = -1;
            for (int i = 0; i < array.length; i++){
                if (array[i] == -1){
                     holdIndex = i;
                } else {
                    if (holdIndex != -1){
                        array[holdIndex] = array[i];
                        array[i] = -1;
                        fixedYet = false;
                        break;
                    }
                }
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] arrayToSort, int firstIndexToSort, int lastIndexToSort){
        if (firstIndexToSort == lastIndexToSort){
            int[] arrayToReturn = {arrayToSort[firstIndexToSort]}; 
            return (arrayToReturn);
        } else {
            int numberOfElementsToSort = lastIndexToSort-firstIndexToSort+1;
            int numberOfElementsToSortInTheFirstHalf = numberOfElementsToSort/2;
            int numberOfElementsToSortInTheSecondHalf = numberOfElementsToSort-numberOfElementsToSortInTheFirstHalf;
            int[] firstHalfSorted = mergeSort(arrayToSort, firstIndexToSort, firstIndexToSort+numberOfElementsToSortInTheFirstHalf-1);
            int[] secondHalfSorted = mergeSort(arrayToSort, lastIndexToSort-numberOfElementsToSortInTheSecondHalf+1, lastIndexToSort);

            return mergeArrays(firstHalfSorted,secondHalfSorted);
        }
    }
    
    public static int[] mergeArrays(int[] firstArray, int[] secondArray){
        int firstArrayCursor = 0;
        int secondArrayCursor = 0;
        int[] arrayToReturn = new int[firstArray.length + secondArray.length];
        while (firstArrayCursor<firstArray.length && secondArrayCursor<secondArray.length){
            if (
                (App.cargos.getNode(firstArray[firstArrayCursor]).cargo.howManyDays + App.getDateInteger(App.cargos.getNode(firstArray[firstArrayCursor]).cargo.date))
                 < 
                (App.cargos.getNode(secondArray[secondArrayCursor]).cargo.howManyDays + App.getDateInteger(App.cargos.getNode(secondArray[secondArrayCursor]).cargo.date))
                ){
                arrayToReturn[firstArrayCursor+secondArrayCursor] = firstArray[firstArrayCursor];
                firstArrayCursor++;
            } else {
                arrayToReturn[firstArrayCursor+secondArrayCursor] = secondArray[secondArrayCursor];
                secondArrayCursor++;
            }
        }
        while (firstArrayCursor<firstArray.length){
            arrayToReturn[firstArrayCursor+secondArrayCursor] = firstArray[firstArrayCursor];
            firstArrayCursor++;
        }
        while (secondArrayCursor<secondArray.length){
            arrayToReturn[secondArrayCursor+firstArrayCursor] = secondArray[secondArrayCursor];
            secondArrayCursor++;
        }
        return arrayToReturn;
    }

    public static String getDaysLeftString(int sendDate, int currentDate, int deliveryDays){
        if ((sendDate + deliveryDays - currentDate) < 1){
            return "teslim edildi";
        } else {
            return Integer.toString(sendDate + deliveryDays - currentDate);
        }
    }
}
