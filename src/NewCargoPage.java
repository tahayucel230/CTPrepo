import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewCargoPage {
    static boolean pressed;
    public static void newCargoPageRun(User currentUser){
        SwingMain.mainFrame.setVisible(false);
        JButton confirmCargoButton = new JButton("kargoyu onayla");
        JLabel productLabel = new JLabel("urununuzu giriniz");
        JLabel locationLabel = new JLabel("lokasyonunuzu giriniz");
        JLabel dialogueLabel = new JLabel("Kargo talep edebileceginiz lokasyonlar:");
        JLabel locationsLabel = new JLabel("Ankara/CTP sirket merkezi, Istanbul, Bursa, Denizli, Sivas, Izmir, Antalya");
        JLabel locationsLabel2 = new JLabel("Bingol, Erzurum, Mersin, Mardin, Van, Kahramanmaras");
        JLabel dialogue2Label = new JLabel ("Sehir ismini dogru girdiginize emin olunuz. Buyuk harf ve karakterlere dikkat ediniz");
        JTextField productTextField = new JTextField();
        JTextField locationTextField = new JTextField();

        productLabel.setBounds(130,100,500, 40);
        locationLabel.setBounds(130, 100, 500, 40);
        productTextField.setBounds(130,150,500, 40);
        locationTextField.setBounds(300,150,500, 40);
        confirmCargoButton.setBounds(130,200,500, 40);
        dialogueLabel.setBounds(130,250,500, 40);
        locationsLabel.setBounds(130,300,500, 40);
        locationsLabel2.setBounds(130,350,500, 40);
        dialogue2Label.setBounds(130,400, 500, 40);

        confirmCargoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (RoutesMap.mapTree.findNodeWithName(locationTextField.getText()) != null){
                    pressed = true;
                }
            }
        });

        SwingMain.mainFrame.add(productLabel);
        SwingMain.mainFrame.add(locationLabel);
        SwingMain.mainFrame.add(productTextField);
        SwingMain.mainFrame.add(locationTextField);
        SwingMain.mainFrame.add(confirmCargoButton);
        SwingMain.mainFrame.add(dialogueLabel);
        SwingMain.mainFrame.add(locationsLabel);
        SwingMain.mainFrame.add(locationsLabel2);
        SwingMain.mainFrame.add(dialogue2Label);

        pressed = false;
        SwingMain.mainFrame.setVisible(true);
        while (!pressed){
            App.wait(50);

            productLabel.setBounds(SwingMain.mainFrame.getWidth()*6/24, SwingMain.mainFrame.getHeight()*3/20, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            locationLabel.setBounds(SwingMain.mainFrame.getWidth()*13/24, SwingMain.mainFrame.getHeight()*3/20, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            productTextField.setBounds(SwingMain.mainFrame.getWidth()*6/24, SwingMain.mainFrame.getHeight()*5/20, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*3/60);
            locationTextField.setBounds(SwingMain.mainFrame.getWidth()*13/24, SwingMain.mainFrame.getHeight()*5/20, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*3/60);
            confirmCargoButton.setBounds(SwingMain.mainFrame.getWidth()*6/24, SwingMain.mainFrame.getHeight()*13/40, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*3/60);
            dialogueLabel.setBounds(SwingMain.mainFrame.getWidth()*6/24, SwingMain.mainFrame.getHeight()*16/40, SwingMain.mainFrame.getWidth()*3/8, SwingMain.mainFrame.getHeight()*2/15);
            locationsLabel.setBounds(SwingMain.mainFrame.getWidth()*6/24, SwingMain.mainFrame.getHeight()*19/40, SwingMain.mainFrame.getWidth()*3/4, SwingMain.mainFrame.getHeight()*2/15);
            locationsLabel2.setBounds(SwingMain.mainFrame.getWidth()*6/24, SwingMain.mainFrame.getHeight()*22/40, SwingMain.mainFrame.getWidth()*3/4, SwingMain.mainFrame.getHeight()*2/15);
            dialogue2Label.setBounds(SwingMain.mainFrame.getWidth()*6/24, SwingMain.mainFrame.getHeight()*25/40, SwingMain.mainFrame.getWidth()*3/4, SwingMain.mainFrame.getHeight()*2/15);

            productLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            locationLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            dialogueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            locationsLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            locationsLabel2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            dialogue2Label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));

        }

        String product = productTextField.getText();
        String location = locationTextField.getText();

        SwingMain.mainFrame.setVisible(false);
        SwingMain.mainFrame.remove(productLabel);
        SwingMain.mainFrame.remove(locationLabel);
        SwingMain.mainFrame.remove(productTextField);
        SwingMain.mainFrame.remove(locationTextField);
        SwingMain.mainFrame.remove(confirmCargoButton);
        SwingMain.mainFrame.remove(dialogueLabel);
        SwingMain.mainFrame.remove(locationsLabel);
        SwingMain.mainFrame.remove(locationsLabel2);
        SwingMain.mainFrame.remove(dialogue2Label);

        createNewCargoSave(product, location, currentUser);

    }

    public static void createNewCargoSave(String product, String location, User user){
        //
        //System.out.println("creating new cargo saves: " + product + " for " + user.name + " at date: " + App.date + " to " + location + " //// and also App.cargos.count() :" + App.cargos.count());
        //
        //       TTEEESSSSTTTT TTHHIIIISSSSS WWWHHHHHOOOOOOLLLLEEEEEE  TTTTHHIIIIIINNNGGGGGG

        if (App.cargosInitialized){
            App.cargos.newNode(product, App.cargos.count()-1, App.date, "delivering", RoutesMap.getDistance(location) + 1, user.name, location);
        } else {
            App.cargosInitialized = true;
            App.cargos = new CargoLinkedListNode(product, 0, App.date, "delivering", RoutesMap.getDistance(location) + 1, user.name, location);
        }

        FileHandler.addLineToFile((App.cargos.count()-1 + "," + product + "," + App.date + "," + "delivering" + "," + (RoutesMap.getDistance(location) + 1) + "," + user.name + "," + location), "C:\\CTPdata\\Cargos.txt");

        String[] cargoHistoryArray = user.cargoHistory.split("[,]");

        //
        for (String t : cargoHistoryArray){
            System.out.println(":" + t);
        }
        //
        int index = -1;
        while (index<4){
            if (cargoHistoryArray[index + 1].equals("-")){
                index++;
            } else {
                break;
            }
        }

        if (index == -1){
            for (int historyIndex = 4; historyIndex > 0; historyIndex--){
                cargoHistoryArray[historyIndex] = cargoHistoryArray[historyIndex-1];
            }
            index = 0;
        }

        cargoHistoryArray[index] = Integer.toString(App.cargos.count()-1);
        user.cargoHistory = (cargoHistoryArray[0] + "," + cargoHistoryArray[1] + "," + cargoHistoryArray[2] + "," + cargoHistoryArray[3] + "," + cargoHistoryArray[4]);
        FileHandler.editUserFileLine(user.name, 4, user.cargoHistory);
    }
}
