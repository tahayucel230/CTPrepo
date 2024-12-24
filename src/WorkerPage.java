import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WorkerPage {
    static boolean exitPressed;
    static boolean binaryPressed;
    public static void workerPageRun(){
        //System.out.println("workerpaegtthigs\n");
        SwingMain.mainFrame.setVisible(false);

        int[] cargoIDs = new int[App.cargos.count()];
        for(int cargoID = (App.cargos.count()-1); cargoID>-1; cargoID--){

            /* //
            System.out.println("cargoID: " + cargoID + " / App.cargos.count()-1: " + (App.cargos.count()-1));
            // */

            cargoIDs[cargoID] = cargoID;
        }

        cargoIDs = SeeCargoHistoryPage.mergeSort(cargoIDs, 0, cargoIDs.length-1);

        JLabel[] cargoLabels = new JLabel[cargoIDs.length];
        for (int labelIndex = 0; labelIndex < cargoIDs.length; labelIndex++){
            cargoLabels[labelIndex] = new JLabel("Urun: " + App.cargos.getNode(cargoIDs[labelIndex]).cargo.productName + " / ID: " + cargoIDs[labelIndex] + " / Gonderen: " + App.cargos.getNode(cargoIDs[labelIndex]).cargo.userName + " / Konum: " + App.cargos.getNode(cargoIDs[labelIndex]).cargo.location + " / Gonderilme tarihi: " + App.cargos.getNode(cargoIDs[labelIndex]).cargo.date + " / Varisa kalan gun: " + SeeCargoHistoryPage.getDaysLeftString(App.getDateInteger(App.cargos.getNode(cargoIDs[labelIndex]).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(cargoIDs[labelIndex]).cargo.howManyDays));
            cargoLabels[labelIndex].setBounds(300, 100+labelIndex*50, 700, 40);
            SwingMain.mainFrame.add(cargoLabels[labelIndex]);
        }

        JButton exitButton = new JButton("cikis");
        JButton workForADayButton = new JButton("1 gunluk calisma icin tiklayiniz");
        JButton binarySearchButton = new JButton("Kargo detay goster: (ID ile aratiniz)");
        JTextField binarySearchTextField = new JTextField();

        binarySearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                binaryPressed = true;
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                exitPressed = true;
            }
        });

        workForADayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //SwingMain.mainFrame.setVisible(false);
                App.date = App.getIntegerDate(App.getDateInteger(App.date)+1);
                FileHandler.writeFile(App.date, "C:\\CTPdata\\Date.txt");
                // STUFF TO DO HERE AND FURTHER
            }
        });

        workForADayButton.setBounds(10, 10, 400, 40);
        exitButton.setBounds(10, 50, 400, 40);
        binarySearchTextField.setBounds(100, 10, 400, 40);
        binarySearchButton.setBounds(100, 50, 400, 40);

        SwingMain.mainFrame.add(workForADayButton);
        SwingMain.mainFrame.add(exitButton);
        SwingMain.mainFrame.add(binarySearchTextField);
        SwingMain.mainFrame.add(binarySearchButton);

        SwingMain.mainFrame.setVisible(true);
        exitPressed = false;
        binaryPressed = false;

        while (!exitPressed && !binaryPressed){

            App.wait(50);

            workForADayButton.setBounds(SwingMain.mainFrame.getWidth()/10, SwingMain.mainFrame.getHeight()/30, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*3/60);
            exitButton.setBounds(SwingMain.mainFrame.getWidth()/10, SwingMain.mainFrame.getHeight()*2/20, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*3/60);
            binarySearchTextField.setBounds(SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()/30, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*3/60);
            binarySearchButton.setBounds(SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()*2/20, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*3/60);

            for (int labelIndex = 0; labelIndex < cargoIDs.length; labelIndex++){

                cargoLabels[labelIndex].setBounds(SwingMain.mainFrame.getWidth()/10, SwingMain.mainFrame.getHeight()/10+labelIndex*SwingMain.mainFrame.getHeight()/18, SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()/5);

                cargoLabels[labelIndex].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/40));
            }
        }

        String binarySearchRequest = "none";
        if (binaryPressed){
            binarySearchRequest = binarySearchTextField.getText();
        }

        SwingMain.mainFrame.remove(workForADayButton);
        SwingMain.mainFrame.remove(exitButton);
        SwingMain.mainFrame.remove(binarySearchButton);
        SwingMain.mainFrame.remove(binarySearchTextField);

        for (int labelIndex = 0; labelIndex < cargoIDs.length; labelIndex++){
            SwingMain.mainFrame.remove(cargoLabels[labelIndex]);
        }

        if (binaryPressed){
            int requestedID;
            try{
                requestedID = Integer.parseInt(binarySearchRequest);
            } catch (NumberFormatException e){
                requestedID = -1;
                System.out.println("number format exception");
                e.printStackTrace();
            }
            int foundIndex = BinarySearch.search(cargoIDs, 0, cargoIDs.length-1, requestedID);
            ShowBinarySearchResultsPage.showBinarySearchResultsPageRun(cargoIDs, foundIndex);
            System.out.println("found index was: " + foundIndex + " and the id there was: " + cargoIDs[foundIndex]);
        }
    }
}
