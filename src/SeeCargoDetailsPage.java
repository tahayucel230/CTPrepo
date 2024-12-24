import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SeeCargoDetailsPage {
    static boolean pressed;
    public static void seeCargoDetailsPageRun(String IDs, User currentUser){
        SwingMain.mainFrame.setVisible(false);
        int id;
        try{
            id = Integer.parseInt(IDs);
        } catch (NumberFormatException e){
            System.out.println("numberFormatException");
            e.printStackTrace();
            id = -1;
        }
        String labelString = "Urun: " + App.cargos.getNode(id).cargo.productName + " / Konum: " + App.cargos.getNode(id).cargo.location + " / Gonderilme tarihi: " + App.cargos.getNode(id).cargo.date + " / Varisa kalan gun: " + SeeCargoHistoryPage.getDaysLeftString(App.getDateInteger(App.cargos.getNode(id).cargo.date), App.getDateInteger(App.date), App.cargos.getNode(id).cargo.howManyDays);
        JLabel infoLabel = new JLabel(labelString);
        JButton exitButton = new JButton("cikis");

        infoLabel.setBounds(400, 250, 700, 40);
        exitButton.setBounds(400, 400, 300, 40);

        SwingMain.mainFrame.add(infoLabel);
        SwingMain.mainFrame.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                pressed = true;
            }
        });

        SwingMain.mainFrame.setVisible(true);
        pressed = false;
        while (!pressed) {

            App.wait(50);

            infoLabel.setBounds(SwingMain.mainFrame.getWidth()/8, SwingMain.mainFrame.getHeight()*13/40, SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()*2/15);
            exitButton.setBounds(SwingMain.mainFrame.getWidth()/8, SwingMain.mainFrame.getHeight()*19/40, SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()/20);

            infoLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));

        }
        
        SwingMain.mainFrame.remove(infoLabel);
        SwingMain.mainFrame.remove(exitButton);
    }
}
